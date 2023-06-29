package sk.carbooking.car;

public class Car {
    private String regNumber;
    private String rentalPricePerDay;
    private Brand brand;
    private boolean isElectric;

    public Car(String regNumber, String rentalPricePerDay, Brand brand, boolean isElectric) {
        this.regNumber = regNumber;
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
        this.isElectric = isElectric;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(String rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", rentalPricePerDay='" + rentalPricePerDay + '\'' +
                ", brand=" + brand +
                ", isElectric=" + isElectric +
                '}';
    }
}
