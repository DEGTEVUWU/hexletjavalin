@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.model.User
@import org.example.hexlet.utils.NamedRoutes

@param UsersPage page


@template.layout.page(
content  = @`
    <body>
    <h1>${"Это лист со всеми доступными юзерами!"}</h1>
    <br>
    <h4>${"Вы можете найти юзера по имени"}</h4>
    <form action="${NamedRoutes.usersPath()}" method="get">
        <label>
            <input type="search" name="term" value="${page.getTerm()}">
        </label>
        <input type="submit" value="Искать">
    </form>
    @if(page.getUserList().isEmpty())
        <p>Пока не добавлено ни одного пользователя</p>
    @else
        @for(var user : page.getUserList())
            <div>
                <h2><a href="${NamedRoutes.userPath(user.getId())}">${user.getName()} ${user.getLastName()}</a></h2>
                <p>${user.getEmail()}</p>
            </div>
        @endfor
    @endif
    </body>

`
,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу со всеми юзерами! Жду снова!</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)