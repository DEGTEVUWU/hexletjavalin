package org.example.hexlet.dto.posts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hexlet.model.Post;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostsPage {
    private List<Post> postList;
    private Integer pageNumber;
    private Integer previousPage;
    private Integer nextPage;
    private String term;

    public PostsPage(List<Post> postList, Integer pageNumber, Integer previousPage, Integer nextPage) {
        this.postList = postList;
        this.pageNumber = pageNumber;
        this.previousPage = previousPage;
        this.nextPage = nextPage;
    }
}
