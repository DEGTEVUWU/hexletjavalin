package org.example.hexlet.dto.posts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.hexlet.model.Post;

@AllArgsConstructor
@Getter
@Setter
public class PostPage {
    private Post post;
}
