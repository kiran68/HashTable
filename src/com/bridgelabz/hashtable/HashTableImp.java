package com.bridgelabz.hashtable;

import java.util.ArrayList;

class HashMapTableImp<K, V> {
    HashNode head;
    HashNode tail;
    private final int numOfBuckets;
    ArrayList<HashNode<K,V>> myBucketArray;

    public HashMapTableImp() {
        this.numOfBuckets = 20;    //20 is assigned a little more than the numbers of total words
        this.myBucketArray = new ArrayList<>();
        for (int i = 0; i < numOfBuckets; i++)
            this.myBucketArray.add(null);
    }

    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        HashNode<K,V> myNode= this.myBucketArray.get(index);
        if(myNode == null) {
            myNode = new HashNode<>(key , value);
            this.myBucketArray.set(index, myNode);
        }
        myNode = (HashNode<K, V>) searchNode(key);
        if(myNode == null) {
            myNode = new HashNode<>(key , value);
            this.append(myNode);
        }
        else {
            myNode.setValue(value);
        }
    }

    //Append the value in the hashtable
    public void append(HashNode myNode) {
        if(this.head == null)
            this.head = myNode;
        if(this.tail == null)
            this.tail = myNode;
        else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    //Searching for the word in the hashtable
    public HashNode<K, V> searchNode(K data) {
        HashNode currentNode = head;
        int position = 0;
        while (currentNode != null) {
            position++;
            if (currentNode.getKey().equals(data)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    //Searching for the word and get the value from the hashtable
    public V get(K word) {
        int index = this.getBucketIndex(word);
        if(this.myBucketArray.get(index) == null)
            return null;
        HashNode<K, V> myMapNode = searchNode(word);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    //hashcode to find the index
    private int getBucketIndex(K word) {
        int hashCode = Math.abs(word.hashCode());
        System.out.println(hashCode);
        int index = hashCode % numOfBuckets;
        System.out.println(index);
        return index;
    }

    //Remove "avoidable" from hashtable
    public void remove(K word) {
        HashNode currentNode = head;
        HashNode previousNode = null;
        while (currentNode != null && currentNode.getKey().equals(word)) {
            head = currentNode.getNext();
            return;
        }
        while (currentNode != null && !(currentNode.getKey().equals(word))) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (currentNode != null) {
            previousNode.next = currentNode.next;
        }
        if(currentNode == null)
            System.out.println("Word not found!");
    }

    //Print the hashtable
    @Override
    public String toString() {
        return "MyLinkedListNodes{" + head + "}";
    }
}
