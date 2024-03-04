package org.example.hexlet.dto.users;

import lombok.Getter;

public class User {
    public String name;
    public Integer age;
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
