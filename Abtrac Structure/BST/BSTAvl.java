package BST;

import java.util.ArrayList;

public class BSTAvl<E,K extends Comparable<? super K>> extends BST<E,K>  {
	
	

	private Node<E,K> root;
	private ArrayList<E> toArraylist;
	
	public BSTAvl() {
		root=null;
	}
	
	@Override
	public void add(E element, K key) {
		root = add(root,element, key);
		
	}
	
	private Node<E,K> add(Node<E,K> current,E element, K key)	{
		if(current==null)	{
			return new Node<E,K>(element,key);
		} 
		
		else if(key.compareTo(current.getKey())<0) {
			current.setLeft(add(current.getNodeLeft(),element,key));
		}
		
		else {
			current.setRight(add(current.getNodeRight(),element,key));
		}
		
		if(checkAVLBalance(current)==0) {
			return current;
		}
		
		else if(checkAVLBalance(current)==-1) {
			Node<E,K> R = current.getNodeRight();
			if((depth(R.getNodeLeft()) - (depth(R.getNodeRight())) == 1)){
				current = rotateLeft(current);
			}
			else if((depth(R.getNodeLeft()) - depth(R.getNodeRight()))==1 ){
				current.setRight(rotateRight(R)); 
				current = rotateLeft(current);
			}
			return current;
		}
		else if(checkAVLBalance(current)==1) {
			Node<E,K> L = current.getNodeLeft();
			
			if((depth(L.getNodeLeft()) - (depth(L.getNodeRight())) == 1)){
				current = rotateRight(current);
			}
			else if((depth(L.getNodeLeft()) - depth(L.getNodeRight()))==1 ){
				current.setLeft(rotateLeft(L));
				current = rotateRight(current);
			}
			return current;
		}
		
		return current;
	}
	
	@Override
	public void delete(K key) {
		root = delete(root,key);
	}
	
	private Node<E,K> delete(Node<E,K> node,K key) {
		if(node==null) {
		return null;
		} 
		
		if(node.getKey().equals(key)) {
			return deleteNode(node);
		} else if(key.compareTo(node.getKey())<0) {
			node.setLeft(delete(node.getNodeLeft(),key));
			return node;
		} 
			node.setRight(delete(node.getNodeRight(),key));
		
		if(checkAVLBalance(node)==0) {
			return node;
		}
		
		else if(checkAVLBalance(node)==-1) {
			Node<E,K> R = node.getNodeRight();
			if((depth(R.getNodeLeft()) - (depth(R.getNodeRight())) == 1)){
				node = rotateLeft(node);
			}
			else if((depth(R.getNodeLeft()) - depth(R.getNodeRight()))==1 ){
				node.setRight(rotateRight(R)); 
				node = rotateLeft(node);
			}
			return node;
		}
		else if(checkAVLBalance(node)==1) {
			Node<E,K> L = node.getNodeLeft();
			
			if((depth(L.getNodeLeft()) - (depth(L.getNodeRight())) == 1)){
				node = rotateRight(node);
			}
			else if((depth(L.getNodeLeft()) - depth(L.getNodeRight()))==1 ){
				node.setLeft(rotateLeft(L));
				node = rotateRight(node);
			}
			return node;
		}
		
		return node;
			
		
	}
	
	private	Node<E,K> deleteNode(Node<E,K> node) {
		if(node.getNodeRight()==null && node.getNodeLeft()==null) {
			return null;
		} else if(node.getNodeLeft()==null) {
			return node.getNodeRight();
		}else if(node.getNodeRight()==null) {
			return node.getNodeLeft();
		} else {
			node.setElement(findLeftmost(node.getNodeRight()));
			node.setRight(deleteLeftmost(node.getNodeRight()));
			return node;
		}
	}
	
	private Node<E,K> deleteLeftmost(Node<E,K> node){
		if(node.getNodeLeft() ==  null)
		{
			return node.getNodeRight();
		}
		else{
			node.setLeft(deleteLeftmost(node.getNodeLeft()));
			return node;
		}	
	}
	
	private E findLeftmost(Node<E,K> node)
	{
		if(node.getNodeLeft() == null)	{
			return node.getElement();
		} else	{
			return findLeftmost(node.getNodeLeft()); 
		}
		
	}
	
	private Node<E,K> rotateLeft(Node<E,K> node) {
		
		Node<E,K> pivot = node.getNodeRight();
		Node<E,K> rootLeft = node.getNodeLeft();
		Node<E,K> pivotLeft = pivot.getNodeLeft();
		Node<E,K> pivotRight = pivot.getNodeRight();
		
		node = new Node<E,K>(node.getElement(),node.getKey(),node.getBalance(),rootLeft,pivotLeft); 
		
		pivot = new Node<E,K>(pivot.getElement(),pivot.getKey(),pivot.getBalance(),node,pivotRight);
		
		return pivot;
	}
	
	private Node<E,K> rotateRight(Node<E,K> node) {
		
		Node<E,K> pivot = node.getNodeRight();
		Node<E,K> rootRigth = node.getNodeRight();
		Node<E,K> pivotLeft = pivot.getNodeLeft();
		Node<E,K> pivotRight = pivot.getNodeRight();
		
		node = new Node<E,K>(node.getElement(),node.getKey(),node.getBalance(),rootRigth,pivotRight); 
		
		pivot = new Node<E,K>(pivot.getElement(),pivot.getKey(),pivot.getBalance(),node,pivotLeft);
		
		return pivot;
	}
	
	public int checkAVLBalance() {
		return checkAVLBalance(root);
	}
	
	private int checkAVLBalance(Node<E,K> node){	
		if(depth(node.getNodeLeft())-depth(node.getNodeRight()) >= 2)
		{
			return 1;
		}
		
		else if((depth(node.getNodeRight())-depth(node.getNodeLeft()) >= 2 )) 
		{
			return -1;
		}
		else{
			return 0;
		}
	}
	
	
	public int depth(Node<E,K> current){
		if(current==null) return 0;	
		else
		{
			return Math.max(depth(current.getNodeLeft()),depth(current.getNodeRight())) + 1;  
		}
	}
	
	public ArrayList<E> toArrayList(){
		toArraylist = new ArrayList<E>();
		toArrayList(root);
		
		return toArraylist;
	}
	private void toArrayList(Node<E,K> node){
		if(node == null){
			return;
		}
		toArrayList(node.getNodeLeft());
		toArraylist.add(node.getElement());
		toArrayList(node.getNodeRight());
	}
}
