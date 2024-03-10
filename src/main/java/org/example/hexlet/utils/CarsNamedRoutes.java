package org.example.hexlet.utils;

public class CarsNamedRoutes {
    //маршрут всех машин
    public static String carsPath() {
        return "/cars";
    }

    //маршрут создания машины
    public static String buildCarsPath() {
        return "/cars/build";
    }

    //преобразование айди машины в строку
    public static String carPath(Long id) {
        return carPath(String.valueOf(id));
    }

    //маршрут для конкретной машины
    public static String carPath(String id) {
        return "/cars/" + id;
    }

    //для редактирования машины
    public static String editCarPath(Long id) {
        return editCarPath(String.valueOf(id));
    }

    //для редактирования машины
    public static String editCarPath(String id) {
        return "/cars/" + id + "/edit";
    }
}
