public class Stack<T> {
    private Object[] data;
    private int size;

    public Stack(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[size] = element;
        size++;
    }

    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        T element = (T) data[size - 1];
        data[size - 1] = null;
        size--;
        return element;
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) data[size - 1];
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        System.out.println("Верхний элемент стека: " + stack.peek());
        stack.push(2);
        System.out.println("Верхний элемент стека: " + stack.peek());
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println("Верхний элемент стека: " + stack.peek());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("Верхний элемент стека: " + stack.peek());
    }
}