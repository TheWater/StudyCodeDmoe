#include <iostream>
using namespace std;

struct IdexType
{
	int maxkey;
	int startpos;
};//索引项

//索引查找
//主表L有n个元素，每个子表I有m个元素
int Idex_Search(int L[], int n, IdexType I[], int m, int item)
{
	int low=0, high=n/m-1, mid;  // n/m为索引表长度
	int start=-1,pos; //start为子表的查找起点，pos代表元素位置

	cout<<"第一步，在索引表折半查找"<<item<<"："<<endl;
	while(low<=high){    //在索引表折半查找，分块位置为mid或low
		mid=(low+high)/2;
		cout<<"        在["<<low<<"--"<<high<<"]之间查找，与"<<I[mid].maxkey<<"比较"<<endl;
		if(I[mid].maxkey==item){ //如果item等于索引表当前中间位置的最大关键字
		  	//则直接通过该索引表项得到item在主表相应分块的开始位置
		  	start=I[mid].startpos; 
		  	break;
		}        
		else if (I[mid].maxkey<item)  low=mid+1; //在后半子区间查找
		else	high=mid-1; 	 //在前半子区间查找 
	}
	
	//如果执行完折半查找后，low最终被移动到超出索引表最后一项，
	//说明item大于最后一个分块的最大关键字，则item在主表中不存在
	if(low>n/m-1) 
		return 0;

	//如果start还是初值-1，说明没有在索引表中直接找到item，而由上句可知，此时item在主表中可能存在
	if(start==-1) 
		start=I[low].startpos;  //通过停止时的low位置确认所在分块，并得到分块的开始位置

	cout<<"第二步，继续在子表["<<start<<"--"<<start+m<<"]中顺序查找，依次比较数据：";
	pos=start;
	while(pos<start+m)
	{
		cout<<L[pos]<<" ";
		if(L[pos]==item) break;  //在分块中依次比较以进行顺序查找
		pos++;
	}
	if(pos<start+m)	return pos+1;  //下标加1，返回逻辑位置（以1开头）
	else	        return 0;//查找失败，返回0
}

int main()
{
	int mainlist[]={8,14,6,9,10,  22,34,18,19,31,  40,38,54,66,46};//主表
	IdexType idexlist[]={{14,0},{34,5},{66,10}};//索引表
	
	int item=55,pos;

	cout<<"主表：";
	for(int i=0; i<15; i++)
		cout<<mainlist[i]<<" ";
	cout<<endl;

	cout<<"索引表：";
	for(int i=0; i<3; i++)
		cout<<idexlist[i].maxkey<<" ";
	cout<<endl;

	cout<<endl<<"索引查找"<<item<<"的过程："<<endl;
	pos=Idex_Search(mainlist, 15, idexlist, 5, item);
	cout<<endl<<"查找结果：";
	if(pos==0)
		cout<<item<<"不存在"<<endl;
	else
		cout<<item<<"的位置是"<<pos<<endl;
	return 0;
}
