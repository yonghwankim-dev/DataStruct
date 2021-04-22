package DFS.��������Ʈ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;





/**
 * @title DFS(Depth First Search)
 * @comment
 * 	��������Ʈ�� �̿��� DFS ����
 *
 */
public class DfsGraph {
	private int nV;				// ������ ����
	private ArrayList<ArrayList<Integer>> dfsGraph;	// �׷���
	private boolean[] visitArr;	// ���� �湮 ���� Ȯ�� �迭
	
	// �׷��� �ʱ�ȭ
	public DfsGraph(int nV)
	{
		this.nV = nV;
		this.dfsGraph = new ArrayList<ArrayList<Integer>>();	// �׷��� ����
		/**
		 * �׷��� �ʱ�ȭ
		 * put(int x, int y)���� �ԷµǴ� ������ ���� 0 �̻��� �����̳�
		 * �迭�� index�� 0���� �����̹Ƿ� ArrayIndexOutOfBoundsException ������ ����
		 * ������ ��� �����ؿ��� ��� �� size�� 1�� ���Ͽ� �ʱ�ȭ�Ѵ�.
		 * 
		 * ex) initSize=3
		 * graph[0]
		 * graph[1] -> 2 -> 3
		 * graph[2] -> 1 -> 3 -> 4
		 * graph[3] -> 1 -> 2 -> 4 -> 5
		 */
		for(int i=0;i<this.nV+1;i++)
		{
			this.dfsGraph.add(new ArrayList<Integer>());
		}
		
		/**
		 * ���� �湮 ���� Ȯ�� �迭 �ʱ�ȭ
		 * �׷����� ���������� ������ ������ +1�Ͽ� �ʱ�ȭ
		 */
		this.visitArr = new boolean[this.nV+1];
		
	}
	
	/**
	 * �׷��� ��ȯ
	 * @return dfsGraph
	 */
	public ArrayList<ArrayList<Integer>> getGraph()
	{
		return this.dfsGraph;
	}
	
	/**
	 * 
	 * @param i	���� ���
	 * @return ArrayList<Integer> ���� ���
	 */
	public ArrayList<Integer> getNode(int i)
	{
		return this.dfsGraph.get(i);
	}
	
	/**
	 * �׷��� �߰�(�����)
	 * @param x ���� ���
	 * @param y ���� ���
	 */
	public void put(int x, int y)
	{
		this.dfsGraph.get(x).add(y);
		this.dfsGraph.get(y).add(x);
	}
	
	/**
	 * �׷��� �߰�(�ܹ���)
	 * @param x ���� ���
	 * @param y ���� ���
	 */
	public void putSingle(int x, int y)
	{
		this.dfsGraph.get(x).add(y);
	}
	
	/**
	 * �׷��� ���(��������Ʈ)
	 */
	public void printGraphToAdjArr()
	{
		for(int i=1;i<this.dfsGraph.size();i++)
		{
			System.out.printf("���� %d�� ��������Ʈ", i);
			
			for(int j=0;j<this.dfsGraph.get(i).size();j++)
			{
				System.out.printf(" -> %d", this.dfsGraph.get(i).get(j));
			}
			System.out.println();
			
		}
	}
	
	/**
	 * ���� �湮 ���� Ȯ�� �迭 �ʱ�ȭ
	 */
	public void clearVisitArr()
	{
		for(int i=0;i<this.visitArr.length;i++)
		{
			this.visitArr[i] = false;
		}
	}
	
	/**
	 * �׷��� Ž�� (���ȣ��)
	 */
	public void dfs(int vIdx)
	{
		// dfs()�� ���� vIdx�� �湮�� ���̹Ƿ�
		// �湮�迭�� �ش� index���� true�� �ٲ��ְ� ���� �����
		this.visitArr[vIdx] = true;
		System.out.print(vIdx + " ");
		
		// ��������Ʈ�� ������ �׷������� �ش� index�� �´� ����Ʈ�� �����ͼ� �ݺ�
		for(int i : this.dfsGraph.get(vIdx))
		{
			// �ش� ����(i)�� ���� �湮 ���� Ȯ�� �迭���� �湮���� ���� ����(false)�� ���
			if(this.visitArr[i]==false)
			{
				dfs(i);	// dfs() ���ȣ��
			}
		}

	}
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		int nV = 0;	// ���� ����
		int nE = 0; // ���� ����
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("������ ������ �Է����ּ��� : ");
		nV = Integer.parseInt(br.readLine());	// ����
		System.out.print("������ ������ �Է����ּ��� : ");
		nE = Integer.parseInt(br.readLine());	// ����
		
		// ���� ������ŭ �׷��� �ʱ�ȭ
		DfsGraph dfsGraph = new DfsGraph(nV);
		
		// �׷����� ������ ���� �Է�
		// �Է¹��� ������ ������ŭ �ݺ�
		// ex) ���� 8, ���� 10
		dfsGraph.put(1, 2);
		dfsGraph.put(1, 3);
		dfsGraph.put(2, 4);
		dfsGraph.put(2, 5);
		dfsGraph.put(3, 6);
		dfsGraph.put(3, 7);
		dfsGraph.put(4, 8);
		dfsGraph.put(5, 8);
		dfsGraph.put(6, 8);
		dfsGraph.put(7, 8);
		
		br.close();
		
		// �Է��� ������ �������� ������ ������� ���
		dfsGraph.printGraphToAdjArr();
		
		for(int i=1;i<=nV;i++)
		{
			System.out.println();
			System.out.printf("���� %d���� Ž�� : ", i);
			dfsGraph.clearVisitArr();
			dfsGraph.dfs(i);
		}
	}
	
}
