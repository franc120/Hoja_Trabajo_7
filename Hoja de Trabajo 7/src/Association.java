import java.util.Map;


public class Association<K,V> implements MapEntry<K,V>
{
	 /**
     * Valor inmutable. Objeto arbitrario.
     */
    protected K theKey; // la llave de llave valor es par.
    /**
     * Valor mutable. Objeto arbitrario.
     */
    protected V theValue; // valor - llave es par

    protected V theValue2; // valor - llave es par

   
     */
    /**
     * contructor parea de llave al valor
     *
     * @pre llave es no nula.
     * @post contructor llave valor
     * @param llave es un valor no nulo.
     * @param valor A 8posible nulo) es objeto.
     */
    public Association(K key, V value)
    {
        
        theKey = key;
        theValue = value;
    }

    /**
     * constructor par de una llave, valor es nulo.
     *
     * @pre llave es no nula
     * @post contructor llave-valor, llave es null
     * @param llave A llave no nula.
     */
    public Association(K key)
    {
        this(key,null);
    }

    /**
     * Standard comparison function.  Comparison based on keys only.
     *
     * @pre otra asiociación no nula
     * @post retorna treu si la llaves son iguales
     * @param una con otras asiociaciones.
     * @retorna treu si son iguales
     */
    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }
    
    /**
     * Standard hashcode function.
     *
     * @psot returna codigo hash con su repectiva asiocciación
     * @retona hash A codigo de asiociación
     * @ver Hashtable
     */
    public int hashCode()
    {
        return getKey().hashCode();
    }
    
    /**
     * Fetch value from association.  May return null.
     *
     * @retorna el de valor de la asociación.
     */
    public V getValue()
    {
        return theValue;
    }

    /**
     * Obtener clave de la asiocación."no puede obtener nulo"
     *
     * @regresa la llave de asociación
     * @regresaa llave del valor par
     */
    public K getKey()
    {
        return theKey;
    }

    /**
     * Sets the value of the key-value pair.
     *
     * @establece una asicioacion de valor a valor
     * @parametro nuevo = nuevo valor
     */
    public V setValue(V value)
    {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }

    /**
     * da la representacion estandar de una cadena
     *
     * @post devuelve la representación de la cadena
     * @regresa la cade represaativa de llave y valor.
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append(" ("+getKey()+", "+getValue() + ") ");
        return s.toString();
    }
    /*
...
*/
}

