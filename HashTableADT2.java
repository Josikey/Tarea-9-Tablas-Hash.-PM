
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ilike
 */
public class HashTableADT2 {
    //Constructor 
    String []arreglo;
    int tamanio, contador;
    public HashTableADT2(int tam){
        tamanio=tam;
        arreglo= new String [tam];
        Arrays.fill(arreglo, "-1");
        
    }
    
    //add (key , value)  🡪   Agrega una nueva entrada a la tabla.
    public void add(String [] ramArreglo, String [] arreglo){
        int i;
        for (i = 0; i < ramArreglo.length; i++) {
            String elemento=ramArreglo[i];
            int indiceArreglo=Integer.parseInt(elemento)%8;
            //En dodne dice int indiceArreglo es la hash table de tamaño el cual puede ser modificado
            System.out.println("El indice es " + indiceArreglo
                    + " Para el Elemento " + elemento);
            //Tratando las condiciones 
            
            while(arreglo[indiceArreglo]!="-1"){
                indiceArreglo++;
                System.out.println("HAY COLISIÓN en el indice " +
                        (indiceArreglo-1) + " Cambiar al inidice " + indiceArreglo);
                
                indiceArreglo%=tamanio;
            }
            
            arreglo[indiceArreglo]=elemento;
            
        }
        
    }
          
    /*
    En la parte de mostar
    Para mostrar todos los valores de tabla se tiene que declarar la cantidad de slots 
    Por ejemplo:
    Table tamaño   Slots
          7           8
          11          12
          303         304
    */
    
    public void mostrar(){
        int incremento=0,i,j;
        for (i = 0; i < 1; i++) {
           incremento += 9;
            for ( j = 0; j < 71; j++) {
                System.out.print("-");  
            }
            System.out.println();
            for ( j = incremento -9; j < incremento; j++) {
                System.out.format("| %3s " + " " , j); 
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++) {
                System.out.print("-");  
            }
            
            System.out.println();
            
            for ( j = incremento -9; j < incremento; j++) {
                if (arreglo[j].equals("-1")) {
                    System.out.print("|      ");
                }else{
                    System.out.print(String.format("| %3s " + " ", arreglo[j]));
                }
            }
            System.out.println("|");
            for ( j = 0; j < 71; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
    
    //valueOf ( key)  🡪   Regresa el valor asociado a una llave.
     public String valueOf(String elemento){
         int indiceArreglo=Integer.parseInt(elemento)%8;
         int cont=0;
         while(arreglo[indiceArreglo]!="-1"){
             if(arreglo[indiceArreglo]==elemento){
                 System.out.println("El elemento " + elemento + " Esta en el indice " + indiceArreglo);
                 
                 return arreglo [indiceArreglo];
             }
             indiceArreglo++;
             indiceArreglo%=tamanio;
             contador++;
             if (contador > 7) {
                break; 
             }
         }
         return null;
     } 
    
    public static void main(String[] args) {
        HashTableADT2 hash = new HashTableADT2(9);
        //En esta parte se puede agregar o eliminar el valor asociado a la llave
          String[] elementos={"20","33",
                              "21","10",
                              "12","14",
                              "56","100", "89"};
          hash.add(elementos, hash.arreglo);
          hash.mostrar();
          //Ingresar el valor a buscar
          String buscado=hash.valueOf("89");
          if (buscado==null) {
              System.out.println("El elememto no se encuentra"  );
        }
                  
    }
}
