package org.example.hexlet;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.Data;
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
    private static final List<Course> COURSES = Data.getCourses();

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


        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();

            Course course = COURSES.stream()
                    .filter(c -> id.equals(c.getId()))
                    .findFirst()
                    .orElse(null);

            if (course == null) {
                throw new NotFoundResponse("User not found");
            }

            CoursePage page = new CoursePage(course);
            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
        });

        app.get("/courses", ctx -> {
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