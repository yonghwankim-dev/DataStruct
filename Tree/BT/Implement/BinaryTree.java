package Tree.BT.Implement;

class Node
{
    int key;
    Node left, right;
 
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}
 
// 이진트리를 소개하기 위한 예제
class BinaryTree
{
    Node root;	// 루트 노드
 
    // 생성자
    BinaryTree(int key)
    {
        root = new Node(key);
    }
 
 	// 비어있는 트리
    BinaryTree()
    {
        root = null;
    }
 
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
 
        // 루트 노드 생성
        tree.root = new Node(1);
 
        /* 위의 명령문 이후 아래와 같이 트리 생성
 
              1
            /   \
          null  null     */
 
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
 
        /* 1의 자식노드로 2, 3 노드 생성
               1
            /     \
          2        3
        /   \     /  \
      null null null null  */
 
 
        tree.root.left.left = new Node(4);
        /* 4는 2의 왼쪽 자식 노드가 된다.
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */
    }
}