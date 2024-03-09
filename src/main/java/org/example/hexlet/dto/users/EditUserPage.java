package org.example.hexlet.dto.users;

import io.javalin.validation.ValidationError;
import jdk.jfr.SettingDefinition;
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
public class EditUserPage {
    private long id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private Map<String, List<ValidationError<Object>>> errors;
}
