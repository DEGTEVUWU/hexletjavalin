package org.example.hexlet.dto.posts;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuildPostPage {
    private String name;
    private String body;
    private Map<String, List<ValidationError<Object>>> errors;
    public BuildPostPage(Map<String, List<ValidationError<Object>>> errors) {
            this.errors = errors;
        }
}
