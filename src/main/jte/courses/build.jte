@import org.example.hexlet.dto.courses.BuildCoursePage
@import org.example.hexlet.utils.CourseNamedRoutes
@import org.example.hexlet.utils.UserNamedRoutes
@param BuildCoursePage page


@template.layout.page(
content  = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

            <div class="mx-auto p-4 py-md-5">
    <form action="${CourseNamedRoutes.coursesPath()}" method="post">
            <div class="mb-3">
                <label class="form-label">
                Название курса
                <input type="text" class="form-control" name="name" value="${page.getName()}"/>
            </label>
        </div>
            <div class="mb-3">
                <label class="form-label">
                Описание курса
                <textarea class="form-control" required name="description" rows="6" cols="30" value="${page.getDescription()}"></textarea>
            </label>
        </div>
        <input type="submit" value="Зарегистрировать" />
    </form>
`
,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с регистрацией нового курса!
            Зарегайся, краб и чекни, что будет..</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)