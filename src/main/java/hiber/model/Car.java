package hiber.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "cars")
@Embeddable
public class Car {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

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
