package bai3;

import thuchanh2.Node;

public class UseQueue {
    public static class Node {
        public int data;
        public Node link;
    }

    public static class Queue{
        Node front, rear;
    }
    //Tạo hàm đợi
    public static void enQueue(Queue q, int value){
        Node temp = new Node();
        temp.data = value;
        if (q.front == null){
            q.front = temp;
        } else {
            q.rear.link = temp;
        }
        q.rear = temp;
        q.rear.link = q.front;
    }
    //Hàm xóa các phần tử trong hàm đợi
    public static int deQueue(Queue q){
        if (q.front == null){
            System.out.println("Queue is empty!");
            return Integer.MAX_VALUE;
        }
        int value;
        if (q.front == q.rear){
            value = q.front.data;
            q.front = null;
            q.rear = null;
        } else {
            Node temp = q.front;
            value = temp.data;
            q.front = q.front.link;
            q.rear.link = q.front;
        }
        return value;
    }
    //Hàm hiển thị các phần tử của hàm đợi hình tròn
    public static void displayQueue(Queue q){
        Node temp = q.front;
        System.out.print("Elements in Circular Queue are: ");
        while (temp.link != q.front){
            System.out.printf("%d ", temp.data);
            temp = temp.link;
        }
        System.out.printf("%d", temp.data);
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.front = q.rear = null;
        enQueue(q, 14);
        enQueue(q, 22);
        enQueue(q, 6);
        displayQueue(q);

        System.out.println();
        System.out.printf("Deleted value = %d, ", deQueue(q));
        System.out.printf("Deleted value = %d ", deQueue(q));
        System.out.println();
        displayQueue(q);
        System.out.println();
        enQueue(q, 10);
        enQueue(q,11);
        displayQueue(q);
    }

}
