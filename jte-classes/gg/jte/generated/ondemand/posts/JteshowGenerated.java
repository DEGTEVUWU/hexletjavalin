package gg.jte.generated.ondemand.posts;
import org.example.hexlet.dto.posts.PostPage;
import org.example.hexlet.utils.NamedRoutes;
import org.example.hexlet.utils.PostsNamedRoutes;
public final class JteshowGenerated {
	public static final String JTE_NAME = "posts/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,6,6,8,8,11,11,11,15,15,15,17,19,19,19,19,19,19,19,19,21,23,23,23};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, PostPage page) {
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <main>\r\n        <div class=\"mx-auto p-4 py-md-5\">\r\n            <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getPost().getName());
				jteOutput.writeContent("</h1>\r\n        </div>\r\n\r\n        <div class=\"mx-auto p-4 py-md-5\">\r\n            ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getPost().getBody());
				jteOutput.writeContent("\r\n        </div>\r\n        ");
				jteOutput.writeContent("\r\n        <div class=\"mx-auto p-4 py-md-5\">\r\n            <a");
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
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		PostPage page = (PostPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
