package com.bridgelabz.binarysearchtree;

public class BinarySearchOne {
	  Node root;

	    public BinarySearchOne() {
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
	                if(data < current.data) {   // 30 < 56
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

	    public static void main(String[] args) {
	        BinarySearchOne binary = new BinarySearchOne();

	        binary.insert(56);
	        binary.insert(30);
	        binary.insert(70);

	        binary.inorderTraversal(binary.root);
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

