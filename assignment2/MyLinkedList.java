// JAZA KHAN UCID 30119100
// CPSC 331 Assignment 2
// Tutorial 03

package Assignment2;

/** 
 * MyLinkedList.java class, implements MyLinkedListInterface.java
 * Class which contains multilpe methods to manipulate a linked list
 * 
 * @author Jaza K.
 */
public class MyLinkedList<ElementType> implements MyLinkedListInterface<ElementType> {
    
    // the head of the linked list
    private MyLinkedListNode<ElementType> head;

    /** 
     * Constructs an empty list.
     */
    public MyLinkedList() {
        head = null;
    }

    /** 
     * getHeadNode() method
     * 
     * Precondition: this is a linked list
     * Postcondition: the head node is returned, if the list is empty null is returned
     * 
     * @return the head node of the linked list
     */
    public MyLinkedListNode<ElementType> getHeadNode() {
        // check for empty list
        if (head == null) {
            return null;
        }
        // get the head node
        return head;
    } 


    /** 
     * appendToTail() method
     * 
     * Precondition: this is a linked list, and value is a variable with appropriate
     * type, and not already present in the list
     * 
     * Postcondition: the value is appended to the end of the list, the length of the 
     * list is previous length + 1. If a node with the given value already exists,
     * throw exception
     * 
     * @param value the value to be appended to the end of the list
     * @throws LinkedListValueExistsException if a node with the given value already exists
     */
    public void appendToTail(ElementType value) throws LinkedListValueExistsException {
        // check for empty list
        if (head == null) {
            // set head to new node
            head = new MyLinkedListNode<ElementType>(value);
        } 
        else {
            MyLinkedListNode<ElementType> currentNode = head; // initialize current node
            // iterate through list to find the end
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
                // if value already exists, throw the exception
                if (currentNode.getValue().equals(value)) {
                    throw new LinkedListValueExistsException("Value already exists in list");
                }
            }
            // once end is found, set next to new node (appending)
            currentNode.setNext(new MyLinkedListNode<ElementType>(value));
        }
    }

    /** 
     * appendToTail() method
     * 
     * Precondition: this is a linked list, and node is a variable with appropriate
     * type, and not already present in the list
     * 
     * Postcondition: the tail node of the list is node, the length of the list is 
     * previous length + 1
     * 
     * @param node the node to be appended to the end of the list
     * @throws LinkedListValueExistsException if a node with the given value already exists
     */
    public void appendToTail(MyLinkedListNode<ElementType> node) throws LinkedListValueExistsException {
		// check for empty list
        if (head == null) {
            // set head to new node
            head = node;
        } 
        else {
            MyLinkedListNode<ElementType> currentNode = head; // initialize current node
            // iterate through list to find the end
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
                // if value already exists, throw the exception
                if (currentNode.getValue().equals(node.getValue())) {
                    throw new LinkedListValueExistsException("Value already exsists in list");
                }
            }
            // once end is found, set next to new node (appending)
            currentNode.setNext(node);
        }

    }

    /** 
     * length() method
     * 
     * Precondition: this is a linked list
     * Postcondition: the length of the list is returned, 0 if list is empty
     * 
     * @return the length of the list
     */
    public int length() {
        // initialize variable for length
        int length = 0;
        // check for empty list
        if (head == null) {
            return length;
        }
        // iterate through list and increment length until end is reached
        MyLinkedListNode<ElementType> currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            length++;
        }
        return length;
    }

    /** 
     * deleteByValue() method
     * 
     * Precondition: this is a linked list, and value is a variable with appropriate type
     * 
     * Postcondition: the node with the given value is removed from the list. If no node with
     * the given value exists, list remains unchanged. If list is empty, throw exception
     * 
     * @param value the value to be deleted
     * @throws LinkedListListEmptyException if list is empty
     */
    public void deleteByValue(ElementType value) throws LinkedListListEmptyException {
        // check for empty list
        if (head == null) {
            throw new LinkedListListEmptyException("List is empty");
        }
        // check if head is the node to be deleted
        else if (head.getValue().equals(value)) {
            head = head.getNext();
        }
        // otherwise, iterate through list to search for it
        else {
            MyLinkedListNode<ElementType> currentNode = head;
            while (currentNode.getNext() != null) {
                if (currentNode.getNext().getValue().equals(value)) {
                    currentNode = currentNode.getNext().getNext();
                    return;
                }
                currentNode = currentNode.getNext();
            }
        }
    }

    /** 
     * searchByValue() method
     * 
     * Precondition: this is a linked list, and value is a variable with appropriate type
     * 
     * Postcondition: the node with the given value is returned, if no node with the given
     * value exists, null is returned. If list is empty, throw exception
     * 
     * @param value the value to be searched for
     * @throws LinkedListListEmptyException if list is empty
     */
    public MyLinkedListNode<ElementType> searchByValue(ElementType value) throws LinkedListListEmptyException {
        // check for empty list
        if (head == null) {
            throw new LinkedListListEmptyException("List is empty");
        }
        // check if head is the node to be searched for
        else if (head.getValue().equals(value)) {
            return head;
        }
        // otherwise, iterate through list to search for it
        else {
            MyLinkedListNode<ElementType> currentNode = head;
            while (currentNode.getNext() != null) {
                if (currentNode.getNext().getValue().equals(value)) {
                    return currentNode.getNext();
                }
                currentNode = currentNode.getNext();
            }
        }
        // return null if value not found
        return null;
    }   

    /** 
     * toString() method
     * 
     * Precondition: this is a linked list
     * Postcondition: the list is returned as a string of values, in the same order
     * 
     * @return a string representation of the list
     */
    public String toString() {
        String listString = "";
        // check for empty list
        if (head == null) {
            return listString;
        }
        // initialize current node for iteration
        MyLinkedListNode<ElementType> currentNode = head;
        while (currentNode.getNext() != null) {
            // append value to string
            listString += currentNode.getValue() + " - ";
            currentNode = currentNode.getNext();
        }
        listString += currentNode.getValue();
        return listString; 
    }
}