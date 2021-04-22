package DFS.�������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;





/**
 * @title DFS(Depth First Search)
 * @comment
 * 	��������� �̿��� DFS ����
 *
 */
public class DfsGraph {
	private int nV;				// ������ ����
	private int[][] dfsGraph;	// �׷���
	private boolean[] visitArr;	// ���� �湮 ���� Ȯ�� �迭
	
	// �׷��� �ʱ�ȭ
	public DfsGraph(int nV)
	{
		this.nV = nV;
		
		/**
		 * �׷��� �ʱ�ȭ
		 * put(int x, int y)���� �ԷµǴ� ������ ���� 0 �̻��� �����̳�
		 * �迭�� index�� 0���� �����̹Ƿ� ArrayIndexOutOfBoundsException ������ ����
		 * ������ ��� �����ؿ��� ��� �� size�� 1�� ���Ͽ� �ʱ�ȭ�Ѵ�.
		 */
		this.dfsGraph = new int[this.nV+1][this.nV+1];
		
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
	public int[][] getGraph()
	{
		return this.dfsGraph;
	}
	
	/**
	 * �׷��� �߰�(�����)
	 * @param x ���� ���
	 * @param y ���� ���
	 */
	public void put(int x, int y)
	{
		this.dfsGraph[x][y] = this.dfsGraph[y][x] = 1;
	}
	
	/**
	 * �׷��� �߰�(�ܹ���)
	 * @param x ���� ���
	 * @param y ���� ���
	 */
	public void putSingle(int x, int y)
	{
		this.dfsGraph[x][y] = 1;
	}
	
	/**
	 * �׷��� ���(�������)
	 */
	public void printGraphToAdjArr()
	{
		for(int i=0;i<this.dfsGraph.length;i++)
		{
			for(int j=0;j<this.dfsGraph[i].length;j++)
			{
				System.out.print(" " + this.dfsGraph[i][j]);
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
		
		// ���� ��ķ� ������ �׷������� ������ ����(nV) ��ŭ Ž��
		for(int i=1;i<=this.nV;i++)
		{
			// dfsGraph[][]�� �ش� ������ ����Ǿ� �ִ� ������ ǥ�õǾ� ������ (������ 1�� ǥ��)
			// �湮 �迭���� �湮���� ���� ����(false)�� ��� dfs ��� ȣ�� ����
			if(dfsGraph[vIdx][i]==1 && visitArr[i] == false)
			{
				dfs(i);	// dfs() ��� ȣ��
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
