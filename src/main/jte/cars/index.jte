@import org.example.hexlet.utils.CarsNamedRoutes
@import org.example.hexlet.dto.cars.CarsPage
@param CarsPage page

@template.layout.page(
page = page,
content = @`
    <h1>Cars List</h1>
    <a href="${CarsNamedRoutes.buildCarsPath()}">New Car</a>
    @if(page.getCars().isEmpty())
        <p>Cars list is empty</p>
    @else
        @for(var car : page.getCars())
            <div>
                <h2>
                    <a href="${CarsNamedRoutes.carPath(car.getId())}">${car.getMake()}</a>
                </h2>
            </div>
        @endfor
    @endif
`
,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт и страницу со всеми машинами! Жду снова!</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)