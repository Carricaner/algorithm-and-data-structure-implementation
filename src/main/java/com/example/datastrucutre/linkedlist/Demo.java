package com.example.datastrucutre.linkedlist;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demo {

  public static void main(String[] args) {
    demoQueueAttributes();
    demoListAttributes();
    demoDequeAttributes();
  }

  private static void demoQueueAttributes() {
    // Regard a linked list as a queue
    Queue<String> queue = new LinkedList<>();
    queue.offer("Google");
    queue.offer("Nvidia");
    queue.offer("Amazon");
    queue.offer("Meta");
    System.out.println(queue); // [Google, Nvidia, Amazon, Meta]

    queue.poll();
    System.out.println(queue); // [Nvidia, Amazon, Meta]

    queue.offer("Microsoft");
    System.out.println(queue); // [Nvidia, Amazon, Meta, Microsoft]

    System.out.println(queue.peek()); // Nvidia
    System.out.println(queue.element()); // Nvidia

    queue.clear();

    System.out.println(queue.peek()); // null
    try {
      System.out.println(queue.element()); // will throw an exception
    } catch (Exception exception) {
      System.out.println(exception); // java.util.NoSuchElementException
    }
  }

  private static void demoListAttributes() {
    List<String> list = new LinkedList<>();
    list.add("Google");
    list.add("Nvidia");
    list.add("Amazon");
    list.add("Meta");
    System.out.println(list); // [Google, Nvidia, Amazon, Meta]

    System.out.println(list.get(0)); // Google
    System.out.println(list.get(3)); // Meta
    System.out.println(list.indexOf("Amazon")); // 2
    System.out.println(list.indexOf("TSMC")); // -1

    list.add("Google");
    System.out.println(list.indexOf("Google")); // 0
    System.out.println(list.lastIndexOf("Google")); // 4

    list.remove("Google"); // will remove the first occurrence
    System.out.println(list); // [Nvidia, Amazon, Meta, Google]
    list.remove("TSMC"); // there is no exception even if the item is not in the list
    System.out.println(list); //  [Nvidia, Amazon, Meta, Google]
    list.remove(2);
    System.out.println(list); // [Nvidia, Amazon, Google]
    List<String> subList = list.subList(1, 3);
    System.out.println(subList); // [Amazon, Google]
  }

  private static void demoDequeAttributes() {
    Deque<String> deque = new LinkedList<>();
    deque.offerFirst("Google");
    deque.addFirst("Nvidia");
    deque.offerLast("Amazon");
    deque.addLast("Meta");
    System.out.println(deque); // [Nvidia, Google, Amazon, Meta]

    System.out.println(deque.peekFirst()); // Nvidia
    System.out.println(deque.peekLast()); // Meta
    System.out.println(deque); // [Nvidia, Google, Amazon, Meta] -> remain the same

    System.out.println(deque.pollFirst()); // Nvidia
    System.out.println(deque.pollLast()); // Meta
    System.out.println(deque); // [Google, Amazon]

    deque.offerLast("Google");
    deque.offerLast("Meta");
    deque.offerLast("Google");
    deque.offerLast("Meta");
    System.out.println(deque); // [Google, Amazon, Google, Meta, Google, Meta]
    System.out.println(deque.removeFirstOccurrence("Google")); // true
    System.out.println(deque); // [Amazon, Google, Meta, Google, Meta]
    System.out.println(deque.removeLastOccurrence("Google"));
    System.out.println(deque); // [Amazon, Google, Meta, Meta]
    System.out.println(deque.removeLastOccurrence("TSMC")); // false

    deque.push("TSMC");
    System.out.println(deque); // [TSMC, Amazon, Google, Meta, Meta]
  }
}
