package org.jay.queue_using_stack_imp;

/**
 * Queue interface using Stacks
 * LLD question
 * Enque Deque implementation
 *
 */
public interface QueueInterface<T> {

    void enque(T obj);
    T deque();

    T peek();

    int size();

    boolean isEmpty();

}
