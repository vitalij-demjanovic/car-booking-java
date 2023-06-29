package sk.carbooking.car;

public class CarDAO {
    private static final Car[] cars;

    static {
        cars = new Car[]{
          new Car("1234", "88", Brand.Tesla, true),
          new Car("5678", "33", Brand.Volkswagen, false),
          new Car("2456", "56", Brand.Toyota, true),
          new Car("1290", "49", Brand.Audi, false),
        };
    }

    public Car[] getCars() {
        return cars;
    }
}
