package gg.jte.generated.ondemand.posts;
import org.example.hexlet.dto.posts.PostsPage;
import org.example.hexlet.utils.PostsNamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "posts/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,8,8,10,10,10,14,14,16,16,17,17,19,19,19,19,19,19,19,19,19,19,19,20,20,20,22,22,23,23,28,28,28,28,28,28,28,28,30,30,30,30,30,30,30,30,34,34,34,34,41,41,41};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, PostsPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <body>\r\n    <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent("Это лист со всеми доступными постами!");
				jteOutput.writeContent("</h1>\r\n    <br>\r\n    <a href=\"\">На страницу с постами!</a>\r\n\r\n    ");
				if (page.getPostList().isEmpty()) {
					jteOutput.writeContent("\r\n        <p>Пока не добавлено ни одного поста</p>\r\n    ");
				} else {
					jteOutput.writeContent("\r\n        ");
					for (var post : page.getPostList()) {
						jteOutput.writeContent("\r\n            <div>\r\n                <h2><a");
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(PostsNamedRoutes.postPath(post.getId()))) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(PostsNamedRoutes.postPath(post.getId()));
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(post.getName());
						jteOutput.writeContent("</a></h2>\r\n                <p>");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(post.getBody());
						jteOutput.writeContent("</p>\r\n            </div>\r\n        ");
					}
					jteOutput.writeContent("\r\n    ");
				}
				jteOutput.writeContent("\r\n\r\n    <nav aria-label=\"Page navigation example\">\r\n        <ul class=\"pagination\">\r\n            <li class=\"page-item\"><a class=\"page-link\"\r\n                                     href=\"");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(PostsNamedRoutes.postsPath());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("?page=");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(page.getPreviousPage());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\">Previous</a></li>\r\n            <li class=\"page-item\"><a class=\"page-link\"\r\n                                     href=\"");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(PostsNamedRoutes.postsPath());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("?page=");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(page.getNextPage());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\">Next</a></li>\r\n        </ul>\r\n    </nav>\r\n    </body>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n<div class=\"footer\">\r\n    <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с регистрацией нового поста!\r\n        Зарегай его, краб и чекни, что будет..</a>\r\n    <br>\r\n    <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n</div>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		PostsPage page = (PostsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
