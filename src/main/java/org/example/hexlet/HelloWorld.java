package org.example.hexlet;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.controller.*;
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
import org.example.hexlet.repository.*;
import org.example.hexlet.utils.*;
import org.example.hexlet.utils.UserNamedRoutes;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils.*;
import io.javalin.Javalin;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

import static org.apache.commons.lang3.StringUtils.startsWithIgnoreCase;

public class HelloWorld {
/*    private static List<User> USERS = UserRepository.getEntities();
    private static List<Course> COURSES = CourseRepository.getEntities();*/

    public static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.valueOf(port);
    }
    public static Javalin getApp() throws Exception {
        //создали бд в памяти машины
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:mem:hexlet_project;DB_CLOSE_DELAY=-1;");

        var dataSource = new HikariDataSource(hikariConfig);

        // Получаем путь до файла в src/main/resources
        var url = HelloWorld.class.getClassLoader().getResourceAsStream("schema.sql");
        var sql = new BufferedReader(new InputStreamReader(url))
                .lines().collect(Collectors.joining("\n"));

        // Получаем соединение, создаем стейтмент и выполняем запрос
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
                statement.execute(sql);
        }

        BaseRepository.dataSource = dataSource;

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });


        //work with users
        app.get(UserNamedRoutes.buildUserPath(), UsersController::build);
        app.post(UserNamedRoutes.usersPath(), UsersController::create);
        app.get(UserNamedRoutes.userPath("{id}"), UsersController::show);
        app.get(UserNamedRoutes.usersPath(), UsersController::index);
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


        //
        app.get(CarsNamedRoutes.buildCarsPath(), CarController::build);
        app.post(CarsNamedRoutes.carsPath(), CarController::create);
        app.get(CarsNamedRoutes.carPath("{id}"), CarController::show);
        app.get(CarsNamedRoutes.carsPath(), CarController::index);



        app.get(RootNamedRoutes.mainPath(), ctx -> {
            Boolean visited = Boolean.valueOf(ctx.cookie("visited"));
            var user = ctx.sessionAttribute("user");

            var page = new MainPage(user, ctx.sessionAttribute("currentUser"), visited);

            ctx.render("index.jte", Collections.singletonMap("page", page));
            ctx.cookie("visited", String.valueOf(true));
        });

        return app;
    }
    public static void main(String[] args) throws IOException, SQLException, Exception {
        Javalin app = getApp();
        app.start(getPort());
    }
}