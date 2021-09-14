package ArrayList.Implement;

public class ArrayList_imple {
	private int arr[];
	private int capacity;
	private int size;
	
	public ArrayList_imple()
	{
		capacity = 1;
		arr = new int[capacity];
		size = 0;
	}
	
	public ArrayList_imple(int capacity)
	{
		this.capacity = capacity;
		arr = new int[this.capacity];
		size = 0;
	}
	
	private void reSize()
	{
		int[] dummy = new int[capacity];
		System.arraycopy(arr, 0, dummy, 0, capacity);
		this.capacity *= 2;
		arr = new int[capacity];
		System.arraycopy(dummy, 0, arr, 0, dummy.length);
	}
	
	private void checkIndexOutOfBounds(int index)
	{
		try {
			if(size<index)
			{
				throw new IndexOutOfBoundsException();
			}
		}catch(IndexOutOfBoundsException e)
		{
			System.out.println("배열리스트 삽입 중 잘못된 인덱스에 삽입하였습니다. " + e);
			System.exit(0);
		}
	}
	
	public void add(int element)
	{
		if(isFull())
		{
			reSize();
		}
		arr[size++] = element;
	}
	
	public void add(int index, int element)
	{
		// 배열 공간 검사
		if(isFull())
		{
			reSize();
		}
		
		// 삽입 위치 검사
		checkIndexOutOfBounds(index);
		
		
		// 삽입 데이터
		if(size==index)
		{
			arr[size] = element;
		}
		else
		{
			// right shift
			int lastIdx = size-1;
			for(int i=lastIdx; i>=index; i--)
			{
				arr[i+1] = arr[i];
			}
			arr[index] = element;
		}
		size++;
	}
	
	public void clear()
	{
		this.capacity = 1;
		arr = new int[this.capacity];
		size = 0;
	}
	
	public boolean contains(int element)
	{
		for(int i=0;i<size;i++)
		{
			if(arr[i]==element)
			{
				return true;
			}
		}
		return false;
	}
	
	public int get(int index)
	{
		if(index>=size)
		{
			System.out.println(new Throwable(new IndexOutOfBoundsException()));
			System.exit(0);
		}
		return arr[index];
	}
	
	public int remove(int index)
	{
		if(index>=size)
		{
			System.out.println(new Throwable(new IndexOutOfBoundsException()));
			System.exit(0);
		}
		
		int delVal = arr[index];
		// left shift
		for(int i=index+1; i<size; i++)
		{
			arr[i-1] = arr[i];
		}
		size--;
		return delVal;
	}
	
	public boolean isEmpty()
	{
		return (size==0 ? true : false);
	}
	
	public boolean isFull()
	{
		return (size==capacity ? true : false);
	}
	
	public int size()
	{
		return size;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for(int i=0;i<size;i++)
		{
			sb.append(arr[i] + ", ");
		}
		sb.replace(sb.length()-2,sb.length(),"");	// 마지막 쉼표 제거
		sb.append("]");
		
		return sb.toString();
	}
}
