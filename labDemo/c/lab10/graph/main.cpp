#include "D:\CODE\springDemo\StudyCodeDmoe\labDemo\c\lab10\graph\graph.cpp"

int main()
{
  MGraph graph; //定义图结构变量graph
  AdjMatrix g = &graph; //定义指针变量g指向图graph

  char d[MAXV] = {'A', 'B', 'C', 'D', 'E', 'F', 'G'}; //定义一维数组d作为顶点表

  //定义一维数组visited并初始化，作为访问标记。
  int visited[MAXV] = {0, 0, 0, 0, 0, 0, 0};

  //定义二维数组m为邻接矩阵
  int m[MAXV][MAXV] = {
      {0, 0, 1, 0, 0, 0, 1},
      {0, 0, 1, 0, 0, 0, 0},
      {1, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 1},
      {0, 0, 0, 0, 0, 1, 1},
      {0, 0, 0, 0, 0, 0, 0},
      {1, 0, 1, 0, 0, 0, 0},
  };

  //已知图的顶点表和邻接矩阵数据，创建图graph的邻接矩阵
  CreateGraph(g, m, d, MAXV);

  //显示邻接矩阵
  DispGraph(g);
  cout << "深度优先遍历：";

  //依次选择未被访问的顶点作为起点对图进行深度优先遍历
  for (int v = 0; v < g->n; v++)
    if (visited[v] == 0) //找未访问过的顶点作为起点
      DFS(g, v, visited);
  cout << endl;
}
