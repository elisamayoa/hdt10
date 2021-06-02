import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testAlgoritmoDeFloyd {
	
	private Matriz matriz;//podría ser grafo también
	private AlgoritmoDeFloyd floyd; 
	
	public void escenario() {
		matriz = new Matriz();
		floyd = new AlgoritmoDeFloyd();
	}
	
	public void Add() {
		escenario();
		matriz.add("Amatitlan","Villa-Nueva", "7"); //Se agregan tres ciudades y tres distancias diferentes
		matriz.add("Amatitlan","Guatemala", "25");
		matriz.add("Villa-Nueva", "Guatemala", "10");
		floyd.Floyd(matriz); //se organiza la matriz y busca la ruta mas rapida con Floyd
		
	}

	@Test
	void testFloyd() {
		escenario();
		Add();
		assertEquals(17, matriz.distancia("Amatitlan", "Guatemala")); //debe buscar la ruta más rapida entre Amati y Guate
		
	}
	
}