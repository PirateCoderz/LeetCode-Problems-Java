package simple;

import java.util.HashMap;
import java.util.Map;

class LinkedListRaw {
    int data;
    LinkedListRaw next;

    // Constructor to initialize node with data
    public LinkedListRaw(int data) {
        this.data = data;
        this.next = null;
    }

    // Default constructor
    public LinkedListRaw() {}

    // Method to append nodes based on values in the map
    public void append(Map<Integer, Integer> dataMap) {
        LinkedListRaw current = this;

        // Iterate through the map's values and append each as a new node
        for (int value : dataMap.values()) {
            if (current.data == 0 && current.next == null) {
                current.data = value;  // Set the head's data if it's a placeholder
            } else {
                current.next = new LinkedListRaw(value);
                current = current.next;
            }
        }
    }

    // Utility method to print the linked list
    public void printList() {
        LinkedListRaw current = this;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Two_twoSumRaw {

    // Method to create a map where each digit of 'num' is stored in reverse order
    static Map<Integer, Integer> createMap(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;

        // Loop to separate each digit and store it in the map
        while (num > 0) {
            map.put(index++, num % 10);  // Store each digit in reverse order
            num = num / 10;
        }
        return map;
    }

    public static void main(String[] args) {
        int num = 304;

        // Creating a map of digits in reverse order from the integer
        Map<Integer, Integer> map1 = createMap(num);
        System.out.println("Generated map from number " + num + ": " + map1);

        // Initializing the linked list and appending nodes based on the map
        LinkedListRaw l1 = new LinkedListRaw();
        l1.append(map1);

        // Printing the linked list
        System.out.print("Linked List: ");
        l1.printList();
    }
}
