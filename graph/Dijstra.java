package graph;

import java.util.LinkedList;
/*
 *  Dijstra's Algorithm finds Shortest distance from source vertex to all the other vertices in the graph
 *  if no path prints INF as the distance  
 */

public class Dijstra {
	  static int no_of_nodes = 5;
	  static int position_pointer[] = new int[no_of_nodes];  // this array plays a role of locating the vertex's position in the heap
	  
	public static void main(String[] args){
		 graph_node vertices[] = new graph_node[no_of_nodes];
		 for(int i=0;i<no_of_nodes;i++)
			 vertices[i]= new graph_node(i);
		 
    LinkedList<heap_node> d  = new LinkedList<heap_node>();  // This is the linked list were the final correct distance is available 
    position_pointer[0]=0;
    vertices[0].add(4,1);    // preparing the graph vertices[source_vertex_no].add(edge_length,Destination_vertex_no)
    vertices[0].add(2,2);
    vertices[1].add(3,3);
    vertices[2].add(1,4);
    vertices[2].add(1,1);
    vertices[3].add(3,2);
    vertices[3].add(6,4);
    vertices[4].add(2,2);
	 for(int i=0;i<no_of_nodes;i++)     // preparing the heap with initial values
	 {
		    heap_node temp = new heap_node();
		    temp.vertex_no=i;
		 if(i!=0)
			 temp.distance=Integer.MAX_VALUE;  
		 else
			 temp.distance=0; 
		 d.add(i, temp); 
		 position_pointer[i]=i;		 
	 }
	 
     int heap_size=no_of_nodes;
     build_heap(d,heap_size,position_pointer);  
     
      while(heap_size!=1) {  // This is runs in order  O((|V|+|E|)*Log(|V|))   were Log|V| compensates for extract_min and Rev_heapify
    	 heap_node min_pos = extract_min(d,heap_size);   
    	 heap_size--; 
    	 
//    	 Relaxing all the adjacent edges for the extracted min_vertex
    	 
    	 for(int i=0;i<vertices[min_pos.vertex_no].ajacent_edges.size();i++) {
    		 if(vertices[min_pos.vertex_no].ajacent_edges.get(i).edge_length + min_pos.distance < d.get(position_pointer[vertices[min_pos.vertex_no].ajacent_edges.get(i).vertex_no]).distance) {
    			 d.get(position_pointer[vertices[min_pos.vertex_no].ajacent_edges.get(i).vertex_no]).distance = vertices[min_pos.vertex_no].ajacent_edges.get(i).edge_length + min_pos.distance;	 
    	
//       now as the d[v] value changes the min_heap properties may be violated so hence Rev_heapify is required 
//    		were the first parameter is the heap itself second parameter gives the location for the changed d value in the heap
    			 Rev_heapify(d,position_pointer[vertices[min_pos.vertex_no].ajacent_edges.get(i).vertex_no],heap_size);
    		 }
    	 }
     }
 	 for(int j=0;j<no_of_nodes;j++)
 	 {
 		if(d.get(position_pointer[j]).distance!=Integer.MAX_VALUE) 
 		 System.out.println("Distance from source node to vertex "+j+" is "+d.get(position_pointer[j]).distance); 
 		else
         System.out.println("Distance from source node to vertex "+j+" is INF");	
 	 }
 	 
}	
		
	static int Min_and_Swap(LinkedList<heap_node> A,int i,int size){
		 int min = i,temp;
		 if(A.get(min).distance>A.get(2*i+1).distance)
		     min = 2*i+1;
		 if(2*(i+1)<=size-1 && A.get(min).distance>A.get(2*(i+1)).distance)
		     min=2*(i+1);
		  temp=A.get(i).distance;
		  A.get(i).distance =A.get(min).distance;
		  A.get(min).distance=temp;
		  
		  temp=A.get(i).vertex_no;
		  
		  position_pointer[A.get(i).vertex_no] = min;   //  to keep track of the vertex position in heap
		  position_pointer[A.get(min).vertex_no] = i;    //  to keep track of the vertex position in heap
		 
		  A.get(i).vertex_no =A.get(min).vertex_no;
		  A.get(min).vertex_no=temp;
		 
		   return min;
		}
	static int Rev_min_and_Swap(LinkedList<heap_node> A,int i) {
		 int min = i,temp;
		 if(A.get(i).distance<A.get(i/2).distance)
		     min = i/2;
		  temp=A.get(i).distance;
		  A.get(i).distance =A.get(min).distance;
		  A.get(min).distance=temp;		  
		  temp=A.get(i).vertex_no;
		  position_pointer[A.get(i).vertex_no] = min;
		  position_pointer[A.get(min).vertex_no] = i;
		  A.get(i).vertex_no =A.get(min).vertex_no;
		  A.get(min).vertex_no=temp;
		 return min;
	 }
		static void heapify(LinkedList<heap_node> A,int i,int size){
		    if(2*i+1 <= size-1){
		         int change_occurance = Min_and_Swap(A,i,size);
		         if(i!=change_occurance)                  
		         heapify(A,change_occurance,size);
		    }
		}
		static void Rev_heapify(LinkedList<heap_node> A,int i,int size) {
		    if(i != 0){
		         int change_occurance = Rev_min_and_Swap(A,i);
		         if(i!=change_occurance)                  
		        	 Rev_heapify(A,change_occurance,size);
		     }
		}	
		static heap_node extract_min(LinkedList<heap_node> A,int size){
			heap_node temp= new heap_node();
			temp.distance = A.get(0).distance;
			temp.vertex_no = A.get(0).vertex_no;
			position_pointer[A.get(0).vertex_no] = size-1;
			position_pointer[A.get(size-1).vertex_no] = 0;
			A.get(0).distance = A.get(size-1).distance;
			A.get(0).vertex_no =A.get(size-1).vertex_no;
			A.get(size-1).distance =temp.distance;
			A.get(size-1).vertex_no = temp.vertex_no;
			size = size -1;
			heapify(A,0,size);
			return temp;
		}
		static void build_heap(LinkedList<heap_node> A,int size,int pos[]) {
	     for(int i=A.size()-1;i>=0;i--)
	         heapify(A,i,A.size());
	    }
}
 class heap_node{
	int vertex_no;
	int distance;
}
