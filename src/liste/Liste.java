package liste;

public interface Liste {
	public abstract int size();
	public abstract void append(Object o);
	public abstract void prepend(Object o);
	public abstract Object getFirst();
	public abstract Object getLast();
	public abstract Object	removeFirst();
	public abstract Object get(int position) throws ArrayIndexOutOfBoundsException;
	public abstract void set(int position, Object o) throws ArrayIndexOutOfBoundsException;
}
