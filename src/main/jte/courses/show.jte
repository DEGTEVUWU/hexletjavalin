@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.model.Course
@import org.example.hexlet.utils.CourseNamedRoutes
@import org.example.hexlet.utils.UserNamedRoutes
@param CoursePage page

@template.layout.page(
content  = @`
    <main>
        <div class="mx-auto p-4 py-md-2">
            <h3>${page.getCourse().getName()}</h3>
        </div>

        <div class="mx-auto p-4 py-md-2">
            ${page.getCourse().getDescription()}
        </div>
        <!-- BEGIN -->
        <div class="mx-auto p-4 py-md-2">
            <a href="${CourseNamedRoutes.editCoursePath(page.getCourse().getId())}">Редактировать</a>
        </div>
        <!-- END -->
    </main>
`
,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт! Особенно страницу с описанием курса № ${page.getCourse().getId()}! Жду снова!</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)