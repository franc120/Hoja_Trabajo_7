import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class BynaryTreeTest {
	 @Test
	    void buscar() {

	        ArrayList<Association> lista = new ArrayList();
	        lista.add(new Association<String, String>("house", "casa"));

	        BinaryTree<Association> instancia = new BinaryTree<Association>(lista.get(0));
	        String palabra = "house";
	        String expected = "casa";
	        String result = instancia.buscar(palabra);
	        assertEquals(expected, result);
	    }

	    @Test
	    void agregar() {

	        ArrayList<Association> lista = new ArrayList();
	        lista.add(new Association<String, String>("house", "casa"));
	        lista.add(new Association<String, String>("dog", "perro"));

	        BinaryTree<Association> btActual = new BinaryTree<Association>(lista.get(0));

	        BinaryTree<Association> btSiguiente = new BinaryTree<Association>();
	        for (int n = 0; n < lista.size(); n++) {
	            if ((n+1) < lista.size()) {
	                btSiguiente = new BinaryTree<>(lista.get(n+1));
	                BinaryTree.agregar(btActual, btSiguiente);
	            }
	        }

	        boolean expected = true;
	        boolean result = btActual.agregar(btActual, btSiguiente);
	        assertEquals(expected, result);
	    }
	

}
