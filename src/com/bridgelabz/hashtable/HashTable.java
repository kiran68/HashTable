package com.bridgelabz.hashtable;

//Node class for linked list
class MyMapNode {
 String key;
 int value;
 MyMapNode next;

 public MyMapNode(String key, int value) {
     this.key = key;
     this.value = value;
     next = null;
 }
}

//Hash table class using linked list
class MyHashMap {
 private int size; // initial size of the hash table
 private MyMapNode[] bucket; // array of buckets

 public MyHashMap() {
     size = 10;
     bucket = new MyMapNode[size];
 }

 // Hash function to get the index of the bucket for a given key
 private int getHash(String key) {
     return Math.abs(key.hashCode()) % size;
 }

 // Function to add a key-value pair to the hash table
 public void put(String key, int value) {
     int index = getHash(key);
     MyMapNode newNode = new MyMapNode(key, value);
     if (bucket[index] == null) {
         bucket[index] = newNode;
     } else {
         MyMapNode curr = bucket[index];
         while (curr.next != null) {
             if (curr.key.equals(key)) { // if key already exists, update the value
                 curr.value = value;
                 return;
             }
             curr = curr.next;
         }
         curr.next = newNode;
     }
 }

 // Function to get the value associated with a given key in the hash table
 public Integer get(String key) {
     int index = getHash(key);
     if (bucket[index] != null) {
         MyMapNode curr = bucket[index];
         while (curr != null) {
             if (curr.key.equals(key)) {
                 return curr.value;
             }
             curr = curr.next;
         }
     }
     return null;
 }

 // Function to find the frequency of a word in a sentence
 public int findFrequency(String sentence, String word) {
     String[] words = sentence.split(" ");
     int wordCount = 0;
     for (String w : words) {
         if (w.equals(word)) {
             wordCount++;
         }
     }
     return wordCount;
 }
}

public class  HashTable {
 public static void main(String[] args) {
     // Create a hash table
     MyHashMap hashMap = new MyHashMap();

     // Add key-value pairs to the hash table
     hashMap.put("To", 1);
     hashMap.put("be", 2);
     hashMap.put("or", 3);
     hashMap.put("not", 4);

     // Find frequency of words in a sentence
     String sentence = "To be or not to be";
     String[] words = sentence.split(" ");
     for (String word : words) {
         int frequency = hashMap.findFrequency(sentence, word);
         System.out.println("The frequency of '" + word + "' in the sentence is: " + frequency);
     }
 }
}

