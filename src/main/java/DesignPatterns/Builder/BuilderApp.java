package DesignPatterns.Builder;

public class BuilderApp {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .buildMake("Mersedes")
                .buildMaxSpeed(300)
                .buildTransmission(Transmission.AUTO)
                .build();
        System.out.println(car);
    }
}

enum Transmission {
    MANUAL, AUTO
}

class Car {
    String make;
    Transmission transmission;
    int maxspeed;

    public void setMake(String make) {
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }


    public void setMaxspeed(int maxspeed) {
        this.maxspeed = maxspeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxspeed=" + maxspeed +
                '}';
    }
}

class CarBuilder {
    String mark = "Deafult";
    Transmission t = Transmission.MANUAL;
    int speed = 120;

    CarBuilder buildMake(String mark) {
        this.mark = mark;
        return this;
    }

    CarBuilder buildTransmission(Transmission t) {
        this.t = t;
        return this;
    }

    CarBuilder buildMaxSpeed(int s) {
        this.speed = speed;
        return this;
    }

    Car build() {
        Car car = new Car();
        car.setMake(mark);
        car.setMaxspeed(speed);
        car.setTransmission(t);
        return car;
    }
}