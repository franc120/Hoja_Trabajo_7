import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

/******************************************

 * Clase Main, funcionamiento del programa
 * se encarga de leer los archivos y hacer
 * las asosiaciones entre las palabras
 * para luego poder crear el arbol 
 * y asi poder tener el diccionario.
******************************************/

public class Main {

	public static void main(String[] args) {
		BinaryTree arbol = new BinaryTree();

        //creando instancias
        Scanner scanner = new Scanner(System.in);

        //realizando listas para tener los diccionarios
        //son 6 para poder tener todas las combinaciones de traduccion posibles
        ArrayList<Association> listaIE = new ArrayList();
        ArrayList<Association> listaIF = new ArrayList();

        ArrayList<Association> listaEI = new ArrayList();
        ArrayList<Association> listaEF = new ArrayList();

        ArrayList<Association> listaFI = new ArrayList();
        ArrayList<Association> listaFE = new ArrayList();

        //arraylist tendra opciones de idiomas
        ArrayList<String> opciones = new ArrayList<>();

        //leer el archivo
        ArrayList<String> archivo = new ArrayList<>();

        Association<String, ArrayList<HashMap<String, String>>> diccionario = null;

        //try catch para encontrar el archivo que contiene las palabras
        try {
            Stream<String> lines = Files.lines(
                    Paths.get("diccionario.txt"),
                    StandardCharsets.UTF_8
            );
            lines.forEach(archivo::add);

        } catch (IOException e ){
            System.out.println("No se ha encontrado el archivo!");
        }

        //haciendo un foreach para crear un arraylist con los 3 idiomas
        for (String linea : archivo) {

            ArrayList<String> traduc = new ArrayList();

            //foreach para poder separar las palabras por las comas y agregarlas a la lista
            for (String palabra : linea.split(",")) {
                traduc.add(palabra);
            }

            /**
             * crean muchas listas para tener todas las combinaciones de idiomas 
             * y asi agregar las palabras correspondientes a la lista correspondiente. 
             */
 //creando diccionarios de ingles
            listaIE.add(new Association<String, String>(traduc.get(0).toLowerCase(), traduc.get(1).toLowerCase()));
            listaIF.add(new Association<String, String>(traduc.get(0).toLowerCase(), traduc.get(2).toLowerCase()));

            //creando diccionarios de espanol
            listaEI.add(new Association<String, String>(traduc.get(1).toLowerCase(), traduc.get(0).toLowerCase()));
            listaEF.add(new Association<String, String>(traduc.get(1).toLowerCase(), traduc.get(2).toLowerCase()));

             //creando diccionarios de espanol
             listaFI.add(new Association<String, String>(traduc.get(2).toLowerCase(), traduc.get(0).toLowerCase()));
             listaFE.add(new Association<String, String>(traduc.get(2).toLowerCase(), traduc.get(1).toLowerCase()));


            //creando una llave para los hashmaps
            String key = traduc.get(0);
            //arraylist de mapas para poder meter los 3 mapas, 1 por cada idioma
            ArrayList<HashMap<String, String>> losMapas = new ArrayList<>();

            //creando los mapas de 3 idiomas y agregando las palabras
            HashMap<String, String> ingles = new HashMap<>();
            ingles.put("Ingles", traduc.get(0));
            HashMap<String, String> espanol = new HashMap<>();
            espanol.put("Español", traduc.get(1));
            HashMap<String, String> frances = new HashMap<>(); 
            frances.put("Frances", traduc.get(2));

            //agregando los mapas a la arraylist de mapas
            losMapas.add(ingles);
            losMapas.add(espanol);
            losMapas.add(frances);

            //creando una nuevo asociacion
            diccionario = new Association<>(key, losMapas);

            //inertando el nodo al arbol
            arbol.insertarNodo(key, diccionario);

        }
            //agregando las opciones al arraylist
          opciones.add("Ingles");
          opciones.add("Español");
          opciones.add("Frances");
  
          //pidiendo al usuario que ingrese el idioma que quiere traducir
          System.out.println("\nQue idioma es el que desea traducir?");
  
          //imprimiendo las tres opciones
          for(int i=0;i<opciones.size();i++){
              int op = i+1;
              System.out.println(op + " " + opciones.get(i));
          }
  
          //creando la variable del primer idioma
          int idioma1;
  
          //try catch para asegurar que se ingrese una opcion correcta entre 1 y 3
          while(true){
              try{
                  System.out.print("Opcion: ");
                  idioma1 = scanner.nextInt();
                  // por si el usuario elige un número menor a uno o mayor a tres, seguirá pidiendo la opción. 
                  if(idioma1 > 3 || idioma1 < 1){
                      System.out.println("Opcion incorrecta, intenta de nuevo..");
                  }
                  //Si el usuario ingresa los datos correctos terminará el ciclo while
                  else{break;}
              }
              //Si el usuario comete un error. 
              catch(Exception o){
                  scanner.nextLine();
                  System.out.println("Caracter invalido! Intenta de nuevo..");
              }
          }  
          //if para ver que idioma sacar de la lista
          String idiom1 = "";
          if(idioma1==1) {
              idiom1 = "Ingles";
              opciones.remove(0);
          } 
          else if(idioma1==2) {
              idiom1 = "Español";
              opciones.remove(1);
          } 
          else if(idioma1==3) {
              idiom1 = "Frances";
              opciones.remove(2);
          }
          
  
          //ver que idioma se va a traducir
          System.out.println("\nA que idioma quiere traducir su texto?");
  
          //imprimiendo las opciones restantes
          for(int i=0;i<opciones.size();i++){
              int op = i+1;
              System.out.println(op + " " + opciones.get(i));
          }
  
            //creando la variable del primer idioma
            int idioma2;

//creando un try catch para asegurar que se ingrese una opcion correcta entre 1 y 3
            while(true){
                try{
                    System.out.print("Opcion: ");
                    idioma2 = scanner.nextInt();
                    //por si el usuario elige un número menor a uno o mayor a dos, seguirá pidiendo la opción. 
                    if(idioma2 > 2 || idioma2 < 1){
                        System.out.println("Opcion incorrecta, intenta de nuevo..");
                    }
                    //Si el usuario ingresa los datos correctos terminará el ciclo while
                    else{break;}
                }
                //Si el usuario comete un error. Si el usuario ingresa una letra regresará un mensaje de error. 
                catch(Exception o){
                    scanner.nextLine();
                    System.out.println("Caracter invalido! Intenta de nuevo..");
                }
            }  

       //if para ver que idioma escogió
        //se hacen todas las combinaciones para ver a que idioma quiere traducir el texto
        String idiom2 = "";
        if(opciones.contains("Ingles") && opciones.contains("Español") && idioma2==1){idiom2="Ingles";}
        if(opciones.contains("Ingles") && opciones.contains("Frances") && idioma2==1){idiom2="Ingles";}
        if(opciones.contains("Ingles") && opciones.contains("Español") && idioma2==2){idiom2="Español";}
        if(opciones.contains("Ingles") && opciones.contains("Frances") && idioma2==2){idiom2="Frances";}
        if(opciones.contains("Español") && opciones.contains("Frances") && idioma2==1){idiom2="Español";}
        if(opciones.contains("Español") && opciones.contains("Frances") && idioma2==2){idiom2="Frances";}

        //realizando ista vacia para cambiar el valor dependiendo de que traduccion se quiera
        ArrayList<Association> queLista = new ArrayList<>();

        //viendo cual es la traduccion final para poder ver que lista se utilizara 
        if(idiom1.equals("Ingles") && idiom2.equals("Español")) {
            queLista = listaIE;
        } else if(idiom1.equals("Ingles") && idiom2.equals("Frances")) {
            queLista = listaIF;
        }  else if(idiom1.equals("Español") && idiom2.equals("Ingles")) {
            queLista = listaEI;
        } else if(idiom1.equals("Español") && idiom2.equals("Frances")) {
            queLista = listaEF;
        } else if(idiom1.equals("Frances") && idiom2.equals("Ingles")) {
            queLista = listaFI;
        } else if(idiom1.equals("Frances") && idiom2.equals("Español")) {
            queLista = listaFE;
        } 

       System.out.println(queLista.get(0));
        //instanciar el arbol con el diccionario y la lista que sean necesarios
        BinaryTree<Association> elDiccionario = new BinaryTree<Association>(queLista.get(0));

        //for para agregar el diccionario al arbol
        for (int n = 0; n < queLista.size(); n++) {
            if ((n+1) < queLista.size()) {
                BinaryTree<Association> btSiguiente = new BinaryTree<>(queLista.get(n+1));
                BinaryTree.agregar(elDiccionario, btSiguiente);
            }
        }

        //agregando arbol en orden
        elDiccionario.inOrder(elDiccionario);
        System.out.println("\n------Diccionario In Order------");
        //System.out.println(elDiccionario.inOrder(elDiccionario));
        Nodo nodoRaiz = arbol.getRaiz();
        String inOrderFinal2 = "(";

        //while para obtener todos los elementos en orden
        while(nodoRaiz.getNodoIzquierda() != null){
            ArrayList<HashMap<String, String>> temp = nodoRaiz.getValor().getValue();
            String inOrderFinal = "(";
            // inOrderFinal += ((Object) temp.get(0)).getValue((Object)"Ingles");
            for(int i = 0; i < temp.size(); i++) {
               inOrderFinal += temp.get(i).toString().replace("{","").replace("}","") + " ";
            }
            inOrderFinal += ")";
            if(nodoRaiz.getNodoIzquierda().getNodoIzquierda() == null){
               
                Nodo temporal = nodoRaiz.getNodoIzquierda();
                ArrayList temp2 = temporal.getValor().getValue();
                String t = temp2.toString().replace("{","(").replace("}",")").replace("[","").replace("]","").replace(",","").replace(")","").replace("(","");
                System.out.println("("+t + " )");
                // inOrderFinal += ((Object) temp.get(0)).getValue((Object)"Ingles");
                for(int i = 0; i < temp2.size(); i++) {
                    inOrderFinal2 += temp.get(i).toString().replace("{","").replace("}","").replace("[","").replace("]","") + " ";
                }
            }
            nodoRaiz = nodoRaiz.getNodoIzquierda();
            //imrpimiendo el inorder
            System.out.println(inOrderFinal);
        }
        //System.out.println(inOrderFinal2);

         //Leyendo el archivo e imprimiendo el texto ingresado 
         System.out.println();
         System.out.println("------Texto ingresado------");
         archivo = new ArrayList<>();

         //haciendo try catch para asegurar que si se encuentre el archivo
         try {
             Stream<String> lines = Files.lines(
                     Paths.get("texto.txt"),
                     StandardCharsets.UTF_8
             );
             lines.forEach(archivo::add);
 } catch (IOException e ){
             System.out.println("No se ha podido leer el archivo");
         }

         //traduciendo
         String traduccion = "";
        for (String linea : archivo) {
            //quitandole los puntos a la oracion
            System.out.println(linea);
            String lineaClean = linea.replaceAll("\\.","");

            for (String palabra : lineaClean.trim().split("\\s+")) {

                //if asegurar que sí este la palabra
                //para asegurar que no se le agreguen asteriscos.
                if (elDiccionario.buscar(palabra) == null) {
                    traduccion += "*"+palabra+"* ";
                } else {
                    //haciendo la traduccion y agregando un espacio
                    traduccion += elDiccionario.buscar(palabra) + " ";
                }
            }
            traduccion += ".\n";
        }

        //imprimir el resultado final
        System.out.println("\n------Traduccion Final------");
        System.out.println(traduccion+"\n");
        scanner.close(); //cerrando el scanner

    }

    	

	}

}
