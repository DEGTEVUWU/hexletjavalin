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
    <br>

    @if (page.getName() != null)
        <h3 class="mb-3"> Добро пожаловать, ${page.getName().toString()}</h3>
        <form action="${SessionNamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Выйти">
        </form>
    @else
        <h3 class="mb-3"> Добро пожаловать, гость</h3>
        <form action="${SessionNamedRoutes.buildSessionPath()}" method="get">
            <input type="submit" value="Войти">
        </form>
        <form action="${UserNamedRoutes.buildUserPath()}" method="get">
            <input type="submit" value="Зарегистрироваться">
        </form>
    @endif
<br>

        @if(!page.isVisited())
            <h2>Это сообщение показывается лишь единожды! Если хочешь снова - сотри куки!</h2>
            @endif
    @if(page.getCurrentUser() != null)
        Добро пожаловать, ${page.getCurrentUser()}.
        Чтобы разлогиниться, удалите куку JSESSIONID из браузера
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

        <li><a href="${SessionNamedRoutes.buildSessionPath()}">Войти, как юзер</a> </li>

    </ul>
`
,
footer = @`
    <div class="footer">
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)