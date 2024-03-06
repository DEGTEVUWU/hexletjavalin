package org.example.hexlet.dto.courses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hexlet.model.Course;


import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CoursesPage {
    private List<Course> courses;
    private String term;

    public CoursesPage(List<Course> courses) {
        this.courses = courses;
    }
}
