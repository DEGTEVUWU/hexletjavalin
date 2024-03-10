package gg.jte.generated.ondemand.posts;
import org.example.hexlet.dto.posts.EditPostPage;
public final class JteeditGenerated {
	public static final String JTE_NAME = "posts/edit.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,7,7,8,8,11,11,12,12,13,13,13,14,14,15,15,18,18,21,21,21,21,25,25,25,25,25,25,25,25,30,30,30,36,36,36,36,42,42,42};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, EditPostPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\r\n        <div class=\"mb-3\">\r\n            <ul>\r\n                ");
					for (var validator : page.getErrors().values()) {
						jteOutput.writeContent("\r\n                    ");
						for (var error : validator) {
							jteOutput.writeContent("\r\n                        <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\r\n                    ");
						}
						jteOutput.writeContent("\r\n                ");
					}
					jteOutput.writeContent("\r\n            </ul>\r\n        </div>\r\n    ");
				}
				jteOutput.writeContent("\r\n\r\n    <div class=\"mx-auto p-4 py-md-5\">\r\n        <form action=\"/posts/");
				jteOutput.setContext("form", "action");
				jteOutput.writeUserContent(page.getId());
				jteOutput.setContext("form", null);
				jteOutput.writeContent("\" method=\"post\">\r\n            <div class=\"mb-3\">\r\n                <label class=\"form-label\">\r\n                    Название\r\n                    <input type=\"text\" class=\"form-control\" name=\"name\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(page.getName())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(page.getName());
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("/>\r\n                </label>\r\n            </div>\r\n            <div class=\"mb-3\">\r\n                <label class=\"form-label\">Содержание</label>\r\n                <textarea class=\"form-control\" rows=\"20\" cols=\"70\" type=\"text\" name=\"body\">");
				jteOutput.setContext("textarea", null);
				jteOutput.writeUserContent(page.getBody());
				jteOutput.writeContent("\r\n                </textarea>\r\n            </div>\r\n            <input type=\"submit\" class=\"btn btn-primary\" value=\"Обновить\" />\r\n        </form>\r\n    </div>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"footer\">\r\n        <a>Спасибо, что посетили мой сайт! И в особенности эту страницу с изменением данных поста!\r\n            Измени что-то, краб и чекни, что будет..</a>\r\n        <a href=\"https://github.com/DEGTEVUWU\">Дёгтев Иван - профиль на GitHub</a>\r\n    </div>\r\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		EditPostPage page = (EditPostPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
