@import org.example.hexlet.model.Course
@import org.example.hexlet.dto.courses.CoursesPage
@import org.example.hexlet.utils.CourseNamedRoutes
@import org.example.hexlet.utils.UserNamedRoutes

@param CoursesPage page


@template.layout.page(
content  = @`
<div class="mx-auto p-4 py-md-5">
    <main>
    <h1>${"Это лист со всеми доступными курсами!"}</h1>

    <h4>${"Вы можете найти курс по имени"}</h4>
    <form action="${CourseNamedRoutes.coursesPath()}" method="get">
        <label>
            <input type="search" name="term" value="${page.getTerm()}">
        </label>
        <input type="submit" value="Искать">
    </form>

        <div class="mb-3">
            <a href="${CourseNamedRoutes.buildCoursesPath()}">Создать новый курс</a>
        </div>


    @if(page.getCourses().isEmpty())
        <p>Пока не добавлено ни одного курса</p>
        @else


        <table class="table table-striped">
            @for(var post : page.getCourses())
                <tr>
                    <td>
                        ${post.getId()}
                    </td>
                    <td>
                        <a href="${CourseNamedRoutes.coursePath(post.getId())}">${post.getName()}</a>
                    </td>
                    <td>
                        ${post.getDescription()}
                    </td>
                </tr>
            @endfor
        </table>
        @endif
        </main>
</div>
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