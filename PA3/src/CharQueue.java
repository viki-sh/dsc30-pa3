/*
    Name: Viki Shi
    PID:  A17704905
 */

import java.util.NoSuchElementException;

 /**
 * class CharQueue implements a circular queue that stores characters
 *
 * @author Viki Shi
 * @since 4/16/2024
 */

public class CharQueue {
    /* instance variables, feel free to add more if you need */
    private char[] circularArray;
    private int size;
    private int front;
    private int rear;
    int DEFAULT_CAPACITY = 5;
    int DOUBLE_LENGTH = 2;

    /**
     * Constructor that sets initial capacity to 5
     */
    public CharQueue() {
        circularArray = new char[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }
    /**
     * Creates a new queue that sets specified capacity
     * @param capacity an int to set capacity to
     * @throws IllegalArgumentException if capacity out of range (less than 1)
     */
    public CharQueue(int capacity) {
        if (capacity <1){
            throw new IllegalArgumentException("Cant be less than 1");
        }else{
            circularArray = new char[capacity];
            front = 0;
            rear = 0;
            size = 0;
        }

    }
    /**
     * Checks if queue is empty
     * @return true if array is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Returns the number of elements stored in the queue
     * @return number stored in queue (current size)
     */
    public int size() {
        return size;
    }
    /**
     * Clears all elements in the queue
     */
    public void clear() {
        front = 0;
        rear = 0;
        size = 0;
    }
    /**
     * Adds new elem to the back of the queue
     * If full, double the capacity
     * @param elem the element being added to the queue
     */
    public void enqueue(char elem) {
        if (size == circularArray.length){
            char[] newArray = new char[circularArray.length*DOUBLE_LENGTH];

            for (int i=0; i<size; i++){
                newArray[i] = circularArray[(front + i) %
                        circularArray.length];
            }
            circularArray=newArray;
            front = 0;
            rear = size;
            size++;
        }
        circularArray[rear] = elem;
        rear = (rear + 1) % circularArray.length; // Update the rear index
        size++;
    }
     /**
      * returns the element at the front of the queue
      * @throws NoSuchElementException if queue is empty
      */
    public char peek() {
        if (size == 0){
            throw new NoSuchElementException("Queue is empty");
        }
        return circularArray[front];
    }
     /**
      * returns and removes the element at the front of the queue
      * @throws NoSuchElementException if queue is empty
      */
    public char dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        char returned = circularArray[front];
        front = (front + 1) % circularArray.length;
        size --;
        return returned;
    }
}
