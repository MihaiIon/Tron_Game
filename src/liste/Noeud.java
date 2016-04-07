package liste;

public class Noeud {
	
	// Attributes
	public Object content;
	public Noeud next = null; // null = no next node
	
	// Constructor
	public Noeud(){}

	// Methods
	public String toString() { return ""+this.content; }
}
