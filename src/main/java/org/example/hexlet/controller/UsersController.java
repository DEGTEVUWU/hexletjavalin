package org.example.hexlet.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.utils.NamedRoutes;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;

import static org.apache.commons.lang3.StringUtils.startsWithIgnoreCase;

public class UsersController {
    public static void index(Context ctx) {
        List<User> users = UserRepository.getEntities();

        var term = ctx.queryParam("term");
        List<User> finalUsersList = new ArrayList<>();

        if (term != null) {
            Set<String> namesUsers = new TreeSet<>();
            namesUsers = users.stream()
                    .map(User::getName)
                    .collect(Collectors.toSet());

            Set<String> mailUsers = new TreeSet<>();
            mailUsers = users.stream()
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
                finalUsersList = users.stream()
                        .filter(u  -> startsWithIgnoreCase(u.getName(), term))
                        .collect(Collectors.toList());
            } else if (mailExist) {
                finalUsersList = users.stream()
                        .filter(u -> startsWithIgnoreCase(u.getEmail(), term))
                        .collect(Collectors.toList());
            }
        } else {
            finalUsersList = users;
        }
        UsersPage page = new UsersPage(finalUsersList, term);
        ctx.render("users/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        User user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));

        UserPage page = new UserPage(user);
        ctx.render("users/show.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildUserPage();
        ctx.render("users/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
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
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new UserPage(user);
        ctx.render("users/edit.jte", Collections.singletonMap("page", page));
    }


    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var name = ctx.formParam("name");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.usersPath());
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        UserRepository.delete(id);
        ctx.redirect(NamedRoutes.usersPath());
    }
}