package com.company;

// Costumer class
//
// Author: Lahcen Anjaimi
// Date: 04/02/19
// Class: MET CS342
// Issues: None known
//
// Description:
// class holding information of the costumer
//
// Assumptions:
// Should only be used for this specific problem

public class CostumerInfo {
    private int id;
    private int arrivalTime;
    private int serviceTime;
    private int waitTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public String toString(){
        return "Costumer #" + getId();
    }
}
