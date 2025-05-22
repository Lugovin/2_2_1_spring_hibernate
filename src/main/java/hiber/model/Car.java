package hiber.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Car {

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_series")
    private String series;


    public Car() {
    }

    public Car(String model, String series) {
        this.model = model;
        this.series = series;

    }

    @Override
    public String toString() {
        return "Car ='" + model + " " + series + "'";
    }

}
