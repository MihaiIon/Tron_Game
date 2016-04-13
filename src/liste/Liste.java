package liste;

public interface Liste {
	public abstract int size();
	public abstract void append(Object o);
	public abstract void prepend(Object o);
	public abstract Noeud getFirst();
	public abstract Noeud getLast();
	public abstract Noeud removeFirst();
	public abstract Noeud get(int position) throws ArrayIndexOutOfBoundsException;
	public abstract void set(int position, Object o) throws ArrayIndexOutOfBoundsException;
}
