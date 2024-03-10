@import org.example.hexlet.utils.CarsNamedRoutes
@import org.example.hexlet.dto.cars.BuildCarsPage

@param BuildCarsPage page

@template.layout.page(
content  = @`
<%--    @if(page.getErrors() != null)--%>
<%--        <ul>--%>
<%--            @for(var validator : page.getErrors().values())--%>
<%--                @for(var error : validator)--%>
<%--                    <li>${error.getMessage()}</li>--%>
<%--                @endfor--%>
<%--            @endfor--%>
<%--        </ul>--%>
<%--    @endif--%>

            <div class="mx-auto p-4 py-md-5">
    <form action="${CarsNamedRoutes.carsPath()}" method="post">
            <div class="mb-3">
                <label class="form-label">
                Марка машины
                <input type="text" class="form-control" required  name="make"/>
            </label>
        </div>
             <div class="mb-3">
                <label class="form-label">
                Модель машины
                <input type="text" class="form-control" required name="model"/>
            </label>
        </div>
        <input type="submit" value="Зарегистрировать" />
    </form>
`
,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с добавление данных авто в базу данных!
            Добавь их, краб и чекни, что будет..</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)