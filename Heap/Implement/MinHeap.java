package Heap.Implement;

public class MinHeap {
	private int[] harr;
	private int capacity;	// �ּ� ���� �ּ� ���� ũ��
	private int heap_size;	// �ּ� ���� ���� ũ��
	
	public MinHeap()
	{
		this(10);
	}
	
	public MinHeap(int capacity)
	{
		harr = new int[capacity];
		this.capacity = capacity;
		heap_size = 0;
	}
	
	// �־��� i��° ����� ����Ʈ���� �� �����ϱ� ���� �޼���
	public void MinHeapify(int i)
	{
		int left = getLeftChild(i);
		int right = getRightChild(i);
		int smallest = i;
		
		if(left < heap_size && harr[left] < harr[i])
		{
			smallest = left;
		}
		if(right < heap_size && harr[right] < harr[smallest])
		{
			smallest = right;
		}
		
		if(smallest != i)
		{
			swap(smallest, i);
			MinHeapify(smallest);
		}		
	}
	
	// �־��� i��° ����� �θ� ��� ��ȯ
	public int getParent(int i)
	{
		return (i-1)/2;
	}
	
	// �־��� i��° ����� ���� �ڽ� ��ȯ
	public int getLeftChild(int i)
	{
		return (2*i+1);
	}
	
	// �־��� i��° ����� ������ �ڽ� ��ȯ
	public int getRightChild(int i)
	{
		return (2*i+2);
	}
	
	// ��Ʈ ����� ���� �����մϴ�. ����� ��Ʈ ���� ���ŵ˴ϴ�.
	public int extractMin()
	{
		if(heap_size<=0)
		{
			return Integer.MAX_VALUE;
		}
		
		if(heap_size==1)
		{
			heap_size--;
			return harr[0];
		}
		
		// �����κ��� ��Ʈ ����� ���� �����ϰ� �ּҰ����� ��ü
		int root = harr[0];
		harr[0] = harr[heap_size-1];
		heap_size--;
		MinHeapify(0);	// ��Ʈ ��� ������
		
		return root;
	}
	
	// i��° ����� ���� new_val ������ �����մϴ�.
	public void decreaseKey(int i, int new_val)
	{
		harr[i] = new_val;
		while(i!=0 && harr[getParent(i)] > harr[i])
		{
			swap(getParent(i), i);
			i = getParent(i);
		}
	}
	// �ּҰ� ��ȯ, ��Ʈ ����� ���� �������� �ʰ� ���� ��ȯ�մϴ�.
	public int getMin()
	{
		return harr[0];
	}
	
	// i��° ��带 �����մϴ�.
	// i��° �ڸ��� ������ �ּڰ����� ��ü�ǰ� extractMin()�� ȣ���Ͽ� �������� ����˴ϴ�.
	public void deleteKey(int i)
	{
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}
	
	// ���ο� �� 'k' ����
	public void insertKey(int k)
	{
		if(heap_size==capacity)
		{
			System.out.println("Overflow : Could not insertKey\n");
			return;
		}
		
		// heap�� ������ �ڸ��� k�� �߰�
		heap_size++;
		int i = heap_size - 1;
		harr[i] = k;
		
		// i�� 0�� �ƴϰ� �θ� ����� ���� ����(i) ����� ������ ū ��쿡��
		// �θ� ���� ���� ����� ���� �����Ѵ�. (�ּ� �� ����)
		while(i!=0 && harr[getParent(i)]>harr[i])
		{
			swap(getParent(i),i);
			i = getParent(i);
		}
	}
	
	public void swap(int parent, int i)
	{
		int temp = harr[parent];
		harr[parent] = harr[i];
		harr[i] = temp;
	}
	
}
