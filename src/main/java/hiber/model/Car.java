package hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car")
    private Long id;

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_series")
    private int series;


    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;

    }

    @Override
    public String toString() {
        return "Car ='" + model + " " + series + "'";
    }

}
