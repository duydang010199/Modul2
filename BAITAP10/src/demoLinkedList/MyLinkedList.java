package demoLinkedList;

import java.util.LinkedList;

public class MyLinkedList {
    private Node head;
    private int numOfNodes;

    public MyLinkedList(Node head){
        this.head = head;
    }
    //Them vao vi tri index
    public void addByIndex(int index, Object data){
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++){
            temp = temp.next;
        }
        Node holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numOfNodes++;
    }
    //Them vao dau
    public void addFirst(Object data){
        Node temp = head;
        temp = new Node(data);
        head.next = temp;
        numOfNodes++;
    }
    //Them vao cuoi
    public void addLast(Object data){
        Node temp = head;
        temp = new Node(data);


    }

    public void deleteByIndex(int index){
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        numOfNodes--;
    }
    private class Node{
        private Object data;
        private Node next;
        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }
}
