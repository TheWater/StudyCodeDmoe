#include <iostream>
using namespace std;

#define MAXV 7 //最大顶点个数

typedef int weight; //邻接矩阵元素类型
typedef char ElemType; //顶点数据元素类型

//邻接矩阵类型
typedef struct {
  weight arcs[MAXV][MAXV]; //邻接矩阵
  ElemType data[MAXV]; //一维数组顶点表
  int n; //顶点个数
} MGraph, *AdjMatrix;

//创建邻接矩阵, g是指向图的指针变量，m[][MAXV]是邻接矩阵，d[]是顶点表,n顶点个数
void CreateGraph(AdjMatrix g, int m[][MAXV], ElemType d[], int n);

//显示邻接矩阵
void DispGraph(AdjMatrix g);

//取顶点v的第一个邻接点
int GetFirst(AdjMatrix g, int v);

//取顶点v的位于顶点t之后的下一个邻接点
int GetNext(AdjMatrix g, int v, int t);

//以顶点v为起点，深度优先遍历图
void DFS(AdjMatrix g, int v, int visited[]);