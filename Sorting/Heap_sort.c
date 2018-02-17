#include <stdio.h>
#include <stdlib.h>
int Max_and_Swap(int A[],int i,int size){
 int max = i,temp;
 if(A[max]<A[2*i+1])
     max = 2*i+1;
 if(2*(i+1)<=size-1 && A[max]<A[2*(i+1)])
     max=2*(i+1);
  temp=A[i];
  A[i] =A[max];
  A[max]=temp;
 return max;
}
void heapify(int A[],int i,int size){

    if(2*i+1 <= size-1){
         int change_occurance = Max_and_Swap(A,i,size); // this function takes root, left child and right child compares swaps the
         if(i!=change_occurance)                        // root with the max of three
         heapify(A,change_occurance,size);   // recursion were the swap occurred
    }
}
void build_heap(int A[],int size){
     for(int i=size/2 - 1;i>=0;i--){  // started with size/2 as the rest will be leaves no heapify property is
       heapify(A,i,size);             // required
     }
}
int main()
{
     int A[] = {4,1,3,2,16,9,10,10,14,8,7,21,24};
     build_heap(A,sizeof(A)/sizeof(int));
     printf("After building the heap\n");
     for(int i=0;i<sizeof(A)/sizeof(int);i++)
        printf("%d ",A[i]);
     printf("\nAfter sorting \n");
     for(int i=0;i<sizeof(A)/sizeof(int)-1;i++)
     {
          int temp=A[0];
          A[0] =A[(sizeof(A)/sizeof(int))-1-i];
          A[(sizeof(A)/sizeof(int))-1-i]=temp;  // swap with last element with the first
          heapify(A,0,(sizeof(A)/sizeof(int))-1-i);  // restore the distorted  max heap property
     }
     for(int i=0;i<sizeof(A)/sizeof(int);i++)
        printf("%d ",A[i]);
     return 0;
}
