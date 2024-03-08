package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.model.Course;
import org.example.hexlet.utils.CourseNamedRoutes;
import org.example.hexlet.utils.NamedRoutes;
public final class JteshowGenerated {
	public static final String JTE_NAME = "courses/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,4,4,6,6,10,10,13,13,13,17,17,17,19,21,21,21,21,21,21,21,21,23,25,25,25,25,27,27,27,31,31,31};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursePage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <main>\r\n        <div class=\"mx-auto p-4 py-md-5\">\r\n            <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getCourse().getName());
				jteOutput.writeContent("</h1>\r\n        </div>\r\n\r\n        <div class=\"mx-auto p-4 py-md-5\">\r\n            ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getCourse().getDescription());
				jteOutput.writeContent("\r\n        </div>\r\n        ");
				jteOutput.writeContent("\r\n        <div class=\"mx-auto p-4 py-md-5\">\r\n            <a");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(CourseNamedRoutes.editCoursePath(page.getCourse().getId()))) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(CourseNamedRoutes.editCoursePath(page.getCourse().getId()));
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Редактировать</a>\r\n        </div>\r\n        ");
				jteOutput.writeContent("\r\n    </main>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"footer\">\r\n        <a>Спасибо, что посетили мой сайт! Особенно страницу с описанием курса № ");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(page.getCourse().getId());
				jteOutput.writeContent("! Жду снова!</a>\r\n        <br>\r\n        <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n    </div>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursePage page = (CoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
