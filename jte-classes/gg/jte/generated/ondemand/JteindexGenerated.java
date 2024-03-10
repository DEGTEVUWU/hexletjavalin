package gg.jte.generated.ondemand;
import gg.jte.Content;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.utils.*;
import org.example.hexlet.utils.UserNamedRoutes;
import org.example.hexlet.utils.PostsNamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,6,6,6,9,9,13,13,18,18,19,19,19,20,20,20,20,20,20,20,20,23,23,25,25,25,25,25,25,25,25,28,28,28,28,28,28,28,28,31,31,34,34,36,36,37,37,38,38,38,40,40,43,43,43,43,43,43,43,43,44,44,44,44,44,44,44,44,45,45,45,45,45,45,45,45,46,46,46,46,46,46,46,46,47,47,47,47,47,47,47,47,52,52,52,52,52,52,52,52,55,55,55,55,59,59,59};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page, Content content) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <h1>Заголовок моего локал-сайта!</h1>\r\n    <h2>Подзаголовок! Если ты читаешь - пожалуйста, пользуйся</h2>\r\n    <br>\r\n\r\n    ");
				if (page.getName() != null) {
					jteOutput.writeContent("\r\n        <h3 class=\"mb-3\"> Добро пожаловать, ");
					jteOutput.setContext("h3", null);
					jteOutput.writeUserContent(page.getName().toString());
					jteOutput.writeContent("</h3>\r\n        <form");
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(SessionNamedRoutes.logoutPath())) {
						jteOutput.writeContent(" action=\"");
						jteOutput.setContext("form", "action");
						jteOutput.writeUserContent(SessionNamedRoutes.logoutPath());
						jteOutput.setContext("form", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" method=\"post\">\r\n            <input type=\"submit\" value=\"Выйти\">\r\n        </form>\r\n    ");
				} else {
					jteOutput.writeContent("\r\n        <h3 class=\"mb-3\"> Добро пожаловать, гость</h3>\r\n        <form");
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(SessionNamedRoutes.buildSessionPath())) {
						jteOutput.writeContent(" action=\"");
						jteOutput.setContext("form", "action");
						jteOutput.writeUserContent(SessionNamedRoutes.buildSessionPath());
						jteOutput.setContext("form", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" method=\"get\">\r\n            <input type=\"submit\" value=\"Войти\">\r\n        </form>\r\n        <form");
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(UserNamedRoutes.buildUserPath())) {
						jteOutput.writeContent(" action=\"");
						jteOutput.setContext("form", "action");
						jteOutput.writeUserContent(UserNamedRoutes.buildUserPath());
						jteOutput.setContext("form", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" method=\"get\">\r\n            <input type=\"submit\" value=\"Зарегистрироваться\">\r\n        </form>\r\n    ");
				}
				jteOutput.writeContent("\r\n<br>\r\n\r\n        ");
				if (!page.isVisited()) {
					jteOutput.writeContent("\r\n            <h2>Это сообщение показывается лишь единожды! Если хочешь снова - сотри куки!</h2>\r\n            ");
				}
				jteOutput.writeContent("\r\n    ");
				if (page.getCurrentUser() != null) {
					jteOutput.writeContent("\r\n        Добро пожаловать, ");
					jteOutput.setContext("html", null);
					jteOutput.writeUserContent(page.getCurrentUser());
					jteOutput.writeContent(".\r\n        Чтобы разлогиниться, удалите куку JSESSIONID из браузера\r\n    ");
				}
				jteOutput.writeContent("\r\n    <h4>Тут ты увидишь:</h4>\r\n    <ul>\r\n        <li><a");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(RootNamedRoutes.mainPath())) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(RootNamedRoutes.mainPath());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Главную страницу</a></li>\r\n        <li><a");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(CourseNamedRoutes.coursesPath())) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(CourseNamedRoutes.coursesPath());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Список всех курсов</a></li>\r\n        <li><a");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(UserNamedRoutes.usersPath())) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(UserNamedRoutes.usersPath());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Список всех юзеров</a></li>\r\n        <li><a");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(PostsNamedRoutes.postsPath())) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(PostsNamedRoutes.postsPath());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Список всех постов</a> </li>\r\n        <li><a");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(CarsNamedRoutes.carsPath())) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(CarsNamedRoutes.carsPath());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Список всех машин</a> </li>\r\n        <li><a>Инфу про каждый курс</a></li>\r\n        <li><a>Инфу про каждого юзера</a></li>\r\n        <li><a>Инфу про каждый пост</a></li>\r\n\r\n        <li><a");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(SessionNamedRoutes.buildSessionPath())) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(SessionNamedRoutes.buildSessionPath());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Войти, как юзер</a> </li>\r\n\r\n    </ul>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"footer\">\r\n        <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n    </div>\r\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, page, content);
	}
}
