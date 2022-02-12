package com.sda.javaspring.car;

public class Engine {

    private final EngineBody engineBody;
    private final EngineHead engineHead;

    public Engine(EngineBody engineBody, EngineHead engineHead) {
        this.engineBody = engineBody;
        this.engineHead = engineHead;
    }
}
