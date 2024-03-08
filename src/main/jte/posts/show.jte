@import org.example.hexlet.dto.posts.PostPage
@import org.example.hexlet.utils.NamedRoutes
@import org.example.hexlet.utils.PostsNamedRoutes
@param PostPage page


@template.layout.page(
content = @`
    <main>
        <div class="mx-auto p-4 py-md-5">
            <h1>${page.getPost().getName()}</h1>
        </div>

        <div class="mx-auto p-4 py-md-5">
            ${page.getPost().getBody()}
        </div>
        <!-- BEGIN -->
        <div class="mx-auto p-4 py-md-5">
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