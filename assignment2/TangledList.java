// JAZA KHAN UCID 30119100
// CPSC 331 Assignment 2
// Tutorial 03

package Assignment2;

import Assignment2.MyLinkedListInterface.MyLinkedListNode;

/** 
 * TangledList.java class, implements MyLinkedListInterface.java
 * Contains methods to manipulate a linked list and perform operations on it
 * 
 * @author Jaza K.
 */
class TangledList {

    /** 
     * removeSharedLinkedListNodes() method
     * 
     * Precondition: list0 and list1 are linked lists, there is at least one non-shared node in each
     * Postcondition: the nodes in list0 and list1 that are shared are removed from both lists
     * 
     * @param list0 the first list
     * @param list1 the second list
     */
    public static void removeSharedLinkedListNodes(Assignment2.MyLinkedList<String> list0, Assignment2.MyLinkedList<String> list1) {
        
        // compute the length of the lists
        int listLength0 = list0.length(); 
        int listLength1 = list1.length();

        // check list0 is longer, if not then swap the lists
        if (listLength0 < listLength1) {
            MyLinkedList<String> temp = list0;
            list0 = list1;
            list1 = temp;
        }

        // compute length difference
        int lengthDiff = listLength0 - listLength1;

        // initialize two nodes and set them to the head of the lists
        MyLinkedListNode<String> node0 = list0.getHeadNode();
        MyLinkedListNode<String> node1 = list1.getHeadNode();

        // move node0 forward lengthDiff times
        for (int i = 0; i < lengthDiff; i++) {
            node0 = node0.getNext();
        }

        int count = 0;
        // compare both lists now, checking for a shared node
        while (node0 != null && node1 != null) {
            // check if the nodes are the same
            if (node0.getValue().equals(node1.getValue())) {
                // set node1 back to head of list1
                node1 = list1.getHeadNode();
                // move node1 forward count-1 times
                for (int i = 0; i < count-1; i++) {
                    node1 = node1.getNext();
                }
                // set the next node of node1 to null
                node1.setNext(null);
                count++;
            } else {
                // move the nodes forward
                node0 = node0.getNext();
                node1 = node1.getNext();
                count++;
            }
        }
    }

    /** 
     * detectCycleAndPeriod() method
     * 
     * Precondition: list0 is a linked list
     * Postcondition: if list contains a cycle, return the period of the cycle, otherwise return 0
     * 
     * @param list0 the list to be checked
     * @return the period of the cycle, or -1 if no cycle
     */
    public static int detectCycleAndPeriod(Assignment2.MyLinkedList<String> list0) {

        // initialize the two nodes and set them to the head of the list
        MyLinkedListNode hare = list0.getHeadNode();
        MyLinkedListNode tortoise = list0.getHeadNode();

        // advance the hare two nodes and the tortoise one node and check for a cycle
        while (hare != null && hare.getNext() != null) {
            hare = hare.getNext().getNext();
            tortoise = tortoise.getNext();
            // if the hare and tortoise are the same, then there is a cycle
            if (hare == tortoise) {
                // calculate the period
                int period = 0;
                do {
                    tortoise = tortoise.getNext();
                    period++;
                } while (tortoise != hare);
                return period;
            }
        }
        // return -1 when no cycle exists
        return -1;
    };
    
    /** 
     * removeCycle() method
     * 
     * Precondition: list0 is a linked list with a cycle, period is the numnber of nodes in cycle
     * Postcondition: the cycle is removed from list0, 
     * 
     * @param list0 the list to be checked
     * @param period the period of the cycle
     */
    public static void removeCycle(Assignment2.MyLinkedList<String> list0, int period) {

         // initialize the two nodes and set them to the head of the list
         MyLinkedListNode hare = list0.getHeadNode();
         MyLinkedListNode tortoise = list0.getHeadNode();

        // advancing the hare period nodes forward into the list
        for (int i = 0; i < period; i++) {
            hare = hare.getNext();
        }

        // now advancing the hare and tortoise at the same rate, checking for equality
        while (hare != tortoise) {
            hare = hare.getNext();
            tortoise = tortoise.getNext();
        }
        // the tortoise and hare meet at the first node in the cycle

        // advance the hare period-1 nodes, this is the last node in the cycle
        for (int i = 0; i < period-1; i++) {
            hare = hare.getNext();
        }
        // set the next node of the hare to null
        hare.setNext(null);

    }

