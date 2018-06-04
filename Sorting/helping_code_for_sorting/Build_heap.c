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
int main()
{
     int A[] = {4,1,3,2,16,9,10,14,8,7,21,24};
     for(int i=sizeof(A)/(2*sizeof(int))-1;i>=0;i--){  // started with size/2 as the rest will be leaves no heapify property is
       heapify(A,i,sizeof(A)/sizeof(int));             // required
     }
     for(int i=0;i<sizeof(A)/sizeof(int);i++)
        printf("%d ",A[i]);
     return 0;
}
