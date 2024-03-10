@import org.example.hexlet.dto.users.BuildUserPage
@import org.example.hexlet.utils.UserNamedRoutes
@param BuildUserPage page


@template.layout.page(
page = page,
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
    <form action="${UserNamedRoutes.usersPath()}" method="post">
            <div class="mb-3">
                <label class="form-label">
                Имя пользователя
                <input type="text" class="form-control" name="name" value="${page.getName()}"/>
            </label>
        </div>
            <div class="mb-3">
                <label class="form-label">
                Фамилия пользователя
                <input type="text" class="form-control" name="lastName" value="${page.getLastname()}"/>
            </label>
        </div>
            <div class="mb-3">
                <label class="form-label">
                Email
                <input type="email" class="form-control" required name="email" value="${page.getEmail()}"/>
            </label>
        </div>
            <div class="mb-3">
                <label class="form-label">
                Пароль
                <input type="password" class="form-control" required name="password" />
            </label>
        </div>
            <div class="mb-3">
                <label class="form-label">
                Подтверждение пароля
                <input type="password" class="form-control" required name="passwordConfirmation" />
            </label>
        </div>
        <input type="submit" value="Зарегистрировать" />
    </form>
`
,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с регистрацией нового пользоватея!
            Зарегайся, краб и чекни, что будет..</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)

