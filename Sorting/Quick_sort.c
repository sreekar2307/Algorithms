#include <stdio.h>
#include <stdlib.h>
int partioning(int A[],int p,int q){
int pointer_r=p,pointer_s=p,pointer_t=q+1,pivot=A[(p+q)/2];  // pivot as the middle element
// if need random is needed then pivot = A[(rand()%q + p)]
  int flag,count=1;
  for(int i=q;i>=p;i--)
  {
      if(A[i]>pivot)
        pointer_t--;
      else
        break;
  }
  while(pointer_s<pointer_t){
    if(A[pointer_s]==pivot)
   {
      pointer_s++;
   }
    else if(pivot>A[pointer_s])
    {
        if(count){
        flag=A[pointer_s];
        A[pointer_s]=A[pointer_r];
        A[pointer_r]=flag;count--;
        }
       else{
        pointer_r++;
        flag=A[pointer_s];
        A[pointer_s]=A[pointer_r];
        A[pointer_r]=flag;
        }
        pointer_s++;
    }
    else
   {
        if(pointer_t==q+1)
      {
        flag=A[pointer_s];
        A[pointer_s]=A[pointer_t-1];
        A[pointer_t-1]=flag;
        pointer_t--;
      }
        else
      {
        pointer_t--;
        flag=A[pointer_s];
        A[pointer_s]=A[pointer_t];
        A[pointer_t]=flag;
      }
   }
  }
  for(int i=p;i<q;i++)
  {
      if(A[i]==pivot)
        return i;
  }

}
void quick_sort(int A[],int p,int r){
if(p<r){
    int q = partioning(A,p,r);
    quick_sort(A,p,q);
    quick_sort(A,q+1,r);
}
}
int main()
{
  int A[] = {20,11,7,5,12,6,15,13,12,50,57,48,12,48,13};
  quick_sort(A,0,(sizeof(A)/sizeof(int))-1);
  for(int i=0;i<sizeof(A)/sizeof(int);i++)
    printf("%d ",A[i]);
  return 0;
}
