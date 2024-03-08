package org.example.hexlet.utils;

public class CourseNamedRoutes {
    //маршрут всех курсов
    public static String coursesPath() {
        return "/courses";
    }

    //маршрут создания курса
    public static String buildCoursesPath() {
        return "/courses/build";
    }
    //преобразование айди курса в строку
    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    //маршрут для конкретного курса
    public static String coursePath(String id) {
        return "/courses/" + id;
    }

    //для редактирования курса
    public static String editCoursePath(Long id) {
        return editCoursePath(String.valueOf(id));
    }

    //для редактирования курса
    public static String editCoursePath(String id) {
        return "/courses/" + id + "/edit";
    }
}
