package com.maximilian.interview.designpattern.factorymethod;

public class CarFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

}
