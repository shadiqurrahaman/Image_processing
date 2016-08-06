package du.iit.dhaka;

import java.util.ArrayList;

public class RecartionDFS {
	
	 ArrayList<Integer> path=new ArrayList<Integer>();
	 public static void dfs(int i,int[][] mat,boolean[] vi){
		 
		 int j;
		 
		 vi[i]=true;
		 System.out.println(i);
		 for(j=0;j<mat.length;j++){
			 if(mat[i][j]>0 && !vi[j]){
				 dfs(j,mat,vi);
			 }
		 }
		 
	 }
	public static void main(String[] args) {
		int[][] Graph = {  { 0, 1, 0, 1, 0, 0, 0, 0, 1 },  // 0
				{ 1, 0, 0, 0, 0, 0, 0, 1, 0 },  // 1
				{ 0, 0, 0, 1, 0, 1, 0, 1, 0 },  // 2
				{ 1, 0, 1, 0, 1, 0, 0, 0, 0 },  // 3
				{ 0, 0, 0, 1, 0, 0, 0, 0, 1 },  // 4
				{ 0, 0, 1, 0, 0, 0, 1, 0, 0 },  // 5
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0 },  // 6
				{ 0, 1, 1, 0, 0, 0, 0, 0, 0 },  // 7
				{ 1, 0, 0, 0, 1, 0, 0, 0, 0 } };// 8
		
		 int[][]  adjMatrix=new int[Graph.length][Graph.length];
		 boolean[] visited=new boolean[Graph.length];
		ArrayList<Integer> path=new ArrayList<Integer>();
		
		 for (int i = 0; i <  adjMatrix.length; i++) {
			for (int j = 0; j <  adjMatrix.length; j++) {
				
				adjMatrix[i][j]=Graph[i][j];
			}
		}
		 
		 dfs(0,adjMatrix,visited);
		
	}

}
