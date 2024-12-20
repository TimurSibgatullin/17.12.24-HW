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
        last = a;
        return true;
    }

    public void sort() {

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
        return null;
    }

    public Apple remove(int position) {
        Node a = first;
        for (int i = 1; i < position; ++i) {
            a = a.next;
        }

        Node b = a;
        Apple res = a.next.value;
        a.prev = b.prev;
        a.next = b;
        b.prev = a;
        a.prev.next = a;
        last = a;
        return res;
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
