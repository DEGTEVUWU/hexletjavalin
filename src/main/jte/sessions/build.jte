@import org.example.hexlet.utils.SessionNamedRoutes
@import org.example.hexlet.dto.LoginPage
@import org.example.hexlet.utils.SessionNamedRoutes
@param LoginPage page

@template.layout.page(
content = @`
    @if(page.getError() != "")
        <div class="mb-3">
            ${page.getError()}
        </div>
    @endif
    <div class="mx-auto p-4 py-md-5">
        <form action="${SessionNamedRoutes.loginPath()}" method="post">
            <div class="mb-3">
                <label class="form-label">
                    Имя
                    <input type="text" class="form-control" name="name" value="${page.getName()}" />
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    Пароль
                    <input type="password" class="form-control" name="password" />
                </label>
            </div>
            <input type="submit" class="btn btn-primary" value="Войти" />
        </form>
    </div>
`
)