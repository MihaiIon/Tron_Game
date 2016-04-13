package liste;

public class ListeChainee implements Liste{

	
	// Attributes
	private Noeud premier;
	private Noeud dernier;
	private int size;
	 
	/**
	* Default Constructor
	**/
	public ListeChainee()
	{
		size = 0;
		premier = null;
		dernier = null;
	}
	 
	/**
	* Returns the list size.
	**/
	public int size() { return size; }
	 
	/**
	* Adds Element to the end of the list.
	**/
	public void append(Object o)
	{	
		if(size == 0)
		{
		  dernier = premier = new Noeud();
		  dernier.content = o;
		}
		else if (size == 1){
			dernier = new Noeud();
			premier.next = dernier;
			dernier.content = o;
		}
		else{
			Noeud currentLast = new Noeud();
			currentLast.content = dernier.content;
			currentLast.next = dernier;
			dernier.content = o; 
			((Noeud)get(size-2)).next = currentLast; }
		size++;
	}
	 
	 /**
	 * Adds Element to the beginning of the list.
	 **/
	 public void prepend(Object o)
	 {
		if(size == 0)
		{
		  dernier = premier = new Noeud();
		  premier.content = o;
		}
		else if (size == 1){
			premier = new Noeud();
			premier.next = dernier;
			premier.content = o;
		}
		 else{
			 Noeud currentFirst = new Noeud();
			 currentFirst.content = premier.content;
			 currentFirst.next = premier.next;
			 premier.content = o;
			 premier.next = currentFirst; }
		 size++;
	 }
	 
	 /**
	 * Returns first Element
	 **/
	 public Noeud getFirst(){ return premier; }
	 
	 /**
	 * Returns last Element
	 **/
	 public Noeud getLast(){ return dernier; }
	 
	 /**
	 * Removes first Element and returns it
	 **/
	 public Noeud removeFirst()
	 { 
		 Noeud first = new Noeud();
		 first.content = premier.content;
		 premier = premier.next;
		 size--;
		 return first;
	 }
	 
	 /**
	 * Returns the Element at the index : position.
	 **/
	 public Noeud get(int position) throws ArrayIndexOutOfBoundsException
	 {
		 if(position < 0 || position >= size) throw new ArrayIndexOutOfBoundsException();
		 else{
			 int i = 0;
			 Noeud currentNode = premier;
			 while( i != position)
			 {
				 i++;
				 currentNode = currentNode.next;
			 }
			 return currentNode;
		 }
	 }
	 
	 /**
	 * Sets the Element at the index : positiontion >
	 **/
	 public void set(int position, Object o) throws ArrayIndexOutOfBoundsException
	 {
		 Noeud newNode = new Noeud();
	 	 newNode.content = o;    //nodeTS =  as in node to set
	 	 newNode.next = get(position).next; //cNode = current node
	 	 get(position-1).next = newNode;
	 }
	 
	 /**
	 * Example output : ListeChainee[ 13, Hello, world, -7.8 ]
	 **/
	 public String toString(){
	  
		 String output = "ListeChainee[ ";
	 
		 int i = 0;
		 Noeud currentNode = premier;
		 while( i != size)
		 {
			 i++;
			 output += (currentNode.content + ", ");
			 currentNode = currentNode.next;
		 }
		 return output.substring(0, output.length()-2) + " ]";
	 }
}
