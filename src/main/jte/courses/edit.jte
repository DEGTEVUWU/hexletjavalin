@import org.example.hexlet.dto.courses.EditCoursePage
@param EditCoursePage page

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
        <form action="/courses/${page.getId()}" method="post">
            <div class="mb-3">
                <label class="form-label">
                    Изменить название
                    <input type="text" class="form-control" name="name" value="${page.getName()}" />
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">Изменить описание</label>
                <textarea class="form-control" rows="20" cols="70" type="text" name="description">${page.getDescription()}
                </textarea>
            </div>
            <input type="submit" class="btn btn-primary" value="Обновить" />
        </form>
    </div>
`
,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с изменением данных курса!
            Измени что-то, краб и чекни, что будет..</a>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)