package com.queue.algo;

public class LinkedListImplQueue {

    QueueNode front,rear;

    public LinkedListImplQueue(){
        this.front=null;
        this.rear=null;
    }

    void enqueue(int data){

        QueueNode newNode=new QueueNode(data);
        if(rear==null){
            this.front=this.rear=newNode;
        }
        rear.next=newNode;
        rear=newNode;
    }

    int dequeue(){

        if(front==null)
            return -1;
        int data=front.data;
        front=front.next;
        return data;
    }

    void display(){
        if(front==null)
            return;
        QueueNode temp=front;
        while(temp!=rear.next){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedListImplQueue queue=new LinkedListImplQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        System.out.println();
        for(int i=0;i<5;i++) {
            System.out.println(queue.dequeue());
        }
        queue.display();


    }

    class QueueNode{
        int data;
        QueueNode next;

        public QueueNode(int data){
            this.data=data;
            this.next=null;
        }

    }
}

