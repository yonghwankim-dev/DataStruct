### 1\. TreeSet이란 무엇인가?

TreeSet은 데이터를 저장하기 위해 Java Tree 데이터 구조 기반에 SortedSet 인터페이스의 구현 중 하나입니다. 명시적인 comparator 객체가 제공 여부에 관계없이 오름차순 정렬을 유지합니다.

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Tree/img/%238%20TreeSet%20in%20Java/01_inhreritance.png)

TreeSet 객체 생성시 생성자에서 Comparator 객체를 사용하여 정렬이 가능합니다. TreeSet은 AbstractSet 클래스를 상속하여 NavigableSet 인터페이스를 구현합니다.

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Tree/img/%238%20TreeSet%20in%20Java/02_set.png)

위의 그림과 같이 NavigableSet 인터페이스는 SortedSet 인터페이스로부터 상속받습니다. 일반적인 Set은 삽입 순서를 유지하지 않기 때문에 NavigableSet 인터페이스는 Set 인터페이스를 통해서 안내하기 위해서 구현을 제공합니다. NavigableSet을 구현하기 위한 클래스는 self-balancing tree의 구현인 TreeSet입니다.

### 2\. TreeSet 인터페이스의 내부는 어떻게 작동하는가?

TreeSet 인터페이스는 Red-Black Tree와 같은 self-balancing 이진 탐색 트리의 기본적인 구현입니다. 따라서 add, remove, search와 같은 연산들의 시간 복잡도는 O(log(N)) 시간이 소요됩니다. 그 이유는 노드가 삽입 또는 삭제 될때마다 트리의 높이를 안정적으로 조절하기 때문에 언제나 O(log(N)) 시간이 소요되게 할 수 있습니다. 그러므로 TreeSet 인터페이스는 큰 용량의 정렬된 데이터를 저장하고 연산을 수행하기 위한 가장 효율적인 데이터 구조 중에 하나로 고려됩니다. 그러나 트리의 모든 N개의 노드 값을 출력하는 연산들은 O(N) 시간이 소요될 수 밖에 없습니다.

### 3\. 동기화(Synchronized)된 TreeSet에 대하여

TreeSet 인터페이스의 구현물은 비동기화합니다. 비동기화라는 의미는 여러개의 스레드가 동시에 하나의 TreeSet의 접근하여 삽입 또는 삭제와 같은 연산을 할 수 있다는 의미입니다. 이러한 삽입과 삭제와 같은 연산은 다른 스레드에서 접근이 불가능하게 하고 수행되어야 합니다. 이러한 문제를 해결하기 위하여 집합(set)을 자연스럽게 캡슐화하는 일부 객체들을 동기화함으로써 해결할 수 있습니다. 만약 그러한 객체가 존재하지 않는다면 그 집합(set)은 Collections.synchronizedSortedSet 메서드를 사용하여 래핑하여야 합니다. 이 방법은 집합에 비동기화적인 접근을 예방하기 위해서 객체 생성시에 좋은 방법입니다. 방법은 아래와 같이 표현할 수 있습니다.

```
TreeSet ts = new TreeSet();
Set syncSet = Collections.synchronizedSet(ts);
```

### 4\. TreeSet 클래스의 생성자

-   TreeSet() : 빈 TreeSet을 생성합니다.
-   TreeSet(Comparator) : 빈 TreeSet을 생성하고 정렬 기준은 Comparator를 따릅니다.
-   TreeSet(Collection) : Collection 타입의 객체안에 요소들을 TreeSet에 삽입합니다.
-   TreeSet(SortedSet) : 객체 생성시 SortedSet 객체안에 요소들을 삽입합니다. 순서는 기본적인 자연스러운 정렬순서입니다.

```
TreeSet ts1 = new TreeSet();
TreeSet ts2 = new TreeSet(Comparator comp);
TreeSet ts3 = new TreeSet(Collection col);
TreeSet ts4 = new TreeSet(SortedSet s);
```

### 5\. TreeSet 클래스의 메서드

MethodDescription

