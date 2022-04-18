#include<iostream>
using namespace std;
struct Rect{
	double length;
	double width;
};//声明矩形（矩形的类型定义）
void InitRect(Rect &R, double l, double w);//构造矩形
double Circumference(Rect &R);//求矩形周长
double AreaR(Rect &R);//求矩形面积

int main()
{
	Rect my_rect;//定义矩形变量my_rect
	double Length,Width,Circ,Area;
	cout<<"Input length,width:"<<endl;
	cin>>Length>>Width;
	InitRect(my_rect,Length,Width);//构造矩形my_rect

	Circ = Circumference(my_rect);
	cout<<"此矩形周长为:"<<endl;
	cout<<Circ<<endl;

	Area = AreaR(my_rect);
	cout<<"此矩形面积为:"<<endl;
	cout<<Area<<endl;

	return 0;
}

//初始化矩形
void InitRect(Rect &R, double l, double w)
{
	R.length=l;
	R.width=w;
}

//求矩形周长
double Circumference(Rect &R)
{
	return 2 * ( R.length + R.width );
}
	
//求矩形面积
double AreaR(Rect &R)
{
	return R.length * R.width ;
}
