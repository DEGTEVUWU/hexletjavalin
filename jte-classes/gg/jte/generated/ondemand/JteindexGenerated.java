package gg.jte.generated.ondemand;
import gg.jte.Content;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.utils.*;
import org.example.hexlet.utils.UserNamedRoutes;
import org.example.hexlet.utils.PostsNamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,6,6,6,9,9,13,13,17,17,19,19,20,20,21,21,21,23,23,26,26,26,26,26,26,26,26,27,27,27,27,27,27,27,27,28,28,28,28,28,28,28,28,29,29,29,29,29,29,29,29,34,34,34,34,34,34,34,34,37,37,37,37,41,41,41};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page, Content content) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <h1>Заголовок моего локал-сайта!</h1>\r\n    <h2>Подзаголовок! Если ты читаешь - пожалуйста, пользуйся</h2>\r\n\r\n        ");
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
				jteOutput.writeContent(">Список всех постов</a> </li>\r\n        <li><a>Инфу про каждый курс</a></li>\r\n        <li><a>Инфу про каждого юзера</a></li>\r\n        <li><a>Инфу про каждый пост</a></li>\r\n\r\n        <li><a");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(SessionNamedRoutes.buildSessionPath())) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(SessionNamedRoutes.buildSessionPath());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Регистрация</a> </li>\r\n\r\n    </ul>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"footer\">\r\n        <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n    </div>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, page, content);
	}
}
