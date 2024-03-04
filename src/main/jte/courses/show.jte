@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.model.Course
@param CoursePage page

@template.layout.page(
content  = @`
    <div>
        ${page.getCourse().getId()} ${page.getCourse().getName()} ${page.getCourse().getDescription()}
    </div>
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