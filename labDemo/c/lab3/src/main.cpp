#include <iostream>
#include"D:\CODE\springDemo\StudyCodeDmoe\labDemo\c\lab3\src\linkedlist.cpp"


int main()
{
  LinkNode *L;
  //初始化L
  InitList(L);


  // 在L的头部依次插入 'a',  'b',  'c',  'd' 元素
  char array[]={'a','b','c','d'};
  for (int i = 0; i < sizeof(array); i++)
  {
    ListInsert(L,i+1,array[i]);
  }

  TraverseList(L);
  

  if(!ListEmpty(L)){
    cout<<"L链表不为空"<<endl;
    cout<<"L链表的长度为："<<ListLength(L)<<endl;
    cout<<"L链表的元素为：";
    TraverseList(L);
  }

  //查找第三个位置的元素
  ElemType a;
  Find_pos(L,3,a);
  cout<<"L链表的第三个元素为："<<a<<endl; 


  //查找'a'的位置
 
  cout<<"b的位置为："<<Find_item(L,'b')<<endl;

  cout<<"向第三个位置插入f"<<endl;
  ListInsert(L,3,'f');
  TraverseList(L);
  

  ListDelete(L,2,a);
  cout<<"删除第二个元素，为："<<a<<endl;



  cout<<"输入你想删除的元素：";
  cin>>a;
  ListDelete(L,a);


  cout<<"删除"<<a<<"成功。表中的元素为：";
  TraverseList(L);

  return 0;
  


}
