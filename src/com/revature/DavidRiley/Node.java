package com.revature.DavidRiley;

public class Node {
    // Each node has only a data attribute and markers to the previous node and next nodes (doubly linked list).
    private int data;
    private Node prev;
    private Node next;

    // A blank constructor.
    public Node() {

    }

    // The main constructor that sets the default attributes of each created node.
    // prev and next are set to null so the programmer can set them at any time on separate lines without
    // taking up any additional memory. Plus, subsequent nodes aren't made yet, so making pointers to the
    // non-existing nodes would be impossible until they do exist.
    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    // As the method's name suggests, this inserts a Node with the data, data in it after the node with the data of nodeDataToFind.
    public Node InsertAfter(Node head, int dataToImpose, int nodeDataToFind) {

        // holds the head of the node in a variable as a starting point to check for the value nodeDataToFind. The variable
        // will also be iterative to go through each node in the linked list.
        Node tempNode = head;

        // The while loop to go through each node in the linked list to check if the current node (tempNode) holds the
        // value the user is looking for.
        while (tempNode != null) {
            if (tempNode.data == nodeDataToFind)
                break; // Breaks the while loop so tempNode is the node the user is looking for.
            tempNode = tempNode.next;
        }
        if (tempNode == null)  // If the node the user was looking for doesn't exist in the linked list, tempNode will be null.
            return head;  // return, returns the head of the linked list back to its call variable, so the linked list remains unchanged.

        Node newNode = new Node(dataToImpose); // Creates the new node, but doesn't issue pointer values just yet.
        Node nextNode = tempNode.next; // Holds the current Node that is next in the list beside the tempNode. (whether Null or not).

        // If there is no nextNode, make newNode the new end of the node, and set the old end node's next pointer = newNode.
        if (nextNode == null) {
            newNode.prev = tempNode;
            tempNode.next = newNode;
        }
        else {
            newNode.prev = tempNode;
            newNode.next = nextNode;
            tempNode.next = newNode;
            nextNode.prev = newNode;
        }
        return head; // head remains unchanged during this method, and it is returned to the caller.
    }
    // As the method's name suggests, this inserts a Node with the data, data in it before the node with the data of nodeDataToFind.
    // This method is, basically, the same as the InsertAfter.
    public Node InsertBefore(Node head, int data, int nodeDataToFind) {
        Node tempNode = head;

        while (tempNode != null) {
            if (tempNode.data == nodeDataToFind)
                break;
            tempNode = tempNode.next;
        }

        if (tempNode == null)
            return head;

        Node newNode = new Node(data);
        Node prevNode = tempNode.prev;

        if (prevNode == null) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode; // if the tempNode replaces the head, it has to be the new head node of the linked list.
        } else {
            newNode.next = tempNode;
            newNode.prev = prevNode;
            prevNode.next = newNode;
            tempNode.prev = newNode;
        }
        return head;
    }
    // This removes the node with the data, nodeDataToFind.
    public Node RemoveElement(Node head, int nodeDataToFind) {
        Node tempNode = head;

        while (tempNode != null) {
            if (tempNode.data == nodeDataToFind)
                break;
            tempNode = tempNode.next; // the .next variable holds the pointer to a Node. So, this line makes tempNode become a different node.
        }

        if (tempNode == null)
            return head;

        Node prevNode = tempNode.prev;
        Node nextNode = tempNode.next;

        if (prevNode == null) {
            // This means the chosen node is the head, so extra code needs to be written to make a new head.
            nextNode.prev = null;
            head = nextNode;
        } else if (nextNode == null) {
            prevNode.next = null;
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        return head;
    }

    // This counts the number of nodes in the given linked list.
    public int CountLinks(Node head) {
        Node tempNode = head;
        int countNodes = 0;
        while (tempNode != null) {
            countNodes++;
            tempNode = tempNode.next;
        }
        return countNodes;
    }

    // This prints the data values of each node in the node list that is headed by the head node, to the screen.
    public void PrintList(Node head) {
        Node tempNode = head;
        int countNodes = CountLinks(head);

        // Though a while loop would be more effecient and make more sense, I wanted to show you can use a for-loop in this instance.
        for (int i = 1; i <= countNodes; i++) {
            System.out.print(head.data + " ");
            tempNode = tempNode.next;
        }
    }
    // This creates a string variable of the data values of each node in the node list that is headed by the head node, and returns the list.
    // This method is necessary to be able to use it in a System.out.println statement.
    public String PrintListAsString(Node head) {
        Node tempNode = head;
        String nodeListString = "";

        while(tempNode != null) {
            nodeListString = nodeListString + tempNode.data + " ";
            tempNode = tempNode.next;
        }

        return nodeListString;
    }

    // This creates a new node list with the values passed into this method.
    public Node CreateList(int... nodeData) {
        int countNodesMade = 1;

        // Initializes the head of the linked list with the first element in the given array.
        Node head = new Node(nodeData[0]);

        Node tempNode = null;
        Node prevNode = null;

        for (int i = 1; i < nodeData.length; i++) {
            tempNode = new Node(nodeData[i]);
            tempNode.prev = prevNode;
            if (i == 1)
                head.next = tempNode;
            else
                prevNode.next = tempNode;

            prevNode = tempNode; // This is to start out the next iteration of the for loop, if it exists.
        }
        return head;
    }



    // Basic getters and setters for programmer convenience.
    public int GetData() {
        return data;
    }

    public void SetData(int data) {
        this.data = data;
    }

    public Node GetPrev() {
        return prev;
    }

    public void SetPrev(Node prev) {
        this.prev = prev;
    }

    public Node GetNext() {
        return next;
    }

    public void SetNext(Node next) {
        this.next = next;
    }
}
