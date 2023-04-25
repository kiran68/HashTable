package com.bridgelabz.hashtable;

import java.util.Hashtable;

public class HashTable {
	public static void main (String [] args) {
        HashMapTableImp<String,Integer> hashImpl = new HashMapTableImp<>();
		String massage = "Paranoids are not paranod because they are paranoid but" + 
		                 "because they keep putting themeselves deliberately init paranoid available situtation";
		
		//Split the words when a white space comes up.
		//Convert all the words in lowercase
		String[] messageArray = massage.toLowerCase().split(" ");
		
		for (String word:messageArray) {
			//Search for the word in the linked list
			
			Integer value = hashImpl.get(word);
			//If not Found,Frequency of the word StayWith 1 
			
			if (value == null)
			value = 1;
			
			else 
				//If found, frequency of the word increases by 1
				value = value + 1;
			hashImpl.add(word,value);
			
		}
		System.out.println(hashImpl);
	}
}

