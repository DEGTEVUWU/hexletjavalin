package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.utils.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,7,7,11,11,13,13,13,15,15,15,16,16,16,16,16,16,16,16,18,18,18,18,18,18,18,18,22,22,24,24,25,25,27,27,27,27,27,27,27,27,27,27,27,27,27,27,28,28,28,30,30,31,31,34,34,34,34,40,40,40};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <body>\r\n    <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent("Это лист со всеми доступными юзерами!");
				jteOutput.writeContent("</h1>\r\n    <br>\r\n    <h4>");
				jteOutput.setContext("h4", null);
				jteOutput.writeUserContent("Вы можете найти юзера по имени");
				jteOutput.writeContent("</h4>\r\n    <form");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.usersPath())) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(NamedRoutes.usersPath());
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
				jteOutput.writeContent(">\r\n        </label>\r\n        <input type=\"submit\" value=\"Искать\">\r\n    </form>\r\n    ");
				if (page.getUserList().isEmpty()) {
					jteOutput.writeContent("\r\n        <p>Пока не добавлено ни одного пользователя</p>\r\n    ");
				} else {
					jteOutput.writeContent("\r\n        ");
					for (var user : page.getUserList()) {
						jteOutput.writeContent("\r\n            <div>\r\n                <h2><a");
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.userPath(user.getId()))) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(NamedRoutes.userPath(user.getId()));
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(user.getName());
						jteOutput.writeContent(" ");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(user.getLastName());
						jteOutput.writeContent("</a></h2>\r\n                <p>");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(user.getEmail());
						jteOutput.writeContent("</p>\r\n            </div>\r\n        ");
					}
					jteOutput.writeContent("\r\n    ");
				}
				jteOutput.writeContent("\r\n    </body>\r\n\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"footer\">\r\n        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу со всеми юзерами! Жду снова!</a>\r\n        <br>\r\n        <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n    </div>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
