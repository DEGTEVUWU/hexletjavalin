@import org.example.hexlet.dto.posts.PostPage
@import org.example.hexlet.utils.UserNamedRoutes
@import org.example.hexlet.utils.PostsNamedRoutes
@param PostPage page


@template.layout.page(
content = @`
    <main>
        <div class="mx-auto p-4 py-md-2">
            <h3>${page.getPost().getName()}</h3>
        </div>

        <div class="mx-auto p-4 py-md-2">
            ${page.getPost().getBody()}
        </div>
        <!-- BEGIN -->
        <div class="mx-auto p-4 py-md-2">
            <a href="${PostsNamedRoutes.editPostPath(page.getPost().getId())}">Редактировать</a>
        </div>
        <!-- END -->
    </main>
`
    ,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с полной информацией о посте №
            ${page.getPost().getId()}!</a>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)