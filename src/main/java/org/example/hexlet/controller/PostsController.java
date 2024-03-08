package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.posts.BuildPostPage;
import org.example.hexlet.dto.posts.EditPostPage;
import org.example.hexlet.dto.posts.PostPage;
import org.example.hexlet.dto.posts.PostsPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.Post;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.PostRepository;
import org.example.hexlet.utils.NamedRoutes;
import org.example.hexlet.utils.PostsNamedRoutes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }

    public static void index(Context ctx) {
        int pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int quantity = 5;
        int begin = (pageNumber - 1) * quantity;
        int end = begin + quantity;
        var posts = PostRepository.getEntities();
        int previousPage = pageNumber == 1 ? 1 : pageNumber - 1;
        int nextPage = pageNumber + 1;
        List<Post> sliceOfPosts;

        if(begin >= posts.size()) {
            sliceOfPosts = new ArrayList<>();
        } else if (end > posts.size()) {
            sliceOfPosts = posts.subList(begin, posts.size());
        } else {
            sliceOfPosts = posts.subList(begin, end);
        }
        var page = new PostsPage(sliceOfPosts, pageNumber, previousPage, nextPage);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }
    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", Collections.singletonMap("page", page));
    }
    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var content = ctx.formParam("content");

        try {
            ctx.formParamAsClass("name", String.class)
                    .check(value -> PostRepository.getEntities().stream()
                                    .noneMatch(post -> post.getName().equals(value)),
                            "Пост с таким названием уже существует!")
                    .check(value -> value.length() > 2, "Название поста слишком короткое!")
                    .get();
            ctx.formParamAsClass("content", String.class)
                    .check(value -> value.length() > 10, "Содержание поста слишком короткое!")
                    .get();

            Post post = new Post(name, content);
            PostRepository.save(post);
            ctx.redirect(PostsNamedRoutes.postsPath());
        } catch (ValidationException e) {
            var page = new BuildPostPage(name, content, e.getErrors());
            ctx.status(422).render("posts/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new EditPostPage(id, post.getName(), post.getBody(), null);
        ctx.render("posts/edit.jte", Collections.singletonMap("page", page));
    }

    public static void update(Context ctx) {

        var id = ctx.pathParamAsClass("id", Long.class).get();

        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                    .get();

            var body = ctx.formParamAsClass("body", String.class)
                    .check(value -> value.length() >= 10, "Пост должен быть не короче 10 символов")
                    .get();

            var post = PostRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Post not found"));

            post.setName(name);
            post.setBody(body);

            PostRepository.save(post);
            ctx.redirect(PostsNamedRoutes.postsPath());

        } catch (ValidationException e) {
            var name = ctx.formParam("name");
            var body = ctx.formParam("body");
            var page = new EditPostPage(id, name, body, e.getErrors());
            ctx.render("posts/edit.jte", Collections.singletonMap("page", page)).status(422);
        }
    }
    // END
}
