package com.ssafy.live;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_BJ_4485_녹색옷입은애가젤다지 {
    static int N; //가로세로 길이
    static int [][]map; //데이터 저장 배열
    static int [][]distance;//최단거리 저장(최소비용)
//    static int result;//결과 데이터 저장
    
    static int[]dy= {-1,1, 0,0};
    static int[]dx= { 0,0,-1,1};
                  //상하좌우 (인접경로)
	
	public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
       
	   int no=0;
	   while(true) {//테스트 케이스 반복
		  N=sc.nextInt();
		  
		  if(N==0) break; //종료조건
		  
		  map = new int[N][N];
		  distance = new int[N][N];
		  
		  //데이터 입력
		  for(int i=0; i<N; i++) {
			  for(int j=0; j<N; j++) {
				  map[i][j]= sc.nextInt();
//				  distance[i][j]=Integer.MAX_VALUE;
			  }
			  Arrays.fill(distance[i], Integer.MAX_VALUE);
		  }
		  
		  //알고리즘 구현
//		  solve();
		  
		  System.out.println("Problem "+ ++no +": "+solve());
		   
	   }//while
	   
	   sc.close();
	}//main
	
	private static int solve() {
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	     pq.offer(new Node(0,0,map[0][0]));//시작위치 저장(최상단 맨좌측)
	    distance[0][0]= map[0][0];
		
	    while(!pq.isEmpty()){ //큐에 Node가 존재한다면
	    	Node node = pq.poll();//최소거리(최소비용)의 Node
	    	
	    	if(distance[node.row][node.col] == Integer.MAX_VALUE ) {//방문했는지 , 처리는 했는지
	    		continue;
	    	}
	    	
	    	for(int i=0; i<4; i++) {//(사방)인접한 곳 이동
	    		int ny = node.row + dy[i];
	    		int nx = node.col + dx[i];
	    		if(ny<0 || ny>= N ||  nx<0 ||  nx>=N) continue;
	    		//if(ny>=0 && ny< N &&  nx>=0 &&  nx<N) {실행}
	    	
	    		if( distance[ny][nx]  >  distance[node.row][node.col] + map[ny][nx]   ) {//최소거리(비용) 발견시
	    			distance[ny][nx] = distance[node.row][node.col] + map[ny][nx];
	    			pq.offer(new Node(ny,nx, map[ny][nx]));
	    		}
	    	}
	    }
//	    result = distance[N-1][N-1];//도착지의 결과값 저장
	    return distance[N-1][N-1];//도착지의 결과값 저장
	}//solve
	
    static class Node implements Comparable<Node>{ //현재위치와 비용을 저장하는 객체
    	int row;
    	int col;
    	int cost;//비용(거리)
    	
		public Node(int row, int col, int cost) {
			super();
			this.row = row;
			this.col = col;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost; //비용 오름차순 정렬
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [row=");
			builder.append(row);
			builder.append(", col=");
			builder.append(col);
			builder.append(", cost=");
			builder.append(cost);
			builder.append("]");
			return builder.toString();
		} 
		
		
    }
}//end class













