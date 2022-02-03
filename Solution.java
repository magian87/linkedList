package com.javarush.task.pro.task11.others.linkedList;

public class Solution {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("a1");
        myLinkedList.add("a2");
        myLinkedList.add("a3");

        myLinkedList.printAll();
        myLinkedList.remove(1);
        System.out.println(myLinkedList.get(2));

        myLinkedList.remove("a1");
        myLinkedList.remove("a3");
        myLinkedList.remove("a2");
        myLinkedList.printAll();
        System.out.println(myLinkedList.getFirst());
        System.out.println(myLinkedList.getLast());


    }
}
