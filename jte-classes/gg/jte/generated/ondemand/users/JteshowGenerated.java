package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UserPage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "users/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,7,7,9,9,9,9,9,9,9,9,9,9,9,9,11,11,11,11,14,14,14,18,18,18};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UserPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div>\r\n        ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getUser().getId());
				jteOutput.writeContent(" ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getUser().getName());
				jteOutput.writeContent(" ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getUser().getLastName());
				jteOutput.writeContent(" ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getUser().getEmail());
				jteOutput.writeContent("\r\n    </div>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"footer\">\r\n        <a>Спасибо, что посетили мой сайт! Особенно эту страницу с полной информацией про пользователя №\r\n            ");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(page.getUser().getId());
				jteOutput.writeContent(" Жду снова!</a>\r\n        <br>\r\n        <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n    </div>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UserPage page = (UserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
