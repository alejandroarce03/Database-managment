package BST;

public class BST<E, K extends Comparable<? super K>> {

	private Node<E, K> root;

	public BST() {
		root=null;
	}

	public BST(Node<E, K> current) {
		root = current;
	}

	public BST(E element, K key) {
		root = new Node<E, K>(element, key);
	}

	public E search(K key) {
		if(root==null) {
		throw new NullPointerException();
		} else {
			if (root.getKey().equals(key)) {
				return root.getElement();
			} else {
				return searchRecursive(root, key);
			}
		}
	}

	private E searchRecursive(Node<E, K> current, K key) {

		if (key == current.getKey()) {
			return current.getElement();
		}
		if ((Integer) key < (Integer) current.getKey()) {
			return searchRecursive(current.getNodeLeft(), key);
		} else {
			return searchRecursive(current.getNodeRight(), key);
		}

	}

	/**
	 * Adds a new Node to the BTS using recursive insertion bases on his value.
	 * 
	 * <pre>
	 *  The value most not be repeated
	 * </pre>
	 * 
	 * @param value : Is the value of the node.
	 */
	public void add(E element, K key) {
		root = addNodeRecursive(root, element, key);
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

		return current;
	}



	/**
	 * Recursive Method for deleting a Node with no children of the BTS.
	 * 
	 * @param current : Current position in the tree.
	 * @param value   : Value of the Node which is going to be deleted.
	 * @return : Returns the Node as a null when is deleted o a system out print if
	 *         the node has children.
	 */
	public void delete(K key) {
		root = deleteRecursive(root, key);
	}
	
	private Node<E, K> deleteRecursive(Node<E, K> current, K key) {
		if (current == null) {
			return null;
		}
		if (key.compareTo(current.getKey())<0) {
			current.setLeft(deleteRecursive(current.getNodeLeft(), key));
		} 
		else if(key.compareTo(current.getKey())>0) {
		current.setRight(deleteRecursive(current.getNodeRight(), key));
		} else {
			if(current.getNodeLeft()==null && current.getNodeRight()==null) {
				current=null;
			}
			else if(current.getNodeLeft()==null) {
				return current.getNodeRight();
			}
			else if(current.getNodeRight()==null) {
				return current.getNodeLeft();
			}
			else {
				Node<E, K>  data = findRightmost(current);
				current.setElement(data.getElement());
				current.setRight(deleteRecursive(current.getNodeRight(), data.getKey()));
			}
			
		}
		
		return current;
	}
	
	private Node<E, K> findRightmost(Node<E, K> node) {
		if (node.getNodeLeft() == null) {
			return node;
		} else {
			return findRightmost(node.getNodeLeft());
		}

	}

	/**
	 * The in-order traversal consists of first visiting the left sub-tree, then the
	 * root node, and finally the right sub-tree.
	 * 
	 * @param node : Root of the tree.
	 * @return : the list of nodes in the tree in order.
	 */
	
	
	public void traverseInOrder() {
		traverseInOrder(root);
	}

	private void traverseInOrder(Node<E, K> node) {
		if (node != null) {
			traverseInOrder(node.getNodeLeft());
			System.out.println(node.getElement());
			traverseInOrder(node.getNodeRight());
		}
	}

	/**
	 * Pre-order traversal visits first the root node, then the left subtree, and
	 * finally the right subtree.
	 * 
	 * @param node : Root of the tree.
	 * @return : the list of nodes in the tree in pre-order.
	 */
	
	public void traversePreOrder() {
		 traversePreOrder(root);
	}
	private void traversePreOrder(Node<E, K> node) {
		if (node != null) {
			System.out.println(" " + node.getElement());
			traverseInOrder(node.getNodeLeft());
			traverseInOrder(node.getNodeRight());
		}
	}

	/**
	 * Post-order traversal visits the left subtree, the right subtree, and the root
	 * node at the end.
	 * 
	 * @param node : Root of the tree.
	 * @return : the list of nodes in the tree in Post-order.
	 */
	public void traversePostOrder() {
		traversePostOrder(root);
	}
	private void traversePostOrder(Node<E, K> node) {
		if (node != null) {
			traverseInOrder(node.getNodeLeft());
			traverseInOrder(node.getNodeRight());
			System.out.println(" " + node.getElement());
		}
	}


	public Node<E, K> getRoot() {
		return root;
	}

}
