@import gg.jte.Content
@import org.example.hexlet.utils.NamedRoutes
@param Content content

@template.layout.page(
content  = @`
    <h1>Заголовок моего локал-сайта!</h1>
    <h2>Подзаголовок! Если ты читаешь - пожалуйста, пользуйся</h2>
    <h4>Тут ты увидишь:</h4>
    <ul>
        <li><a href="${NamedRoutes.mainPath()}">Главную страницу</a></li>
        <li><a href="${NamedRoutes.coursesPath()}">Список всех курсов</a></li>
        <li><a href="${NamedRoutes.usersPath()}">Список всех юзеров</a></li>
        <li><a>Инфу про каждый курс</a></li>
        <li><a>Инфу про каждого юзера</a></li>
    </ul>
`
,
footer = @`
    <div class="footer">
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)