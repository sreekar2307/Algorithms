package graph;
import java.util.Scanner;
public class Depth_first_search {
	static int time =0;
	private static Scanner scan;
	public static void main(String[] args){
		 scan = new Scanner(System.in);
		 int no_of_nodes = 8;
		 graph_node vertices[] = new graph_node[no_of_nodes];
		 for(int i=0;i<no_of_nodes;i++)
			 vertices[i]= new graph_node(i);
		 vertices[0].add(1,1);
		 vertices[0].add(1,4);
		 vertices[1].add(1,0);
		 vertices[1].add(1,5);
		 vertices[2].add(1,3);
		 vertices[2].add(1,5);
		 vertices[2].add(1,6);
		 vertices[3].add(1,2);
		 vertices[3].add(1,7);
		 vertices[4].add(1,0);
		 vertices[5].add(1,1);
		 vertices[5].add(1,2);
		 vertices[5].add(1,6);
		 vertices[6].add(1,2);
		 vertices[6].add(1,5);
		 vertices[6].add(1,7);
		 vertices[7].add(1,6);
		 vertices[7].add(1,3);
		 
		 System.out.println("Select source Node");
		 int source = scan.nextInt();
		 
		 int i=0;
		 depth_First_search(source,vertices,no_of_nodes);
		 while(i<no_of_nodes-1)
		 {
			 if(!vertices[i].color) {
				 System.out.printf("Detected non_connected component\n");
				 depth_First_search(i,vertices,no_of_nodes);
			 }
			 i++;
		 }
	DFS_tree(vertices,no_of_nodes); 
}
	static void depth_First_search(int v,graph_node A[],int no_of_nodes){
		time++;
        A[v].color=true;
		A[v].in_time=time;
		int k;
		for(k=0;k<A[v].ajacent_edges.size();k++)
		{
			if(!A[A[v].ajacent_edges.get(k).vertex_no].color)
			 {
				A[A[v].ajacent_edges.get(k).vertex_no].vertex_parent=v;
				depth_First_search(A[v].ajacent_edges.get(k).vertex_no,A,no_of_nodes);
			 }
			else if(A[v].vertex_parent!=A[v].ajacent_edges.get(k).vertex_no && A[A[v].ajacent_edges.get(k).vertex_no].out_time==0) {
				System.out.println("back edge from "+v+" to "+A[v].ajacent_edges.get(k).vertex_no);
			}
		}
		A[v].out_time=time;
		 	  
   }
	 static void DFS_tree(graph_node A[],int no_of_nodes) {
		 System.out.println();
	 for(int i=0;i<no_of_nodes;i++)
		 {
			 if(A[i].vertex_parent!=-1)
			 System.out.println("Parent of vertex "+i+" is "+A[i].vertex_parent +" IN_time is "+A[i].in_time+" OUT_time is "+A[i].out_time);
			 else
				 System.out.println(i+" is a root node"+" IN_time is "+A[i].in_time+" OUT_time is "+A[i].out_time);	 
		 }
		 
	 }
}