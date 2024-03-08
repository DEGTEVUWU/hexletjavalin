package org.example.hexlet.dto.posts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.hexlet.model.Post;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostsPage {
    private List<Post> postList;
    private Integer pageNumber;
    private Integer previousPage;
    private Integer nextPage;
}
