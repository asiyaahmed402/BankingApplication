public class LinkedList1<T> {

    private LinkedListNode<T> first = null;


     //Insert at the front of the list

    public void insert(LinkedListNode<T> node) {
        node.setNext(first);
        first = node;
    }

    //Remove from the front of the list


    public void remove(){
        if(first.getNext()!=null)
            first = first.getNext();
        else first = null;
    }


     //Recursively traverse this list and print the node value

    private void printList(LinkedListNode<T> node) {
        System.out.println(node.getValue());
        if(node.getNext()!=null) printList(node.getNext());
    }

    public void print(){
        printList(first);
    }






}
