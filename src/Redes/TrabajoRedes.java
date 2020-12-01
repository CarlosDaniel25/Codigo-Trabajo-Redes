/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Redes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author madac
 */
public class TrabajoRedes
        
{
    
 int calc(int nodos,int distancia[],boolean flag[])
 {
  
  int vertice=0;
  int minimo=9999;
  
  for(int i=0;i<nodos;i++)
  {  
      if(flag[i]==false && distancia[i]<=minimo)
      {
          minimo=distancia[i];
          vertice=i;
      } 
  }
 return vertice;
 }
 public void calculo_grafico(int matriz[][],int origen,int nodos)
 {
     int distancia[]=new int[nodos];
     boolean flag[]=new boolean[nodos];
     for (int i = 0; i < nodos; i++) 
     {
      distancia[i]=9999;
      flag[i]=false;
     }
     distancia[origen]=0;
     System.out.println("Distancia a todos los vertices desde el vertice: "+origen);
     for (int i = 0; i < nodos-1; i++) 
     {
         int u=calc(nodos,distancia,flag);
         flag[u]=true;
         for (int k = 0; k <nodos; k++) 
         {
             if (!flag[k]&& matriz[u][k]!=0 && distancia[u]!=9999 && distancia[u]+matriz[u][k]<distancia[k])
             {
                 distancia[k]=distancia[u]+matriz[u][k];
             } 
             
         }
         System.out.println("Recorrido num: "+(i+1));
         imprimir(distancia,nodos,origen);
         
     }
     
 }
 void imprimir(int distancia[],int nodos,int origen)
 {   
     System.out.println("Hacia el Vertice\t\t Distancia desde el Nodo "+origen);
     for (int i = 0; i < nodos; i++) 
     {
         if (i==origen) 
         {
             System.out.print("") ;  
         }
         else
         {System.out.println(i+" \t\t                 "+distancia[i]);}
         
         
     }
 }
  
        
    
    public static void main(String[] args) throws FileNotFoundException 
    { long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
    TInicio = System.currentTimeMillis();
        
  int nodos,origen;
  Scanner in = new Scanner(System.in);
  File escenario = new File("C:\\Users\\madac\\OneDrive\\Documentos\\EscenarioMedio.txt");
  
        Scanner scan = new Scanner(escenario);
        String espacio = scan.nextLine();
        nodos = Integer.parseInt(espacio);
        espacio = scan.nextLine();
        int cant_aristas = Integer.parseInt(espacio);
        espacio = scan.nextLine();
        origen = Integer.parseInt(espacio);     
        int grafico[][] = new int [nodos][nodos];
        for(int i=1;i<cant_aristas;i++)
        {   int nodo_origen=scan.nextInt();
            int distancia= scan.nextInt();
            int destino = scan.nextInt();
            
            
            grafico[nodo_origen][destino]=distancia;
        }
  
            TrabajoRedes Disjkstra = new TrabajoRedes();
    
            Disjkstra.calculo_grafico(grafico, origen, nodos);
 TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
  tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
  System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
  
  
        
  
 } 
}
