package sk.carbooking.car;

public class CarService {

    private final CarDAO carDAO;
    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public Car[] getAllCars() {
        return carDAO.getCars();
    }

    public Car getCarByRegNumber(String regNumber) {
        for (Car car : carDAO.getCars()) {
            if (regNumber.equals(car.getRegNumber())) {
                return car;
            }
        }
        return null;
    };

    public Car[] getAllElectricCars() {
      int electricCarsCount = 0;
      Car[] cars = getAllCars();

        if (cars.length == 0) {
            return new Car[0];
        }

        for (Car car : cars) {
            if (car.isElectric()) {
                electricCarsCount++;
            }
        }

        if (electricCarsCount == 0) {
            return new Car[0];
        }

        Car[] electricCars = new Car[electricCarsCount];
        System.out.println(electricCars.length);
        int index = 0;

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].isElectric()) {
                electricCars[index++] = cars[i];
            }
        }

        return electricCars;
    };
}
