
#include <stdio.h>
#include <stdlib.h>
void merge(int C[],int l,int u){
  int i=0,k=0,j=0;
     int mid=(l+u)/2;
  int temp1[mid-l+1];
  int temp2[u-mid];
  for(int i=l;j<mid-l+1;i++,j++)
{
        temp1[j]=C[i];
}
j=0;
  for(int i=mid+1;j<u-mid;i++,j++)
  {
        temp2[j]=C[i];
  }
  j=0;i=l;k=0;
  while(j<mid-l+1 && k<u-mid){
     if(temp1[j]>temp2[k])
     {
         C[i] = temp2[k];
         k++;
     }
     else{
        C[i] = temp1[j];
        j++;
     }
     i++;
  }
  if(j>=mid-l+1){
    while(k<u-mid){
         C[i] = temp2[k];
         k++;i++;
    }
  }
  else if (k>=u-mid){
    while(j<mid-l+1){
        C[i] = temp1[j];
        j++;i++;
    }
  }
}

void mergesort(int A[] ,int l ,int u){
     if(l<u){
        int mid = (l+u)/2; 
        mergesort(A,l,mid);   // sort the first half
        mergesort(A,mid+1,u);  // sort the later half
        merge(A,l,u);   // merge both of them 
     }
   return;
}
int main()
{
    int arr[] = {17,81,7,20,14,21,30};
    int arr_size = sizeof(arr)/sizeof(arr[0]);

    printf("Given array is \n");
    for(int i=0;i<arr_size;i++)
    printf("%d ",arr[i]);

    mergesort(arr, 0, arr_size - 1);

    printf("\nSorted array is \n");
    for(int i=0;i<arr_size;i++)
    printf("%d ",arr[i]);
    return 0;
}
