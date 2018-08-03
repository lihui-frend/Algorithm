package com.algorithm;

class Node{
    private int data;
    private Node next;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
public class Reverse {
    //递归
    public static Node reverse1(Node head){
        if (head==null||head.getNext()==null){
            return head;
        }
        Node result = reverse1(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return result;
    }

    //遍历
    public static Node reverse2(Node head){
        if(head==null||head.getNext()==null){
            return head;
        }
        Node pre = head;
        Node cur = head.getNext();
        Node tep;
        while (cur!=null){
            tep = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = tep;
        }
        head.setNext(null);
        return pre;
    }
}
