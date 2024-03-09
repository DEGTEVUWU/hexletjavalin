package org.example.hexlet.dto.users;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hexlet.dto.BasePage;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuildUserPage extends BasePage {
    private String name;
    private String lastname;
    private String email;
    private Map<String, List<ValidationError<Object>>> errors;
}
