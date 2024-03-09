package org.example.hexlet;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.PostsController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.data.DataCourses;
import org.example.hexlet.data.DataUsers;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.Data;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.PostRepository;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.utils.*;
import org.example.hexlet.utils.UserNamedRoutes;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils.*;
import io.javalin.Javalin;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;

import static org.apache.commons.lang3.StringUtils.startsWithIgnoreCase;

public class HelloWorld {
    private static List<User> USERS = UserRepository.getEntities();
    private static List<Course> COURSES = CourseRepository.getEntities();

    public static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.valueOf(port);
    }
    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });


        //work with users
        app.get(UserNamedRoutes.usersPath(), UsersController::index);
        app.get(UserNamedRoutes.buildUserPath(), UsersController::build);
        app.post(UserNamedRoutes.usersPath(), UsersController::create);
        app.get(UserNamedRoutes.userPath("{id}"), UsersController::show);
        app.get(UserNamedRoutes.editUserPath("{id}"), UsersController::edit);
        app.post(UserNamedRoutes.userPath("{id}"), UsersController::update);



        //work with courses
        app.get(CourseNamedRoutes.buildCoursesPath(), CoursesController::build);
        app.post(CourseNamedRoutes.coursesPath(), CoursesController::create);
        app.get(CourseNamedRoutes.coursePath("{id}"), CoursesController::show);
        app.get(CourseNamedRoutes.coursesPath(), CoursesController::index);
        app.get(CourseNamedRoutes.editCoursePath("{id}"), CoursesController::edit);
        app.post(CourseNamedRoutes.coursePath("{id}"), CoursesController::update);



        //work with posts
        app.get(PostsNamedRoutes.buildPostsPath(), PostsController::build);
        app.post(PostsNamedRoutes.postsPath(), PostsController::create);
        app.get(PostsNamedRoutes.postPath("{id}"), PostsController::show);
        app.get(PostsNamedRoutes.postsPath(), PostsController::index);
        app.get(PostsNamedRoutes.editPostPath("{id}"), PostsController::edit);
        app.post(PostsNamedRoutes.postPath("{id}"), PostsController::update);


        //work with session

        app.get(SessionNamedRoutes.buildSessionPath(), SessionsController::build);
        app.post(SessionNamedRoutes.loginPath(), SessionsController::create);
        app.post(SessionNamedRoutes.logoutPath(), SessionsController::destroy);


        app.get(RootNamedRoutes.mainPath(), ctx -> {
            Boolean visited = Boolean.valueOf(ctx.cookie("visited"));
            var user = ctx.sessionAttribute("user");

            var page = new MainPage(user, ctx.sessionAttribute("currentUser"), visited);

            ctx.render("index.jte", Collections.singletonMap("page", page));
            ctx.cookie("visited", String.valueOf(true));
        });

        return app;
    }
    public static void main(String[] args) throws IOException, SQLException {
        Javalin app = getApp();
        app.start(getPort());
    }
}