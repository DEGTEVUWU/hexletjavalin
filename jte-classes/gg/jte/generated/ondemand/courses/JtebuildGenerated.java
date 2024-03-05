package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.utils.NamedRoutes;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,5,5,9,9,10,10,12,12,13,13,14,14,14,15,15,16,16,18,18,20,20,20,20,20,20,20,20,24,24,24,24,24,24,24,24,30,30,30,30,30,30,30,30,35,35,35,35,42,42,42};
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
				jteOutput.writeContent("\r\n\r\n    <form");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.coursesPath())) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(NamedRoutes.coursesPath());
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\r\n        <div>\r\n            <label>\r\n                Название курса\r\n                <input type=\"text\" name=\"name\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(page.getName())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(page.getName());
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("/>\r\n            </label>\r\n        </div>\r\n        <div>\r\n            <label>\r\n                Описание курса\r\n                <textarea required name=\"description\" rows=\"6\" cols=\"30\"");
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
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildCoursePage page = (BuildCoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
