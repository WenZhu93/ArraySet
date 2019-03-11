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


## Requirements

- The ArraySet class needs all of the methods and inner classes as explained above
- A reasonable Test Suite that convinces you that your ArrayMap works (we will grade with our own test suite for correctness, but yours should exist and do what we want our test suite to do).
- Documentation using javadoc.
 
## Submission
 
 As always, the last pushed commit prior to the due date will be graded.
 
 

