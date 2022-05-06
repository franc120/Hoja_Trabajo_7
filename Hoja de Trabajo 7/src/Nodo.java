import java.util.ArrayList;
import java.util.HashMap;

public class Nodo {
	
	 private String llave; 

	    private Association<String,ArrayList<HashMap<String,String>>> valor;

	    private Nodo nodoIzqrd;
	    private Nodo nodoDerch;

	    public Nodo(String key, Association<String,ArrayList<HashMap<String,String>>> value){
	        this.llave = key;
	        this.valor = value;
	        this.nodoIzqrd = null;
	        this.nodoDerch = null;
	    }

	    public Association<String,ArrayList<HashMap<String,String>>> getValor(){
	        return this.valor;
	    }

	    public String getLlave(){
	        return this.llave;
	    }

	    public Nodo getNodoIzquierda(){
	        return this.nodoIzqrd;
	    }

	    public Nodo getNodoDerecha(){
	        return this.nodoDerch;
	    }

	    public void setNodoIzquierda(Nodo n){
	        this.nodoIzqrd = n;
	    }

	    public void setNodoDerecha(Nodo n){
	        this.nodoDerch = n;
	    }

}
