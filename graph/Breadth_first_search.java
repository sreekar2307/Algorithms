package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Breadth_first_search {
	 static queue Q = new queue();	 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
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
		 Q.enqueue(source);
		vertices[source].color=true;
		 breath_first_search(source,vertices,no_of_nodes);
		for(int i=0;i<no_of_nodes;i++)
		{
			
			if(!vertices[i].color)
			{
				System.out.println("Disconnected component");
				breath_first_search(i,vertices,no_of_nodes);
			}
		}
}
static void breath_first_search(int v,graph_node A[],int no_of_nodes) {
	for(int i=0;i<A[v].ajacent_edges.size();i++) 
	{
		if(!A[A[v].ajacent_edges.get(i).vertex_no].color)
		{
			Q.enqueue(A[v].ajacent_edges.get(i).vertex_no);
			A[A[v].ajacent_edges.get(i).vertex_no].color=true;
		}
	}
	System.out.print(Q.dequeue()+" ");
	if(!Q.Isempty())
	breath_first_search(Q.getTop(),A,no_of_nodes);
 }
}

class queue {
	 private ArrayList<Integer> Array = new ArrayList<Integer>();
	  void enqueue(int i) {
		  Array.add(i);
	  }
	  int dequeue() {
		  return Array.remove(0);
	  }
	  int getTop() {
		  return Array.get(0);
	  }
	  boolean Isempty() {
		return Array.isEmpty();  
	  } 
}

