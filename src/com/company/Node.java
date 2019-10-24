package com.company;

// Queue Node
//
// Author: Lahcen Anjaimi
// Date: 04/02/19
// Class: MET CS342
// Issues: None known
//
// Description:
// Specialized Node for the bank simulation problem
//
// Assumptions:
// Should only be used for this problem

public class Node {
    private CostumerInfo data;// holds costumer object
    private Node next;

    public CostumerInfo getData() {
        return data;
    }

    public void setData(CostumerInfo data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}