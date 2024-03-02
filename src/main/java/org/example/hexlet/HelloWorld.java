package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import io.javalin.http.NotFoundResponse;

import io.javalin.Javalin;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {




        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });


//        app.get("/users/{id}", ctx -> {
//            ctx.result("User ID: " + ctx.pathParam("id"));
//        });
//        app.get("/posts/{postId}", ctx -> {
//            ctx.result("Post ID: " + ctx.pathParam("postId"));
//        });
//        app.get("/users/{id}/posts/{postId}", ctx -> {
//            ctx.result("User ID: " + ctx.pathParam("id"));
//            ctx.result("Post ID from user " + ctx.pathParam("postId"));
//
//        });
        //this 6 lessons


        Course course1 = new Course(1, "math", "math-desc");
        Course course2 = new Course(2, "language", "land-des");
        Course course3 = new Course(3, "java", "java-des");


        app.get("/courses/{id}", ctx -> {
            var id = Integer.parseInt(ctx.pathParam("id"));

            List<Course> courses = new ArrayList<>();
            courses.add(course1);
            courses.add(course2);
            courses.add(course3);

            var selectedPage = courses.stream()
                    .filter(course -> course.getId().equals(id))
                    .findFirst()
                    .orElse(null);

            if (selectedPage == null) {
                ctx.status(404);
                return;
            }
            var header = "Course for programming";
            var page = new CoursesPage(Arrays.asList(selectedPage), header);
            ctx.render("index.jte", Collections.singletonMap("page", page));
        });

        app.start(7070);
    }

}