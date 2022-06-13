#include <stdio.h>
#define MAXV 20 //最大顶点个数

typedef int InfoType;
//以下定义邻接矩阵类型
typedef struct
{
  int no; //顶点编号
  InfoType info; //顶点其他信息
} VertexType; //顶点类型

typedef struct //图的定义
{
  int edges[MAXV][MAXV]; //邻接矩阵
  int n, e; //顶点数，弧数
  VertexType vexs[MAXV]; //存放顶点信息
} MGraph; //图的邻接矩阵类型

//以下定义邻接表类型
typedef struct ANode //弧的结点结构类型
{
  int adjvex; //该弧的终点位置
  struct ANode *nextarc; //指向下一条弧的指针
  InfoType info; //该弧的相关信息,这里用于存放权值
} ArcNode;

typedef int Vertex;
typedef struct Vnode //邻接表头结点的类型
{
  Vertex data; //顶点信息
  int count; //存放顶点入度,只在拓扑排序中用
  ArcNode *firstarc; //指向第一条弧
} VNode;

typedef VNode AdjList[MAXV]; //AdjList是邻接表类型
typedef struct
{
  AdjList adjlist; //邻接表
  int n, e; //图中顶点数n和边数e
} ALGraph; //图的邻接表类型

void MatToList(MGraph g, ALGraph *&G)
//将邻接矩阵g转换成邻接表G
{
  int i, j, n = g.n; //n为顶点数
  ArcNode *p;
  G = new ALGraph;
  for (i = 0; i < n; i++) //给邻接表中所有头结点的指针域置初值
    G->adjlist[i].firstarc = NULL;
  for (i = 0; i < n; i++) //检查邻接矩阵中每个元素
    for (j = n - 1; j >= 0; j--)
      if (g.edges[i][j] != 0) //邻接矩阵的当前元素不为0
      {
        p = new ArcNode; //创建一个结点*p
        p->adjvex = j;
        p->info = g.edges[i][j];
        p->nextarc = G->adjlist[i].firstarc; //采用头插法插入*p
        G->adjlist[i].firstarc = p;
      }
  G->n = n;
  G->e = g.e;
}

void DispAdj(ALGraph *G)
//输出邻接表G
{
  int i;
  ArcNode *p;
  printf("邻接表：\n");
  for (i = 0; i < G->n; i++) {
    p = G->adjlist[i].firstarc;
    printf("%3d: ", i);
    while (p != NULL) {
      printf("%3d", p->adjvex);
      p = p->nextarc;
    }
    printf("\n");
  }
}

void TopSort(ALGraph *G)
{
  int i, j;
  int St[MAXV], top = -1; //栈St的指针为top
  ArcNode *p;
  for (i = 0; i < G->n; i++) //入度置初值0
    G->adjlist[i].count = 0;
  for (i = 0; i < G->n; i++) //求所有顶点的入度
  {
    p = G->adjlist[i].firstarc;
    while (p != NULL) {
      G->adjlist[p->adjvex].count++;
      p = p->nextarc;
    }
  }
  for (i = 0; i < G->n; i++)
    if (G->adjlist[i].count == 0) //入度为0的顶点进栈
    {
      top++;
      St[top] = i;
    }
  while (top > -1) //栈不为空时循环
  {
    i = St[top];
    top--; //出栈
    printf("%d ", i); //输出顶点
    p = G->adjlist[i].firstarc; //找第一个相邻顶点
    while (p != NULL) {
      j = p->adjvex;
      G->adjlist[j].count--;
      if (G->adjlist[j].count == 0) //入度为0的相邻顶点进栈
      {
        top++;
        St[top] = j;
      }
      p = p->nextarc; //找下一个相邻顶点
    }
  }
}

int main()
{
  int i, j;
  MGraph g;
  ALGraph *G;
  g.n = 6;
  g.e = 6;
  int A[MAXV][MAXV] = {
      {0, 0, 1, 0, 0, 0},
      {0, 0, 1, 1, 0, 0},
      {0, 0, 0, 0, 1, 0},
      {0, 0, 0, 0, 0, 1},
      {0, 0, 0, 0, 0, 1},
      {0, 0, 0, 0, 0, 0}
  };
    
  for (i = 0; i < g.n; i++)
    for (j = 0; j < g.n; j++)
      g.edges[i][j] = A[i][j];
  
  MatToList(g, G);
  DispAdj(G);
  printf("\n");
  printf("拓扑序列:");
  TopSort(G);
  printf("\n");
}