    /** 
     * removeLinkedListCycle() method
     * 
     * @param list0 the list to be checked
     */
    public static void removeLinkedListCycles(Assignment2.MyLinkedList<String> list0) {
        int period = detectCycleAndPeriod(list0);
        if (period != -1) {
            removeCycle(list0, period);
        }
    }

    // Code to setup one test case for eliminating shared nodes from two linked lists
    public static void createAndTestSharedNode() {
        // Your assignment submission should have more specific error handling
        try{
            Assignment2.MyLinkedList<String> stage0 = new Assignment2.MyLinkedList<String>();
            stage0.appendToTail("Arkells");
            stage0.appendToTail("Bruno Mars");
            stage0.appendToTail("Coldplay");
            stage0.appendToTail("David Bowie");
            stage0.appendToTail("Earth, Wind & Fire");
            
            Assignment2.MyLinkedList<String> stage1 = new Assignment2.MyLinkedList<String>();
            stage1.appendToTail("Foo Fighters");
            stage1.appendToTail("Gorillaz");

            MyLinkedListNode<String> node;
            node = stage0.searchByValue("Coldplay");
            stage1.appendToTail(node);

            System.out.println("Shared Nodes: Stage 0 Lineup");
            System.out.println(stage0.toString());
            System.out.println("Shared Nodes: Stage 1 Lineup");
            System.out.println(stage1.toString());
            System.out.println("\n");

            removeSharedLinkedListNodes(stage0, stage1);
            
            System.out.println("Shared Nodes Fixed: Stage 0 Lineup");
            System.out.println(stage0.toString());
            System.out.println("Shared Nodes Fixed: Stage 1 Lineup");
            System.out.println(stage1.toString());
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // Code to setup one test case for eliminating cycles from a linked list
    public static void createAndTestCycle() {
        // Your assignment submission should have more specific error handling
        try {
            Assignment2.MyLinkedList<String> stage0 = new Assignment2.MyLinkedList<String>();
            stage0.appendToTail("Arkells");
            stage0.appendToTail("Bruno Mars");
            stage0.appendToTail("Coldplay");
            stage0.appendToTail("David Bowie");
            stage0.appendToTail("Earth, Wind & Fire");
            stage0.appendToTail("Foo Fighters");
            stage0.appendToTail("Gorillaz");
            
            MyLinkedListNode<String> loopToNode;
            try{
                loopToNode = stage0.searchByValue("Coldplay");
            } catch (Exception e) {
                System.out.println("Exception thrown:" + e.getMessage());
                return;
            }
        

            MyLinkedListNode<String> tail;
            try {
                tail = stage0.searchByValue("Gorillaz");
            } catch (Exception e) {
                System.out.println("Exception thrown:" + e.getMessage());
                return;
            }
            if (tail != null) {
                tail.setNext(loopToNode);
            }

            System.out.println("Cyclic Nodes: Stage 0 Lineup");
            MyLinkedListNode<String> currentNode;
            currentNode = stage0.searchByValue("Arkells");

            // If we use the toString method it will never terminate. 
            // Most linked list operations on this list will not work, so be careful!
            for(int i = 0; i<10 & currentNode != null; i++) { 
                System.out.println("Element: " + currentNode.toString());
                currentNode = currentNode.getNext();
            }
            System.out.println("\n");

            // call removeLinkedListCycles() to remove the cycle from stage0
            removeLinkedListCycles(stage0);
            
            // print out fixed lineup after calling function
            System.out.println("Cyclic Nodes Fixed: Stage 0 Lineup");
            currentNode = stage0.getHeadNode();
            for(int i = 0; i<10 & currentNode != null; i++) {
                System.out.println("Element: " + currentNode.toString());
                currentNode = currentNode.getNext();
            }
            System.out.println("\n");
        
        } catch (Exception e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        //Feel free to set up different tests, your code should be general, and will be tested against other cases
        createAndTestSharedNode();
        createAndTestCycle();
    }
}
