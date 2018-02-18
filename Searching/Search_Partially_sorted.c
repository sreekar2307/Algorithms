#include <stdio.h>
/*Searching  for an element in a partially sorted array
partially sorted array is the one in which there will be n/k blocks in a n elements unsorted array with each
block containing k elements within and are unsorted, all elements in the ith block are lesser compared to (i+1)th block
expected complexity O(2*k +log(n/k)) => O(k)
** here k is known
*/
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
  return l;
}
int main()
{
    int A[] = {7,5,3,10,17,9,20,19,18,27,22,25}; // here there are 3 blocks with 3 elements each
    int k=3,search_for = 9,n=sizeof(A)/sizeof(int);
    int *Buffer = calloc(n/k,sizeof(int));
    for(int i=0;i<n/k;i++)
    Buffer[i]=A[k*i];   //Buffer[]={7,10,20}
    int possible_location = binarySearch(Buffer,0,(n/k)-1,search_for);  // binary search will given probable location were it could be found
    if(A[possible_location]==search_for)
    {
        printf("%d is the index location of %d in the partially sorted array",possible_location,search_for);
        return 0;
    }
    for(int i=(possible_location-1)*3;i<(possible_location+1)*3;i++){  // now instead of searching in the whole array we are searching in
        if(A[i]==search_for){                                          // 2*k memory location
        printf("%d is the index location of %d in the partially sorted array",i,search_for);
        return 0;
    }
}
    printf("Not found");
    return 0;
}
