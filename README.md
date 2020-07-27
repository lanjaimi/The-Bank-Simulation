# The-Bank-Simulation//
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
