@import org.example.hexlet.dto.courses.CoursesPage

@param CoursesPage page


@template.layout.page(
content  = @`
    <form action="/courses" method="post">
        <div>
            <label>
                Название курса
                <input type="text" name="name" />
            </label>
        </div>
        <div>
            <label>
                Описание курса
                <input type="text" required name="text" />
            </label>
        </div>
        <div>
            <label>
                Пароль для курса
                <input type="password" required name="password" />
            </label>
        </div>
        <div>
            <label>
                Подтверждение пароля
                <input type="password" required name="passwordConfirmation" />
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