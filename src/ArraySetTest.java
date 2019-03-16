import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class ArraySetTest {

	@Test
	void testArraySet() {
		ArraySet<Integer> test = new ArraySet<Integer>();
		// Test add
		test.add(1);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		assertEquals(test.size(), 9);
		
		// Test remove
		test.remove(2);
		test.remove(2);
		
		// Test iterator
		Iterator<Integer> itr = test.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
		assertThrows(NoSuchElementException.class, () -> {
			itr.next();
		});
		
		Iterator<Integer> itr2 = test.iterator();
		while(itr2.hasNext()) {
			itr2.remove();
			//break;
		}
		
		// Test toString
		System.out.println(test);
	}
}
