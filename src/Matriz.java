/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * Algoritmos y estruras de datos
 * @author elisa
 * @version 2.0
 * @date 1-6-2021
 */


import java.util.Vector;

public class Matriz {

    //Se instancian los objetos de ciudad, distancia y rutas
    private Vector<String> ciudades;
    private int[][] distancia;
    private int[][] rutas;
    

    /** 
     * Constructor
     */
    public Matriz(){
    	
    	//Se crean los objetos
        ciudades = new Vector<String>(); 
        distancia = new int [90][90];
        rutas = new int [90][90];

        //Llenado de matrices
        for(int i=0;i<90;i++){
            for(int j=0;j<90;j++){
                if(i==j){
                    distancia[i][j]=0;
                }
                else{
                    distancia[i][j]=999999; //999999 equivale a infinito
                }

                rutas[i][j] = 999999;
                
            }
        }
    }
    /**
     * Obtiene el tamaño del vector de las ciudades para usarlo en el algoritmo de Floyd
     * @param void
     * @return int 
     */

    public int getCiudadesSize() { 
    	return ciudades.size();
    }
    
    /**
     * Obtiene la matriz de distancia para usarse en FLoyd
     * @param void
     * @return int[][]
     */
    
    public int[][] getDistancia(){
    	return distancia;
    }
    
    /**
     * Obtiene la matriz de las rutas para usarse en Floyd
     * @param void
     * @return int[][]
     */

    public int[][] getRutas(){
    	return rutas;
    }
    
    /** 
     * Genera la distancia entre ciudad 1 y ciudad 2
     * @param city1
     * @param city2
     * @return int
     */
    public int distancia(String city1, String city2){
        return distancia[ciudades.indexOf(city1)][ciudades.indexOf(city2)];
    }
    
    /** 
     * Muestra las ciudades por las que debe hacer su trayecoria
     * @param city1
     * @param city2
     * @return void
     */
    public void ciudadesEnTrayectoria(String city1, String city2) {
        //encontrar la posición del elemento en el vector
        int i = ciudades.indexOf(city1);
        int j = ciudades.indexOf(city2);        
        
        Vector<String> ruta = new Vector<String>(); //se crea otro vector con la nueva ruta
        ruta.add("---> "+ciudades.get(i));

        if (distancia[i][j] == 999999 || distancia[i][j] == 0){ //verificar que el camino existe
            System.out.println("No hay camino. Hay una interrupcion o el camino es muy largo.\n"); 
        }else{
            while (i != j)
            {
                i = rutas[i][j];
                ruta.add(ciudades.get(i)); // se ingresa el camino en la nueva ruta
            }

        }

        //muesta los resultados
        int n = ruta.size();
        System.out.print("Las ciudades por las que debe pasar son: \n ");
        for(int l = 0; l < n - 1; l++) //ciclo para recorrer el vector
        System.out.print(ruta.get(l) + " ---> ");
        System.out.print(ruta.get(n - 1) + "\n");
        
    }

    
    /** 
     * Se ingresan rutas y ciudades a la matriz
     * @param city1
     * @param city2
     * @param dist
     * @return void
     */
    public void add(String city1, String city2, String dist) {
        //verificar que las ciudades ya esten ingresadas
        if(!ciudades.contains(city1)){
            ciudades.add(city1);
        }
        if(!ciudades.contains(city2)){
            ciudades.add(city2);
        }

        //mira la posicion en que esta cada ciudad
        int i = ciudades.indexOf(city1);
        int j = ciudades.indexOf(city2);        
        distancia[i][j]= Integer.parseInt(dist);

        //se guarda el valor de la distancia
        if(dist == "999999"){
            rutas[i][j] = 999999;
        }else{
            rutas[i][j] = j;
        }
        
    }

    /** 
     * Muestra las matrices de ruta y istancia
     * @param void
     * @return void
     */
    public void show(){
        System.out.println("\n__________________________\n    RUTAS DISPONIBLES \n__________________________\n");
        for(int a=0;a<ciudades.size();a++){ //recorre el vector de las ciudades
            for(int b=0;b<ciudades.size();b++){
                System.out.print(""+rutas[a][b]+" "); //imprime las rutas
            }
            System.out.println("");
        }
        
        System.out.println("\n________________________________\n DISTANCIA ENTRE CIUDADES (km) \n________________________________\n");
        for(int a=0;a<ciudades.size();a++){										   
            for(int b=0;b<ciudades.size();b++){ //recorre el vector de ciudades
                System.out.print(""+distancia[a][b]+" "); //imprime las distancias
            }
            System.out.println("");
        }
    }
    

    
    /** 
     * Verifica si una ciudad existe
     * @param city1
     * @return boolean
     */
    public boolean contains(String city1){
        return ciudades.contains(city1);
    }

    
    /** 
     * Verifica si las dos ciudades existen
     * @param city1
     * @param city2
     * @return boolean
     */
    public boolean contains(String city1, String city2){
        boolean status = false;
        if(ciudades.contains(city1) && ciudades.contains(city2)){
            status = true;
        }
        return status;
    }

    
}


