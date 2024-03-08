@import org.example.hexlet.dto.posts.PostsPage
@import org.example.hexlet.utils.PostsNamedRoutes
@param PostsPage page

@template.layout.page(
content  = @`
    <body>
    <h1>${"Это лист со всеми доступными постами!"}</h1>
    <br>
    <a href="">На страницу с постами!</a>

    @if(page.getPostList().isEmpty())
        <p>Пока не добавлено ни одного поста</p>
    @else
        @for(var post : page.getPostList())
            <div>
                <h2><a href="${PostsNamedRoutes.postPath(post.getId())}">${post.getName()}</a></h2>
                <p>${post.getBody()}</p>
            </div>
        @endfor
    @endif

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link"
                                     href="${PostsNamedRoutes.postsPath()}?page=${page.getPreviousPage()}">Previous</a></li>
            <li class="page-item"><a class="page-link"
                                     href="${PostsNamedRoutes.postsPath()}?page=${page.getNextPage()}">Next</a></li>
        </ul>
    </nav>
    </body>
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