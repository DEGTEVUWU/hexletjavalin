@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.model.User
@import org.example.hexlet.utils.UserNamedRoutes

@param UsersPage page


@template.layout.page(
content  = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>${"Это лист со всеми доступными юзерами!"}</h1>

            <div class="mb-3">
                <a href="${UserNamedRoutes.buildUserPath()}">Добавить нового пользователя</a>
            </div>

            @if(page.getUserList().isEmpty())
                <p>Пока не добавлено ни одного пользователя</p>
            @else

            <table class="table table-striped">
            @for(var user : page.getUserList())
                    <tr>
                        <td>
                            ${user.getId()}
                        </td>
                        <td>
                            <a href="${UserNamedRoutes.userPath(user.getId())}">${user.getName()}</a>
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
        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с выборкой юзеров по твоему поиску! Жду снова!</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)