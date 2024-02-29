package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import io.javalin.http.NotFoundResponse;

import io.javalin.Javalin;

import java.util.Optional;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });


        app.get("/users/{id}", ctx -> {
            ctx.result("User ID: " + ctx.pathParam("id"));
        });
        app.get("/posts/{postId}", ctx -> {
            ctx.result("Post ID: " + ctx.pathParam("postId"));
        });
        app.get("/users/{id}/posts/{postId}", ctx -> {
            ctx.result("User ID: " + ctx.pathParam("id"));
            ctx.result("Post ID from user " + ctx.pathParam("postId"));

        });

        app.start(7070);
    }

}