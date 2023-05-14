package com.hprog99.stack;

public class FixedSizeArrayImpl {

    private int capacity;
    private static final int CAPACITY = 10;
    private int[] array;
    private int top = -1;

    public FixedSizeArrayImpl() {
        this(CAPACITY);
    }

    public FixedSizeArrayImpl(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public int getSize() {
        return top + 1;
    }

    public void push(int data) throws Exception {
        if (getSize() == capacity) {
            throw new Exception("Stack is full!");
        }
        array[++top] = data;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        return array[top--];
    }

    public int top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        return array[top];
    }

    public void printStack() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        for (int i = 0; i <= top; i++) {
            System.out.println("data[" + i + "] => " + array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        FixedSizeArrayImpl fixedArray = new FixedSizeArrayImpl(5);
        fixedArray.push(1);
        fixedArray.push(11);
        fixedArray.printStack();
        System.out.println("Popped an element =>    " + fixedArray.pop());
        System.out.println("Stack Size  =>  " + fixedArray.getSize());
        fixedArray.push(2);
        fixedArray.printStack();
    }
}
