package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.HttpStatus;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

//        app.get("/", ctx -> {
//            ctx.status(403);
//            ctx.header("KEY", "value");
//        });
        app.get("/hello", ctx -> {
            var name = ctx.queryParamAsClass("name", String.class).getOrDefault("Hello, World");
            ctx.result("Hello " + name + "!");
        });
//        app.get("/admin", ctx -> {
//            // Указываем статус вторым параметром
//            ctx.redirect("/", HttpStatus.forStatus(302));
//        });
//        app.get("/", ctx -> {
//            ctx.result("Hello World");
//        });
//        app.get("/users", ctx -> {
//            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
//        });
        app.start(7070);
    }
}