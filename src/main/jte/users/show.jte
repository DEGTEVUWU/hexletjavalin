@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.page(
content  = @`
    <div>
        ${page.getUser().getId()} ${page.getUser().getName()} ${page.getUser().getLastName()} ${page.getUser().getEmail()}
    </div>
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