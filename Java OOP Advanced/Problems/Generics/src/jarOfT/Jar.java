package jarOfT;

import java.util.Stack;

public class Jar<T> {
    private Stack<T> stack;

    public Jar() {
        this.stack = new Stack<>();
    }

    public void add (T item) {
        this.stack.push(item);
    }

    public T remove() {
        return this.stack.pop();
    }
}
