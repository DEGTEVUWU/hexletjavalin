package org.example.hexlet.dto.cars;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hexlet.dto.BasePage;
import org.example.hexlet.model.Car;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarsPage extends BasePage {
    private List<Car> cars;

    private Integer pageNumber;
    private Integer previousPage;
    private Integer nextPage;
    private String term;
    public CarsPage(List<Car> cars) {
        this.cars = cars;
    }
}
