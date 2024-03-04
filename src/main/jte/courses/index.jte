@import org.example.hexlet.model.Course
@import org.example.hexlet.dto.courses.CoursesPage

@param CoursesPage page


@template.layout.page(
content  = @`
    <body>
    <h1>${"Это лист со всеми доступными курсами!"}</h1>
    <br>
    <h4>${"Вы можете найти курс по имени"}</h4>
    <form action="/courses" method="get">
        <label>
            <input type="search" name="term" value="${page.getTerm()}">
        </label>
        <input type="submit" value="Искать">
    </form>
    @for(var course : page.getCourses())
        <tr>
            <td>${course.getId()}</td>
            <td>
                <a href="/courses/${course.getId()}">${course.getName()} ${course.getDescription()}</a>
                <br>
            </td>
        </tr>
    @endfor
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