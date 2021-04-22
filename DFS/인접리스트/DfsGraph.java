package DFS.인접리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;





/**
 * @title DFS(Depth First Search)
 * @comment
 * 	인접리스트를 이용한 DFS 구현
 *
 */
public class DfsGraph {
	private int nV;				// 정점의 개수
	private ArrayList<ArrayList<Integer>> dfsGraph;	// 그래프
	private boolean[] visitArr;	// 정점 방문 여부 확인 배열
	
	// 그래프 초기화
	public DfsGraph(int nV)
	{
		this.nV = nV;
		this.dfsGraph = new ArrayList<ArrayList<Integer>>();	// 그래프 생성
		/**
		 * 그래프 초기화
		 * put(int x, int y)에서 입력되는 정점의 값은 0 이상의 정수이나
		 * 배열의 index는 0부터 시작이므로 ArrayIndexOutOfBoundsException 방지를 위해
		 * 정점을 담는 인접해열의 행과 열 size는 1을 더하여 초기화한다.
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
		 * 정점 방문 여부 확인 배열 초기화
		 * 그래프와 마찬가지로 정점의 개수에 +1하여 초기화
		 */
		this.visitArr = new boolean[this.nV+1];
		
	}
	
	/**
	 * 그래프 반환
	 * @return dfsGraph
	 */
	public ArrayList<ArrayList<Integer>> getGraph()
	{
		return this.dfsGraph;
	}
	
	/**
	 * 
	 * @param i	정점 노드
	 * @return ArrayList<Integer> 정점 노드
	 */
	public ArrayList<Integer> getNode(int i)
	{
		return this.dfsGraph.get(i);
	}
	
	/**
	 * 그래프 추가(양방향)
	 * @param x 정점 노드
	 * @param y 정점 노드
	 */
	public void put(int x, int y)
	{
		this.dfsGraph.get(x).add(y);
		this.dfsGraph.get(y).add(x);
	}
	
	/**
	 * 그래프 추가(단방향)
	 * @param x 정점 노드
	 * @param y 정점 노드
	 */
	public void putSingle(int x, int y)
	{
		this.dfsGraph.get(x).add(y);
	}
	
	/**
	 * 그래프 출력(인접리스트)
	 */
	public void printGraphToAdjArr()
	{
		for(int i=1;i<this.dfsGraph.size();i++)
		{
			System.out.printf("정점 %d의 인접리스트", i);
			
			for(int j=0;j<this.dfsGraph.get(i).size();j++)
			{
				System.out.printf(" -> %d", this.dfsGraph.get(i).get(j));
			}
			System.out.println();
			
		}
	}
	
	/**
	 * 정점 방문 여부 확인 배열 초기화
	 */
	public void clearVisitArr()
	{
		for(int i=0;i<this.visitArr.length;i++)
		{
			this.visitArr[i] = false;
		}
	}
	
	/**
	 * 그래프 탐색 (재귀호출)
	 */
	public void dfs(int vIdx)
	{
		// dfs()에 들어온 vIdx는 방문한 것이므로
		// 방문배열의 해당 index값을 true로 바꿔주고 값을 출력함
		this.visitArr[vIdx] = true;
		System.out.print(vIdx + " ");
		
		// 인접리스트로 구현된 그래프에서 해당 index에 맞는 리스트를 가져와서 반복
		for(int i : this.dfsGraph.get(vIdx))
		{
			// 해당 정점(i)이 정점 방문 여부 확인 배열에서 방문하지 않은 상태(false)인 경우
			if(this.visitArr[i]==false)
			{
				dfs(i);	// dfs() 재귀호출
			}
		}

	}
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		int nV = 0;	// 정점 개수
		int nE = 0; // 간선 개수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("정점의 개수를 입력해주세요 : ");
		nV = Integer.parseInt(br.readLine());	// 정점
		System.out.print("간선의 개수를 입력해주세요 : ");
		nE = Integer.parseInt(br.readLine());	// 간선
		
		// 정점 개수만큼 그래프 초기화
		DfsGraph dfsGraph = new DfsGraph(nV);
		
		// 그래프에 정점과 간선 입력
		// 입력받은 간선의 개수만큼 반복
		// ex) 정점 8, 간선 10
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
		
		// 입력한 정점과 간선으로 구성된 인접행렬 출력
		dfsGraph.printGraphToAdjArr();
		
		for(int i=1;i<=nV;i++)
		{
			System.out.println();
			System.out.printf("정점 %d부터 탐색 : ", i);
			dfsGraph.clearVisitArr();
			dfsGraph.dfs(i);
		}
	}
	
}
