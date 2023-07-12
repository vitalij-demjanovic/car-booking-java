package sk.carbooking.car;

import java.math.BigDecimal;

public class CarDAO {
    private static final Car[] CARS = {
            new Car("1234", new BigDecimal("89.00"), Brand.Tesla, true),
            new Car("5678", new BigDecimal("50.00"), Brand.Audi, false),
            new Car("5678", new BigDecimal("77.00"), Brand.Volkswagen, false),
            new Car("5678", new BigDecimal("77.00"), Brand.Tesla, false)
    };

    public Car[] getCars() {
        return CARS;
    }
}
