package com.company;

// Linked Queue
//
// Author: Lahcen Anjaimi
// Date: 04/02/19
// Class: MET CS342
// Issues: None known
//
// Description:
// Linked Queue specific to the bank simulation problem
//
// Assumptions:
// Should only be used for this specific problem

public class LinkedQueue {

    private Node head;
    private Node tail;
    private int count;
    private int timeToAddNext;// holds time to add next costumer
    private int nextCostumerId;// holds id to be assigned to next costumer
    private int longestWait;// holds the longest wait time
    private int maxQueueSize;// holds the maximum queue size ever reached
    private int minute;// keeps track of loop Iterations


    //Constructor Initiating the time to add, id and minute to 1
    public LinkedQueue() {
        this.timeToAddNext = 1;
        this.nextCostumerId = 1;
        this.minute = 1;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getLongestWait() {
        return longestWait;
    }

    public void setLongestWait(int intestWait) {
        this.longestWait = intestWait;
    }

    public int getMaxQueueSize() {
        return maxQueueSize;
    }

    public void setMaxQueueSize(int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
    }

    public int getNextCostumerId() {
        return nextCostumerId;
    }

    public void setNextCostumerId(int nextCostumerId) {
        this.nextCostumerId = nextCostumerId;
    }

    public int getTimeToAddNext() {
        return timeToAddNext;
    }

    public void setTimeToAddNext(int timeToAddNext) {
        this.timeToAddNext = timeToAddNext;
    }

    public CostumerInfo remove() {
        if (isEmpty()) {
            return null;
        } else {
            CostumerInfo temp = head.getData();
            if (count == 1) {
                // Now empty
                head = tail = null;
                count = 0;
            } else {
                head = head.getNext();
                count--;
            }
            return temp;
        }
    }

    public boolean add(CostumerInfo data) {

        Node newNode = new Node();
        newNode.setData(data);
        newNode.setNext(null);

        if (count == 0) {
            head = tail = newNode;
            count = 1;
        } else {
            tail.setNext(newNode);
            tail = newNode;
            count++;
        }

        return true;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public int getCount(){
        return count;
    }

    public String toString() {
        String str = "top -> ";

        Node tmp = head;
        while (tmp != null) {
            str += tmp.getData().getId() + ", ";
            tmp = tmp.getNext();
        }

        if(count == 0){
            str = "<Empty>";
        }

        return str;
    }

}
