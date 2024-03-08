package org.example.hexlet.dto.posts;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hexlet.model.Post;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EditPostPage {
    private long id;
    private String name;
    private String body;
    private Map<String, List<ValidationError<Object>>> errors;
}
