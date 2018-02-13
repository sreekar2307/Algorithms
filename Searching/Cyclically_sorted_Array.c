#include <stdio.h>
#include <stdlib.h>
  int n;
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
int * Cyclic_array(int *A){
  int random_pivot = (rand()%(n-1)) + 1;
  printf("\n\nthe random pivot position is %d\n",random_pivot-1);
  int *temp1 = calloc(random_pivot,sizeof(int));
  int *temp2 = calloc(n-random_pivot,sizeof(int));
  int j = n - random_pivot;
  for(int i=0;i<random_pivot&&j<n;i++){
    temp1[i]=A[j];
    j++;
  }
  j=0;
  for(int i=0;i<n-random_pivot;i++){
    temp2[i]=A[j];
    j++;
  }  printf("\nThe cyclic array that is generated\n");j=0;
   for(int i=0;i<n;i++){
    if(i<random_pivot)
        A[i]=temp1[i];
    else
      {
            A[i]=temp2[j];
            j++;
      }
    printf("%d ",A[i]);
   }
   printf("\n");
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

int find_pivot(int *A,int l ,int u){
  if(l<=u){
    int mid = (l+u)/2;
 if(A[mid]>A[mid+1])
   return mid;
 else if(A[mid]<A[mid-1])
   return mid-1;
 else if(A[l]>A[mid])
   find_pivot(A,l,mid-1);
 else
   find_pivot(A,mid+1,n-1);
  }
  else{
    return -1;
  }
}

int search(int a,int *A){
   int pivot = find_pivot(A,0,n-1);
   printf("%d the pivot point after searching in the cyclic array\n",pivot);
   if(A[pivot]==a)
   return pivot;
   else if(a<A[0])
   return binarySearch(A,pivot+1,n,a);
   else if(a>A[0])
   return binarySearch(A,0,pivot-1,a);
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
  A = Cyclic_array(A);
  printf("\n%d is the location of the %d given in a cyclically sorted array\n",search(95,A),95);
 return 0;
}
