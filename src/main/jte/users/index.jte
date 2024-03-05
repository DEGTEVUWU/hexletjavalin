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
    @for(var user : page.getUserList())
        <tr>
            <td>${user.getId()}</td>
            <td>
                <a href="${NamedRoutes.usersPath()}${user.getId()}">${user.getName()} ${user.getLastName()}</a>
                <br>
            </td>
        </tr>
    @endfor
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