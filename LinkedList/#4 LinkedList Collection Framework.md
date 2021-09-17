### 1\. LinkedList Collection Framwork

LinkedList는 java.util 패키지에서 Collection Framework 중 하나이다. LinkedList 클래스는 연결리스트(LinkedList) 데이터 구조를 구현한 클래스입니다. 대표적인 특징으로는 선형 데이터 구조이지만 메모리상의 연속적인 위치에 저장되지 않고 노드를 구성합니다. 노드는 값을 담을 수 있는 데이터 변수와 다음 노드를 가리킬 수 있는 주소 노드로 구성됩니다. LinkedList 데이터 구조는 삽입과 삭제가 쉽고 크기가 동적이기 때문에 이부분에서는 배열보다 성능이 좋습니다. 하지만 단점으로는 배열은 직접적으로 특정 위치에 접근이 가능한 반면 LinkedList는 head부터 탐색할 수 밖에 없습니다. 즉, 탐색의 성능이 배열보다 좋지 않습니다.

### 2\. LinkedList의 생성 및 사용

```
import java.util.*;
  
public class Test {
  
    public static void main(String args[])
    {
        LinkedList<String> ll
            = new LinkedList<String>();
  
        // Adding elements to the linked list
        ll.add("A");
        ll.add("B");
        ll.addLast("C");
        ll.addFirst("D");
        ll.add(2, "E");
  
        System.out.println(ll);	// Expected Output : [D, A, E, B, C]
  
        ll.remove("B");
        ll.remove(3);
        ll.removeFirst();		
        ll.removeLast();
  
        System.out.println(ll);	// Expected Output : [A]
    }
}
```

```
Output 

[D, A, E, B, C]
[A]
```

### 3\. LinkedList의 요소 추가(add)

ArrayList에 요소를 추가하기 위하여 add 메서드를 사용할 수 있었다. add 메서드는 서로 다른 파라미터에 기반하여 여러개의 연산을 수행하기 위하여 오버로드(overloaded)되었습니다.

-   add(Object) : LinkedList의 끝쪽에 요소를 추가
-   add(int index, Object) : LinkedList의 index 위치에 요소를 추가

```
// LinkedList에 요소를 추가하는 예제
import java.util.*; 
    
public class GFG { 
    
    public static void main(String args[]) 
    { 
        LinkedList<String> ll = new LinkedList<>(); 
    
        ll.add("Geeks"); 
        ll.add("Geeks"); 
        ll.add(1, "For"); 
    
        System.out.println(ll); // Expected Output : [Geeks, For, Geeks]
    } 
}
```

```
Output 

[Geeks, For, Geeks]
```

### 4\. LinkedList의 요소 변경(set)

LinkedList에 요소를 추가한 이후 만약 특정 위치에 존재하는 노드의 값을 변경하고 싶다면 set 메서드를 사용하면 됩니다. LinkedList는 index로 접근하기 때문에 변경을 원하는 요소는 인덱스로 접근이 가능하다. 그러므로 set 메서드는 매개변수로 index와 변경을 원하는 값이 들어갑니다.

```
// LinkedList set 메서드 예제
import java.util.*; 
    
public class GFG { 
    
    public static void main(String args[]) 
    { 
        LinkedList<String> ll = new LinkedList<>(); 
    
        ll.add("Geeks"); 
        ll.add("Geeks"); 
        ll.add(1, "Geeks"); 
    
        System.out.println("Initial LinkedList " + ll); 	// Expected Output : [Geeks, Geeks, Geeks]
    
        ll.set(1, "For"); 
    
        System.out.println("Updated LinkedList " + ll); 	// Expected Output : [Geeks, For, Geeks]
    } 
}
```

```
Output

Initial LinkedList [Geeks, Geeks, Geeks]
Updated LinkedList [Geeks, For, Geeks]
```

### 5\. LinkedList의 요소 제거(remove)

LinkedList의 특정 위치에 존재하는 노드를 제거합니다. remove 메서드또한 add 메서드와 마찬가지로 매개변수의 타입에 따라서 다른 연산을 수행합니다. 매개변수의 타입이 정수인 경우 index번째 위치의 노드를 제거하고 타입이 Object인 경우 해당 Object 값인 노드를 탐색하고 제거합니다.

-   remove(Object) : LinkedList에서 해당 Object인 값을 탐색하여 제거합니다. 만약 연결리스트에 동일한 값의 Object가 다수 존재하면 첫번째로 만나는 Object값을 제거합니다.
-   remove(int index) : LinkedList에서 index번째에 위치하는 노드를 제거합니다. index는 0번째부터 시작합니다.

```
// LinkedList remove 메서드 예제    
import java.util.*; 
    
public class GFG { 
    
    public static void main(String args[]) 
    { 
        LinkedList<String> ll = new LinkedList<>(); 
    
        ll.add("Geeks"); 
        ll.add("Geeks"); 
        ll.add(1, "For"); 
    
        System.out.println( 
            "Initial LinkedList " + ll); 	// Expected Output : [Geeks, For, Geeks]
    
        ll.remove(1); 
    
        System.out.println( 
            "After the Index Removal " + ll); // Expected Output : [Geeks, Geeks]
    
        ll.remove("Geeks"); 
    
        System.out.println( 
            "After the Object Removal " + ll); // Expected Output : [Geeks]
    } 
}
```

```
Output

Initial LinkedList [Geeks, For, Geeks]
After the Index Removal [Geeks, Geeks]
After the Object Removal [Geeks]
```

### 6\. LinkedList의 순회

LinkedList의 모든 노드의 값을 참조하고 출력할 수 있습니다. 가장 대표적인 방법으로는 get 메서드와 같이 사용하는 반복문을 활용하는 방법입니다.

```
// LinkedList의 순회 예제    
import java.util.*; 
    
public class GFG { 
    
    public static void main(String args[]) 
    { 
        LinkedList<String> ll 
            = new LinkedList<>(); 
    
        ll.add("Geeks"); 
        ll.add("Geeks"); 
        ll.add(1, "For"); 
    
        // 반복문에서 get메서드를 통하여 순회
        for (int i = 0; i < ll.size(); i++) { 
    
            System.out.print(ll.get(i) + " "); // Expected Output : Geeks For Geeks
        } 
    
        System.out.println(); 
    
        // 각 루프에 대해서  사용
        for (String str : ll) 
            System.out.print(str + " "); 		// Expected Output : Geeks For Geeks
    } 
}
```

```
Output

Geeks For Geeks 
Geeks For Geeks
```

[##_Image|kage@baQUUi/btrfjVKbT00/9VJMDsJ1nU0BuARf8hbIuk/img.png|alignCenter|data-origin-width="702" data-origin-height="381" data-ke-mobilestyle="widthOrigin"|||_##]

위 그림에서 AbstractList, CopyOnWriteArrayList, AbstractSequentialList 클래스들은 List 인터페이스로부터 구현됨을 알수 있습니다.

### 7\. Java LinkedList의 메서드들

[https://www.geeksforgeeks.org/linked-list-in-java/](https://www.geeksforgeeks.org/linked-list-in-java/)

 [LinkedList in Java - GeeksforGeeks

A Computer Science portal for geeks. It contains well written, well thought and well explained computer science and programming articles, quizzes and practice/competitive programming/company interview Questions.

www.geeksforgeeks.org](https://www.geeksforgeeks.org/linked-list-in-java/)

### References

> https://www.geeksforgeeks.org/linked-list-in-java/