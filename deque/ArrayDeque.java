package deque;

public class ArrayDeque<T> {
    private T[] items;
    public  int size;
    public int indexOfFirstItem;
    public int indexOfLastItem;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        indexOfFirstItem = 3;
        indexOfLastItem = 3;
        size = 0;
    }

    public void resize(int x){
        T[] newArray = (T[]) new Object[x];
        if(indexOfFirstItem <= indexOfLastItem){
            System.arraycopy(items,indexOfFirstItem,newArray,0,size);
        } else {
            System.arraycopy(items,indexOfFirstItem,newArray,0, items.length-indexOfFirstItem);
            System.arraycopy(items,0,newArray,items.length-indexOfFirstItem, indexOfLastItem + 1);
        }
        indexOfFirstItem = 0;
        indexOfLastItem = size;
        items = newArray;
    }

    public void addFirst(T x){
        if (size == items.length) {
            resize(size * 2);
        }
        if(indexOfFirstItem != 0 ) {
            items[indexOfFirstItem - 1] = x;
            indexOfFirstItem = indexOfFirstItem - 1;
        } else {
            items[items.length - 1] = x;
            indexOfFirstItem = items.length - 1;
        }
    }

    public void addLast(T x){
        if (size == items.length) {
            resize(size * 2);
        }
        if(indexOfLastItem != items.length - 1 ) {
            indexOfLastItem = indexOfLastItem + 1;
        } else {
            items[0] = x;
            indexOfLastItem = 0;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i = 0; i < size; i++){
            System.out.print(get(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    public void removeFirst(){
        if(indexOfFirstItem != (items.length-1) ) {
            indexOfFirstItem = indexOfFirstItem + 1;
        } else {
            indexOfFirstItem = 0;
        }
        if (size < items.length / 4) {
            resize(items.length / 2);
        }
    }

    public void removeLast(){
        if(indexOfLastItem != 0 ) {
            indexOfLastItem = indexOfLastItem - 1;
        } else {
            indexOfLastItem = items.length - 1;
        }
        if (size < items.length / 4) {
            resize(items.length / 2);
        }
    }

    public T get(int i){
        if (indexOfFirstItem + i <= items.length){
            return (items[indexOfFirstItem + i]);
        } else {
            return items[i - (items.length - indexOfFirstItem)];
        }
    }

}
