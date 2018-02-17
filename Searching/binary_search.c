#include <stdio.h>
#include <stdlib.h>
int * sorted_array(int *A){
  for(int i=0;i<n;i++){
    for(int j=i+1;j<n;j++){
       if(A[i]>A[j]){
        int temp = A[i];
        A[i] = A[j];
        A[j]=temp;
       }
    }
  }
 return A;
}
int binarySearch(int *A,int l,int u,int key){
   if(l<=u){
   int mid = (l+u)/2;
   if(A[mid]==key)
   return mid;
   else if(A[mid]>key)
   binarySearch(A,l,mid-1,key);
   else
   binarySearch(A,mid+1,u,key);
   }
else
  return -1;
}
int main(){
  scanf("%d",&n);
  int * A = calloc(n,sizeof(int));
  printf("The unsorted array\n");
  for(int i=0;i<n;i++)
    {
       A[i]= rand()%100 + 1;
       printf("%d ",A[i]);
    }
  A =  sorted_array(A);
  printf("\nThe sorted array\n");
  for(int i=0;i<n;i++){
    printf("%d ",A[i]);
  }
  printf("\n%d is the location of the %d given in a normal sorted array",binarySearch(A,0,n-1,84),84);
 return 0;
}
