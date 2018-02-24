#include<stdio.h>
int partioning(int A[],int p,int q){
int pointer_r=p,pointer_s=p,pointer_t=q+1,pivot=A[(p+q)/2];
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

int Kthsmallest(int A[],int p,int r,int i){
     int q = partioning(A,p,r);
     for(int i=p;i<=r;i++)
     printf("%d ",A[i]);
     printf("     %d the value of q\n",q);
     int k = q-p+1;
     if(k==i)
       return A[q];
     else if(i<k)
      Kthsmallest(A,p,q,i);
     else
      Kthsmallest(A,q+1,r,i-k); 
}
int main(){
int A[] = {20,11,7,5,12,6,15,13,50,57,48};
printf("5 th smallest number is %d\n",Kthsmallest(A,0,sizeof(A)/sizeof(int)-1,5));     
  return 0;
}
