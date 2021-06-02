/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * Algoritmos y estruras de datos
 * @author elisa
 * @version 2.0
 * @date 1-6-2021
 */


import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {
	
	/**
	 * El metodo principal del programa para mantener interaccion con usuario
	 * @param args
	 * @throws IOException
	 */
	
	public static void main (String[] args) throws IOException {   
		
		//mensaje de bienvenida a usuarios
		System.out.print("\n-------------------------------------------------------------------------------------"+
				 "\n                            BIENVENIDO A GUATEGRAFO.GT                  "+
				 "\n-------------------------------------------------------------------------------------"+
				 "\n\nA continuación, cargue el archivo para leer las rutas y ciudades a analizar...");
		//se instancian los objetos	 
        AlgoritmoDeFloyd floyd = new AlgoritmoDeFloyd();
        Scanner teclado = new Scanner(System.in);
        JFileChooser file = new JFileChooser();
        Matriz graph = new Matriz();
        
        //solicita el archivo a cargar
        int r1 = file.showOpenDialog(null); //abre ventana para leer archivos
        if (r1 == JFileChooser.APPROVE_OPTION) {
        	File archivo1 = file.getSelectedFile();
        	String path1 = archivo1.getAbsolutePath(); //obtiene la ruta
        	JOptionPane.showMessageDialog(null, "Archivo: " + path1 + " abierto exitosamente!");

            //Se lee el archivo
            new Lectura(path1, graph);
    		System.out.print("Las ciudades se agregaron correctamente!");
    		floyd.Floyd(graph); //se utiliza Floyd para organizar la matriz
    		
        }


        
        boolean keep = true;
        while (keep == true){ //imprime menu principal
        	System.out.print("\n---------------------------------------"+
            				 "\n	          MENU PRINCIPAL           "+ 
            				 "\n---------------------------------------"+
            			"\n 1. Buscar ruta mas corta entre dos ciudades"+
                        "\n 2. Modificar el grafo"+
                        "\n 3. Mostrar grafo"+
                        "\n 4. Salir"+
                        "\n----------------------------------------\n");
        	
        	int op1 = getNumero(); //opcion para el menu principal
  
	        switch(op1){ 
	            case 1: 
	            	//se ingresa ciudad de partida
	                System.out.println("\nCiudad de partida: ");
	                String city1 = teclado.next(); 
	                
	                //se ingresa ciudad de salida
	                System.out.println("\nCiudad de destino: ");
	                String city2= teclado.next();
	            
	                if(graph.contains(city1,city2)){ //condicion si las ciudades sí fueron ingresadas
	
	                    //muestra la distancia entre ciuades
	                    System.out.println("\n\nLa ruta más corta entre "+ city1 +" y "+ city2 +" es: " + graph.distancia(city1, city2)+".");
	
	                    //muestra la trayectoria para las ciudades
	                    graph.ciudadesEnTrayectoria(city1, city2);
	                    
	               
	                }else{ //pero si no existen o no fueron ingresadas las ciudades..
	                    System.out.println("\nERROR. No se han encontrado las ciudades..."); //imprime mensaje
	                }
	            	break;
	            case 2: 
	            	
	                System.out.println("\n-------------------------"+ //imprime segundo menu para modificar grafo
	                					"\n     MODIFICAR GRAFO "+
	                				    "\n-----------------------"+
	                					"\n1. Interrupción de tráfico entre ciudades \n 2. Nueva conexión\n");
	                int op2 = getNumero();
	
	                
	                switch (op2) {
	                	case 1: 
		                   
		                    System.out.println("\n Ciudad de partida: "); //ingresa la ciudad de partida
		                    String city11 = teclado.next();
		                    System.out.println("\n Ciudad de destino: "); //ingresa la ciudad de destino
		                    String city22 = teclado.next();
		
		                    
		                    if(graph.contains(city11,city22)){
		                        graph.add(city11, city22, "999999"); //se ingresa infinito en el luga de la distancia
		                        System.out.println("¡La interrupción se realizó exitosamente!");
		                    
		                    }else{ //pero si no existe la ciudad
		                        System.out.println("ERROR. No se han encontrado las ciudades ingresadas..."); //imprime mensaje de error
		                    }
		                break;
		              
	                	case 2: //para agregar otras conexiones
		                
		                    System.out.println("\n Ciudad de partida: "); //se ingresa la ciudad de partida
		                    String city111 = teclado.next();
		                    System.out.println("\n Ciudad de destino: "); //se ingresa la ciudad de destino
		                    String city222= teclado.next();
		                    System.out.println("\n Distancia entre ciudades: "); //se ingresa la distancia
		                    String distancia = teclado.next();
		
		                    //se ingresa las ciudades y distancia al grafo
		                    graph.add(city111, city222, distancia);
		                    System.out.println("¡La conexión se hizo correctamente!"); //mensaje de exito
		                    floyd.Floyd(graph);
		                    
		                break;
	                }
	            
	            	break;
	            case 3:
	            	graph.show(); // muestra las dos matrices, una de rutas y otra de distancia
	            	break;
	            	
	            case 4:
	            	System.out.print("\n Gracias por usar GUATEGRAFO.GT"); //mensaje de finalización
	                System.exit(0); //salir del programa
	                break;
	            default:
	            	System.out.print("\n Debe ingresar una respuesta correcta"); //en caso de no ingresar una respuesta entre el 1 al 4
	            	break;
	        }
        }
    }
    


/**
 * Recibe numeros por scanner de los usuarios y los valida
 * @return int 
 */
	public static int getNumero(){
	      //Objetos 
	  Scanner teclado = new Scanner(System.in);
	  String entrada="";
	      
	      //Variables locales
	  int num = 0;
	  boolean ok = true;
	      
	  do{
	      System.out.print(" Ingrese un número: ");
	      entrada = teclado.nextLine();
	          
	          //Intentar convertir el String a int
	      try{
	          num = Integer.parseInt(entrada);
	          ok = true;
	      }
	      catch(Exception e){
	              //Si no se pudo convertir
	          System.out.println("ERROR \n"+ entrada + " no es un número esperado. Intente de nuevo.");
	          ok = false;
	      }
	  } while (!ok); //Mientras no este OK
	      
	  return num;
	}
}



	


