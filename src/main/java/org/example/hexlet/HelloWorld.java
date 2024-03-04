package org.example.hexlet;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;
import io.javalin.Javalin;
import org.apache.commons.text.StringEscapeUtils;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import io.javalin.Javalin;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;

public class HelloWorld {
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



        app.get("/", ctx -> {
            ctx.result("Post ID from user " + ctx.pathParam("postId"));

        });

        app.get("/users/{id}", ctx -> {
            PolicyFactory policy = new HtmlPolicyBuilder()
                    .allowElements("a")
                    .allowUrlProtocols("https")
                    .allowAttributes("href").onElements("a")
                    .requireRelNofollowOnLinks()
                    .toFactory();

            var id = ctx.pathParam("id");
            var escapedId = StringEscapeUtils.escapeHtml4(id);
            var filtredHtml = policy.sanitize(escapedId);
            ctx.contentType("html/text");
            ctx.result(filtredHtml);
        });



        return app;
    }
    public static void main(String[] args) throws IOException, SQLException {
        Javalin app = getApp();
        app.start(getPort());
    }
}