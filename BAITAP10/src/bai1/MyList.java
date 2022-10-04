package bai1;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }
    public int size(){
        int count = 0;
        for (int i = 0; i < size; i++){
            count++;
        }
        return count;
    }
    public MyList<E> myClone() {
        MyList<E> v = new MyList<>();
        v.elements = elements;
        v.size = size;

        return v;
    }

    public E remove(int index) {
        checkIndex(index);
        E e = (E) elements[index];
        for (int j = index; j < size - 1; j++) {
            elements[j] = elements[j + 1];
        }
        elements[size - 1] = null;
        size--;
        return e;
    }
    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        }
    }

    // Trả về true nếu danh sách chứa phần tử
    public boolean contains(E o){
        for (int i = 0; i < size; i++){
            if (o.equals(elements[i])){
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o){
        for (int i = 0; i < size; i++){
            if (o.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }
    public boolean aDD(E e){
        elements[size++] = e;
        return true;
    }

    public E get(int i){
        if (i > 0 || i < size) {
            return (E) elements[i];
        }
        return null;
    }
    public void clear(){
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    public int getSize() {
        return size;
    }

    public Object[] getElements() {
        return elements;
    }

}
