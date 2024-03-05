package org.example.hexlet;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.data.DataCourses;
import org.example.hexlet.data.DataUsers;
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
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.utils.NamedRoutes;
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
//    private static final List<Course> COURSES = DataCourses.getCourses();
//    private static final List<User> USERS = DataUsers.getUsers();
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


        app.get(NamedRoutes.buildUserPath(), ctx -> {
            var page = new BuildUserPage();
            ctx.render("users/build.jte", Collections.singletonMap("page", page));
        });

        app.get(NamedRoutes.buildCoursesPath(), ctx -> {
            var page = new BuildCoursePage();
            ctx.render("courses/build.jte", Collections.singletonMap("page", page));
        });

        app.post(NamedRoutes.usersPath(), ctx -> {
            var name = ctx.formParam("name");
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            try {
                ctx.formParamAsClass("name", String.class)
                                .check(value -> UserRepository.getEntities().stream()
                                        .noneMatch(user -> user.getName().equals(value)),
                                        "Пользователь с таким именем уже существует!")
                                        .get();
                ctx.formParamAsClass("password", String.class)
                        .check(value -> value.equals(passwordConfirmation), "Password mismatch!")
                        .check(value -> value.length() > 4, "Password is too short!")
                        .get();
                User user = new User(name, email, password);
                UserRepository.save(user);
                ctx.redirect(NamedRoutes.usersPath());
            } catch (ValidationException e) {
                var page = new BuildUserPage(name, email, e.getErrors());
                ctx.status(422).render("users/build.jte", Collections.singletonMap("page", page));
            }
        });

        app.post(NamedRoutes.coursesPath(), ctx -> {
            var name = ctx.formParam("name");
            var description = ctx.formParam("description");
            try {
                ctx.formParamAsClass("name", String.class)
                        .check(value -> value.length() > 2, "Название курса слишком короткое!")
                        .check(value -> CourseRepository.getEntities().stream()
                                .noneMatch(course -> course.getName().equals(value)),
                                "Курс с таким название уже существует!")
                        .get();
                ctx.formParamAsClass("description", String.class)
                        .check(value -> value.length() > 10, "Описание курса слишком короткое!")
                        .get();
                var course = new Course(name, description);
                CourseRepository.save(course);
                ctx.redirect(NamedRoutes.coursesPath());
            } catch (ValidationException e) {
                var page = new BuildCoursePage(name, description, e.getErrors());
                ctx.status(422).render("courses/build.jte", Collections.singletonMap("page", page));
            }
        });

        app.get(NamedRoutes.userPath("{id}"), ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();

            User user = USERS.stream()
                    .filter(u -> id.equals(u.getId()))
                    .findFirst()
                    .orElse(null);

            if (user == null) {
                throw new NotFoundResponse("User not found");
            }

            UserPage page = new UserPage(user);
            ctx.render("users/show.jte", Collections.singletonMap("page", page));
        });


        app.get(NamedRoutes.coursePath("{id}"), ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();

            Course course = COURSES.stream()
                    .filter(c -> id.equals(c.getId()))
                    .findFirst()
                    .orElse(null);

            if (course == null) {
                throw new NotFoundResponse("Course not found");
            }

            CoursePage page = new CoursePage(course);
            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
        });




        app.get(NamedRoutes.usersPath(), ctx -> {

            var term = ctx.queryParam("term");
            List<User> users = new ArrayList<>();

            if (term != null) {
                Set<String> namesUsers = new TreeSet<>();
                namesUsers = USERS.stream()
                        .map(User::getName)
                        .collect(Collectors.toSet());

                Set<String> mailUsers = new TreeSet<>();
                mailUsers = USERS.stream()
                        .map(User::getEmail)
                        .collect(Collectors.toSet());

                boolean nameExist = false;
                for (var name : namesUsers) {
                    if (startsWithIgnoreCase(name, term)) {
                        nameExist = true;
                        break;
                    }
                }

                boolean mailExist = false;
                for (var name : mailUsers) {
                    if (startsWithIgnoreCase(name, term)) {
                        mailExist = true;
                        break;
                    }
                }

                if (nameExist) {
                    users = USERS.stream()
                            .filter(u  -> startsWithIgnoreCase(u.getName(), term))
                            .collect(Collectors.toList());
                } else if (mailExist) {
                    users = USERS.stream()
                            .filter(u -> startsWithIgnoreCase(u.getEmail(), term))
                            .collect(Collectors.toList());
                }
            } else {
                users = USERS;
            }
            UsersPage page = new UsersPage(users, term);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));

        });




        app.get(NamedRoutes.coursesPath(), ctx -> {

            var term = ctx.queryParam("term");
            List<Course> courses = new ArrayList<>();

            if (term != null) {
                Set<String> namesCourses = new TreeSet<>();
                namesCourses = COURSES.stream()
                        .map(Course::getName)
                        .collect(Collectors.toSet());

                Set<String> descCourses = new TreeSet<>();
                descCourses = COURSES.stream()
                        .map(Course::getDescription)
                        .collect(Collectors.toSet());

                boolean nameExist = false;
                for (var name : namesCourses) {
                    if (startsWithIgnoreCase(name, term)) {
                        nameExist = true;
                        break;
                    }
                }

                boolean descExist = false;
                for (var name : descCourses) {
                    if (startsWithIgnoreCase(name, term)) {
                        descExist = true;
                        break;
                    }
                }

                if (nameExist) {
                     courses = COURSES.stream()
                            .filter(c  -> startsWithIgnoreCase(c.getName(), term))
                            .collect(Collectors.toList());
                } else if (descExist) {
                    courses = COURSES.stream()
                            .filter(c -> startsWithIgnoreCase(c.getDescription(), term))
                            .collect(Collectors.toList());
                }
            } else {
                courses = COURSES;
            }
            CoursesPage page = new CoursesPage(courses, term);
            ctx.render("courses/index.jte", Collections.singletonMap("page", page));

        });

        app.get(NamedRoutes.mainPath(), ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }
    public static void main(String[] args) throws IOException, SQLException {
        Javalin app = getApp();
        app.start(getPort());
    }
}