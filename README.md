# CSC 335 ArraySet

An ArraySet will be a set that is implemented using an arrays of type Object.

Your ArrayMap will be a templated (generic type) that will allow Sets of any type.
It will be declared as:

```Java
public class ArraySet<E> extends AbstractSet<E> 
```

You are required to provide the implementations of several methods to make your map work.

```Java
@Override
public boolean add(E element)
```
	
This method adds an element to your set. If element already exists in the set, it does nothing and returns false.

You will need to do the ArrayList-style growth on your backing storage array. Have an initial capacity and when `add()` is unable to find any space, double its size and copy the old elements over.

```Java
@Override
public int size()
```

This method returns the number of elements the set contains.

```Java
@Override
public boolean remove(Object elem) {
```
This method will attempt to remove the item elem from the set, returning true if it succeeds, false otherwise.

Remove the element from your backing storage array by shifting the elements after the deleted element down one spot. You do not need to shrink the array regardless of how much larger its capacity is versus your set size.

```Java		
@Override
public Iterator<E> iterator() 
```

This returns an iterator that walks over the set.

## The Iterator 
This iterator will be implemented as a private inner class:

```Java
private class ArraySetIterator<T> implements Iterator<T>
```

And must provide implementations of:

```Java
@Override
public boolean hasNext()
```

Returns true if there are more items in the set being iterated over.

```Java
@Override
public T next() 
```

Returns an item not previously returned while iterating over our set.

```Java
@Override
void remove()
```

The JavaDoc for this method states:

>Removes from the underlying collection the last element returned by this iterator (optional operation). This method can be called only once per call to next(). The behavior of an iterator is unspecified if the underlying collection is modified while the iteration is in progress in any way other than by calling this method.
>
>Throws:
>
>   `IllegalStateException` - if the next method has not yet been called, or the remove method has already been called after the last call to the next method 

## Requirements

- The ArraySet class needs all of the methods and inner classes as explained above
- A reasonable Test Suite that convinces you that your ArraySet works (we will grade with our own test suite for correctness, but yours should exist and do what we want our test suite to do).
  - You should once again have 100% branch coverage. 
  - You may use any of the templated methods provided by AbstractSet or AbstractCollection, and these also will serve as good methods to use in your JUnit tests since they implicitly call the methods you have overridden.
- Documentation using javadoc for each method.
 
## Submission
 
 As always, the last pushed commit prior to the due date will be graded.
 
 

