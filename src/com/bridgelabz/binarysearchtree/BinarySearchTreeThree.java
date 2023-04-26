package com.bridgelabz.binarysearchtree;

public class BinarySearchTreeThree {
	   Node root;
	    static boolean flag = false;

	    public BinarySearchTreeThree() {
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

	    // Search the Node With keyValue 63
	    public void searchNode(Node node, int value) {
	        if(root == null)
	            System.out.println("Tree is empty");
	        else {
	            if(node.data == value) {
	                flag = true;
	                return;
	            }
	            if(flag == false && node.left != null){
	                searchNode(node.left, value);
	            }
	            if(flag == false && node.right != null){
	                searchNode(node.right, value);
	            }
	        }
	    }

	    public static void main(String[] args) {
	        BinarySearchTreeThree binary = new BinarySearchTreeThree();

	        binary.insert(56);
	        binary.insert(30);
	        binary.insert(70);
	        binary.insert(22);
	        binary.insert(40);
	        binary.insert(11);
	        binary.insert(3);
	        binary.insert(16);
	        binary.insert(60);
	        binary.insert(95);
	        binary.insert(65);
	        binary.insert(63);
	        binary.insert(67);

	        System.out.println("Inorder Traversal of Binary Search tree");
	        binary.inorderTraversal(binary.root);

	        binary.searchNode(binary.root, 63);

	        if(flag)
	            System.out.println("\nElement 63 is present in the binary tree");
	        else
	            System.out.println("\nElement 63 is not present in the binary tree");
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

