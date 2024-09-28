# Node class to represent each element

```java
class Node {
    int data;
    Node next;  // Reference to the next node

    // Constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class containing operations on the linked list
class LinkedList {
    Node head;  // Head node of the list

    // Method to insert a new node at the end
    public void insert(int data) {
        Node newNode = new Node(data);

        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            // Traverse to the end of the list
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;  // Link the new node at the end
        }
    }

    // Method to display the linked list
    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Method to delete a node by value
    public void delete(int value) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        // If the head needs to be removed
        if (head.data == value) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        // If the value was found, unlink the node
        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Value not found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insert some nodes
        list.insert(10);
        list.insert(20);
        list.insert(30);

        // Display the list
        list.display();

        // Delete a node
        list.delete(20);

        // Display the list again
        list.display();
    }
}
```
