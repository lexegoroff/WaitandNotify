package com.company;

public class Parking {
    private int parkingSize = 500;
    private int carCount = 0;

    public synchronized void in() {
        if (carCount == parkingSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        carCount++;
        System.out.println("The car is in the parking slot.");
        System.out.println("Available slots left: " + (parkingSize - carCount));
        notify();
    }

    public synchronized void out() {
        if (carCount == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        carCount--;
        System.out.println("The car left the parking slot.");
        System.out.println("Available slots left: " + (parkingSize - carCount));
        notify();
    }
}
