package ArrayList.Implement;

import java.util.Arrays;
import java.util.stream.Collectors;

class ArrayListImple<T> {
	private T arr[];
	private int capacity;
	private int size;
	
	public ArrayListImple()
	{
		this(1);
	}
	
	public ArrayListImple(int capacity)
	{
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
		size = 0;
	}

	public void add(T element)
	{
		add(size, element);
	}
	
	public void add(int index, T element)
	{
		if(isFull())
		{
			reSize();
		}

		if(size == index)
		{
			arr[size] = element;
		}
		else
		{
			// right shift
			shiftRight(index, element);
		}
		size++;
	}

	
	public void clear()
	{
		this.capacity = 1;
		arr = (T[]) new Object[capacity];
		size = 0;
	}
	
	public boolean contains(T element)
	{
		for(int i = 0; i < size; i++)
		{
			if(arr[i].equals(element))
			{
				return true;
			}
		}
		return false;
	}
	
	public T get(int index)
	{
		checkIndexOutOfBoundsException(index);

		return arr[index];
	}
	
	public T remove(int index)
	{
		checkIndexOutOfBoundsException(index);

		T delVal = arr[index];
		shiftLeft(index);
		size--;
		return delVal;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public boolean isFull()
	{
		return size == capacity;
	}
	
	public int size()
	{
		return size;
	}

	public int capacity(){
		return capacity;
	}

	private void reSize()
	{
		T[] dummy = (T[]) new Object[capacity];
		System.arraycopy(arr, 0, dummy, 0, capacity);
		this.capacity *= 2;
		arr = (T[]) new Object[capacity];
		System.arraycopy(dummy, 0, arr, 0, dummy.length);
	}

	private void shiftRight(int index, T element){
		int lastIdx = size-1;
		for(int i = lastIdx; i >= index; i--)
		{
			arr[i+1] = arr[i];
		}
		arr[index] = element;
	}

	private void shiftLeft(int index) {
		for(int i=index+1; i<size; i++)
		{
			arr[i-1] = arr[i];
		}
	}

	private void checkIndexOutOfBoundsException(int index){
		if(index >= size){
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public String toString()
	{
		return Arrays.stream(arr)
				     .limit(size)
				     .collect(Collectors.toList())
				     .toString();
	}
}
