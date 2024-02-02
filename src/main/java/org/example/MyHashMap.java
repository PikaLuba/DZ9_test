package org.example;

import java.util.Objects;
import java.util.List;

public class MyHashMap<K,V> {

    /* однозв'язної Node.

Не може зберігати дві ноди з однаковими ключами.
    put(Object key, Object value) додає пару ключ + значення
remove(Object key) видаляє пару за ключем
clear() очищає колекцію
size() повертає розмір колекції
get(Object key) повертає значення (Object value) за ключем
     */

    private Node1<K,V>[] hashTable;
    private int size1 = 0;
    private float threshold;

    public MyHashMap() {
        hashTable = new Node1[16];
        threshold = hashTable.length + 0.75f;
    }

    public boolean put(K key, V value) {
        if (size1 + 1 >= threshold) {
            threshold *= 2;
            arrayDubling();
        }
        Node1<K,V> newNode = new Node1<>(key, value);
        int index = hash(key);

        if (hashTable[index] == null) {
            return simpleAdd(index, newNode);
        }

        List <Node1<K,V>> nodeList = hashTable[index].getNodes();
        for (Node1<K,V> node1 : nodeList) {
            if (keyExistButValueNew(node1,newNode,value) ||
                collisionProcessing(node1,newNode,nodeList)
            ) {
                return  true;
            }
        }
        return false;
    }

    private void arrayDubling() {
        Node1<K,V>[] oldHashTable = hashTable;
        hashTable = new Node1[oldHashTable.length * 2];
        size1 = 0;
        for (Node1<K,V> node1 : oldHashTable) {
            if (node1 == null) {
                for (Node1<K,V> n : node1.getNodes()) {
                    put(n.getKey(), n.getValue());
                }
            }
        }
    }

    private  boolean simpleAdd(int index, Node1<K,V> newNode) {
        hashTable[index] = new Node1<>(null,null);
        hashTable[index].getNodes().add(newNode);
        size1++;
        return true;
    }

    private boolean keyExistButValueNew (Node1<K,V> nodeFromList,
                                        Node1<K,V> newNode,
                                        V value) {
       if (newNode.getKey().equals(nodeFromList.getKey()) &&
       !newNode.getValue().equals(nodeFromList.getValue())) {
           nodeFromList .setValue(value);
           return  true;
       }
       return false;
    }

    private boolean collisionProcessing (Node1<K,V> nodeFromList,
                                         Node1<K,V> newNode,
                                         List<Node1<K, V>> nodes) {
        if (newNode.hashCode() == nodeFromList.hashCode() &&
         !Objects.equals(newNode.getKey(), nodeFromList.getKey()) &&
         !Objects.equals(newNode.getValue(), nodeFromList.getValue()) ) {
            nodes.add(newNode);
            size1++;
            return true;
        }
        return false;
    }

    public boolean remove(K key) {
        int index = hash(key);
        if (hashTable[index] == null) {
            return false;
        }
        if (hashTable[index].getNodes().size() == 1) {
                    hashTable[index] = null;
        size1--;
        return true;
        }
        List<Node1<K, V>> nodeList = hashTable[index].getNodes();
        for (Node1<K,V> node1: nodeList) {
            if (key.equals(node1.getKey())) {
                nodeList.remove(index);
                size1--;
                return true;
            }
        }
        return false;
    }

    public V get (K key) {
        int index = hash(key);
        if (index < hashTable.length &&
        hashTable[index] != null) {
            List<Node1<K, V>> nodeList = hashTable[index].getNodes();
            for (Node1<K,V> node1 : nodeList) {
                if (key.equals(node1.getKey()) ) {
                    return node1.getValue();
                }
            }
        }
        return null;
    }

    public int size() {
        return size1;
    }

    public void clear() {
        Node1<K,V>[] oldHashTable = hashTable;
        hashTable = new Node1[16];
        size1 = 0;
    }


    private int hash(K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashTable.length;
    }


}

