@import org.example.hexlet.dto.courses.CoursesPage
@import org.example.hexlet.model.Course
@import org.example.hexlet.utils.CourseNamedRoutes

@param CoursesPage page


@template.layout.page(
content  = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>${"Это лист со всеми доступными курсами!"}</h1>

            <div class="mb-3">
                <a href="${CourseNamedRoutes.buildCoursesPath()}">Добавить новый курс!</a>
            </div>

            @if(page.getCourses().isEmpty())
                <p>Пока не добавлено ни одного курса</p>
            @else

                <table class="table table-striped">
                    @for(var course : page.getCourses())
                        <tr>
                            <td>
                                ${course.getId()}
                            </td>
                            <td>
                                <a href="${CourseNamedRoutes.coursePath(course.getId())}">${course.getName()}</a>
                            </td>
                            <td>
                                <a>${course.getDescription()}</a>
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
        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с выборкой курсов по твоему поиску! Жду снова!</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)