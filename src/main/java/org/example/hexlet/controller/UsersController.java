package org.example.hexlet.controller;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.example.hexlet.dto.posts.EditPostPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.EditUserPage;
import org.example.hexlet.model.Post;
import org.example.hexlet.repository.PostRepository;
import org.example.hexlet.utils.Security;
import org.example.hexlet.utils.UserNamedRoutes;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.utils.UserNamedRoutes;

import static org.apache.commons.lang3.StringUtils.startsWithIgnoreCase;

public class UsersController {
    public static void index(Context ctx) throws SQLException {
        List<User> users = UserRepository.getEntities();
        List<User> finalUsersList = new ArrayList<>(users);
        var term = ctx.queryParam("term");


        //код для поиска юзера по имени и мэйлу
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
            UsersPage page = new UsersPage(finalUsersList, null, null, null, term);
            ctx.render("users/search.jte", Collections.singletonMap("page", page));
            return;
        }

        //создание страни по 5 элементов из списка юзеров на каждой
        int pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int quantity = 5;
        int begin = (pageNumber - 1) * quantity;
        int end = begin + quantity;
        int previousPage = pageNumber == 1 ? 1 : pageNumber - 1;
        int nextPage = pageNumber + 1;
        List<User> sliceOfUsers;

        if(begin >= users.size()) {
            sliceOfUsers = new ArrayList<>();
        } else if (end >= users.size()) {
            sliceOfUsers = users.subList(begin, users.size());
        } else {
            sliceOfUsers = users.subList(begin, end);
        }

        UsersPage page = new UsersPage(sliceOfUsers, pageNumber, previousPage, nextPage, term);

        //вывод флеш-сообщения о создании пользователя
        page.setFlash(ctx.consumeSessionAttribute("flash"));

        ctx.render("users/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) throws SQLException {
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

    public static void create(Context ctx) throws SQLException {
        var name = ctx.formParam("name");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email").trim().toLowerCase();
        var password = ctx.formParam("password");
        var passwordConfirmation = ctx.formParam("passwordConfirmation");

        try {
            ctx.formParamAsClass("name", String.class)
                    .check(value -> {
                                try {
                                    return UserRepository.getEntities().stream()
                                                    .noneMatch(user -> user.getName().equals(value));
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                            },
                            "Пользователь с таким именем уже существует!")
                    .get();
            ctx.formParamAsClass("password", String.class)
                    .check(value -> value.equals(passwordConfirmation), "Password mismatch!")
                    .check(value -> value.length() > 4, "Password is too short!")
                    .get();
            String encryptedPassword = Security.encrypt(password);
            User user = new User(name, lastName, email, encryptedPassword);
            UserRepository.save(user);

            ctx.sessionAttribute("flash", "Пользователь успешно зарегистрирован!");

            ctx.redirect(UserNamedRoutes.usersPath());
        } catch (ValidationException e) {
            var page = new BuildUserPage(name, lastName, email, password, e.getErrors());

            ctx.sessionAttribute("errorFlash", "Не удалось зарегистрировать пользователя!");
            page.setErrorFlash(ctx.consumeSessionAttribute("errorFlash"));
            ctx.status(422).render("users/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void edit(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new EditUserPage(id, user.getName(), user.getLastName(), user.getEmail(), user.getPassword(), null);
        ctx.render("users/edit.jte", Collections.singletonMap("page", page));
    }


    public static void update(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var name = ctx.formParam("name");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        try {
            ctx.formParamAsClass("password", String.class)
                    .check(value -> value.length() > 4, "Password is too short!")
                    .get();

            var user = UserRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));

            user.setId(id);
            user.setName(name);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(password);
            ctx.redirect(UserNamedRoutes.usersPath());
        } catch (ValidationException e) {
            var page = new EditUserPage(id, name, lastName, email, password, e.getErrors());
            ctx.render("users/edit.jte", Collections.singletonMap("page", page)).status(422);
        }

    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        UserRepository.delete(id);
        ctx.redirect(UserNamedRoutes.usersPath());
    }
}
