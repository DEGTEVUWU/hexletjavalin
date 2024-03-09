package org.example.hexlet.dto.courses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hexlet.dto.BasePage;
import org.example.hexlet.model.Course;


import java.util.Base64;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CoursesPage extends BasePage {
    private List<Course> courses;
    private Integer pageNumber;
    private Integer previousPage;
    private Integer nextPage;
    private String term;

    public CoursesPage(List<Course> courses) {
        this.courses = courses;
    }
}
