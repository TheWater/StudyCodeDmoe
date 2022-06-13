#include <iostream>
#include <string.h>
using namespace std;

//Huffman树的存储结构
#define n 5 //叶子数目
#define m 2 * n - 1 //树中结点总数

typedef struct //结点类型
{
  double weight; //权值，不妨设权值均大于零
  int lchild, rchild, parent; //左右孩子及双亲指针
} HTNode;
typedef HTNode HuffmanTree[m]; //HuffmanTree是向量类型

typedef struct
{
  char ch; //存储字符
  char bits[n]; //存放编码位串
} CodeNode;
typedef CodeNode HuffmanCode[n];

void InitHuffmanTree(HuffmanTree T); //初始化Huffman树
void InputWeight(HuffmanTree T); //输入权值
void CreateHuffmanTree(HuffmanTree T); //构造Huffman树，T[m-1]为其根结点
void CharSetHuffmanEncoding(HuffmanTree T, HuffmanCode H); //根据Huffman树T求Huffman编码表H

int main()
{
  HuffmanTree T;
  HuffmanCode H;
  CreateHuffmanTree(T);
  CharSetHuffmanEncoding(T, H);
}

void CreateHuffmanTree(HuffmanTree T)
{ //构造Huffman树，T[m-1]为其根结点
  int i, j;
  double min1, min2; //最小权值min1, 次小权值min2, min1<min2
  int lnode, rnode; //左结点(权值为min1)序号lnode, 右结点(权值为min2)序号rnode

  InitHuffmanTree(T); //将T初始化
  InputWeight(T); //输入叶子权值至T[0..n-1]的weight域

  for (i = n; i < m; i++) //共进行n-1次合并，新结点依次存于T[i]中
  {
    //在T[0..i-1]中选择两个权最小的根结点，其序号分别为lnode和rnode

    min1 = min2 = 65535; //min1,min2的初始值设为大于所有可能权值的最大值
    lnode = rnode = -1;

    for (j = 0; j <= i - 1; j++)
      if (T[j].parent == -1) //寻找没有选取过的结点
      {
        if (T[j].weight < min1) //如果找到结点权值小于min1，说明找到比min1,min2更小的权值
        {
          min2 = min1; //原min1值转移到min2
          rnode = lnode; //原左结点序号转移到右结点

          min1 = T[j].weight; //更新min1为找到的更小的权值
          lnode = j; //更新左结点序号为找到的该结点的序号
        } else if (T[j].weight < min2) //如果min1<=结点权值<min2，则不影响min1
        {
          min2 = T[j].weight; //更新min2
          rnode = j; //更新右结点序号
        }
      }

    T[i].weight = T[lnode].weight + T[rnode].weight; //新的双亲结点放在i位置，其权值为左右结点权值之和
    T[i].lchild = lnode; //最小权的根结点是新结点的左孩子
    T[i].rchild = rnode; //次小权的根结点是新结点的右孩子
    T[lnode].parent = T[rnode].parent = i; //左右结点的双亲均为新结点
  }
}

void InitHuffmanTree(HuffmanTree T)
{ //初始化Huffman树
  int i;
  for (i = 0; i < m; i++) {
    T[i].weight = 0;
    T[i].lchild = T[i].rchild = T[i].parent = -1;
  }
}

void InputWeight(HuffmanTree T)
{ //输入权值
  int i;
  for (i = 0; i < n; i++) {
    cout << "请输入第" << i + 1 << "个权值：";
    cin >> T[i].weight;
  }
}

void CharSetHuffmanEncoding(HuffmanTree T, HuffmanCode H)
{ //根据Huffman树T求Huffman编码表H
  int i, c, f; //c和f分别指示T中孩子和双亲的位置
  char cd[n]; //临时存放编码
  char str[n + 1]; //存放输入字符串
  int start; //指示编码在cd中的起始位置
  cd[n - 1] = '\0'; //编码结束符

  cout << "请输入字符串：";
  cin >> str;
  for (i = 0; i < n; i++) //依次求叶子T[i]的编码
  {
    H[i].ch = str[i]; //读入叶子T[i]对应的字符
    start = n - 1; //编码起始位置的初值
    c = i; //从叶子T[i]开始上溯
    while ((f = T[c].parent) != -1) //直至上溯到T[c]是树根为止
    { //若T[c]是T[f]的左孩子，则生成代码0；否则生成代码1
      cd[--start] = (T[f].lchild == c) ? '0' : '1';
      c = f; //继续上溯
    }
    strcpy_s(H[i].bits, &cd[start]); //复制编码位串
  }
  for (i = 0; i < n; i++)
    cout << "第" << i + 1 << "个字符" << H[i].ch << "的编码为" << H[i].bits << endl;
}
