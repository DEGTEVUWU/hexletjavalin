package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.utils.CourseNamedRoutes;
import org.example.hexlet.utils.UserNamedRoutes;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,6,6,10,10,11,11,13,13,14,14,15,15,15,16,16,17,17,19,19,22,22,22,22,22,22,22,22,26,26,26,26,26,26,26,26,32,32,32,32,32,32,32,32,37,37,37,37,44,44,44};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildCoursePage page) {
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\r\n        <ul>\r\n            ");
					for (var validator : page.getErrors().values()) {
						jteOutput.writeContent("\r\n                ");
						for (var error : validator) {
							jteOutput.writeContent("\r\n                    <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\r\n                ");
						}
						jteOutput.writeContent("\r\n            ");
					}
					jteOutput.writeContent("\r\n        </ul>\r\n    ");
				}
				jteOutput.writeContent("\r\n\r\n            <div class=\"mx-auto p-4 py-md-5\">\r\n    <form");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(CourseNamedRoutes.coursesPath())) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(CourseNamedRoutes.coursesPath());
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\r\n            <div class=\"mb-3\">\r\n                <label class=\"form-label\">\r\n                Название курса\r\n                <input type=\"text\" class=\"form-control\" name=\"name\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(page.getName())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(page.getName());
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("/>\r\n            </label>\r\n        </div>\r\n            <div class=\"mb-3\">\r\n                <label class=\"form-label\">\r\n                Описание курса\r\n                <textarea class=\"form-control\" required name=\"description\" rows=\"6\" cols=\"30\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(page.getDescription())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("textarea", "value");
					jteOutput.writeUserContent(page.getDescription());
					jteOutput.setContext("textarea", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("></textarea>\r\n            </label>\r\n        </div>\r\n        <input type=\"submit\" value=\"Зарегистрировать\" />\r\n    </form>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"footer\">\r\n        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с регистрацией нового курса!\r\n            Зарегайся, краб и чекни, что будет..</a>\r\n        <br>\r\n        <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n    </div>\r\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildCoursePage page = (BuildCoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
