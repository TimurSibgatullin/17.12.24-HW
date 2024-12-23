package org.example;

import com.sun.source.util.SourcePositions;

import javax.swing.*;

public class List2Direction {

    private Node first;
    private Node last;

    public void add(Apple value) {
        if (first == null) {
            first = new Node(value);
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
            current.next.prev = current;
            last = current.next;
        }
    }

    public boolean add(int position, Apple value) {
        Node a = first;
        for (int i = 1; i < position; ++i) {
            a = a.next;
        }
        //return false;

        Node b = a;
        a = new Node(value);
        a.prev = b.prev;
        a.next = b;
        b.prev = a;
        a.prev.next = a;
        Node current = a;
        while (current.next != null) {
            current = current.next;
        }
        last = current;
        return true;
    }

    public void sort() {
        if (first == null || first.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = first;

            while (current.next != null) {
                if (current.value.compare(current.next.value) > 0) {
                    // Swap values
                    Apple temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    @Override
    public String toString() {
        String res = "";
        Node current = first;
        while (current != null) {
            res += "Цвет: " + current.value.getColor() + ", " + "вес:" + current.value.getWeight() + ", " +
                    "сорт: " + current.value.getKind() + ", " + "цена: " + current.value.getPrice() + "; ";
            current = current.next;
        }

        return res;
    }

    public Apple pop() {
        if (last == null) return null;

        Apple value = last.value;
        if (last.prev != null) {
            last = last.prev;
            last.next = null;
        } else {
            first = last = null;
        }
        return value;
    }

    public Apple remove(int position) {
        if (position < 0 || first == null) return null;

        Node current = first;
        for (int i = 0; i < position; ++i) {
            if (current.next == null) return null;
            current = current.next;
        }

        if (current.prev != null) current.prev.next = current.next;
        if (current.next != null) current.next.prev = current.prev;
        if (current == first) first = current.next;
        if (current == last) last = current.prev;

        return current.value;
    }

    public void printReverse() {
        Node current = last;
        while (current != null) {
            System.out.print("Цвет: " + current.value.getColor() + ", " + "вес:" + current.value.getWeight() + ", " +
                    "сорт: " + current.value.getKind() + ", " + "цена: " + current.value.getPrice() + "; ");
            current = current.prev;
        }
        System.out.println();
    }

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.print("Цвет: " + current.value.getColor() + ", " + "вес:" + current.value.getWeight() + ", " +
                    "сорт: " + current.value.getKind() + ", " + "цена: " + current.value.getPrice() + "; ");
            current = current.next;
        }
        System.out.println();
    }
}
