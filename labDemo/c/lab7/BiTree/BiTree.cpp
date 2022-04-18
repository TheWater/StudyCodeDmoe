#include "BiTree.h"

//初始化空二叉树
void InitBTree(BTNode *&root)
{
  root = NULL;
}

//按照课件示意图建立一棵二叉树
void CreateBTree(BTNode *&root)
{
  BTNode *a, *b, *c, *d, *e, *f, *g;

  a = root = new BTNode;
  a->data = 'A';

  b = a->left = new BTNode;
  b->data = 'B';

  c = a->right = new BTNode;
  c->data = 'C';
  c->right = NULL;

  d = b->left = new BTNode;
  d->data = 'D';
  d->left = NULL;
  d->right = NULL;

  e = b->right = new BTNode;
  e->data = 'E';
  e->left = NULL;
  e->right = NULL;

  f = c->left = new BTNode;
  f->data = 'F';
  f->left = NULL;

  g = f->right = new BTNode;
  g->data = 'G';
  g->left = NULL;
  g->right = NULL;
}

//计算二叉树叶子结点个数的函数
int N0(BTNode *root)
{
  if(root==NULL)
    return 0;
  else if(root->left==NULL&&root->right==NULL)
    return 1;
  else
    return N0(root->left)+N0(root->right);
}
//计算二叉树双分支结点个数的函数
int N2(BTNode *root)
{
  if(root==NULL)
    return 0;
  else if(root->right!=NULL&&root->left!=NULL)
    return 1;
  else
    return N2(root->left)+N2(root->right);
}