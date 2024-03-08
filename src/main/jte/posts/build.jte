@import org.example.hexlet.dto.posts.BuildPostPage
@import org.example.hexlet.utils.PostsNamedRoutes
@param BuildPostPage page


@template.layout.page(
content  = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="${PostsNamedRoutes.postsPath()}" method="post">
        <div>
            <label>
                Название поста
                <input type="text" name="name" value="${page.getName()}"/>
            </label>
        </div>
        <div>
            <label>
                Содержание поста
                <textarea required name="content" rows="6" cols="30" value="${page.getBody()}"></textarea>
            </label>
        </div>
        <input type="submit" value="Зарегистрировать" />
    </form>
`
,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с регистрацией нового пользоватея!
            Зарегайся, краб и чекни, что будет..</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)