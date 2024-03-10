package gg.jte.generated.ondemand.posts;
import org.example.hexlet.dto.posts.PostPage;
import org.example.hexlet.utils.UserNamedRoutes;
import org.example.hexlet.utils.PostsNamedRoutes;
public final class JteshowGenerated {
	public static final String JTE_NAME = "posts/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,6,6,10,10,13,13,13,17,17,17,19,21,21,21,21,21,21,21,21,23,25,25,25,25,28,28,28,31,31,31};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, PostPage page) {
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <main>\r\n        <div class=\"mx-auto p-4 py-md-2\">\r\n            <h3>");
				jteOutput.setContext("h3", null);
				jteOutput.writeUserContent(page.getPost().getName());
				jteOutput.writeContent("</h3>\r\n        </div>\r\n\r\n        <div class=\"mx-auto p-4 py-md-2\">\r\n            ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getPost().getBody());
				jteOutput.writeContent("\r\n        </div>\r\n        ");
				jteOutput.writeContent("\r\n        <div class=\"mx-auto p-4 py-md-2\">\r\n            <a");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(PostsNamedRoutes.editPostPath(page.getPost().getId()))) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(PostsNamedRoutes.editPostPath(page.getPost().getId()));
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Редактировать</a>\r\n        </div>\r\n        ");
				jteOutput.writeContent("\r\n    </main>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"footer\">\r\n        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с полной информацией о посте №\r\n            ");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(page.getPost().getId());
				jteOutput.writeContent("!</a>\r\n        <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n    </div>\r\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		PostPage page = (PostPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
