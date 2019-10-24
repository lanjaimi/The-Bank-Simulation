package com.company;
//---------------------------------------------------------------------------
//
// Bank simulation
// Simulates the service at a bank for 8 hours.
//
// Author: Lahcen Anjaimi
// Date: 04/02/19
// Class: MET CS342
// Issues: None known
//
// Description:
//This program simulates the service of a bank using a linked queue
// The arrival and service time for customers is assigned randomly from 1 to 4.
//The method of solving this problem is using a loop from 1 to 480 simulation 480 minutes of operation of a bank for a day.
//The costumers are assigned a random arrival time
// With each iteration, we check if a customer has arrived, if so. We schedule the arrival of the following costumer.
// With each iteration, if a costumer arrives we check if a teller is available, if  so we pick a random service time  and we start servicing  the costumer.

//
// Assumptions:
// We only schedule the arrival of the next costumer after a costumer has arrived
//-------------------------------------------------------------------------------------------


public class Main {
    // main program entry point
    public static void main(String[] args) {

        Main me = new Main();
        me.run();//run worker method

    }

    //Worker method called from main
    public void run() {
        LinkedQueue queue = new LinkedQueue();
        Teller tellerOne = new Teller();
        Teller tellerTwo = new Teller();

        for (int timeStamp = 1; timeStamp < 480; timeStamp++) {
            //print which minute of the day this is
            System.out.println("*************** Minute: " + queue.getMinute() + " ********************");
            costumerArrival(queue, timeStamp);//run method handling costumer arrival
            clearTellers(tellerOne, tellerTwo, timeStamp);//clear tellers if it's time
            servingCustomers(queue, tellerOne, tellerTwo, timeStamp);// run method handling service
            status(queue, tellerOne, tellerTwo);//print the status of the simulation
            queue.setMinute(queue.getMinute() + 1);//increase the minute count by 1

        }

         // print the final results
        System.out.println("**********************END**********************");
        System.out.println("The longest wait time was: " + queue.getLongestWait() + " Minutes");
        System.out.println("The maximum queue size was: " + queue.getMaxQueueSize());
        System.out.println("The ending queue size is: " + queue.getCount());


    }

    // method handling costumers arrival
    public void costumerArrival(LinkedQueue queue, int timeStamp) {
        int arrivalInterval = (int) (Math.floor(1 + Math.random() * 3));//random arrival interval

        if (queue.getTimeToAddNext() <= timeStamp) {// check if it's time to add
            CostumerInfo costumer = new CostumerInfo();//create costumer
            costumer.setId(queue.getNextCostumerId());//set costumer id
            costumer.setArrivalTime(timeStamp);//set costumer arrival time
            queue.add(costumer);// add costumer to queue
            System.out.println("Costumer #" + costumer.getId() + " has arrived!");//announce costumer arrival
            queue.setTimeToAddNext(queue.getTimeToAddNext() + arrivalInterval);// set time to add next costumer
            queue.setNextCostumerId(queue.getNextCostumerId() + 1);//set id to be assigned for next customer

        }

    }

    // method clearing tellers
    public void clearTellers(Teller tellerOne, Teller tellerTwo, int timeStamp) {

        if (tellerOne.getTimeAvailable() <= timeStamp) {//check if time to clear has passed
            if (tellerOne.getCostumer() != null) {//check if teller is busy
                //announce that teller is done
                System.out.println("Teller one has finished serving " + tellerOne.getCostumer());
                // remove the costumer being served
                tellerOne.setCostumer(null);

            }
        }
        if (tellerTwo.getTimeAvailable() <= timeStamp) {//check if time to clear has passed
            if (tellerTwo.getCostumer() != null) {//check if teller is busy

                //announce that teller is done
                System.out.println("Teller Two has finished serving " + tellerTwo.getCostumer());
                // remove the costumer being served
                tellerTwo.setCostumer(null);

            }

        }

    }

    // method handling serving costumers
    public void servingCustomers(LinkedQueue queue, Teller tellerOne, Teller tellerTwo, int timeStamp) {
        if (!queue.isEmpty()) {// check if queue not empty
            if (tellerOne.getCostumer() == null) {//check if teller one available
                int serviceTime = (int) (Math.floor(1 + Math.random() * 10));//generate random number
                tellerOne.setTimeAvailable(serviceTime + timeStamp);//set clearing time
                CostumerInfo costumer = queue.remove();// remove costumer from queue
                costumer.setServiceTime(timeStamp);//set costumer service time
                // calculate and set costumer wait time
                costumer.setWaitTime(costumer.getServiceTime() - costumer.getArrivalTime());
                //set the tellers costumer
                tellerOne.setCostumer(costumer);
                //check if costumer wait time is greater than longest wait
                if (costumer.getWaitTime() > queue.getLongestWait()) {
                    queue.setLongestWait(costumer.getWaitTime());
                }


            } else if (tellerTwo.getCostumer() == null) {//check if teller two available
                //////////////////////////////
                //same steps for teller one
                ////////////////////////////////
                int serviceTime = (int) (Math.floor(1 + Math.random() * 4));
                tellerTwo.setTimeAvailable(serviceTime + timeStamp);
                CostumerInfo costumer = queue.remove();
                costumer.setServiceTime(timeStamp);
                costumer.setWaitTime(costumer.getServiceTime() - costumer.getArrivalTime());
                tellerTwo.setCostumer(costumer);
                if (costumer.getWaitTime() > queue.getLongestWait()) {
                    queue.setLongestWait(costumer.getWaitTime());
                }


            } else {//if both tellers busy
                //check if queue size is greater than the longest queue size
                if (queue.getCount() > queue.getMaxQueueSize()) {
                    queue.setMaxQueueSize(queue.getCount());
                }
                System.out.println("Both Tellers are busy!");
            }

        } else {// if queue is empty announce it
            System.out.println("Queue is empty!");
        }


    }

    // method announcing the simulation status for every loop Iteration
    public void status(LinkedQueue queue, Teller tellerOne, Teller tellerTwo) {
        System.out.println("------------");
        System.out.println("Queue: " + queue);

        if (tellerOne.getCostumer() == null) {// if teller available
            System.out.println("Teller One is Available!");
        } else {
            System.out.println("Teller One is serving: " + tellerOne.getCostumer());
        }

        if (tellerTwo.getCostumer() == null) {// if teller available
            System.out.println("Teller Two is Available!");
        } else {
            System.out.println("Teller Two is serving: " + tellerTwo.getCostumer());
        }


    }


}
