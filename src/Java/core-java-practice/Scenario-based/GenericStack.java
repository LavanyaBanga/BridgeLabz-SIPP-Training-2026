import java.util.*;

class Pair<T, U> {
    T first;
    U second;

    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    void display() {
        System.out.println("First: " + first + ", Second: " + second);
    }
}

class MyStack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    void push(T item) {
        stack.add(item);
    }

    T pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    void display() {
        System.out.println(stack);
    }
}

class Repository<T> {
    private ArrayList<T> items = new ArrayList<>();

    void add(T item) {
        items.add(item);
    }

    void displayAll() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}

public class Main {

    static <T extends Comparable<T>> T findMax(T[] arr) {
        T max = arr[0];

        for (T item : arr) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }

        return max;
    }

    static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Age", 20);
        pair.display();

        MyStack<String> stack = new MyStack<>();
        stack.push("Java");
        stack.push("DSA");
        stack.push("Spring");

        stack.display();
        System.out.println("Popped: " + stack.pop());
        stack.display();

        Integer[] nums = {10, 50, 20, 90, 30};
        String[] names = {"Aman", "Lavanya", "Riya"};

        System.out.println("Max number: " + findMax(nums));
        System.out.println("Max name: " + findMax(names));

        Repository<String> repo = new Repository<>();
        repo.add("Student Entity");
        repo.add("Employee Entity");
        repo.add("Product Entity");

        System.out.println("Repository Data:");
        repo.displayAll();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<String> languages = Arrays.asList("Java", "Python", "C++");

        System.out.println("Wildcard Integer List:");
        printList(numbers);

        System.out.println("Wildcard String List:");
        printList(languages);
    }
}
