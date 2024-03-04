package org.example.hexlet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class Page {
    String title;
    String description;
Page (String title, String description) {
    this.title = title;
    this.description  = description;
}
}
