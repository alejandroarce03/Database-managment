package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BST.BST;

class BSTTest {
	BST<String,Integer> b;
	
	void setUpEmptyBST() {
		b = new BST<String,Integer>();
	}
	
	void setUpBST() {
		b = new BST<String,Integer>();
		b.add("Carlos", 12);
		b.add("Daniel", 9);
		b.add("Andrea", 11);
		b.add("Andrew", 13);
		b.add("Antoni", 7);
		b.add("Ante", 14);
		
	}
	
	@Test
	void testSearch1() {
		setUpBST();
		
		assertTrue(b.search(14).equals("Ante"));
	}
	@Test
	void testSearch2() {
		setUpBST();
		
		assertTrue(b.search(7).equals("Antoni"));
	}
	

	@Test
	void testAdd1() {
		setUpBST();
		
		b.add("Sujeto de prueba", 19);
		
		assertTrue(b.search(19).equals("Sujeto de prueba"));
	}
	
	@Test
	void testAdd2() {
		setUpEmptyBST();
		
		b.add("Sujeto de prueba", 19);
		
		assertTrue(b.search(19).equals("Sujeto de prueba"));
	}
	
	@Test
	void testAdd3() {
		setUpBST();
		
		
		b.add("Problema", 12);
		b.add("Sujeto de prueba", 19);
		b.add("Sujeto de choque", 19);
		
		assertTrue(b.search(19).equals("Sujeto de prueba"));
	}
	@Test
	void testDelete1() {
		setUpBST();
		
		b.delete(12);
		
		assertFalse(b.search(12).equals("Carlos"));
	}
	
	@Test
	void testDelete2() {
		setUpEmptyBST();
		
		b.add("Problema", 12);
		b.add("Sujeto de prueba", 19);
		b.add("Sujeto de choque", 19);
		b.delete(12);
		
		assertFalse(b.search(19).equals("Sujeto de choque"));
	}

}
