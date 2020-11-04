package BST;
import java.util.LinkedList;
import java.util.Queue;


public class BST<E,K extends Comparable<? super K>>{

	private Node<E,K> root;
	
	
	public BST() {		
	}
	
	public BST(Node<E,K> current) {
		root=current;
	}
	
	public BST(E element, K key) {
		root = new Node<E,K>(element,key);
	}
	
	
	public E search(K key) {
		if(root.getKey().equals(key)) {
			return root.getElement();
		} else {
			return searchRecursive(root,key);
		}
			
	}
	
	private E searchRecursive(Node<E,K> current,K key) {
	
	    if (key == current.getKey()) {
	    	return current.getElement();
	    } 
	    if ((Integer)key < (Integer)current.getKey()) {
	        return searchRecursive(current.getNodeLeft(),key);
	    }else {
	    	return searchRecursive(current.getNodeRight(),key);
	    }
		
	}
	/**
	 *  Adds a new Node to the BTS using recursive insertion  bases on his value.
	 *  <pre> The value most not be repeated </pre>
	 * @param value : Is the value of the node.
	 */
	public void add(E element, K key) {
		root=addNodeRecursive(root,element, key);
	}
	
	
	
	/** This method is the recursive part of the method "AddNode".
	 * @param current : The current node in which we are in the tree.
	 * @param value : The value of the node that is going to be added.
	 * @return : The recursive return.
	 */
	private Node<E,K> addNodeRecursive(Node<E,K> current,E element,K key) {	
		
		if(current==null) {
		return new Node<E,K> (element,key);
		} 
		
		if(key.compareTo(current.getKey())<0) {
			current.setLeft(addNodeRecursive(current.getNodeLeft(),element,key));
		}
		
		else {
			current.setRight(addNodeRecursive(current.getNodeRight(),element,key));
		} 
	
		return current;
	}
	public void delete(K key) {
			root = deleteRecursive(root, key);
	}
	/** Recursive Method for deleting a Node with no children of the BTS.
	 * @param current : Current position in the tree.
	 * @param value : Value of the Node which is going to be deleted.
	 * @return : Returns the Node as a null when is deleted o a system out print if the node has children.
	 */
	private Node<E,K> deleteRecursive(Node<E,K> current,K key) {
		if (current == null) {
	        return null;
	    }
	    if (key == current.getKey()) {
	    	if(current.getNodeLeft()==null && current.getNodeRight()==null) {
	    		current=null;
	    	} 
	    } 
	    if ((Integer)key < (Integer)current.getKey()) {
	        current.setLeft(deleteRecursive(current.getNodeLeft(), key));
	        return current;
	    }
	    current.setRight(deleteRecursive(current.getNodeRight(), key));
	    return current;
		
	}
	
	/** The in-order traversal consists of first visiting the left sub-tree, then the root node, 
	 * and finally the right sub-tree.
	 * @param node : Root of the tree.
	 * @return : the list of nodes in the tree in  order.
	 */
	public String traverseInOrder(Node<E,K> node) {
		String report="";
	    if (node != null) {
	        traverseInOrder(node.getNodeLeft());
	        report +=" " + node.getElement();
	        traverseInOrder(node.getNodeRight());
	    }
	    
	    return report;
	}
	
	/** Pre-order traversal visits first the root node, then the left subtree, and finally the right subtree.
	 * @param node : Root of the tree.
	 * @return : the list of nodes in the tree in pre-order.
	 */
	public String traversePreOrder(Node<E,K> node) {
		String report="";
	    if (node != null) {
	    	report +=" " + node.getElement();
	        traverseInOrder(node.getNodeLeft());
	        traverseInOrder(node.getNodeRight());
	    }  
	    return report;
	}
	
	/** Post-order traversal visits the left subtree, the right subtree, and the root node at the end.
	 * @param node : Root of the tree.
	 * @return : the list of nodes in the tree in Post-order.
	 */
	public String traversePostOrder(Node<E,K> node) {
		String report="";
	    if (node != null) {
	        traverseInOrder(node.getNodeLeft());
	        traverseInOrder(node.getNodeRight());
	        report +=" " + node.getElement();
	    }
	    
	    return report;
	}
	
	/** Breadth-First Search : visits all the levels of the tree starting from the root, and from left to right.
	 * @return : A list of the nodes in order for levels.
	 */
	public String traverseLevelOrder() {
		String report="";
	    if (root == null) {
	        return "";
	    }
	 
	    Queue<Node<E,K>> nodes = new LinkedList<>();
	    nodes.add(root);
	 
	    while (!nodes.isEmpty()) {
	 
	    	Node<E,K> node = nodes.remove();
	 
	        report += " " + node.getElement();
	 
	        if (node.getNodeLeft() != null) {
	            nodes.add(node.getNodeLeft());
	        }
	 
	        if (node.getNodeRight() != null) {
	            nodes.add(node.getNodeRight());
	        }
	    }
	    return report;
	}
	
	public Node<E,K> getRoot() {
		return root;
	}


}

