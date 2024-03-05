@import org.example.hexlet.dto.courses.BuildCoursePage
@import org.example.hexlet.utils.NamedRoutes
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

    <form action="${NamedRoutes.coursesPath()}" method="post">
        <div>
            <label>
                Название курса
                <input type="text" name="name" value="${page.getName()}"/>
            </label>
        </div>
        <div>
            <label>
                Описание курса
                <textarea required name="description" rows="6" cols="30" value="${page.getDescription()}"></textarea>
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