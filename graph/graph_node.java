package graph;
import java.util.ArrayList;
class graph_node{
	  int vertex;
	  boolean color=false;
	  int vertex_parent=-1;
	  int Leaps_from_parent;
	  int in_time=0;
	  int out_time=0;
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
