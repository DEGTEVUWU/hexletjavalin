package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import org.example.hexlet.dto.BasePage;
import org.example.hexlet.model.Course;
import org.example.hexlet.utils.*;
import org.example.hexlet.utils.UserNamedRoutes;
import org.example.hexlet.utils.PostsNamedRoutes;
import org.example.hexlet.utils.UserNamedRoutes;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,5,6,8,8,8,31,31,31,31,31,31,31,31,31,34,34,34,34,34,34,34,34,37,37,37,37,37,37,37,37,40,40,40,40,40,40,40,40,43,43,43,43,43,43,43,43,46,46,46,46,46,46,46,46,49,49,49,49,49,49,49,49,52,52,52,52,52,52,52,52,55,55,55,55,55,55,55,55,64,64,66,66,66,68,68,69,69,71,71,71,73,73,75,75,75,80,80,80,84};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, Content footer, BasePage page) {
		jteOutput.writeContent("\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"utf-8\" />\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"\r\n          rel=\"stylesheet\"\r\n          integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"\r\n          crossorigin=\"anonymous\">\r\n    <title>Hello Hexlet!</title>\r\n</head>\r\n<body>\r\n<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\r\n        integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\"\r\n        crossorigin=\"anonymous\"></script>\r\n\r\n<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n    <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\r\n        <ul class=\"navbar-nav\">\r\n            <li class=\"nav-item active\">\r\n                <a class=\"nav-link\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(RootNamedRoutes.mainPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(RootNamedRoutes.mainPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Главная</a>\r\n            </li>\r\n            <li class=\"nav-item\">\r\n                <a class=\"nav-link\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(CourseNamedRoutes.coursesPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(CourseNamedRoutes.coursesPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Все курсы</a>\r\n            </li>\r\n            <li class=\"nav-item\">\r\n                <a class=\"nav-link\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(UserNamedRoutes.usersPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(UserNamedRoutes.usersPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Все пользователи</a>\r\n            </li>\r\n            <li class=\"nav-item\">\r\n                <a class=\"nav-link\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(PostsNamedRoutes.postsPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(PostsNamedRoutes.postsPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Все посты</a>\r\n            </li>\r\n            <li class=\"nav-item\">\r\n                <a class=\"nav-link\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(CarsNamedRoutes.carsPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(CarsNamedRoutes.carsPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Все машины</a>\r\n            </li>\r\n            <li class=\"nav-item\">\r\n                <a class=\"nav-link\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(CourseNamedRoutes.buildCoursesPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(CourseNamedRoutes.buildCoursesPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Написать курс</a>\r\n            </li>\r\n            <li class=\"nav-item\">\r\n                <a class=\"nav-link\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(UserNamedRoutes.buildUserPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(UserNamedRoutes.buildUserPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Зарегистрировать пользователя</a>\r\n            </li>\r\n            <li class=\"nav-item\">\r\n                <a class=\"nav-link\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(PostsNamedRoutes.buildPostsPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(PostsNamedRoutes.buildPostsPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Написать пост</a>\r\n            </li>\r\n            <li class=\"nav-item\">\r\n                <a class=\"nav-link\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(CarsNamedRoutes.buildCarsPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(CarsNamedRoutes.buildCarsPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Добавить машину</a>\r\n            </li>\r\n\r\n\r\n        </ul>\r\n    </div>\r\n</nav>\r\n\r\n<main>\r\n    ");
		if (page != null && page.getFlash() != null) {
			jteOutput.writeContent("\r\n        <div class=\"alert alert-success\" role=\"alert\">\r\n            ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(page.getFlash());
			jteOutput.writeContent("\r\n        </div>\r\n    ");
		}
		jteOutput.writeContent("\r\n        ");
		if (page != null && page.getErrorFlash() != null) {
			jteOutput.writeContent("\r\n        <div class=\"alert alert-danger\" role=\"alert\">\r\n            ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(page.getErrorFlash());
			jteOutput.writeContent("\r\n        </div>\r\n    ");
		}
		jteOutput.writeContent("\r\n\r\n    ");
		jteOutput.setContext("main", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n\r\n</main>\r\n<footer class=\"text-center text-lg-start bg-light text-muted\">\r\n    <div class=\"text-center p-4\" style=\"background-color: rgba(0, 0, 0, 0.05);\">\r\n        ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(footer);
		jteOutput.writeContent("\r\n    </div>\r\n</footer>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.getOrDefault("content", null);
		Content footer = (Content)params.getOrDefault("footer", null);
		BasePage page = (BasePage)params.getOrDefault("page", null);
		render(jteOutput, jteHtmlInterceptor, content, footer, page);
	}
}
