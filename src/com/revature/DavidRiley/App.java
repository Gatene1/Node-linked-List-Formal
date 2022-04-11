package com.revature.DavidRiley;

public class App {
    public static void main(String[] args) {
        // Variable initializations for my first three nodes with int values.
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        Node nodeClass = new Node();

        // Setting the next value my head node. Only the next attribute is set, because nothing is before the head.
        head.SetNext(second);

        // Setting the previous and next attributes of the second node.
        second.SetPrev(head);
        second.SetNext(third);

        // Setting the prev attribute for third. Only the prev attribute because nothing comes after the last node.
        third.SetPrev(second);

        head = nodeClass.InsertAfter(head, 4, 3);
        int countedNodes = nodeClass.CountLinks(head);
        System.out.println(countedNodes + ": " + nodeClass.PrintListAsString(head));
        Node secondaryHead = nodeClass.CreateList(5, 6, 7, 8, 9, 10);
        int countedSecondaryNodes = nodeClass.CountLinks(secondaryHead);
        System.out.println(countedSecondaryNodes + ": " + nodeClass.PrintListAsString(secondaryHead));

        // running this application you will get:
        // 4: 1 2 3 4
        // 6: 5 6 7 8 9 10
        // Meaning there are 2 linked lists, the first has 4 nodes in it 1-4, and the second has  6 in it 5-10.
        // Check out the Node.java for more methods.
    }
}
