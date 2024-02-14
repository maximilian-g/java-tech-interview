package com.maximilian.interview.designpattern.factorymethod;

public class BikeFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }

}
