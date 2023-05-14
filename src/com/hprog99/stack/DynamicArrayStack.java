package com.hprog99.stack;

public class DynamicArrayStack {

    private static final int CAPACITY = 1 << 15;
    private int top = -1;
    private int capacity;
    private int[] array;

    public DynamicArrayStack() {
        this(CAPACITY);
    }

    public DynamicArrayStack(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public int getSize() {
        return top + 1;
    }

    public int top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        return array[top];
    }

    public void push(int data) {
        if (getSize() == capacity) {
            expand();
        }
        array[++top] = data;
    }

    private void expand() {
        int length = getSize();
        int[] newArray = new int[length << 1];
        System.arraycopy(array, 0, newArray, 0, length);
        array = newArray;
        capacity = length << 1;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        shrink();
        return array[top--];
    }

    private void shrink() {
        int length = getSize();
        int threeFourthCapacity = (int) (capacity * 0.75);
        if ((capacity - length) >= threeFourthCapacity) {
            capacity = capacity / 2;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, length);
            array = newArray;
        }
    }

    public void printStack() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        System.out.println("Total Capacity  =>  " + capacity + "      And length  => " + getSize());
        for (int i = 0; i <= top; i++) {
            System.out.println("data[" + i + "] => " + array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        DynamicArrayStack dynamicArray = new DynamicArrayStack(3);
        dynamicArray.push(1);
        dynamicArray.push(11);
        dynamicArray.push(4);
        dynamicArray.printStack();
        System.out.println("Popped an element =>    " + dynamicArray.pop());
        dynamicArray.push(2);
        dynamicArray.push(3);
        dynamicArray.printStack();
        System.out.println("Popped an element =>    " + dynamicArray.pop());
        System.out.println("Popped an element =>    " + dynamicArray.pop());
        System.out.println("Popped an element =>    " + dynamicArray.pop());
        dynamicArray.printStack();
    }
}
