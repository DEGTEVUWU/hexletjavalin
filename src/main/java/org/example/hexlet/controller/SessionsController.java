package org.example.hexlet.controller;
import io.javalin.http.Context;
import org.example.hexlet.dto.LoginPage;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.repository.UserRepository;
import java.util.Collections;

import static org.example.hexlet.utils.Security.encrypt;

public class SessionsController {

    public static void index(Context ctx) {
        var user = ctx.sessionAttribute("user");
        var page = new MainPage(user);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage("", "");
        ctx.render("sessions/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");

        var user = UserRepository.findByName(name);

        if (user != null && user.getPassword().equals(encrypt(password))) {
            ctx.sessionAttribute("user", user.getName());
            ctx.redirect("/");
        } else {
            var errorMessage = "Wrong username or password";
            var page = new LoginPage(name, errorMessage);
            ctx.render("sessions/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("user", null);
        ctx.redirect("/");
    }
}
