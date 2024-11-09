package org.jay.stack;

/**
 * List Interface
 * ArrayList , Queue ,Stack ,Vector all can implement it
 * for now i am going to use it for stack so
 * avoiding adding any unneccessary methods
 * @param <T>
 */
public interface StackInterface<T> {
    public T peek();
    public void push(T object);
    public T pop();

    public boolean isEmpty();

    public int size();

}
