package com.ssafy.abs;

public class VehicleTest {
    public static void main(String[] args) {
        Vehicle[] vehicles = {new DieselSUV(), new ElectricCar(), new HorseCart()};

        for (Vehicle v: vehicles) {
            v.addFuel();
            v.reportPosition();
        }

        Vehicle v = new DieselSUV();

    }
}
