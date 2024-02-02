package org.example;

import java.util.LinkedList;
import java.util.Objects;
import java.util.List;

public class Node1<K,V> {

    private int hash;
    private K key;//ключ
    private V value;//значение
    private List <Node1<K,V>> nodes;

    public List<Node1<K, V>> getNodes() {
        return nodes;
    }

    public Node1(K key, V value) {
        this.value = value;
        this.key = key;
        nodes = new LinkedList<Node1<K, V>>();
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
            if (o instanceof Node1) {
                Node1<K,V> node1 = (Node1) o;
                return (Objects.equals(key, node1.getKey()) &&
                        Objects.equals(value, node1.getValue()) ||
                        Objects.equals(hash, node1.hashCode()));
            }
            return false;
    }

    @Override
    public int hashCode() {
        hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash;
    }


}
