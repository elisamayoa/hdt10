/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * Algoritmos y estruras de datos
 * @author elisa
 * @version 2.0
 * @date 1-6-2021
 */

import java.util.*;
import java.util.Arrays;


import java.io.*;

public class Lectura {
	
	/**
	 * Lee el archivo e ingresa las ciudades y rutas del archivo a la matiz
	 * @param path1
	 * @param graph
	 * @return void
	 */
	
	public Lectura (String path1, Matriz graph){ 
	        try{
            FileReader lec; //define variables para lectura de archivo
            BufferedReader buff;
            String datos;
            ArrayList<String> linea = new ArrayList<String>(); 
            
            	// lee el archivo
                lec = new FileReader(path1);
                buff = new BufferedReader(lec);
                //lee una linea del archivo 
                datos= buff.readLine();
                System.out.println(datos);
                //verifica que tenga contenido
                while (datos!=null){
                   //separa por espacios
                   String partes[] = datos.split(" ");                 
                   graph.add(partes[0], partes[1], partes[2]); 
            
                   datos= buff.readLine(); //lee siguiente linea del archivo
                   
                }
                buff.close(); 
        }
        catch( IOException | NumberFormatException e){ //manejo de excepciones 

        }
        
    }
	


    
}