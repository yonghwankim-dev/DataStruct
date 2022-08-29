### 개요

배열 기반으로 구현한 배열리스트의 주요한 메서드(삽입, 삭제, 탐색) 수행 과정을 알아보고 배열리스트를 직접 구현을 해보겠습니다. 아래의 구현 기능은 java.util.ArrayList 패키지의 메서드를 기반으로 직접 구현을 합니다.

### 구현 기능

| 메서드 | 설명 |
| --- | --- |
| add(int index, Object element) | index번째 자리에 element를 저장합니다. |
| add(Object element) | 배열리스트의 끝쪽에 element를 추가합니다. |
| clear() | 배열리스트의 element들을 초기화합니다. |
| contains(Object element) | 배열리스트에서 매개변수의 element 값이 포함되어 있는지 조회합니다. |
| get(int index) | 배열리스트 index번째 자리의 element값을 반환합니다. |
| remove(int index) | 배열리스트 index번째 자리의 element값을 제거합니다. 그리고 제거한 element 값을 반환합니다. |
| isEmpty() | 배열리스트가 비어있는지 검사합니다. 비어있다면 true, 아니라면 false를 반환합니다. |
| size() | 배열리스트의 요소 개수를 반환합니다. |
| toString() | 배열리스트의 element들을 문자열 형식으로 반환합니다. |

### add(Object element) 메서드 수행 과정

add(Object element) 메서드는 배열 리스트의 마지막 요소 다음 자리에 element를 추가하는 메서드입니다. 주의사항은 만약 배열리스트의 공간이 전부 차지하고 있는 경우에는 배열의 크기를 2배로 늘려야 합니다.

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/ArrayList/img/03_addMethod_1.png)

### add(int index, Object element) 메서드 수행 과정

add(int index, Object element) 메서드는 배열 리스트의 index번째 요소 자리에 element을 추가하는 메서드입니다.

해당 메서드에서 주목할 점은 1번째 자리에 정수 3을 삽입시 1번째 자리에 값이 존재하는 경우 1칸씩 오른쪽으로 이동(Shift)한다는 점입니다. 주의 사항은 배열리스트는 순차적으로 저장이 되어야 하기 때문에 저장하는 위치는 마지막 저장 요소 위치의 다음이어야 합니다. 이 규칙을 어기는 순간 예외처리됩니다.

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/ArrayList/img/04_addMethod_2.png)

### get(int index) 메서드 수행 과정

배열리스트의 index번째 요소를 탐색하여 반환합니다. 주의 사항은 탐색하고자 하는 인덱스가 빈 공간을 참조하는 경우 예외처리됩니다.

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/ArrayList/img/05_getMethod_1.png)

### remove(int index) 메서드 수행 과정

배열리스트의 index번째 요소를 제거합니다. 단, 주의할 점은 제거될때 해당 index번째 뒤에 다른 요소들이 있다면 왼쪽으로 이동(Shift)해야 한다. 주의사항은 제거하고자 하는 인덱스 위치에 데이터가 포함되어야 합니다.

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/ArrayList/img/06_removeMethod_1.png)

### 배열을 이용한 리스트 구현

```
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
```

### 배열을 이용한 리스트 구현 테스트

```


class ArrayList_impleTest {

	@Test
	void addParamOneTest() {
		ArrayList_imple list = new ArrayList_imple(3);
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list); // Expected Output : [1, 2, 3]
	}
	
	@Test
	void addParamTwoTest() {
		ArrayList_imple list = new ArrayList_imple(3);
		list.add(1);
		list.add(2);
		list.add(2,3);
		System.out.println(list);	// Expected Output : [1, 2, 3]
	}
	
	@Test
	void removeTest() {
		ArrayList_imple list = new ArrayList_imple(3);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.remove(1);
		System.out.println(list);	// Expected Output : [1, 3, 4]
	}
	
	@Test
	void getTest() {
		ArrayList_imple list = new ArrayList_imple(3);
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.get(1));	// Expected Output : 2
	}
}
```

### References

> https://www.geeksforgeeks.org/arraylist-in-java/
