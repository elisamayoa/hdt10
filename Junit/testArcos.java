import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testArcos {
	
	private Matriz matriz;//podría ser grafo también
	private AlgoritmoDeFloyd floyd; 
	
	public void escenario() {
		matriz = new Matriz();
		floyd = new AlgoritmoDeFloyd();
	}
	
	public void Add() {
		escenario();
		matriz.add("Amatitlan","Villa-Nueva", "7"); //Se agregan tres ciudades y tres distancias diferentes
		matriz.add("Villa-Nueva", "Guatemala", "10");
		matriz.add("Palin", "Malacatan", "500");
		floyd.Floyd(matriz); //se organiza la matriz y busca la ruta mas rapida con Floyd
		
		
	}
	
	

	@Test
	void testInterrupion() {
		escenario();
		Add();
		if(matriz.contains("Palin", "Malacatan")){
	        matriz.add("Palin", "Malacatan", "999999");
	        assertEquals(999999, matriz.distancia("Palin", "Malacatan"));
		
		}
		
	}
	@Test
	void testNuevaConexion() {
		Add();
		matriz.add("Villa-Nueva", "Guatemala", "10");
		assertTrue(matriz.contains("Villa-Nueva", "Guatemala")==true);
	}
	
	

}

