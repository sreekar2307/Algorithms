package graph;
import java.util.Scanner;
public class Depth_first_search {
	static Stack_implementation stack = new Stack_implementation();
	static boolean flag= true;
	static int time =0,index=0;
	static int DFS[];
	private static Scanner scan;
	public static void main(String[] args){
		 scan = new Scanner(System.in);
		 int no_of_nodes = 8;
		 graph_node vertices[] = new graph_node[no_of_nodes];
		 for(int i=0;i<no_of_nodes;i++)
			 vertices[i]= new graph_node(i);
         DFS = new int [no_of_nodes];
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
				 flag=true;
				 System.out.printf("Detected non_connected component\n");
				 depth_First_search(i,vertices,no_of_nodes);
			 }
			 i++;
		 }
		System.out.println("When the DFS is ");
		for(int j=0;j<no_of_nodes;j++)
		 System.out.print(DFS[j]+" ");
}
	static void depth_First_search(int v,graph_node A[],int no_of_nodes){
		time++;
        boolean all_ajacent_vertices_searched = true;
		if(flag) {
			flag=false;
			stack.push(v);
			A[v].color = true;
			A[v].in_time=time;
		}
		int k;
		for(k=0;k<A[v].ajacent_edges.size();k++)
		{
			if(!A[A[v].ajacent_edges.get(k).vertex_no].color)
			 {
				stack.push(A[v].ajacent_edges.get(k).vertex_no);
				A[A[v].ajacent_edges.get(k).vertex_no].color = true;
				A[A[v].ajacent_edges.get(k).vertex_no].vertex_parent=v;
				all_ajacent_vertices_searched = false ;
				break;
			 }
			else if(A[v].vertex_parent!=A[v].ajacent_edges.get(k).vertex_no && A[A[v].ajacent_edges.get(k).vertex_no].out_time==0) {
				System.out.println("back edge from "+v+" to "+A[v].ajacent_edges.get(k).vertex_no);
			}
		}
		if(all_ajacent_vertices_searched && stack.get_size()!=0)
		{
			DFS[index++]=stack.pop();
			A[v].out_time=time;
		}
		if(stack.get_size()!=0)
		 depth_First_search(stack.get_top(),A,no_of_nodes);
	  
   }
}