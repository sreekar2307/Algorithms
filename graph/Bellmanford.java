package graph;

import java.util.LinkedList;

public class Bellmanford {

	public static void main(String[] args) {
		int no_of_nodes=4;
		   LinkedList<edgelist_node> edgeList =new LinkedList<edgelist_node>();
		   	 
 
   edgeList.add(new edgelist_node(0,1,10));    // preparing the graph vertices[source_vertex_no].add(edge_length,Destination_vertex_no)
   edgeList.add(new edgelist_node(0,2,5));
   edgeList.add(new edgelist_node(1,2,3));
   edgeList.add(new edgelist_node(2,1,4));
   edgeList.add(new edgelist_node(2,3,1));
   edgeList.add(new edgelist_node(3,1,2));

	

	int d[] = new int[no_of_nodes]; 
   for(int i=0;i<no_of_nodes;i++)     //inital_distances
	 {
		 if(i!=0)
			 d[i]=Integer.MAX_VALUE;  
		 else
			 d[i]=0; 		 
	 }
   for(int j=0;j<no_of_nodes-1;j++) {
	   for(int i=0;i<edgeList.size();i++) {
		   
		   if(d[edgeList.get(i).u]+edgeList.get(i).weight<d[edgeList.get(i).v]) {
			   d[edgeList.get(i).v] = d[edgeList.get(i).u]+edgeList.get(i).weight;
		   }
	   }
   }
   for(int i=0;i<edgeList.size();i++) {
	   
	   if(d[edgeList.get(i).u]+edgeList.get(i).weight<d[edgeList.get(i).v]) {
		  System.out.println("Contains negative edge cycle");
	   }
   }
   
   for(int j=1;j<no_of_nodes;j++) {
	  if(d[j]!=Integer.MAX_VALUE)
	   System.out.println("From source node to vertex "+j +" is "+d[j]);
	  else 
	   System.out.println("No path from source node to j vertex");
   }
	
	}
}
class edgelist_node{
	int u,v,weight;
	edgelist_node(int u ,int v,int weight){
		this.u = u;
		this.v=v;
		this.weight=weight;
	}
}