| [**add(Object o)**](https://www.geeksforgeeks.org/treeset-add-method-in-java/) | This method will add the specified element according to the same sorting order mentioned during the creation of the TreeSet. Duplicate entries will not get added. |
| --- | --- |
| [**addAll(Collection c)**](https://www.geeksforgeeks.org/treeset-addall-method-in-java/) | This method will add all elements of the specified Collection to the set. Elements in the Collection should be homogeneous otherwise ClassCastException will be thrown. Duplicate Entries of Collection will not be added to TreeSet. |
| [**ceiling?(E e)**](https://www.geeksforgeeks.org/treeset-ceiling-method-in-java-with-examples/) | This method returns the least element in this set greater than or equal to the given element, or null if there is no such element. |
| [**clear()**](https://www.geeksforgeeks.org/treeset-clear-method-in-java/) | This method will remove all the elements. |
| [**clone()**](https://www.geeksforgeeks.org/treeset-clone-method-in-java/) | The method is used to return a shallow copy of the set, which is just a simple copied set. |
| [**Comparator comparator()**](https://www.geeksforgeeks.org/treeset-comparator-method-in-java/) | This method will return the Comparator used to sort elements in TreeSet or it will return null if the default natural sorting order is used. |
| [**contains(Object o)**](https://www.geeksforgeeks.org/treeset-contains-method-in-java/) | This method will return true if a given element is present in TreeSet else it will return false. |
| [**descendingIterator?()**](https://www.geeksforgeeks.org/treeset-descendingiterator-method-in-java-with-examples/) | This method returns an iterator over the elements in this set in descending order. |
| [**descendingSet?()**](https://www.geeksforgeeks.org/treeset-descendingset-method-in-java-with-examples/) | This method returns a reverse order view of the elements contained in this set. |
| [**first()**](https://www.geeksforgeeks.org/treeset-first-method-in-java/) | This method will return the first element in TreeSet if TreeSet is not null else it will throw NoSuchElementException. |
| [**floor?(E e)**](https://www.geeksforgeeks.org/treeset-floor-method-in-java-with-examples/) | This method returns the greatest element in this set less than or equal to the given element, or null if there is no such element. |
| [**headSet(Object toElement)**](https://www.geeksforgeeks.org/treeset-headset-method-in-java/) | This method will return elements of TreeSet which are less than the specified element. |
| [**higher?(E e)**](https://www.geeksforgeeks.org/treeset-higher-method-in-java-with-examples/) | This method returns the least element in this set strictly greater than the given element, or null if there is no such element. |
| [**isEmpty()**](https://www.geeksforgeeks.org/treeset-isempty-method-in-java/) | This method is used to return true if this set contains no elements or is empty and false for the opposite case. |
| [**Iterator iterator()**](https://www.geeksforgeeks.org/treeset-iterator-method-in-java/) | Returns an iterator for iterating over the elements of the set. |
| [**last()**](https://www.geeksforgeeks.org/treeset-last-method-in-java/) | This method will return the last element in TreeSet if TreeSet is not null else it will throw NoSuchElementException. |
| [**lower?(E e)**](https://www.geeksforgeeks.org/treeset-lower-method-in-java/) | This method returns the greatest element in this set strictly less than the given element, or null if there is no such element. |
| [**pollFirst?()**](https://www.geeksforgeeks.org/treeset-pollfirst-method-in-java/) | This method retrieves and removes the first (lowest) element, or returns null if this set is empty. |
| [**pollLast?()**](https://www.geeksforgeeks.org/treeset-polllast-method-in-java-with-example/) | This method retrieves and removes the last (highest) element, or returns null if this set is empty. |
| [**remove(Object o)**](https://www.geeksforgeeks.org/treeset-remove-method-in-java/) | This method is used to return a specific element from the set. |
| [**size()**](https://www.geeksforgeeks.org/treeset-size-method-in-java/) | This method is used to return the size of the set or the number of elements present in the set. |
| **spliterator()** | This method creates a late-binding and fail-fast Spliterator over the elements in this set. |
| [**subSet(Object fromElement, Object toElement)**](https://www.geeksforgeeks.org/treeset-subset-method-in-java/) | This method will return elements ranging from fromElement to toElement. fromElement is inclusive and toElement is exclusive. |
| [**tailSet(Object fromElement)**](https://www.geeksforgeeks.org/treeset-tailset-method-in-java/) | This method will return elements of TreeSet which are greater than or equal to the specified element. |

### 6\. TreeSet 예제

```
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

class TreeSetTest {

	@Test
	void createAndAddTest() {
		Set<String> ts1 = new TreeSet<String>();
		
		// 요소 추가
		ts1.add("A");
		ts1.add("B");
		ts1.add("C");
		
		
		// 중복된 값은 들어갈 수 없음
		ts1.add("C");
		
		// 기본 정렬 : 오름차순
		System.out.println(ts1);	// Expected Output : [A, B, C]
	}
	
	@Test
	void accessingTest() {
		NavigableSet<String> ts = new TreeSet<String>();
		
		ts.add("Geek");
		ts.add("For");
		ts.add("Geeks");
		
		System.out.println("Tree Set is " + ts);	// Expected Output : [For, Geek, Geeks]
		
		String check = "Geeks";
		
		System.out.println("Contains" + check + " " + ts.contains(check));	// Expected Output : true
		
		System.out.println("Last Value " + ts.last());	// Expected Output : Geeks
		
		String val = "Geek";
		
		// 주어진 문자열보다 큰 문자열을 탐색한다. 
		System.out.println("Higher " + ts.higher(val));	// Expected Output : Geeks
		// 주어진 문자열보다 작은 문자열을 탐색한다.. 
		System.out.println("Lower " + ts.lower(val));	// Expected Output : For
	}
	
	@Test
	void removeTest() {
		NavigableSet<String> ts = new TreeSet<String>();
		
		ts.add("Geek");
        ts.add("For");
        ts.add("Geeks");
        ts.add("A");
        ts.add("B");
        ts.add("Z");
        
        // 초기 트리 상황
        System.out.println("Initial TreeSet " + ts); // Expected Output : [A, B, For, Geek, Geeks, Z] 
        
        // 트리에서 "B" 제거
        ts.remove("B");
        
        // B 제거 후 트리 상황
        System.out.println("After removing element " + ts); // Expected Output : [A, For, Geek, Geeks, Z]
        
        // 트리에서 첫번째 노드 제거
        ts.pollFirst();
        
        // 첫번째 노드 제거 후 트리 상황
        System.out.println("After removing first" + ts); // Expected Output : [For, Geek, Geeks, Z]
        
        // 트리에서 마지막 노드 제거
        ts.pollLast();
        
        // 마지막 노드 제거 후 트리 상황
        System.out.println("After removing last" + ts); // Expected Output : [For, Geek, Geeks]
	}
	
	@Test
	void iterateTest(){
		Set<String> ts = new TreeSet<>();
		
        ts.add("Geek");
        ts.add("For");
        ts.add("Geeks");
        ts.add("A");
        ts.add("B");
        ts.add("Z");
        
        for(String value : ts)
        {
        	System.out.print(value + ", "); // Expected Output : A, B, For, Geek, Geeks, Z,
        }
        System.out.println();
	}
	
	// 트리에 다른 타입의 값이 들어온 경우 삽입을 허용하지 않는다.
	@Test
	void heterogeneousTest() {
		Set<StringBuffer> ts = new TreeSet<>();
		
        ts.add(new StringBuffer("A"));
        ts.add(new StringBuffer("Z"));
        ts.add(new StringBuffer("L"));
        ts.add(new StringBuffer("B"));
        ts.add(new StringBuffer("O"));
        ts.add(new StringBuffer(1));
        
        System.out.println(ts); // Expected Output : [, A, B, L, O, Z]
	}

}
```

### References

> source code : https://github.com/yonghwankim-dev/DataStruct  
> https://www.geeksforgeeks.org/treeset-in-java-with-examples/
