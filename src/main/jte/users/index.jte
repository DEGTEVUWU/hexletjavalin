@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.model.User
@import org.example.hexlet.utils.UserNamedRoutes

@param UsersPage page


@template.layout.page(
content  = @`
<div class="mx-auto p-4 py-md-5">
    <main>
    <h1>${"Это лист со всеми доступными юзерами!"}</h1>
    <h4>${"Вы можете найти юзера по имени"}</h4>
    <form action="${UserNamedRoutes.usersPath()}" method="get">
        <label>
            <input type="search" name="term" value="${page.getTerm()}">
        </label>
        <input type="submit" value="Искать">
    </form>

    <div class="mb-3">
        <a href="${UserNamedRoutes.buildUserPath()}">Добавить нового пользователя</a>
    </div>

    @if(page.getUserList().isEmpty())
        <p>Пока не добавлено ни одного пользователя</p>
    @else

        @for(var user : page.getUserList())
            <div>
                <h2><a href="${UserNamedRoutes.userPath(user.getId())}">${user.getName()} ${user.getLastName()}</a></h2>
                <p>${user.getEmail()}</p>
            </div>
        @endfor
    @endif

        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item"><a class="page-link"
                                         href="${UserNamedRoutes.usersPath()}?page=${page.getPreviousPage()}">Previous</a></li>
                <li class="page-item"><a class="page-link"
                                         href="${UserNamedRoutes.usersPath()}?page=${page.getNextPage()}">Next</a></li>
            </ul>
        </nav>

</main>
</div>
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