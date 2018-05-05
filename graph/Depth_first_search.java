package graph;

import java.util.ArrayList;
import java.util.Scanner;
public class Depth_first_search {
	static Stack_implementation stack = new Stack_implementation();
	static boolean flag= true;
	private static Scanner scan;
	public static void main(String[] args){
		 scan = new Scanner(System.in);
		 System.out.println("Enter no of nodes");
		 int no_of_nodes =  scan.nextInt();
		 graph_node vertices[] = new graph_node[no_of_nodes];
		 for(int i=0;i<no_of_nodes;i++) {
			 graph_node temp = new graph_node(i);
			 vertices[i]=temp;
			 for(int k=0;k<no_of_nodes;k++) {
   				 System.out.println("Enter the weight of the edge from "+i+" to node "+k);
   				 int weight =scan.nextInt();
   				 if(weight!=0)
   				  temp.add(weight,k);
			 }
  }	
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
}
	static void depth_First_search(int v,graph_node A[],int no_of_nodes){
        boolean all_ajacent_vertices_searched = true;
		if(flag) {
			flag=false;
			stack.push(v);
			A[v].color = true;
		}
		int k;
		for(k=0;k<A[v].ajacent_edges.size();k++)
		{
			if(!A[A[v].ajacent_edges.get(k).vertex_no].color)
			 {
				stack.push(A[v].ajacent_edges.get(k).vertex_no);
				A[A[v].ajacent_edges.get(k).vertex_no].color = true;
				all_ajacent_vertices_searched = false ;
				break;
			 }
		}
		if(all_ajacent_vertices_searched && stack.get_size()!=0)
		{
			System.out.print(stack.pop()+" ");
		}
		if(stack.get_size()!=0)
		 depth_First_search(stack.get_top(),A,no_of_nodes);
	  
   }
}
class graph_node{
  int vertex;
  boolean color=false;
  ArrayList<temp> ajacent_edges = new ArrayList<temp>();
	graph_node(int vertex){
		this.vertex = vertex;		
	}
	 class temp{
		int edge_length;int vertex_no;
		temp(int edge_length ,int vertex_no){
			this.edge_length = edge_length;
			this.vertex_no = vertex_no;
		}
	}
	void add(int edge_length,int vertex_no){
		temp temp1 = new temp(edge_length , vertex_no);
		ajacent_edges.add(temp1);
	}
}
