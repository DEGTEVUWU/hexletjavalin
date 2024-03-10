package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.cars.BuildCarsPage;
import org.example.hexlet.dto.cars.CarPage;
import org.example.hexlet.dto.cars.CarsPage;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.model.Car;
import org.example.hexlet.repository.CarRepository;
import org.example.hexlet.utils.CarsNamedRoutes;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CarController {
    public static void index(Context ctx) throws SQLException {
        List<Car> cars = CarRepository.getEntities();
        var page = new CarsPage(cars);

        //вывод флеш сообщения о создании курса
        String flash = ctx.consumeSessionAttribute("flash");
        page.setFlash(flash);

        ctx.render("cars/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var car = CarRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Car with id = " + id + " not found"));
        var page = new CarPage(car);
        ctx.render("cars/show.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        ctx.render("cars/build.jte");
    }

    public static void create(Context ctx) throws SQLException {
        var make = ctx.formParam("make");
        var model = ctx.formParam("model");

        try {
            var car = new Car(make, model);
            CarRepository.save(car);
            ctx.redirect(CarsNamedRoutes.carsPath());
        } catch (ValidationException e) {
            var page = new BuildCarsPage(make, model, e.getErrors());
            ctx.status(422).render("cars/build.jte", Collections.singletonMap("page", page));
        }

    }
}
