package org.example.hexlet.utils;

public class SessionNamedRoutes {
    public static String rootPath() {
        return "/";
    }

    public static String loginPath() {
        return "/sessions";
    }

    public static String logoutPath() {
        return "sessions/delete";
    }

    public static String buildSessionPath() {
        return "/sessions/build";
    }
}
