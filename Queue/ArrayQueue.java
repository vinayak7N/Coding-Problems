package com.queue.algo;
public class ArrayQueue {

   private  int front,rear,noOfElements;
   private int capacity;
   private int queue[];

    public ArrayQueue(int capacity){
        this.capacity=capacity;
        this.noOfElements=0;
        front=0;
        rear=-1;
        queue=new int[capacity];
    }

    public boolean isFull(){
        return noOfElements==capacity;
    }
    public boolean isEmpty(){
        return noOfElements==0;
    }
    public void display(){
        System.out.println("Queue display: ");
        if(isEmpty())
            return;
        for(int index=front;index<=rear;index++){
            System.out.println(queue[index]);
        }
    }
    public void enqueue(int element){
        if(isFull()){
            System.out.println("Queue is full unable to insert "+element);
            return;
        }
        queue[++rear]=element;
        noOfElements++;
    }
    public int dequeue(){

        if(isEmpty()){
            System.out.println("Queue is empty.Unable to delete element");
            return -1;
        }
        int removedElement=queue[front];
        front++;
        noOfElements--;
        return removedElement;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFront() {
        return queue[front];
    }

    public int getNoOfElements() {
        return noOfElements;
    }

    public static void main(String[] args) {
        ArrayQueue queueArray = new ArrayQueue(5);
        queueArray.enqueue(10);
        queueArray.enqueue(20);
        queueArray.enqueue(30);
        queueArray.enqueue(40);
        queueArray.enqueue(50);
        queueArray.enqueue(60);
        System.out.println("Removed element: "+queueArray.dequeue());
        queueArray.display();
    }

}
