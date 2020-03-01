public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int nextFirst;
    private int nextLast;
    private double usageR;
    private static final int RFACTOR = 2;

    /**
     * creates an empty array deque
     */
    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        nextFirst = (array.length / 2) - 1;
        nextLast = (array.length / 2);
        usageR = (double) size / array.length;
    }

    /**
     * resize the underlying array with target capacity
     * create a new array 'a', copy the original array 'array' from the head to tail
     */
    private void resize(int capacity) {

//        //Condition 1: enlarge array to double size when array is full
//        if(size==array.length) {
            T[] a = (T[]) new Object[capacity];
            //System.arraycopy(array,0,a,0,nextFirst);//第一次自己尝试 左边copy 右边copy 中间插空
            //System.arraycopy(array,nextFirst,a,size+nextFirst,size-nextFirst);

            //iteration following head
            int curr = plusOne(nextFirst);
            for (int i = 0; i < size; i++) {
                a[i] = array[curr];
                curr = plusOne(curr);
            }
            array = a;
            //new head and tail
            nextFirst = array.length - 1;
            nextLast = size;
        }

//        //Condition 2: shrink array to half size when ratio hits 0.25
//        if(array.length>=16&&usageR<0.25){
//            T[] a=(T[]) new Object[size /2];
//
//        }
//    }


    /**
     * Adds an item of type T to the front of the deque
     */
    public void addFirst(T item){

        //check whether array is full
        if (size == array.length){
            resize(size * RFACTOR);
        }
        array[nextFirst] = item;
        size += 1;
        //head moves
        nextFirst = minusOne(nextFirst);
    }
    /**
     * helper function to record moves of nextFirst
     */
    private int minusOne(int index){
        return (index - 1 + array.length) % array.length;
    }

    /**
     * Adds an item of type T to the back of the deque
     */
    public void addLast(T item) {

        //check whether array is full
        if(size == array.length) {
            resize(size * RFACTOR);
        }
        array[nextLast] = item;
        size += 1;
        //tail moves
        nextLast = plusOne(nextLast);
    }
    /**
     * helper function to record moves of nextLast
     */
    private int plusOne(int index) {

        return (index+1 + array.length) % array.length;
    }

    /**
     * Returns true if deque is empty, false otherwise
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size(){
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        int curr = plusOne(nextFirst);

        for(int i = 0;i < size; i++) {
            System.out.print(array[curr] + " ");
            curr = plusOne(curr);
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null
     */
    public T removeFirst() {
        //if empty, return null
        if(isEmpty()) {
            return  null;
        }
        //not empty
        else {
            //current head position
            int atFirst = plusOne(nextFirst);

            //remFirst pointer holds current head
            T remFirst = array[atFirst];

            //set current head to null
            array[atFirst] = null;

            //next head position moves
            nextFirst=plusOne(nextFirst);
            size -= 1;

            //　check memory efficiency
            if(array.length >= 16 && size < array.length * 0.25){
                resize(array.length / 2);
        }
            return remFirst;
        }
    }
    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null
     */
    public T removeLast(){
        //if empty, return null
        if(isEmpty()) {
            return  null;
        }
        //not empty
        else {
            //current tail position
            int atLast = minusOne(nextLast);

            //remLast pointer holds current tail
            T remLast = array[atLast];

            //set current tail to null
            array[atLast] = null;

            //next tail position moves
            nextLast = minusOne(nextLast);
            size -= 1;

            //　check memory efficiency
            if(array.length >= 16 && size < array.length * 0.25){
                resize(array.length / 2);
            }
            return remLast;
        }
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index){
        if(index >= size){
            return null;
        }
        else {
            //start from head position
            int atIndex = plusOne(nextFirst);
            atIndex = (atIndex+index) % array.length;
            return array[atIndex];
        }
    }

    /**
     * Creates a deep copy of other
     */
//    public ArrayDeque(ArrayDeque other){
//        array = (T[]) new Object[other.size];
//        nextFirst = other.nextFirst;
//        nextLast = other.nextLast;
//        size = other.size;
//        usageR = other.usageR;
//        System.arraycopy(other.array,0, this.array,0, size);
//    }




//test
//    public static void main(String[] args){
//        ArrayDeque<Integer> AList=new ArrayDeque<>();
//        AList.addLast(4);
//        AList.addLast(5);
//        AList.addLast(6);
//        AList.addLast(7);
//        AList.addFirst(1);
//        AList.addFirst(2);
//        AList.addFirst(3);
//        AList.addFirst(4);
//        AList.addFirst(1);
//        AList.addFirst(2);
//        AList.addLast(4);
//        AList.addLast(5);
//        AList.addFirst(7);
//        AList.addFirst(8);
//        AList.addFirst(9);
//        AList.addLast(4);
//        AList.addLast(5);
//        AList.addLast(6);
//        AList.addLast(7);
//        AList.addLast(8);
//        AList.addFirst(1);
//        AList.addFirst(2);
//        AList.addLast(4);
//        AList.addLast(5);
//        AList.addFirst(7);
//        AList.addFirst(8);
//        AList.addFirst(9);
//        AList.addLast(7);
//        AList.addFirst(1);
//        AList.addFirst(2);
//        AList.addFirst(3);
//        AList.addFirst(4);
//        AList.addFirst(1);
//        AList.addFirst(2);
//
//
//    }
}
