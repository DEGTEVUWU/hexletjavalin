package gg.jte.generated.ondemand.posts;
import org.example.hexlet.dto.posts.PostsPage;
import org.example.hexlet.utils.PostsNamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "posts/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,9,9,12,12,12,14,14,14,15,15,15,15,15,15,15,15,17,17,17,17,17,17,17,17,23,23,23,23,23,23,23,23,26,26,28,28,30,30,33,33,33,36,36,36,36,36,36,36,36,36,36,36,39,39,39,42,42,44,44,49,49,49,49,49,49,49,49,51,51,51,51,51,51,51,51,56,56,56,56,63,63,63,66};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, PostsPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n<div class=\"mx-auto p-4 py-md-5\">\r\n    <main>\r\n    <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent("Это лист со всеми доступными постами!");
				jteOutput.writeContent("</h1>\r\n\r\n        <h4>");
				jteOutput.setContext("h4", null);
				jteOutput.writeUserContent("Вы можете найти курс по имени");
				jteOutput.writeContent("</h4>\r\n        <form");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(PostsNamedRoutes.postsPath())) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(PostsNamedRoutes.postsPath());
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"get\">\r\n            <label>\r\n                <input type=\"search\" name=\"term\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(page.getTerm())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(page.getTerm());
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\r\n            </label>\r\n            <input type=\"submit\" value=\"Искать\">\r\n        </form>\r\n\r\n        <div class=\"mb-3\">\r\n            <a");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(PostsNamedRoutes.buildPostsPath())) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(PostsNamedRoutes.buildPostsPath());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Создать новый пост</a>\r\n        </div>\r\n\r\n    ");
				if (page.getPostList().isEmpty()) {
					jteOutput.writeContent("\r\n        <p>Пока не добавлено ни одного поста</p>\r\n    ");
				} else {
					jteOutput.writeContent("\r\n        <table class=\"table table-striped\">\r\n            ");
					for (var post : page.getPostList()) {
						jteOutput.writeContent("\r\n                <tr>\r\n                    <td>\r\n                        ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(post.getId());
						jteOutput.writeContent("\r\n                    </td>\r\n                    <td>\r\n                        <a");
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
						jteOutput.writeContent("</a>\r\n                    </td>\r\n                    <td>\r\n                        <a>");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(post.getBody());
						jteOutput.writeContent("</a>\r\n                    </td>\r\n                </tr>\r\n            ");
					}
					jteOutput.writeContent("\r\n        </table>\r\n    ");
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
				jteOutput.writeContent("\">Next</a></li>\r\n        </ul>\r\n    </nav>\r\n    </main>\r\n</div>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n<div class=\"footer\">\r\n    <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с регистрацией нового поста!\r\n        Зарегай его, краб и чекни, что будет..</a>\r\n    <br>\r\n    <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n</div>\r\n");
			}
		}, page);
		jteOutput.writeContent("\r\n\r\n\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		PostsPage page = (PostsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
