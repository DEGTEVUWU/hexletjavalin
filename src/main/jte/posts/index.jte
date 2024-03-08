@import org.example.hexlet.dto.posts.PostsPage
@import org.example.hexlet.utils.PostsNamedRoutes
@param PostsPage page

@template.layout.page(
content  = @`
<div class="mx-auto p-4 py-md-5">
    <main>
    <h1>${"Это лист со всеми доступными постами!"}</h1>

        <h4>${"Вы можете найти курс по имени"}</h4>
        <form action="${PostsNamedRoutes.postsPath()}" method="get">
            <label>
                <input type="search" name="term" value="${page.getTerm()}">
            </label>
            <input type="submit" value="Искать">
        </form>

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
                        ${post.getBody()}
                    </td>
                </tr>
            @endfor
        </table>
    @endif

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link"
                                     href="${PostsNamedRoutes.postsPath()}?page=${page.getPreviousPage()}">Previous</a></li>
            <li class="page-item"><a class="page-link"
                                     href="${PostsNamedRoutes.postsPath()}?page=${page.getNextPage()}">Next</a></li>
        </ul>
    </nav>
    </main>
</div>
`
    ,
footer = @`
<div class="footer">
    <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с регистрацией нового поста!
        Зарегай его, краб и чекни, что будет..</a>
    <br>
    <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
</div>
`
)


