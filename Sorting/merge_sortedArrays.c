#include<stdio.h>
#include<stdlib.h>
#include<limits.h>
int Min_and_Swap(int A[],int i,int size){
 int min = i,temp;
 if(A[min]>A[2*i+1])
     min = 2*i+1;
 if(2*(i+1)<=size-1 && A[min]>A[2*(i+1)])
     min=2*(i+1);
  temp=A[i];
  A[i] =A[min];
  A[min]=temp;
 return min;
}
void heapify(int A[],int i,int size){
    if(2*i+1 <= size-1){
         int change_occurance = Min_and_Swap(A,i,size); 
         if(i!=change_occurance)                        
         heapify(A,change_occurance,size);
    }
}
void BuildHeap(int A[],int size){
     for(int i=size-1;i>=0;i--){  
       heapify(A,i,size);            
     }
}
int main()
{
     int A[] = {7,11,15,24,30,40};
     int B[] = {9,17,20,21,25,35,37};
     int C[] = {6,8,9,10};
     int D[] = {31,48,90};
     int pointer[4]={0},result_size=25;
     int temp[] ={A[pointer[0]],B[pointer[1]],C[pointer[2]],D[pointer[3]]};
     int buffer[]={A[pointer[0]],B[pointer[1]],C[pointer[2]],D[pointer[3]]};
     BuildHeap(temp,sizeof(temp)/sizeof(int));   
for(int i=0;i<result_size;i++){ 
       for(int j=0;j<sizeof(buffer)/sizeof(int);j++)
         {
              if(buffer[j]==temp[0])
               {
                  pointer[j]++;
                  printf("%d ",temp[0]);
                  switch(j)
                  {
                   case 0:if(pointer[j]>=sizeof(A)/sizeof(int))
                            temp[0]= INT_MAX;
                          else  
                            temp[0]=A[pointer[j]];buffer[j]=temp[0];break;
                   case 1:if(pointer[j]>=sizeof(B)/sizeof(int))
                            temp[0]= INT_MAX;
                          else  
                            temp[0]=B[pointer[j]];buffer[j]=temp[0];break;
                   case 2:if(pointer[j]>=sizeof(C)/sizeof(int))
                            temp[0]= INT_MAX;
                          else  
                            temp[0]=C[pointer[j]];buffer[j]=temp[0];break;
                   case 3:if(pointer[j]>=sizeof(D)/sizeof(int))
                            temp[0]= INT_MAX;
                          else  
                            temp[0]=D[pointer[j]];buffer[j]=temp[0];break;
                  }
                  break;
               }
         }
      heapify(temp,0,sizeof(temp)/sizeof(int));     
} 
     return 0;
}
