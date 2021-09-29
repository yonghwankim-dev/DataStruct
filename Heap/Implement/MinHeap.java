package Heap.Implement;

public class MinHeap {
	private int[] harr;
	private int capacity;	// 최소 힙의 최소 가능 크기
	private int heap_size;	// 최소 힙의 현재 크기
	
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
	
	// 주어진 i번째 노드의 서브트리를 힙 조정하기 위한 메서드
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
	
	// 주어진 i번째 노드의 부모 노드 반환
	public int getParent(int i)
	{
		return (i-1)/2;
	}
	
	// 주어진 i번째 노드의 왼쪽 자식 반환
	public int getLeftChild(int i)
	{
		return (2*i+1);
	}
	
	// 주어진 i번째 노드의 오른쪽 자식 반환
	public int getRightChild(int i)
	{
		return (2*i+2);
	}
	
	// 루트 노드의 값을 추출합니다. 추출된 루트 노드는 제거됩니다.
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
		
		// 힙으로부터 루트 노드의 값을 제거하고 최소값으로 대체
		int root = harr[0];
		harr[0] = harr[heap_size-1];
		heap_size--;
		MinHeapify(0);	// 루트 노드 힙조정
		
		return root;
	}
	
	// i번째 노드의 값을 new_val 값으로 변경합니다.
	public void decreaseKey(int i, int new_val)
	{
		harr[i] = new_val;
		while(i!=0 && harr[getParent(i)] > harr[i])
		{
			swap(getParent(i), i);
			i = getParent(i);
		}
	}
	// 최소값 반환, 루트 노드의 값을 제거하지 않고 값만 반환합니다.
	public int getMin()
	{
		return harr[0];
	}
	
	// i번째 노드를 제거합니다.
	// i번째 자리는 정수의 최솟값으로 대체되고 extractMin()을 호출하여 힙조정이 수행됩니다.
	public void deleteKey(int i)
	{
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}
	
	// 새로운 값 'k' 삽입
	public void insertKey(int k)
	{
		if(heap_size==capacity)
		{
			System.out.println("Overflow : Could not insertKey\n");
			return;
		}
		
		// heap의 마지막 자리에 k를 추가
		heap_size++;
		int i = heap_size - 1;
		harr[i] = k;
		
		// i가 0이 아니고 부모 노드의 값이 현재(i) 노드의 값보다 큰 경우에만
		// 부모 노드와 현재 노드의 값을 변경한다. (최소 힙 유지)
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
