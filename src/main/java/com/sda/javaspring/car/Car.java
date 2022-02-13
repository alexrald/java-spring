package com.sda.javaspring.car;

public class Car {
    private final CarBody carBody;
    private final Engine engine;

    private final Wheel wheelLF;    // Left Front
    private final Wheel wheelRF;
    private final Wheel wheelLB;
    private final Wheel wheelRB;

    public Car(CarBody carBody, Engine engine, Wheel wheelLF, Wheel wheelRF, Wheel wheelLB, Wheel wheelRB) {
        this.carBody = carBody;
        this.engine = engine;
        this.wheelLF = wheelLF;
        this.wheelRF = wheelRF;
        this.wheelLB = wheelLB;
        this.wheelRB = wheelRB;
    }


}
