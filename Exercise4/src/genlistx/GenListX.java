package genlistx;

// Klasse med fejl
public class GenListX {
	private Node list;
	private int size;

	// create a new empty list
	public GenListX() {
		list = null;
		size = 0;
	}

	// insert an object in the end of the list
	public void add(Object o) {
		Node node = new Node(o);
		Node current;

		if (list == null)
			list = node;
		else {
			current = list;
			while (current.next != null)
				current = current.next;
			current.next = node;
		}
		size++;
	}

	// returns the number of objects in the list
	public int size() {
		return size;
	}

	// returns a reference to object number "index" from the list
	// throws IndexOutOfBoundException
	public Object get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || size <= index)
			throw new IndexOutOfBoundsException("Error (get): Invalid index: "
					+ index);

		Node current = list;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	public void add(int index, Object element) {
		if (index < 0 || size < index)
			throw new IndexOutOfBoundsException("Error (add): Invalid index: "
					+ index);

		Node node = new Node(element);

		// on first position
		if (index == 0) {
			list = node;
			node.next = list;
		} else
		// on a position after the first
		{
			Node current = list;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			node.next = current.next;
			current.next = node;
		}
		size++;
	}

	public Object remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || size < index)
			throw new IndexOutOfBoundsException(
					"Error (remove): Invalid index: " + index);
		Node node;
		Node current = list;
		// from first position
		if (index == 0) {
			node = list;
			list = node.next;
		} else
		// from a position after the first
		{
			current = list;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			node = current.next;
			current.next = node.next;
		}
		size--;
		return node.data;
	}

	// //////////////////////////////////////
	private class Node {
		Object data;
		Node next;

		public Node(Object o) {
			data = o;
			next = null;
		}
	}
}