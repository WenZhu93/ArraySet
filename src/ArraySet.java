import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArraySet<E> extends AbstractSet<E> {

	private Object[] set;
	private int size;
	private int capacity;

	public ArraySet() {
		size = 0;
		capacity = 8;
		set = new Object[capacity];
	}

	@Override
	public Iterator<E> iterator() {
		return new ArraySetIterator<E>(0, size());
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(E element) {
		int index = 0;
		// Check if the new element is already in the array.
		for(; index < size; index++) {
			if(set[index].equals(element)) {
				return false;
			}
		}
		// Otherwise, add the element to the array. if the size equals the 
		// capacity, double the size of the array and copy the previous 
		// elements to the new array.
		if(size == capacity) {
			capacity *= 2;
			set = Arrays.copyOf(set,capacity);
		}
		set[index++] = element;
		size++;
		return true;
	}

	@Override
	public boolean remove(Object elem) {
		for(int i = 0; i < size; i++){
			if(set[i].equals(elem)){
				for(int j = i; j < capacity; j++) {
					if(j+1 == capacity) {
						set[j] = null;
					}else {
						set[j] = set[j+1];
					}
				}
				size--;
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String str = "["+set[0];
		for(int i = 1; i < capacity; i++) {
			str += " "+set[i];
		}
		str += "]";
		return str;
	}

	private class ArraySetIterator<T> implements Iterator<T>{
		private int cursor;
		private int end;

		public ArraySetIterator(int start, int end) {
			this.cursor = start;
			this.end = end;
		}
		@Override
		public boolean hasNext() {
			return cursor < end;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			if(set[cursor] == null) {
				throw new NoSuchElementException();
			}
			T current = (T) set[cursor];
            cursor ++;
            return current;
		}

		@Override
		public void remove() {
			for(int j = cursor; j < end; j++) {
				if(j+1 == end) {
					set[j] = null;
				}else {
					set[j] = set[j+1];
				}
			}
			end--;
		}
	}
}
