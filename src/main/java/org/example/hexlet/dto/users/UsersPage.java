package org.example.hexlet.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.model.Post;
import org.example.hexlet.model.User;

import java.util.List;

@Getter
@AllArgsConstructor
public class UsersPage {
    public List<User> userList;
    private Integer pageNumber;
    private Integer previousPage;
    private Integer nextPage;
    public String term;
    public UsersPage(List<User> userList) {
        this.userList = userList;
    }
    public UsersPage(List<User> userList, Integer pageNumber, Integer previousPage, Integer nextPage) {
        this.userList = userList;
        this.pageNumber = pageNumber;
        this.previousPage = previousPage;
        this.nextPage = nextPage;
    }
}
