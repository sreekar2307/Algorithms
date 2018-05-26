package graph;

import java.util.ArrayList;
import java.util.Scanner;

// this code expects DAG

public class Topological_sort {
	static Stack_implementation stack = new Stack_implementation();
	static boolean flag= true;
	private static Scanner scan;
	static int TOPO[],index=0;
	public static void main(String[] args){
		 scan = new Scanner(System.in);
		 int no_of_nodes =6;
		 graph_node vertices[] = new graph_node[no_of_nodes];
		 for(int i=0;i<no_of_nodes;i++)
			 vertices[i]= new graph_node(i);
		 TOPO =new int [no_of_nodes];
		 vertices[5].add(1,2);
		 vertices[5].add(1,0);
		 vertices[4].add(1,0);
		 vertices[4].add(1,1);
		 vertices[2].add(1,3);
		 vertices[3].add(1,1); 
		 System.out.println("Select source Node");
		 int source = scan.nextInt();
		 int i=0;
		 depth_First_search(source,vertices,no_of_nodes);
		 while(i<no_of_nodes)
		 {
			 if(!vertices[i].color) {
				 flag=true;
				 depth_First_search(i,vertices,no_of_nodes);
			 }
			 i++;
		 }
		 for(i=no_of_nodes-1;i>=0;i--)
			 System.out.print(TOPO[i]+ " ");
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
			TOPO[index++]=stack.pop();
		}
		if(stack.get_size()!=0)
		 depth_First_search(stack.get_top(),A,no_of_nodes);
	  
   }
}
 class Stack_implementation implements stack{
	ArrayList<Integer> value=new ArrayList<>();
     public void push(int a) {
		value.add(a);
	}
	public int pop() {
		int temp =  value.get(value.size()-1);
		value.remove(value.size()-1);
		return temp;
	}
    boolean isFull(int size) {
    	return size==value.size();
    }
    int get_size(){
    	return value.size();
    }
    int get_top() {
    	return value.get(value.size()-1);
    }
}
interface stack {
 final int K=0;
 void push(int N);
 int pop();
 }