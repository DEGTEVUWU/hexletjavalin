package gg.jte.generated.ondemand.courses;
import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.utils.CourseNamedRoutes;
import org.example.hexlet.utils.UserNamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,8,8,13,13,16,16,16,19,19,19,20,20,20,20,20,20,20,20,22,22,22,22,22,22,22,22,28,28,28,28,28,28,28,28,32,32,34,34,37,37,40,40,40,43,43,43,43,43,43,43,43,43,43,43,46,46,46,49,49,51,51,56,56,56,56,56,56,56,56,58,58,58,58,58,58,58,58,64,64,64,64,70,70,70};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n<div class=\"mx-auto p-4 py-md-5\">\r\n    <main>\r\n    <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent("Это лист со всеми доступными курсами!");
				jteOutput.writeContent("</h1>\r\n\r\n\r\n    <h4>");
				jteOutput.setContext("h4", null);
				jteOutput.writeUserContent("Вы можете найти курс по имени");
				jteOutput.writeContent("</h4>\r\n    <form");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(CourseNamedRoutes.coursesPath())) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(CourseNamedRoutes.coursesPath());
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"get\">\r\n        <label>\r\n            <input type=\"search\" name=\"term\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(page.getTerm())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(page.getTerm());
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\r\n        </label>\r\n        <input type=\"submit\" value=\"Искать\">\r\n    </form>\r\n\r\n        <div class=\"mb-3\">\r\n            <a");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(CourseNamedRoutes.buildCoursesPath())) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(CourseNamedRoutes.buildCoursesPath());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Создать новый курс</a>\r\n        </div>\r\n\r\n\r\n    ");
				if (page.getCourses().isEmpty()) {
					jteOutput.writeContent("\r\n        <p>Пока не добавлено ни одного курса</p>\r\n        ");
				} else {
					jteOutput.writeContent("\r\n\r\n        <table class=\"table table-striped\">\r\n            ");
					for (var post : page.getCourses()) {
						jteOutput.writeContent("\r\n                <tr>\r\n                    <td>\r\n                        ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(post.getId());
						jteOutput.writeContent("\r\n                    </td>\r\n                    <td>\r\n                        <a");
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(CourseNamedRoutes.coursePath(post.getId()))) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(CourseNamedRoutes.coursePath(post.getId()));
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(post.getName());
						jteOutput.writeContent("</a>\r\n                    </td>\r\n                    <td>\r\n                        ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(post.getDescription());
						jteOutput.writeContent("\r\n                    </td>\r\n                </tr>\r\n            ");
					}
					jteOutput.writeContent("\r\n        </table>\r\n        ");
				}
				jteOutput.writeContent("\r\n\r\n        <nav aria-label=\"Page navigation example\">\r\n            <ul class=\"pagination\">\r\n                <li class=\"page-item\"><a class=\"page-link\"\r\n                                         href=\"");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(CourseNamedRoutes.coursesPath());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("?page=");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(page.getPreviousPage());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\">Previous</a></li>\r\n                <li class=\"page-item\"><a class=\"page-link\"\r\n                                         href=\"");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(CourseNamedRoutes.coursesPath());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("?page=");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(page.getNextPage());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\">Next</a></li>\r\n            </ul>\r\n        </nav>\r\n\r\n        </main>\r\n</div>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"footer\">\r\n        <a>Спасибо, что посетили мой сайт и страницу со всеми курсами! Жду снова!</a>\r\n        <br>\r\n        <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n    </div>\r\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
