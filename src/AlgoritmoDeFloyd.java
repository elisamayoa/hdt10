/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * Algoritmos y estruras de datos
 * @author elisa
 * @version 2.0
 * @date 1-6-2021
 */





public class AlgoritmoDeFloyd {
	public void Floyd (Matriz graph){
		int size= graph.getCiudadesSize();
		int distancia[][] = graph.getDistancia();
		int rutas[][] = graph.getRutas();
		
        for (int k = 0; k<size; k++)
        {
            //recorre las filas i
            for (int i = 0; i<size; i++)
            {
                //recorre las columnas j
                for (int j = 0; j<size; j++)
                {
                    //verifica que no sea infinito
                    if (distancia[i][k] == 999999|| distancia[k][j] == 999999)
                        continue;
                    
                    //algoritmo de floyd
                    if (distancia[i][k] + distancia[k][j] < distancia[i][j]){
                        //se cambia la distancia en la matriz de distancia
                        distancia[i][j] = distancia[i][k] + distancia[k][j];
                        //se cambia las rutas
                        rutas[i][j] = rutas[i][k];
                    }
                        
                }
            }
        }
    }
}