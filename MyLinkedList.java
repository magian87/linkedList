package com.javarush.task.pro.task11.others.linkedList;

//node=null писать не стоит, т.к. на этот объект ничего не ссылается? в методе удаления
public class MyLinkedList<E> {
    private int size = 0;
    private Node first;
    private Node last;

    public int getSize() {
        return size;
    }

    public void add(E element) {
        if (size == 0) {
            Node node = new Node(element, null, null);
            size++;
            first = node;
            last = node;
        } else {
            Node node = new Node(element, last, null);
            size++;
            last.next = node;
            last = node;
        }

    }

    public void add(int index, E element) {
        Node node = getNode(index);

        if (node != null) {

            Node nodeNew = new Node(element, node.prev, node);

            if (node.prev == null) {
                node.prev = nodeNew;
            } else {
                node.prev.next = nodeNew;
            }

            size++;

            if (nodeNew.prev == null) {
                first = nodeNew;
            } else if (nodeNew.next == null) {
                last = nodeNew;
            }
        }

    }

    public E get(int index) {
        Node node = getNode(index);
        if (node != null) {
            return node.value;
        } else
            return null;
    }


    public void remove(int index) {
        Node node = getNode(index);

        if (node != null) {

            if (node == first) {
                if (size == 1) {
                    first = null;
                    node = null;
                    last = null;
                } else {
                    first = node.next;
                    node.next.prev = null;
                }
            } else if (node == last) {
                node.prev.next = null;
                last = node.prev;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;

            }

            size--;

        }
    }

    public void remove(E element) {
        int index = 0;
        Node currentElement = first;
        while (currentElement != null) {
            if (currentElement.value.equals(element)) {
                remove(index);
            }
            index++;
            currentElement = currentElement.next;

        }
    }


    private Node getNode(int index) {
        //Если есть превышение по индексу, то возвращать NULL
        if (index > size - 1) {
            return null;
        }

        int i = 0;
        Node currentElement = first;
        while (currentElement != null) {
            if (i == index) {
                return currentElement;
            }
            i++;
            currentElement = currentElement.next;
        }
        //без этой строчки не компилируется, как правильно написать?
        return null;
    }

    public void printAll() {
        System.out.println("Print all element Linkedlist");
        Node currentElement = first;
        while (currentElement != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
        System.out.println("Printed all element Linkedlist");
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    private class Node {
        private E value;
        private Node next;
        private Node prev;

        public Node(E value, Node prev, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

}
