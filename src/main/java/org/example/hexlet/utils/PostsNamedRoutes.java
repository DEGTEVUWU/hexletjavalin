package org.example.hexlet.utils;

public class PostsNamedRoutes {
    public static String postsPath() {
        return "/posts";
    }

    //маршрут для конкретного поста
    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }

    //маршрут для конкретного поста
    public static String postPath(String id) {
        return "/posts/" + id;
    }
    public static String buildPostsPath() {
        return "/posts/build";
    }

    //для редактирования поста
    public static String editPostPath(Long id) {
        return editPostPath(String.valueOf(id));
    }

    //для редактирования поста
    public static String editPostPath(String id) {
        return "/posts/" + id + "/edit";
    }
}
