package org.example.hexlet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MainPage extends BasePage {
    private Object name;
    private String currentUser;
    private Boolean visited;
    public MainPage(Object name) {
        this.name = name;
    }
    public MainPage(String currentUser, Boolean visited) {
        this.currentUser = currentUser;
        this.visited = visited;
    }
    public Boolean isVisited() {
        return visited;
    }
}

