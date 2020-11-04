package BST;

public class Node<T,K extends Comparable<? super K>> {
	
	private T element;
	private K key;
	private int balance;
	private Node<T,K> nodeLeft;
	private Node<T,K> nodeRight;
	
	

	public Node(T element,K key) {
		this.element=element;
		this.key=key;
		nodeLeft=null;
		nodeRight=null;
		balance=0;
	}
	
	
	public Node(T element, K key, int balance, Node<T, K> nodeLeft, Node<T, K> nodeRight) {
		super();
		this.element = element;
		this.key = key;
		this.balance = balance;
		this.nodeLeft = nodeLeft;
		this.nodeRight = nodeRight;
	}


	public void setKey(K key) {
		this.key = key;
	}
	public K getKey() {
		return key;
	}
	
	public void setLeft(Node<T, K> nodeLeft) {
		this.nodeLeft = nodeLeft;
	}
	
	public Node<T, K> getNodeLeft() {
		return nodeLeft;
	}
	
	public Node<T, K> getNodeRight() {
		return nodeRight;
	}
	
	public void setRight(Node<T, K> nodeRight) {
		this.nodeRight = nodeRight;
	}
	
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
