package com.maximilian.interview.designpattern.factorymethod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FactoryMethodTest {

    @Test
    void createVehicle() {

        List<VehicleFactory> factories = List.of(new CarFactory(), new BikeFactory(), new TruckFactory());

        Set<String> expectedTypes = Set.of("Car", "Bike", "Truck");

        for (VehicleFactory factory : factories) {
            Assertions.assertTrue(expectedTypes.contains(factory.createVehicle().getType()));
        }

    }

}