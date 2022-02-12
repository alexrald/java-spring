package com.sda.javaspring.car;

public class Car {
    private final CarBody carBody;
    private final Engine engine;

    private final Wheel wheel1;
    private final Wheel wheel2;
    private final Wheel wheel3;
    private final Wheel wheel4;

    public Car(CarBody carBody, Engine engine, Wheel wheel1, Wheel wheel2, Wheel wheel3, Wheel wheel4) {
        this.carBody = carBody;
        this.engine = engine;
        this.wheel1 = wheel1;
        this.wheel2 = wheel2;
        this.wheel3 = wheel3;
        this.wheel4 = wheel4;
    }


}
