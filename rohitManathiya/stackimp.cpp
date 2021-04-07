#include <iostream>
#include<bits/stdc++.h>
using namespace std;

class newstack{
  public: 	
  int a[100];
  int t=-1;
  
  
  void insert(int d){
    if(t<100){
      t++;
      a[t]=d;
    }
  }
  int top(){
    return a[t];
  }
  
  void pop(){
    t--;
  }
  
  bool isempty(){
    if(t==-1){
      return true;
    }
    return false;
  }
  
  
};

int main() 
{
    
    newstack *st=new newstack();
    st->insert(23);
    st->insert(25);
    cout<<st->top();
    return 0;
}