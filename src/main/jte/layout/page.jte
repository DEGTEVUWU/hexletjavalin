@import gg.jte.Content
@import org.example.hexlet.dto.BasePage
@import org.example.hexlet.model.Course
@import org.example.hexlet.utils.*
@import org.example.hexlet.utils.UserNamedRoutes
@import org.example.hexlet.utils.PostsNamedRoutes
@import org.example.hexlet.utils.UserNamedRoutes

@param Content content = null
@param Content footer = null
@param BasePage page = null

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Hello Hexlet!</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="${RootNamedRoutes.mainPath()}">Главная</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${CourseNamedRoutes.coursesPath()}">Все курсы</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${UserNamedRoutes.usersPath()}">Все пользователи</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${PostsNamedRoutes.postsPath()}">Все посты</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${CarsNamedRoutes.carsPath()}">Все машины</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${CourseNamedRoutes.buildCoursesPath()}">Написать курс</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${UserNamedRoutes.buildUserPath()}">Зарегистрировать пользователя</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${PostsNamedRoutes.buildPostsPath()}">Написать пост</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${CarsNamedRoutes.buildCarsPath()}">Добавить машину</a>
            </li>


        </ul>
    </div>
</nav>

<main>
    @if(page != null && page.getFlash() != null)
        <div class="alert alert-success" role="alert">
            ${page.getFlash()}
        </div>
    @endif
        @if (page != null && page.getErrorFlash() != null)
        <div class="alert alert-danger" role="alert">
            ${page.getErrorFlash()}
        </div>
    @endif

    ${content}

</main>
<footer class="text-center text-lg-start bg-light text-muted">
    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
        ${footer}
    </div>
</footer>
</body>
</html>