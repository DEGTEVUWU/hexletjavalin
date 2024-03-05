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
    private static final List<Course> COURSES = DataCourses.getCourses();
    private static final List<User> USERS = DataUsers.getUsers();

    public static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.valueOf(port);
    }
    public static Javalin getApp() {
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



     //---------------------------------------------------------------------------------------
//        Course course1 = new Course(1, "math", "math-desc");
//        Course course2 = new Course(2, "language", "land-des");
//        Course course3 = new Course(3, "java", "java-des");
//
//
//        app.get("/courses/{id}", ctx -> {
//            var id = Integer.parseInt(ctx.pathParam("id"));
//
//            List<Course> courses = new ArrayList<>();
//            courses.add(course1);
//            courses.add(course2);
//            courses.add(course3);
//
//            var selectedPage = courses.stream()
//                    .filter(course -> course.getId().equals(id))
//                    .findFirst()
//                    .orElse(null);
//
//            if (selectedPage == null) {
//                ctx.status(404);
//                return;
//            }
//            var header = "Course for programming";
//            var page = new CoursesPage(Arrays.asList(selectedPage), header);
//            ctx.render("index.jte", Collections.singletonMap("page", page));
//        });
        //this is 7 lesson
        //------------------------------------------------------------------------------



//        app.get("/", ctx -> {
//            ctx.result("Post ID from user " + ctx.pathParam("postId"));
//
//        });

//        app.get("/users/{id}", ctx -> {
//            PolicyFactory policy = new HtmlPolicyBuilder()
//                    .allowElements("a")
//                    .allowUrlProtocols("https")
//                    .allowAttributes("href").onElements("a")
//                    .requireRelNofollowOnLinks()
//                    .toFactory();
//
//            var id = ctx.pathParam("id");
//            var escapedId = StringEscapeUtils.escapeHtml4(id);
//            var filtredHtml = policy.sanitize(escapedId);
//            ctx.contentType("html/text");
//            ctx.result(filtredHtml);
//        });

//        Course course1 = new Course(1L, "math", "math-desc");
//        Course course2 = new Course(2L, "language", "land-des");
//        Course course3 = new Course(3L, "java", "java-des");
//        List<Course> courses = new ArrayList<>();
//        courses.add(course1);
//        courses.add(course2);
//        courses.add(course3);


        app.get("/users/build", ctx -> {
            var page = new BuildUserPage();
            ctx.render("users/build.jte", Collections.singletonMap("page", page));
        });

        app.get("/courses/build", ctx -> {
            var page = new BuildCoursePage();
            ctx.render("courses/build.jte", Collections.singletonMap("page", page));
        });

        app.post("/users", ctx -> {
            var name = ctx.formParam("name");
            var email = ctx.formParam("email").trim().toLowerCase();

            try {
                var passwordConfirmation = ctx.formParam("passwordConfirmation");
                var password = ctx.formParamAsClass("password", String.class)
                        .check(value -> value.equals(passwordConfirmation), "Password mismatch!")
                        .check(value -> value.length() > 4, "Password is too short!")
                        .get();
                User user = new User(name, email, password);
                UserRepository.save(user);
                ctx.redirect("/users");
            } catch (ValidationException e) {
                var page = new BuildUserPage(name, email, e.getErrors());
                ctx.render("users/build.jte", Collections.singletonMap("page", page));
            }
        });

        app.post("/courses", ctx -> {
            try {
                var name = ctx.formParamAsClass("name", String.class)
                        .check(value -> value.length() > 2, "Название курса слишком короткое!")
                        .get();
                var description = ctx.formParamAsClass("description", String.class)
                        .check(value -> value.length() > 10, "Описание курса слишком короткое!")
                        .get();
                var passwordConfirmation = ctx.formParam("passwordConfirmation");
                var password = ctx.formParam("password");
                var course = new Course(name, description, password);
                CourseRepository.save(course);
                ctx.redirect("/courses");
            } catch (ValidationException e) {
                var page = new BuildCoursePage(e.getErrors());
                ctx.render("courses/build.jte", Collections.singletonMap("page", page));
            }
        });

        app.get("/users/{id}", ctx -> {
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


        app.get("/courses/{id}", ctx -> {
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




        app.get("/users", ctx -> {
            List<User> RESULT_USERS = new ArrayList<>();
            RESULT_USERS.addAll(USERS);
            RESULT_USERS.addAll(UserRepository.getEntities());

            var term = ctx.queryParam("term");
            List<User> users = new ArrayList<>();

            if (term != null) {
                Set<String> namesUsers = new TreeSet<>();
                namesUsers = RESULT_USERS.stream()
                        .map(User::getName)
                        .collect(Collectors.toSet());

                Set<String> mailUsers = new TreeSet<>();
                mailUsers = RESULT_USERS.stream()
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
                    users = RESULT_USERS.stream()
                            .filter(u  -> startsWithIgnoreCase(u.getName(), term))
                            .collect(Collectors.toList());
                } else if (mailExist) {
                    users = RESULT_USERS.stream()
                            .filter(u -> startsWithIgnoreCase(u.getEmail(), term))
                            .collect(Collectors.toList());
                }
            } else {
                users = RESULT_USERS;
            }
            UsersPage page = new UsersPage(users, term);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));

        });




        app.get("/courses", ctx -> {
            List<Course> RESULT_COURSES = new ArrayList<>();
            RESULT_COURSES.addAll(COURSES);
            RESULT_COURSES.addAll(CourseRepository.getEntities());

            var term = ctx.queryParam("term");
            List<Course> courses = new ArrayList<>();

            if (term != null) {
                Set<String> namesCourses = new TreeSet<>();
                namesCourses = RESULT_COURSES.stream()
                        .map(Course::getName)
                        .collect(Collectors.toSet());

                Set<String> descCourses = new TreeSet<>();
                descCourses = RESULT_COURSES.stream()
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
                     courses = RESULT_COURSES.stream()
                            .filter(c  -> startsWithIgnoreCase(c.getName(), term))
                            .collect(Collectors.toList());
                } else if (descExist) {
                    courses = RESULT_COURSES.stream()
                            .filter(c -> startsWithIgnoreCase(c.getDescription(), term))
                            .collect(Collectors.toList());
                }
            } else {
                courses = RESULT_COURSES;
            }
            CoursesPage page = new CoursesPage(courses, term);
            ctx.render("courses/index.jte", Collections.singletonMap("page", page));

        });


        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }
    public static void main(String[] args) throws IOException, SQLException {
        Javalin app = getApp();
        app.start(getPort());
    }
}