package org.jay.stack;

/**
 * Stack implementation of List
 */
public class Stack<T> implements StackInterface<T>{

    private int initialCapacity;
    private int top;
    private int size;
    private T[] object;

    public Stack(){
        this.size = 0;
        this.top = -1;
        this.initialCapacity = 11;
        object = (T[]) new Object[initialCapacity];
    }
    @Override
    public T peek() {
        if(isEmpty())
            throw new RuntimeException("Empty Stack");
        return this.object[top];
    }

    @Override
    public void push(T object) {
        if(size == initialCapacity){
            resize();
        }
        this.object[++top] = object;
        size++;
    }

    private void resize() {
        initialCapacity += (initialCapacity/2);
        T[] newObject = (T[]) new Object[initialCapacity];
        System.arraycopy(this.object,0,newObject,0,size);
        this.object = newObject;
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new RuntimeException("Empty Stack");

        T obj = this.object[top];
        this.object[top] = null;
        top--;
        size--;
        return obj;
    }

    @Override
    public boolean isEmpty() {
        return (this.top == -1);
    }

    @Override
    public int size() {
        return size;
    }

    public String toString(){
        if(isEmpty())
            return "[ ]";

        StringBuilder str = new StringBuilder();
        str.append("[");
        str.append(object[0]);

        for(int i = 1 ; i <= top ; i++)
             str.append(", ").append(object[i]);

        str.append(" ]");

        return str.toString();
    }

}
