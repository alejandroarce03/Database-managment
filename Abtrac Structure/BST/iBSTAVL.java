package BST;

public interface iBSTAVL<E,K extends Comparable<? super K>> {
	
	
	/** This method will help us know the actual balance of the node in the AVL search tree for maintaining that search time
	 * @return
	 */
	int getBalance(Node<E,K> node);
	
	
	/** The same add method but now this method has to balance the tree each time a new node is added to the tree
	 * @param elment : Element that is going to be inserted
	 * @param key : Key of the element which is going to be inserted 
	 */
	void add(E elment,K key);
	
	/** The same delete method of and BST but now this method has to balance the tree each time a new node is deleted of the tree
	 * @param key : Key of the element which is going to be deleted
	 */
	void delete(K key);
	
	


	
}
