package com.bridgelabz.hashtable;

import java.util.Hashtable;

public class HashTable {

    public static void main(String[] args) {
        HashMapTableImp<String, Integer> hashImpl = new HashMapTableImp<>();
        String message = "Paranoids are not paranoid because they are paranoid but " +
                "because they keep putting themselves deliberately into paranoid avoidable situations";

        //Split the words when a white space comes up.
        //Convert all the words in lowercase
        String[] messageArray = message.toLowerCase().split(" ");

        for(String word: messageArray) {
            //Search for the word in the hashtable
            Integer value =  hashImpl.get(word);
            //If not found, frequency of the word StayWith 1
            if( value == null)
                value = 1;
            else
                //If found, frequency of the word increases by 1
                value = value + 1;
            hashImpl.add(word , value);
            System.out.println("Value = "+value);
        }
        System.out.println(hashImpl);

        //Remove "avoidable" from the hashtable
        hashImpl.remove("avoidable");

        //Display the hashtable
        System.out.println(hashImpl);
    }
}

