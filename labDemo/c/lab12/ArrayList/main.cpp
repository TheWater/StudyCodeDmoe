#include "D:\CODE\springDemo\StudyCodeDmoe\labDemo\c\lab12\ArrayList\arraylist.cpp"

int main()
{
  ElemType Array[] = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
  SqList my_list;
  InitList(my_list);
  for (int i = 0; i < 10; i++)
    ListInsert(my_list, i + 1, Array[i]);
  TraverseList(my_list);

  int pos = BinarySearch(my_list, 80);
  if (pos == 0)
    cout << "查找失败。" << endl;
  else
    cout << "查找的元素的逻辑位置为：" << pos << endl;
  return 0;
}
