#include <bits/stdc++.h>
using namespace std;

class hashfun{
  public:
  int cp;
  int a[100000];
  map<int,int> cnt; 
  hashfun(int c){
    cp=2*c;
  }
  
  void aini(){
    for(int i=0;i<cp;i++){
    a[cp]=-1;
  }
  }
  
  void insert(int key,int data){
    // hash function
    int k=key--;
    k=k*key;
    int count=0;
    while(a[k]!=-1){
      count++; k++;
    }
    a[k]=data;
    cnt[key]=count;
  }
 int find( int key){
     int k=key--;
    k=k*key;
    for(int i=cnt[key];i>0;i--){
      k++;
    }
    return a[k];
  }
};


int main() 
{
     int cap;
    cin>>cap;
    hashfun *h=new hashfun(cap);
    h->insert(4,34);
    h->insert(5,21);
    int res=h->find(4);
    cout<<res;
    return 0;
}