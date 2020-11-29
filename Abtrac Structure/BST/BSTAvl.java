package BST;

import java.util.ArrayList;

public class BSTAvl<E, K extends Comparable<? super K>> extends BST<E, K> implements iBSTAVL<E,K>  {

	private Node<E, K> root;
	private ArrayList<E> toArraylist;

	public BSTAvl() {
		root = null;
	}
	public BSTAvl(Node<E, K> current) {
		root = current;
	}

	public BSTAvl(E element, K key) {
		root = new Node<E, K>(element, key);
	}

	@Override
	public void add(E element, K key) {	
			root= addNodeRecursive(root,element,key);
	}

	private Node<E, K> addNodeRecursive(Node<E, K> current, E element, K key) {
		if (current == null) {
			return new Node<E, K>(element, key);
		}

		if (key.compareTo(current.getKey()) < 0) {
			current.setLeft(addNodeRecursive(current.getNodeLeft(), element, key));
		}

		else {
			current.setRight(addNodeRecursive(current.getNodeRight(), element, key));
		}
	
		current.setHeight(max((height(current.getNodeLeft())), height(current.getNodeRight())) + 1);
		
		int balance = getBalance(current);
		
		if(balance > 1 && key.compareTo(current.getNodeLeft().getKey())<0) {
			return rotateRight(current);
		}
		if(balance < -1 && key.compareTo(current.getNodeRight().getKey())>0) { 
			return rotateLeft(current); 
		}
        if (balance > 1 && key.compareTo(current.getNodeLeft().getKey())>0) { 
            current.setLeft(rotateLeft(current.getNodeLeft())); 
            return rotateRight(current); 
        }  
        if (balance < -1 && key.compareTo(current.getNodeRight().getKey())<0) { 
            current.setRight(rotateRight(current.getNodeRight())); 
            return rotateLeft(current); 
        } 
		return current;
	}

	@Override
	public void delete(K key) {
		root = delete(root, key);
	}

	private Node<E, K> delete(Node<E, K> node, K key) {
		if (node == null) {
			return null;
		}

		if (node.getKey().equals(key)) {
			return deleteNode(node);
		} else if (key.compareTo(node.getKey()) < 0) {
			node.setLeft(delete(node.getNodeLeft(), key));
			return node;
		} else {
		node.setRight(delete(node.getNodeRight(), key));
		}
		
		node.setHeight(max((height(node.getNodeLeft())), height(node.getNodeRight())) + 1);
		
		int balance = getBalance(node);
		
		if(balance > 1 && key.compareTo(node.getNodeLeft().getKey())<0) {
			return rotateRight(node);
		}
		if(balance < -1 && key.compareTo(node.getNodeRight().getKey())>0) { 
			return rotateLeft(node); 
		}
        if (balance > 1 && key.compareTo(node.getNodeLeft().getKey())>0) { 
            node.setLeft(rotateLeft(node.getNodeLeft())); 
            return rotateRight(node); 
        }  
        if (balance < -1 && key.compareTo(node.getNodeRight().getKey())<0) { 
            node.setRight(rotateRight(node.getNodeRight())); 
            return rotateLeft(node); 
        } 	
        
        return node;
	}

	private Node<E, K> deleteNode(Node<E, K> node) {
		if (node.getNodeRight() == null && node.getNodeLeft() == null) {
			return null;
		} else if (node.getNodeLeft() == null) {
			return node.getNodeRight();
		} else if (node.getNodeRight() == null) {
			return node.getNodeLeft();
		} else {
			node.setElement(findLeftmost(node.getNodeRight()));
			node.setRight(deleteLeftmost(node.getNodeRight()));
			return node;
		}
	}

	private Node<E, K> deleteLeftmost(Node<E, K> node) {
		if (node.getNodeLeft() == null) {
			return node.getNodeRight();
		} else {
			node.setLeft(deleteLeftmost(node.getNodeLeft()));
			return node;
		}
	}

	private E findLeftmost(Node<E, K> node) {
		if (node.getNodeLeft() == null) {
			return node.getElement();
		} else {
			return findLeftmost(node.getNodeLeft());
		}

	}
	
	private Node<E,K> rotateRight(Node<E,K> y) {
		Node<E,K> x = y.getNodeLeft();
		Node<E,K> T2 = x.getNodeRight();
		
		x.setRight(y);
		y.setLeft(T2);
		
		y.setHeight(max((height(y.getNodeLeft())), height(y.getNodeRight())) + 1);
		x.setHeight(max((height(x.getNodeLeft())), height(x.getNodeRight())) + 1);
		
		
		return x;
	}
	
	private Node<E,K> rotateLeft(Node<E,K> x) {
		Node<E,K> y = x.getNodeRight();
		Node<E,K> T2 = y.getNodeLeft();
		
		y.setLeft(x);
		x.setRight(T2);
		
		
		y.setHeight(max((height(y.getNodeLeft())), height(y.getNodeRight())) + 1);
		x.setHeight(max((height(x.getNodeLeft())), height(x.getNodeRight())) + 1);
		
		
		return y;
	}
	
	@Override
	public int getBalance(Node<E,K> current) {
		if(current==null) {
			return 0;
		}
		
		return height(current.getNodeLeft())-height(current.getNodeRight());
	}
	
	public int height(Node<E,K> current) {
		if(current==null) {
			return 0;
		} 
		return current.getHeight();
	}
	
	public int max(int a, int b) {
		return (a>b)?a:b;
	}
	public ArrayList<E> toArrayList() {
		toArraylist = new ArrayList<E>();
		toArrayList(root);

		return toArraylist;
	}

	private void toArrayList(Node<E, K> node) {
		if (node == null) {
			return;
		}
		toArrayList(node.getNodeLeft());
		toArraylist.add(node.getElement());
		toArrayList(node.getNodeRight());
	}
	
	public static void main(String[] args) {

			BSTAvl<String,Integer> hardcore;
			hardcore = new BSTAvl<String, Integer>("Carlos",12);
			hardcore.add("Test", 1);
			hardcore.add("Test", 2);
			hardcore.add("Test", 3);
			hardcore.add("Test", 4);
			hardcore.add("Test", 5);
			hardcore.add("Test", 6);
			
			System.out.println(hardcore.getRoot().getElement());
			hardcore.traverseInOrder();
			hardcore.traversePostOrder();

		
	}

}
