@import org.example.hexlet.dto.posts.EditPostPage
@import org.example.hexlet.dto.users.EditUserPage
@param EditUserPage page

@template.layout.page(
content = @`
    @if(page.getErrors() != null)
        <div class="mb-3">
            <ul>
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        </div>
    @endif

    <div class="mx-auto p-4 py-md-5">
        <form action="/users/${page.getId()}" method="post">
            <div class="mb-3">
                <label class="form-label">
                    Изменить имя
                    <input type="text" class="form-control" name="name" value="${page.getName()}"/>
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    Изменить второе имя
                    <input type="text" class="form-control" name="lastname" value="${page.getLastname()}"/>
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    Изменить email
                    <input type="email" class="form-control" name="email" value="${page.getEmail()}"/>
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    Изменить пароль
                    <input type="password" class="form-control" name="password" value="${page.getPassword()}"/>
                </label>
            </div>
            <input type="submit" class="btn btn-primary" value="Обновить" />
        </form>
    </div>
`
,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с изменением данных пользователя!
            Измени что-то, краб и чекни, что будет..</a>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)