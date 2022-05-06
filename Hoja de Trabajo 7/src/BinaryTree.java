import java.lang.Math;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Esta clase implementa un solo nodo de un árbol binario.  Es un
 * estructura recursiva.  Las relaciones entre nodos son 
 * doblemente vinculados, con referencias de padres e hijos.  Muchas características
 * de los árboles pueden detectarse con métodos estátic.
 */

public class BinaryTree 
{
	 /**
     * El valor asociado a este nodo
     */
    protected E val; // value associated with node
    /**
     * El primer elemento del nodo
     */
    protected BinaryTree<E> parent; // parent of node
    /**
     * El hijo izquierdo de este nodo, o un nodo "vacío"
     */
    protected BinaryTree<E> left, right; // children of node



    /**
     * one-time constructor, para hacer arboles vacios
     * Las eficiencias del espacio son posibles si se reutilizan los árboles vacíos.
     *
     * @post Constructor que genere nodo vacio
     * @retornar nodo vacio
     */
    private Nodo raiz;

    public BinaryTree(){

        raiz = null;

    }

    /**
     * Construye un nodo de árbol sin hijos.  Valor del nodo
     * y los subárboles son proporcionados por el usuario
     *
     * @post Devuelve un valor de referencia de árbol y dos subárboles vacíos
     * @param Devuelve un valor de referencia de árbol y dos subárboles vacíos
     */
    public BinaryTree(E value)
    {
        //Assert.pre(value != null, "Tree values must be non-null.");
        val = value;
        right = left = new BinaryTree<E>();
        setLeft(left);
        setRight(right);
    }

