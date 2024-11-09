package org.jay.queue_using_stack_imp;


import org.jay.stack.Stack;

/**
 * Queue implementation using stacks
 * Enque Deque operations
 * @param <T>
 */
public class Queue<T> implements QueueInterface<T>{

    private Stack<T> enqueStack;
    private Stack<T> dequeStack;

    public Queue(){
        enqueStack = new Stack<T>();
        dequeStack = new Stack<T>();
    }

    /**
     * this will load up enque
     * stack with the coming elements
     * @param obj
     */
    @Override
    public void enque(T obj) {
        enqueStack.push(obj);
    }

    /**
     * this will transfer all elements
     * from enqueStack to deque stack
     * if deque Stack is empty and will
     * pop the top element from deque stack
     * @return
     */
    @Override
    public T deque() {
        if(dequeStack.isEmpty()) {
            while (!enqueStack.isEmpty()) {
                dequeStack.push(enqueStack.pop());
            }
        }
        return dequeStack.isEmpty() ? null : dequeStack.pop();
    }

    /**
     * Similar to deque but will only return top element
     * it will not remove it from the stack
     * @return
     */
    @Override
    public T peek() {
        if(dequeStack.isEmpty()) {
            while (!enqueStack.isEmpty()) {
                dequeStack.push(enqueStack.pop());
            }
        }
        return dequeStack.isEmpty() ? null : dequeStack.peek();
    }

    /**
     * Returns the size of queue
     * @return
     */
    @Override
    public int size() {
        return  enqueStack.size()+dequeStack.size();
    }

    /**
     * Will return true if queue is empty
     * else false will be returned
     * @return
     */
    @Override
    public boolean isEmpty() {
      return enqueStack.isEmpty()
              && dequeStack.isEmpty();
    }


}
