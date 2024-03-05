@import org.example.hexlet.model.Course
@import org.example.hexlet.dto.courses.CoursesPage
@import org.example.hexlet.utils.NamedRoutes

@param CoursesPage page


@template.layout.page(
content  = @`
    <body>
    <h1>${"Это лист со всеми доступными курсами!"}</h1>
    <br>
    <h4>${"Вы можете найти курс по имени"}</h4>
    <form action="${NamedRoutes.coursesPath()}" method="get">
        <label>
            <input type="search" name="term" value="${page.getTerm()}">
        </label>
        <input type="submit" value="Искать">
    </form>
    @if(page.getCourses().isEmpty())
        <p>Пока не добавлено ни одного курса</p>
        @else
    @for(var course : page.getCourses())
        <div>
            <h2><a href="${NamedRoutes.coursePath(course.getId())}">${course.getName()}</a></h2>
            <p>${course.getDescription()}</p>
        </div>
    @endfor
        @endif
    </body>
`
,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт и страницу со всеми курсами! Жду снова!</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)