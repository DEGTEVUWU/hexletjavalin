package org.example.hexlet.controller;

import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.EditCoursePage;
import org.example.hexlet.dto.posts.EditPostPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.PostRepository;
import org.example.hexlet.utils.CourseNamedRoutes;
import org.example.hexlet.utils.UserNamedRoutes;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.utils.PostsNamedRoutes;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.startsWithIgnoreCase;

public class CoursesController {
    public static void index(Context ctx) {
        List<Course> courses = CourseRepository.getEntities();
        var term = ctx.queryParam("term");
        List<Course> finalCoursesList = new ArrayList<>();

        if (term != null) {
            Set<String> namesCourses = new TreeSet<>();
            namesCourses = courses.stream()
                    .map(Course::getName)
                    .collect(Collectors.toSet());

            Set<String> descCourses = new TreeSet<>();
            descCourses = courses.stream()
                    .map(Course::getDescription)
                    .collect(Collectors.toSet());

            boolean nameExist = false;
            for (var name : namesCourses) {
                if (startsWithIgnoreCase(name, term)) {
                    nameExist = true;
                    break;
                }
            }

            boolean descExist = false;
            for (var name : descCourses) {
                if (startsWithIgnoreCase(name, term)) {
                    descExist = true;
                    break;
                }
            }

            if (nameExist) {
                finalCoursesList = courses.stream()
                        .filter(c  -> startsWithIgnoreCase(c.getName(), term))
                        .collect(Collectors.toList());
            } else if (descExist) {
                finalCoursesList = courses.stream()
                        .filter(c -> startsWithIgnoreCase(c.getDescription(), term))
                        .collect(Collectors.toList());
            }
        } else {
            finalCoursesList = courses;
        }
        CoursesPage page = new CoursesPage(finalCoursesList, term);
        ctx.render("courses/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        Course course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));

        CoursePage page = new CoursePage(course);
        ctx.render("courses/show.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var description = ctx.formParam("description");

        try {
            ctx.formParamAsClass("name", String.class)
                    .check(value -> CourseRepository.getEntities().stream()
                                    .noneMatch(course -> course.getName().equals(value)),
                            "Курс с таким названием уже существует!")
                    .check(value -> value.length() > 2, "Название курса слишком короткое!")
                    .get();
            ctx.formParamAsClass("description", String.class)
                    .check(value -> value.length() > 10, "Описание курса слишком короткое!")
                    .get();

            Course course = new Course(name, description);
            CourseRepository.save(course);
            ctx.redirect(CourseNamedRoutes.coursesPath());
        } catch (ValidationException e) {
            var page = new BuildCoursePage(name, description, e.getErrors());
            ctx.status(422).render("courses/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Course not found"));

        var page = new EditCoursePage(id, course.getName(), course.getDescription(), null);
        ctx.render("courses/edit.jte", Collections.singletonMap("page", page));
    }


    public static void update(Context ctx) {

        var id = ctx.pathParamAsClass("id", Long.class).get();

        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                    .get();

            var description = ctx.formParamAsClass("description", String.class)
                    .check(value -> value.length() >= 10, "Описание курса должен быть не короче 10 символов")
                    .get();

            var course = CourseRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Course not found"));

            course.setName(name);
            course.setDescription(description);

            ctx.redirect(CourseNamedRoutes.coursesPath());

        } catch (ValidationException e) {
            var name = ctx.formParam("name");
            var description = ctx.formParam("description");
            var page = new EditCoursePage(id, name, description, e.getErrors());
            ctx.render("courses/edit.jte", Collections.singletonMap("page", page)).status(422);
        }
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        CourseRepository.delete(id);
        ctx.redirect(CourseNamedRoutes.coursesPath());
    }
}
