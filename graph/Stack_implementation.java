package graph;

import java.util.ArrayList;

public class Stack_implementation implements stack{
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
