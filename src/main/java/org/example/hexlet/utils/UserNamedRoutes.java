package org.example.hexlet.utils;

public class UserNamedRoutes {

    //маршрут всех пользователей
    public static String usersPath() {
        return "/users";
    }

    //маршрут создания пользователя
    public static String buildUserPath() {
        return "/users/build";
    }



    // преобразование айди юзера в строку
    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }

    //маршрут для конкретного юзера
    public static String userPath(String id) {
        return "/users/" + id;
    }

}
