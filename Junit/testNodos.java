import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testNodos {
	
	private Matriz matriz;//podría ser grafo también
	
	public void escenario() {
		matriz = new Matriz();
	}
	
	public void Add() {
		escenario();
		matriz.add("Amatitlan","Villa-Nueva", "7"); //se agregan dos ciudades y una distancia
		
	}	

	@Test
	void testAddedContains1() {
		escenario();
		Add();		
		assertTrue(matriz.contains("Amatitlan")==true); //se evalua la existencia de 1 ciudad
		
	}
	
	@Test
	void testAddedContains2() {
		escenario();
		Add();
		assertTrue(matriz.contains("Amatitlan", "Villa-Nueva")==true); //se evalua con dos ciudades
	}
	
	@Test
	void testNotAddedNotContains() {
		escenario();
		Add();
		assertTrue(matriz.contains("Guatemala")==false); //se prueba con una ciudad que no fue ingresada
	}
	
}
