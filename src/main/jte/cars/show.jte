@import org.example.hexlet.utils.CarsNamedRoutes
@import org.example.hexlet.dto.cars.CarPage
@param CarPage page

@template.layout.page(
content = @`
    <h1>${page.getCar().getMake()}</h1>
    <h3>${page.getCar().getModel()}</h3>

`
,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт! Особенно страницу с описанием машины № ${page.getCar().getId()}! Жду снова!</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)