package Trees;

import java.util.ArrayList;

class Node {
	int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}

public class BinaryTree {
	
	ArrayList<Integer> orderedList =  new ArrayList<>();
	Node root;
	int iterations;
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		Integer[] numbers = { 10, 5, 12, 3, 1, 13, 7, 2, 4, 14, 9, 8, 6, 11};
		for(int number: numbers) 
			bt.insert(number);
		Node root = bt.buildList(bt.root);
		bt.search(root, 9);
		System.out.println("number of iterations = " + bt.iterations);
		inorderTraversal(root);
	}
	
	public boolean search(int val){
        return search(root, val);
    }
	
    private boolean search(Node r, int val) {
    	iterations++;
        boolean found = false;
        while ((r != null) && !found)
        {
            int rval = r.value;
            if (val < rval)
                r = r.left;
            else if (val > rval)
                r = r.right;
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    
    Node buildList(Node node) {
    	
    	if (node != null) {
    		buildList(node.left);
    		orderedList.add(node.value);
    		buildList(node.right);
    	}
    	
    	Integer[] arr = orderedList.toArray(new Integer[0]);
    	return buildBST(arr, 0, orderedList.size()-1);
    }
    
    private Node buildBST(Integer[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        Node root = new Node(nums[mid]);
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }
    
    static void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.value + " ");
            inorderTraversal(node.right);
        }
    }
	
	void insert(int data) {
        root = insertNode(root, data);
    }

    Node insertNode(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }
        if (data < node.value) {
            node.left = insertNode(node.left, data);
        } else if (data > node.value) {
            node.right = insertNode(node.right, data);
        }
        return node;
    }
}


