#include "D:\CODE\springDemo\StudyCodeDmoe\labDemo\c\lab7\BiTree\BiTree.cpp"

int main()
{
  BTNode *root;

  InitBTree(root); //初始化空二叉树
  CreateBTree(root); //按照课件示意图建立一棵二叉树

  int a = N0(root);
  cout<<a<<endl;

  int b =N2(root);
  cout<<b<<endl;

  return 0;
}