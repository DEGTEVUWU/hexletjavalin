@import org.example.hexlet.dto.users.UserPage
@import org.example.hexlet.utils.UserNamedRoutes
@param UserPage page

@template.layout.page(
content  = @`
    <main>
        <div class="mx-auto p-4 py-md-2">
            <h4>${page.getUser().getName()}</h4>
        </div>

        <div class="mx-auto p-4 py-md-2">
            <h4>${page.getUser().getLastName()}</h4>
        </div>
        <div class="mx-auto p-4 py-md-2">
            ${page.getUser().getEmail()}
        </div>
        <!-- BEGIN -->
        <div class="mx-auto p-4 py-md-2">
            <a href="${UserNamedRoutes.editUserPath(page.getUser().getId())}">Редактировать</a>
        </div>
        <!-- END -->
    </main>
`
,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт! Особенно эту страницу с полной информацией про пользователя №
            ${page.getUser().getId()} Жду снова!</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)