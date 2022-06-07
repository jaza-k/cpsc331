package Assignment2;

// It is not necessary to modify this file for assignment2

interface MyLinkedListInterface <ElementType> {

    public class LinkedListValueExistsException extends Exception {
        public LinkedListValueExistsException(String errorMessage) {
            super(errorMessage);
        }
    }

    public class LinkedListListEmptyException extends Exception {
        public LinkedListListEmptyException(String errorMessage) {
            super(errorMessage);
        }

        public LinkedListListEmptyException() {
        }
    }

    public class MyLinkedListNode<ElementType> {
        private MyLinkedListNode<ElementType> next;
        private ElementType value;

        public MyLinkedListNode() {
            this.value = null;
            this.next = null;
        }
        public MyLinkedListNode(ElementType value) {
            this.value = value;
        }
        public MyLinkedListNode(ElementType value, MyLinkedListNode<ElementType> next) {
            this.value = value;
            this.next = next;
        }
        public ElementType getValue() {
            return value;
        }
        public void setValue(ElementType value) {
            this.value = value;
        }

        public MyLinkedListNode<ElementType> getNext() {
            return next;
        }
        public void setNext(MyLinkedListNode<ElementType> next) {
            this.next = next;
        }

        public String toString() { 
            return this.value.toString();
        }
    }
    
    public MyLinkedListNode<ElementType> getHeadNode();
    
    public void appendToTail(ElementType value) throws LinkedListValueExistsException;
    
    public void appendToTail(MyLinkedListNode<ElementType> node) throws LinkedListValueExistsException;

    public int length();

    public void deleteByValue(ElementType value) throws LinkedListListEmptyException;

    public MyLinkedListNode<ElementType> searchByValue(ElementType value) throws LinkedListListEmptyException;

    public String toString();
}
