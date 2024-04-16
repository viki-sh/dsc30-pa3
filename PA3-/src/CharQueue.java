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
    private int capacity;
    int DEFAULT_CAPACITY = 5;

    /**
     * Constructor that sets initial capacity to 5
     */
    public CharQueue() {
        circularArray = new char[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
        capacity = DEFAULT_CAPACITY;
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
            capacity = capacity;
        }

    }
    /**
     * Checks if queue is empty
     * @return true if array is empty, false otherwise
     */
    public boolean isEmpty() {
        return circularArray[front] == circularArray[rear];
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
        front = circularArray[0];
        rear = circularArray[0];
        size = 0;
    }
    /**
     * Adds new elem to the back of the queue
     * If full, double the capacity
     */
    public void enqueue(char elem) {
        if (size == capacity){
            char[] newArray = new char[capacity*2];
            for (int i = 0; i < size; i++) {
                //some remainder division shit;
            }

            // Update the array reference, front, rear, and size
            circularArray = newArray;
            front = 0;
            rear = size;
        } else{
            circularArray[rear] = elem;
            rear++;
        }
    }


    public char peek() {
        // TODO
        return circularArray[front];
    }

    public char dequeue() {
        // TODO
        return 0;
    }
}
