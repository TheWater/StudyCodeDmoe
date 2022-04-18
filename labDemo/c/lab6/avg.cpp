#include<iostream>
using namespace std;

int fun(int a[],int n)
{
  if(n==1)
    return a[0];
  else
    return ((n - 1) * fun(a, n - 1) + a[n - 1]) / n;
  
}
int main()
{

  int a[10]={45,65,87,21,45,12,74,97,45,12};
  int aver = fun(a,10);
  cout<<"a数组的平均数为"<<aver<<endl;
  return 0;

}