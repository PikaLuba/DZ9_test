package org.example;

public class Main {
    public static void main(String[] args) {
// MyArrayList
        /*
        add(Object value) додає елемент в кінець
        size() повертає розмір колекції
        get(int index) повертає елемент за індексом
        remove(int index) видаляє елемент із вказаним індексом
        clear() очищає колекцію
        */
        System.out.println("--------------- MyArrayList");
        MyArrayList<String> list = new MyArrayList<>();

        list.add("Igor");
        list.add("Oleg");
        list.add("Irena");
        System.out.print("list = " + list+ "   ");
        System.out.print("list.size() = " + list.size()+ "   ");
        System.out.println("list.get(1) = " + list.get(1));

        System.out.print("list.remove(1) = " + list.remove(1) + "   ");
        System.out.println("list = " + list);

        list.clear();
        System.out.println("list.clear() " + list);
        System.out.println(" ");

// MyLinkedList
        /*
        add(Object value) додає елемент в кінець
        size() повертає розмір колекції
        get(int index) повертає елемент за індексом
        remove(int index) видаляє елемент із вказаним індексом
        clear() очищає колекцію
         */
        System.out.println("--------------- MyLinkedList");
        MyLinkedList<String> list1 = new MyLinkedList<>();
        list1.clear();
        list1.add("Alfa");
        list1.add("Beta");
        list1.add("Gamma");

        System.out.println("list1.size() = " + list1.size() + "   ");

        for (int i = 0; i < list1.size(); i++) {
            System.out.println("list1 = " + list1.get(i));
        }

        System.out.println("---------");
        System.out.println("list1.remove(1) = " + list1.remove(1));

        System.out.println("list1.size() = " + list1.size() + "   ");
         for (int i = 0; i < list1.size(); i++) {
             System.out.println("list1 = " + list1.get(i));
         }

        System.out.println("-----------");
        list1.clear();
        System.out.println("list1.size() = " + list1.size());
        System.out.println(" ");

// MyQueue
       /* FIFO (first-in-first-out).
                Можна робити за допомогою Node або використати масив.

        add(Object value) додає елемент в кінець
        clear() очищає колекцію
        size() повертає розмір колекції
        peek() повертає перший елемент з черги
        poll() повертає перший елемент з черги і видаляє його з колекції, повертає null
        */

        System.out.println("--------------- MyQueue");
        MyQueue<String> queue = new MyQueue<>();
        queue.clear();
        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue.peek() = " + queue.peek());

        queue.add("Igor");
        queue.add("Oleg");
        queue.add("Irena");

        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.pool() = " + queue.poll());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println(" ");

        // MyStack
/*
Написати свій клас MyStack як аналог класу Stack, який працює за принципом LIFO (last-in-first-out).

Можна робити за допомогою Node або використати масив.

Методи

push(Object value) додає елемент в кінець
remove(int index) видаляє елемент за індексом
clear() очищає колекцію
size() повертає розмір колекції
peek() повертає перший елемент стеку
pop() повертає перший елемент стеку та видаляє його з колекції
 */
        System.out.println("--------------- MyStack");
        MyStack<String> stack = new MyStack<>();
        stack.clear();
        System.out.println("stack.size() = " + stack.size());

        stack.push("Igor");
        System.out.println("stack.peek() = " + stack.peek());
        stack.push("Oleg");
        System.out.println("stack.peek() = " + stack.peek());
        stack.push("Irena");

        System.out.println("stack.size() = " + stack.size());
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack.remove() = " + stack.remove(0));
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println(" ");

        // MyHashMap
         /* однозв'язної Node.

Не може зберігати дві ноди з однаковими ключами.
put(Object key, Object value) додає пару ключ + значення
remove(Object key) видаляє пару за ключем
clear() очищає колекцію
size() повертає розмір колекції
get(Object key) повертає значення (Object value) за ключем
     */
        System.out.println("--------------- MyHashMap");
        MyHashMap<String, String> str = new MyHashMap<>();
        str.put("1","bcd");
        str.put("2","345");
        str.put("5","222");
        str.put("3","lkj");
        System.out.println(str.get("1"));
        System.out.println(str.get("2"));
        System.out.println(str.size());
        str.remove("1");
        System.out.println(str.size());
        str.clear();
        System.out.println(str.size());
        System.out.println(str.get("2"));
    }


}