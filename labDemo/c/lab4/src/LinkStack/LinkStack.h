#include <iostream> 

using namespace std;

typedef int ElemType;

typedef struct LNode //LNode为结点类型名
{
  ElemType data; //data代表数据元素
  struct LNode *next; //next为指向下一结点的指针
} LinkNode; // 单链表结点类型



//初始化空链栈
bool InitStack(LinkNode *&S);

//判链栈空
bool StackEmpty(LinkNode *S);

//入栈
bool Push(LinkNode *S, ElemType item);

//出栈
bool Pop(LinkNode *S, ElemType &item);

//取栈顶
bool GetTop(LinkNode *S, ElemType &item);

//释放链栈
void Destroy(LinkNode *&S);

void TraverseStack(LinkNode *S);