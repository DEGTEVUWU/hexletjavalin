@import gg.jte.Content
@import org.example.hexlet.dto.MainPage
@import org.example.hexlet.utils.*
@import org.example.hexlet.utils.UserNamedRoutes
@import org.example.hexlet.utils.PostsNamedRoutes

@param MainPage page
@param Content content

@template.layout.page(
content  = @`
    <h1>Заголовок моего локал-сайта!</h1>
    <h2>Подзаголовок! Если ты читаешь - пожалуйста, пользуйся</h2>

        @if(!page.isVisited())
            <h2>Это сообщение показывается лишь единожды! Если хочешь снова - сотри куки!</h2>
            @endif
    <h4>Тут ты увидишь:</h4>
    <ul>
        <li><a href="${RootNamedRoutes.mainPath()}">Главную страницу</a></li>
        <li><a href="${CourseNamedRoutes.coursesPath()}">Список всех курсов</a></li>
        <li><a href="${UserNamedRoutes.usersPath()}">Список всех юзеров</a></li>
        <li><a href="${PostsNamedRoutes.postsPath()}">Список всех постов</a> </li>
        <li><a>Инфу про каждый курс</a></li>
        <li><a>Инфу про каждого юзера</a></li>
        <li><a>Инфу про каждый пост</a></li>
    </ul>
`
,
footer = @`
    <div class="footer">
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)