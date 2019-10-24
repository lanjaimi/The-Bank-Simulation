package com.company;

// Teller Class
//
// Author: Lahcen Anjaimi
// Date: 04/02/19
// Class: MET CS342
// Issues: None known
//
// Description:
// class handling the teller
//
// Assumptions:
// Should only be used for this specific problem

public class Teller {
    private int timeAvailable;// stores time when the teller will be available to take costumers
    private CostumerInfo costumer;// stores the costumer the teller is currently serving

    //Constructor Initiating the time available to the first loop Iteration
    public Teller(){
        timeAvailable = 1;
    }

    public CostumerInfo getCostumer() {
        return costumer;
    }

    public void setCostumer(CostumerInfo costumer) {
        this.costumer = costumer;
    }

    public int getTimeAvailable() {
        return timeAvailable;
    }

    public void setTimeAvailable(int timeAvailable) {
        this.timeAvailable = timeAvailable;
    }





}
