import javax.swing.*;

public class LinkedListDeque<T> {
    private TNode sentinel;
    private int size;

    public class TNode{
        private TNode prev;
        private T item;
        private TNode next;

        TNode(TNode p,T x, TNode n){
            prev=p;
            item=x;
            next=n;
        }
    }
    //create an empty deque
    public LinkedListDeque(){
        sentinel=new TNode(null,null,null);
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
        size=0;
    }

    //Adds an item of type T to the front of the deque
    public void addFirst(T item){
        sentinel.next=new TNode(sentinel,item,sentinel.next);
        sentinel.next.next.prev=sentinel.next;
        size++;
    }

    //Adds an item of type T to the back of the deque
    public void addLast(T item){
    sentinel.prev=new TNode(sentinel.prev,item,sentinel);
    sentinel.prev.prev.next=sentinel.prev;
    size++;
    }

    //Returns true if deque is empty, false otherwise
    public boolean isEmpty(){
        return(size==0);
    }

    //Returns the number of items in the deque
    public int size(){
        return size;
    }

    /**
     * Prints the items in the deque from first to last,
     * separated by a space.
     * Once all the items have been printed, print out a new line
     */
    public void printDeque(){
        if(isEmpty()){
            System.out.println("null");
        }
        else {
            TNode printDeq = sentinel.next;
            for (int i = 0; i < this.size; i++) {
                System.out.print(printDeq.item + " ");
                printDeq = printDeq.next;
            }
            System.out.println(" ");
        }
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null
     */
    public T removeFirst(){
    if(isEmpty()){
        return null;
    }
    else{
        T removeF=sentinel.next.item;
        sentinel.next.next.prev=sentinel;
        sentinel.next=sentinel.next.next;
        size--;
        return removeF;
    }
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast(){
        T removeL=sentinel.prev.item;
        sentinel.prev.prev.next=sentinel;
        sentinel.prev=sentinel.prev.prev;
        size--;
        return removeL;
        //return sentinel.prev.item;
    }
    /**
     * Gets the item at the given index,
     * where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * Must not alter the deque!
     * iteration
     */
    public T get(int index){
        if(index>size){
            return null;
        }
        else {
            TNode getIndex = sentinel;
            for (int i = 0; i <= index; i++) {
                getIndex = getIndex.next;
            }
            return getIndex.item;
        }
    }

    /**
     *  Same as get, but uses recursion
     */
    public T getRecursive(int index){
    if(index>size){
        return null;
    }
    else {
        return getHelper(sentinel.next, index);
    }
    }

    /**
     *getRecursive helper function
     */
    private T getHelper(TNode helper, int index){
        if(index==0){
            return helper.item ;
        }
        else{
            return getHelper(helper.next,index-1);
        }
    }

    //Creates a deep copy of other
    public LinkedListDeque(LinkedListDeque other){
    sentinel=new TNode(null,null,null);
    sentinel.prev=sentinel;
    sentinel.next=sentinel;
    size=0;
        for(int i=0;i<other.size;i++){
        this.addLast((T)other.get(i));
    }
    }


    //main method
    public static void main(String[] args) {
        LinkedListDeque<Integer> Dllist = new LinkedListDeque<>();
        Dllist.addFirst(1);
        Dllist.addFirst(0);
        Dllist.addLast(2);
        Dllist.addLast(3);
        Dllist.get(4);
        Dllist.get(3);
        Dllist.getRecursive(3);
        Dllist.getHelper(Dllist.sentinel,3);
        Dllist.printDeque();
        Dllist.removeFirst();
        Dllist.removeLast();
        LinkedListDeque<Integer> Copy = new LinkedListDeque<>(Dllist);



    }
}
