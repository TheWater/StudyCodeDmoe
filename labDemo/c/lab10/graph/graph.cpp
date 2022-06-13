#include "graph.h"

//创建邻接矩阵, g是指向图的指针变量，m[][MAXV]是邻接矩阵，d[]是顶点表,n顶点个数
void CreateGraph(AdjMatrix g, int m[][MAXV], ElemType d[], int n)
{
  int i, j;

  g->n = n; //为图g的顶点个数域赋值

  for (i = 0; i < n; i++) {
    g->data[i] = d[i]; //为图g的顶点表赋值

    for (j = 0; j < n; j++) //为图g的邻接矩阵赋值
      g->arcs[i][j] = m[i][j];
  }
}

//显示邻接矩阵
void DispGraph(AdjMatrix g)
{
  int i, j;

  cout << "图的顶点：  ";
  for (i = 0; i < g->n; i++) //输出图g的顶点
    cout << " " << g->data[i];

  cout << "\n\n图的邻接矩阵:" << endl;
  //外层for循环控制对每一个顶点进行遍历
  for (i = 0; i < g->n; i++) {
    cout << " " << g->data[i]; //输出顶点i的数据

    for (j = 0; j < g->n; j++) //在输出顶点i的数据之后，输出顶点i对应在邻接矩阵的第i行的数据
      cout << " " << g->arcs[i][j];
    cout << endl;
  }
  cout << endl;
}

//取顶点v的第一个邻接点
int GetFirst(AdjMatrix g, int v)
{
  int j;
  if (v < 0 || v >= g->n) //顶点表的下标范围在0到g->n-1之间，下标即是顶点的序号
  {
    cout << "参数v超出范围" << endl;
    return -1;
  }

  for (j = 0; j < g->n; j++)
    if (g->arcs[v][j] == 1) //扫描顶点v所在行的元素值，第一个元素值为1的对应的顶点即是顶点v的第一个邻接点
      return j; //返回顶点v的第一个邻接点的序号
  return -1;
}

//取顶点v的位于顶点t之后的下一个邻接点
int GetNext(AdjMatrix g, int v, int t)
{
  int j;
  if (v < 0 || v >= g->n || t < 0 || t >= g->n) {
    cout << "参数v或t超出范围" << endl;
    return -1;
  }

  for (j = t + 1; j < g->n; j++) //在矩阵的第v行，从第t+1列开始扫描
    if (g->arcs[v][j] == 1)
      return j;
  return -1;
}

//以顶点v为起点，深度优先遍历图
void DFS(AdjMatrix g, int v, int visited[])
{
  int u;
  cout << " " << g->data[v]; //访问起点v
  visited[v] = 1; //访问标志记为1，代表已访问

  u = GetFirst(g, v); //取顶点v的第一个邻接点u
  while (u != -1) {
    if (visited[u] == 0) { //如果顶点u未被访问
      DFS(g, u, visited); //以顶点u为起点，继续深度优先遍历(递归)
    }
    u = GetNext(g, v, u); //回到顶点u，取顶点v的位于顶点u之后的下一个邻接点，如有，继续循环过程
  }
}