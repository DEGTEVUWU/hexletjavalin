package gg.jte.generated.ondemand.posts;
import org.example.hexlet.dto.posts.PostsPage;
import org.example.hexlet.model.Post;
import org.example.hexlet.utils.PostsNamedRoutes;
public final class JtesearchGenerated {
	public static final String JTE_NAME = "posts/search.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,7,7,11,11,14,14,14,17,17,17,17,17,17,17,17,20,20,22,22,25,25,28,28,28,31,31,31,31,31,31,31,31,31,31,31,34,34,34,37,37,39,39,43,43,43,43,49,49,49};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, PostsPage page) {
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"mx-auto p-4 py-md-5\">\r\n        <main>\r\n            <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent("Это лист со всеми доступными постами!");
				jteOutput.writeContent("</h1>\r\n\r\n            <div class=\"mb-3\">\r\n                <a");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(PostsNamedRoutes.buildPostsPath())) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(PostsNamedRoutes.buildPostsPath());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Создать новый пост</a>\r\n            </div>\r\n\r\n            ");
				if (page.getPostList().isEmpty()) {
					jteOutput.writeContent("\r\n                <p>Пока не добавлено ни одного поста</p>\r\n            ");
				} else {
					jteOutput.writeContent("\r\n\r\n                <table class=\"table table-striped\">\r\n                    ");
					for (var post : page.getPostList()) {
						jteOutput.writeContent("\r\n                        <tr>\r\n                            <td>\r\n                                ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(post.getId());
						jteOutput.writeContent("\r\n                            </td>\r\n                            <td>\r\n                                <a");
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
						jteOutput.writeContent("</a>\r\n                            </td>\r\n                            <td>\r\n                                <a>");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(post.getBody());
						jteOutput.writeContent("</a>\r\n                            </td>\r\n                        </tr>\r\n                    ");
					}
					jteOutput.writeContent("\r\n                </table>\r\n            ");
				}
				jteOutput.writeContent("\r\n\r\n        </main>\r\n    </div>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"footer\">\r\n        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с выборкой юзеров по твоему поиску! Жду снова!</a>\r\n        <br>\r\n        <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n    </div>\r\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		PostsPage page = (PostsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
