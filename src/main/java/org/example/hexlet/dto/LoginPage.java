package org.example.hexlet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginPage {
    private String name;
    private String error;
}
