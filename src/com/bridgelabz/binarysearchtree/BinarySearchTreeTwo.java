package com.bridgelabz.binarysearchtree;

public class BinarySearchTreeTwo {
	 Node root;

	    public BinarySearchTreeTwo() {
	        root = null;
	    }

	    // Adding the new Nodes to Tree
	    public void insert(int data) {
	        Node newNode = new Node(data);

	        if(root == null) {
	            root = newNode;
	            return;
	        }
	        else {
	            Node current = root;
	            Node parent = null;
	            while(true) {
	                parent = current;
	                if(data < current.data) {
	                    current = current.left;
	                    if(current == null) {
	                        parent.left = newNode;
	                        return;
	                    }
	                }
	                else {
	                    current = current.right;
	                    if(current == null) {
	                        parent.right = newNode;
	                        return;
	                    }
	                }
	            }
	        }
	    }

	    // Print the All Nodes in Tree
	    public void inorderTraversal(Node node) {
	        if(root == null)
	            System.out.println("Tree is empty");
	        else {
	            if(node.left != null)
	                inorderTraversal(node.left);
	            System.out.print(node.data + " ");
	            if(node.right != null)
	                inorderTraversal(node.right);
	        }
	    }

	    // Calculate the Size For checking all nodes are added or Not
	    public int size(Node node) {
	        if (node == null)
	            return 0;
	        else
	            return(size(node.left) + 1 + size(node.right));
	    }

	    public static void main(String[] args) {
	        BinarySearchTreeTwo binary = new BinarySearchTreeTwo();

	        binary.insert(12);
	        binary.insert(36);
	        binary.insert(70);
	        binary.insert(22);
	        binary.insert(40);
	        binary.insert(5);
	        binary.insert(3);
	        binary.insert(16);
	        binary.insert(60);
	        binary.insert(95);
	        binary.insert(98);
	        binary.insert(63);
	        binary.insert(67);

	        binary.inorderTraversal(binary.root);
	        int value = binary.size(binary.root);
	        if(value == 13)
	            System.out.println("\nAll the Elements are added Sucessfully");
	        else
	            System.out.println("\nSome Elements are Missing");
	    }
	    public class Node {
	        int data;
	        Node left;
	        Node right;

	        public Node(int data) {
	            this.data = data;
	            this.left = null;
	            this.right = null;
	        }
	    }
	}


