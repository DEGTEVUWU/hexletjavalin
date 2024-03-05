package org.example.hexlet.utils;

public class NamedRoutes {

    //маршрут главной страницы
    public static String mainPath() {
        return "/";
    }

    //маршрут всех пользователей
    public static String usersPath() {
        return "/users";
    }

    //маршрут создания пользователя
    public static String buildUserPath() {
        return "/users/build";
    }

    //маршрут всех курсов
    public static String coursesPath() {
        return "/courses";
    }

    //маршрут создания курса
    public static String buildCoursesPath() {
        return "/courses/build";
    }

    // преобразование айди юзера в строку
    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }

    //маршрут для конкретного юзера
    public static String userPath(String id) {
        return "/users/" + id;
    }

    //преобразование айди курса в строку
    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    //маршрут для конкретного курса
    public static String coursePath(String id) {
        return "/courses/" + id;
    }
}