    /**
     * Constructs a tree node with two children.  Value of the node
     * and subtrees are provided by the user.
     *
     * @post  Devuelve un valor de referencia de árbol y dos subárboles
     * @param valor A (posiblemente nulo) al que se hará referencia por nodo
     * @param izquierda El subárbol a la izquierda subárbol del nodo
     * @param derecha El subárbol para ser el subárbol derecho del nodo
     */
    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right)
    {
        //Assert.pre(value != null, "Tree values must be non-null.");
        val = value;
        if (left == null) { left = new BinaryTree<E>(); }
        setLeft(left);
        if (right == null) { right = new BinaryTree<E>(); }
        setRight(right);
    }

    /**
     * Get subarbol izquierdo del nodo
     *
     * @post Retorna referencia de (posible este vacio) sub arbol izquierdo
     *
     * @retorna El sub arbol izquierdo de este nodo
     */
    public BinaryTree<E> left()
    {
        return left;
    }

    /**
     * Get subarbol derecho del nodo
     *
     * @post Retorna referencia de (posible este vacio) sub arbol derecho
     * 
     * @retorna The right subtree of this node
     */
    public BinaryTree<E> right()
    {
        return right;
    }

    /**
     *@pre recibe un arbol binario
     * @post Retorna arbol(posible que este vacio) referencia para subarbol
     * 
     * @param bt es tipo Arbol Binario
     * @retorna el arbol tipo string ya ordenado
     */
    public String inOrder(BinaryTree bt) {
        String arbol = "";
        if (bt.val != null) {
            arbol += inOrder(bt.left);
            arbol += bt.value();
            arbol += inOrder(bt.right);
        }
        return arbol;
    }

     /**
     *@pre recibe String
     * @post Retorna null
     * 
     * @param palabra es la palabra a traducir
     * @retorna null
     */
    public String buscar(String palabraNueva) {
        palabraNueva = palabraNueva.toLowerCase();

        if (this.val == null) {
            return null;
        } else if (((Association) this.val).theKey.toString().equals(palabraNueva)) {
            return (String) ((Association) this.val).theValue;
        } else if (((Association) this.val).theKey.toString().compareTo(palabraNueva) > 0) {
            return this.left.buscar(palabraNueva);
        } else if (((Association) this.val).theKey.toString().compareTo(palabraNueva) < 0) {
            return this.right.buscar((palabraNueva));
        }
        return null;

    }

    /**
     * Get referencia de padres a este nodo
     *
     * @post Retorna referencia o retorna null
     * 
     * @retorna referencia del padres
     */
    public BinaryTree<E> parent()
    {
        return parent;
    }
    
    /**
     * Actualiza el subarbol del nodo.  padres del subarbol izquierdo
     * actualización es consistente.  El subárbol existente está separado
     *
     * @post Sets subarbol izquierda a nuevo izquierda
     *       re-parents newLeft if not null
     * 
     * @param nueva rama izquierda del nuevo subarbol izquierdo
     */
    public void setLeft(BinaryTree<E> newLeft)
    {
        if (isEmpty()) return;
        if (left != null && left.parent() == this) left.setParent(null);
        left = newLeft;
        left.setParent(this);
    }

    /**
     * actualize el nodo derecho del subarbol. padre del subarbolderecho
     * es actualizado constantemente.El subárbol existente está separado
     *
     * @post Sets subarbol izquierdo para el  nuevoDerecho
     *       re-padres newDerecho no esta lleno
     * 
     * @param nuevo derecha A referencia de nuevo subarbol del nodo derecho
     */
    public void setRight(BinaryTree<E> newRight)
    {
        if (isEmpty()) return;
        if (right != null && right.parent() == this) right.setParent(null);
        right = newRight;
        right.setParent(this);
    }


    /**
     * actualize el nodo padre
     *
     * @param Nuevo padre A referencia de padre A de este nodo.
     */
    protected void setParent(BinaryTree<E> newParent)
    {
        if (!isEmpty()) {
            parent = newParent;
        }
    }

    /**
     * Retorna numeros descendientes del nodo
     *
     * @post Retorna el ancho del arbol
     * @retorna Ancho del subarbol
     */
    public int size()
    {
        if (isEmpty()) return 0;
        return left().size() + right().size() + 1;
    }

    /**
     * Retorna la referencia del arbol obtenido x
     *
     * @post Retorna la rama del arbol del nodo x
     * @retorna la rama del arbol.
     */
    public BinaryTree<E> root()
    {
        if (parent() == null) return this;
        else return parent().root();
    }

   
    
    /**
     * Retorna treu si el arbol esta vacio.
     * @post Retorna true si la rama del arbol esta vacia
     * @retorna True sí el arbol esta vacio.
     */
    public boolean isEmpty()
    {
        return val == null;
    }
    
   
   

    /**
     * Determine sí el nodo es del hijo de la izquierda
     *
     * @post retorna true si es el hijo de la izquierda
     * 
     * @retorna treu si es el hijo de la izquierda
     */
    public boolean isLeftChild()
    {
        if (parent() == null) return false;
        return this == parent().left();
    }

    /**
     * Determine si el nodo es del hijo de la derecha.
     *
     * @post retorna true si es el hijo de la derecha
     * 
     * @retorna treu si es el hijo de la derecha
     */
    public boolean isRightChild()
    {
        if (parent() == null) return false;
        return this == parent().right();
    }

    /**
     * Metodo para poder realizar arbol binario
     * @post 
     * @param btActual es el arbol primario original creado anteriormente como instancia
     * @param btSiguiente es el arbol binario que se modifica a partir del actual
     * @retorna 
     */
    public static boolean agregar(BinaryTree btActual, BinaryTree btSiguiente) {

        boolean flag = false;

        if (btActual.value().toString().compareTo(btSiguiente.value().toString()) > 0) {
            if (btActual.left().value() == null) {
                btActual.setLeft(btSiguiente);
                flag = true;
            } else {
                agregar(btActual.left(), btSiguiente);
                flag = true;
            }
        } else if (btActual.value().toString().compareTo(btSiguiente.value().toString()) < 0) {
            if (btActual.right().value() == null) {
                btActual.setRight(btSiguiente);
                flag = true;
            } else {
                agregar(btActual.right(), btSiguiente);
                flag = true;
            }
        }

        return flag;

    }

    /**
     * retorna valor de asiociacion de este nodo
     *
     * @post retorna el valor asociado de este nodo
     * 
     * @retorna el valor del nodo.
     */
    public E value()
    {
        return val;
    }

    /**
     * Set valor asociado de este nodo
     *
     * @post set valor asociado del nodo
     * @param nuevo valor = valor nodo
     */
    public void setValue(E value)
    {
        val = value;
    }

    /**
     * @post returna la suma de los hashcodes
     */
    public int hashCode()
    {
        if (isEmpty()) return 0;
        int result = left().hashCode() + right().hashCode();
        if (value() != null) result += value().hashCode();
        return result;
    }
    
	/**
     * computar un nodo.  a lo largo de lo delimitado
     * de nodo a root o rama
     *
     * @post retorna el largo del nodo en el arbol
     */
    public int depth()
    {
        if (parent() == null) return 0;
        return 1 + parent.depth();
    }
	
    public String treeString(){
        String s = "";
        for (int i=0; i < this.depth(); i++){
            s += "\t|";
        }
        
        s += ("<" + val + " : " + getHand() + ">\n");
        
        if (!left.isEmpty()) s += left.treeString();
        if (!right.isEmpty()) s += right.treeString();

        return s;
    }
    
    /**
     * Support method for {@link #toString}. R Retorna nodo hijo 
     * si es el de la derecha, L returna hijo izquierda y rama de este 
     * si este nodo es una rama.
     * 
     * @retorna R si este es un nodo
     * is hijo por derecha, L es hijo por izquierda y Root sí
     * si es nodo es rama o root.
     */
    private String getHand(){
        if (isRightChild()) return "R";
        if (isLeftChild()) return "L";
        return "Root";  
    }
    
    
    /**
     * Retorna un sub arbol con sus ramas en este nodo
     *
     * @post Retorna String
     * 
     * @retorna representación de sub arbol
     */
    public String toString()
    {
        if (isEmpty()) return "<BinaryTree: empty>";
        StringBuffer s = new StringBuffer();
        s.append("<BinaryTree "+value());
        if (!left().isEmpty()) s.append(" "+left());
        else s.append(" -");
        if (!right().isEmpty()) s.append(" "+right());
        else s.append(" -");
        s.append('>');
        return s.toString();
    }

    public Nodo getRaiz(){

        return this.raiz;

    }

    public void insertarNodo(String llave, Association<String,ArrayList<HashMap<String,String>>> valor){

        Nodo nuevoNodo = new Nodo(llave,valor);

        if(this.raiz == null){

            raiz = nuevoNodo;

        }

        else{

            Nodo NodoAuxiliar = this.raiz;

            Nodo padre;

            while(true){

                padre = NodoAuxiliar;

                NodoAuxiliar = NodoAuxiliar.getNodoIzquierda();

                if(NodoAuxiliar == null){

                    padre.setNodoIzquierda(nuevoNodo);
                    return;
    
                }

            }

        }

    }

    public boolean esVacio(){

        return this.raiz == null;

    }

    public Nodo localizarNodo(String palabra){

        Nodo temporal = this.raiz;

        while(temporal.getLlave() != palabra){

            temporal = temporal.getNodoIzquierda();
            if(temporal == null){

                return null;

            }

        }
        return temporal;


    }


}
