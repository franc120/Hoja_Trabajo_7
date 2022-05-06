
public interface MapEntry 
{
	 public boolean equals (Object o);
	   // post: devuelve true if esta entrada <K,V> es igual al objeto o

	   public K getKey();
	   // post: retorna la llave de esta entrada

	   public V getValue();
	   // post: retorna la llave de esta entrada

	   public int hashCode();
	   // post: retorna el hashcode de la llave
	   
	   public V setValue(V value);
	   // post: reemplaza el valor de esta entrada
	   
	   
}
