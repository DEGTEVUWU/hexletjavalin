@import org.example.hexlet.dto.posts.PostsPage
@import org.example.hexlet.model.Post
@import org.example.hexlet.utils.PostsNamedRoutes

@param PostsPage page


@template.layout.page(
content  = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>${"Это лист со всеми доступными постами!"}</h1>

            <div class="mb-3">
                <a href="${PostsNamedRoutes.buildPostsPath()}">Создать новый пост</a>
            </div>

            @if(page.getPostList().isEmpty())
                <p>Пока не добавлено ни одного поста</p>
            @else

                <table class="table table-striped">
                    @for(var post : page.getPostList())
                        <tr>
                            <td>
                                ${post.getId()}
                            </td>
                            <td>
                                <a href="${PostsNamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                            </td>
                            <td>
                                <a>${post.getBody()}</a>
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