#include <stdio.h>
#include <stdlib.h>
int main()
{
  int A[] = {20,11,7,5,12,6,15,13};
  int pointer_r=0,pointer_s=0,pointer_t=sizeof(A)/sizeof(int),pivot=20;
  int flag,count=1;
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
        if(pointer_t==sizeof(A)/sizeof(int))
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
  printf("\n");
  for(int i=0;i<sizeof(A)/sizeof(int);i++)
    printf("%d ",A[i]);
  return 0;
}
