@import gg.jte.Content
@param Content content

@template.layout.page(
content  = @`
    <h1>Заголовок моего локал-сайта!</h1>
    <h2>Подзаголовок! Если ты читаешь - пожалуйста, пользуйся</h2>
    <h4>Тут ты увидишь:</h4>
    <ul>
        <li><a href="/">Главную страницу</a></li>
        <li><a href="/courses/">Список всех курсов</a></li>
        <li><a href="/courses/{1}">Инфу про каждый курс</a></li>
    </ul>
`
,
footer = @`
    <div class="footer">
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)