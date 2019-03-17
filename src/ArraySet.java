import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * This class construct a ArraySet which stores unique elements(generic type) to
 * an array.
 * 
 * @author Jerry Zhu
 * @param <E> Generic type
 */
public class ArraySet<E> extends AbstractSet<E> {

	private Object[] set;
	private int size;
	private int capacity;

	/**
	 * This is the constructor of the ArraySet, which 
	 * construct a array and initialize several private variables.
	 */
	public ArraySet() {
		size = 0;
		capacity = 8;
		set = new Object[capacity];
	}

	@Override
	/**
	 * This method is to construct a iterator for the ArraySet.
	 */
	public Iterator<E> iterator() {
		return new ArraySetIterator<E>(0, size());
	}

	@Override
	/**
	 * This method is to return the size of the array.
	 * 
	 * @return The size of the array
	 */
	public int size() {
		return size;
	}


	@Override
	/**
	 * This method is to add new element to the ArraySet.
	 * @param element The new element that need to be added.
	 * @return True if the add processing is success.
	 */
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
	/**
	 * This method is to remove the specific element from the array
	 * 
	 * @param elem the given element that need to be removed.
	 * @return True if the removev processing is success.
	 */
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

	/**
	 * This method is to convert the ArraySet into a printable string
	 * with its elements.
	 * 
	 * @return The string that represent the ArraySet
	 */
	public String toString() {
		String str = "["+set[0];
		for(int i = 1; i < capacity; i++) {
			str += ", "+set[i];
		}
		str += "]";
		return str;
	}

	/**
	 * This is a self design iterator for ArraySet class.
	 * @author Jerry Zhu
	 *
	 * @param <T> A generic type
	 */
	private class ArraySetIterator<T> implements Iterator<T>{
		private int cursor;
		private int end;

		/**
		 * This is the constructor of the iterator. 
		 * @param start The start of the iterator(array).
		 * @param end The end of the iterator(array).
		 */
		public ArraySetIterator(int start, int end) {
			this.cursor = start;
			this.end = end;
		}
		@Override
		/**
		 * This method will check if the next element is exist or not.
		 * 
		 * @return True if has the next element.
		 */
		public boolean hasNext() {
			return cursor < end;
		}

		@SuppressWarnings("unchecked")
		@Override
		/**
		 * This method is to return the next element from the array.
		 * 
		 * @return the next element.
		 */
		public T next() {
			if(set[cursor] == null) {
				throw new NoSuchElementException();
			}
			T current = (T) set[cursor];
            cursor ++;
            return current;
		}

		@Override
		/**
		 * This method is to remove the recent element from the array.
		 */
		public void remove() {
			if(set[cursor] == null) {
				throw new IllegalStateException();
			}
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
