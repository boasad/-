import java.util.*;

public class paixu {
    //排序都是从小到大.
     public void pai(){
     }
    public static void main(String[] args) {
        long touTime=System.currentTimeMillis();
        int a=0;
        int[] sum = new int[100000];
        int[] sum2=new int[sum.length];//归并排序需要
        Random random = new Random();
        System.out.print("初始数组为：\n");
        for (int i = 0; i < sum.length; i++) {
            sum[i] = random.nextInt(101);//设置数的大小
           // System.out.print("\t" + sum[i]);
        }//随机产生数组
        System.out.println("\n");
        {
            xuanzhe z = new xuanzhe();
            maopao y = new maopao();
            kuaipai x = new kuaipai();
            charu q = new charu();
            guibing p=new guibing();

            //以下排序比较经典
            //y.pai(sum);//冒泡排序,速度最慢，最经典
            //z.pai(sum);//选择排序,和冒泡一样经典，速度比冒泡快一些
            //q.pai(sum);//插入排序,小数据最快，大数据比较慢

            //以下排序都使用了递归
            //x.pai(sum, 0, sum.length - 1);//快速排序，填坑法，适合数组，速度很快。
            //p.pai(sum,sum2,0,sum.length-1);//归并排序，归并法，需要额外一个数组的内存，速度最快,链表能用!。
        }
        System.out.print("变化之后数组为：\n");
        for (int i : sum) {
           /* System.out.print("\t" + i);
            a++;
            if(a%20==0){
                System.out.println("\n");
            }*/
        }
        long weiTime=System.currentTimeMillis();
        System.out.println();
        System.out.println("代码耗时:"+(weiTime-touTime)+"ms");
    }
}
class maopao extends paixu{
    //冒泡排序,最慢和最经典的排序.
     public void pai(int a[]){
         int tmp=0;//替换数
         for (int i = 0; i < a.length; i++) {
             for (int j = 1; j <a.length-i; j++) {
                 if(a[j-1]>a[j]){
                        tmp=a[j-1];
                        a[j-1]=a[j];
                        a[j]=tmp;
                 }
             }
         }
     }
}
class xuanzhe extends paixu{
    //选择排序,冒泡的好朋友
    public void pai(int a[]){
        int tmp=0;//替换数
        for (int i = 0; i <a.length; i++) {
            for (int j = i; j <a.length ; j++) {
                if(a[i]>a[j]){
                    tmp=a[i];
                    a[i]=a[j];
                    a[j]=tmp;
                }
            }
        }
    }
}
class charu extends paixu{
    //插入排序，对于小数据速度很快
    public void pai(int a[]){
        int tmp=0;
        for (int i = 1; i <a.length ; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(a[j]>a[j+1]){
                    tmp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=tmp;
                }
                else break;
            }
              /*  System.out.println("\n现在数组为:\n");
            for (int sum:a) {
                System.out.print("\t"+sum);
            }*/
        }
    }
}
class kuaipai extends paixu {
    //快速排序尝试，采用填坑法,速度最快.
    public void pai(int a[], int l, int n) //a[]为数组，l为头指针，n为尾指针
    {
        //Random random = new Random();
        if (l < n) {
            int i=l,j=n;
            int poin = a[i];
            //System.out.println("\n对应的数字为：" + a[l]);
            while(i<j){
                while((i<j)&&(poin<=a[j]))j--;//从右边寻找比标识数小的
                if(i<j)a[i]=a[j];//找到之后替换
                while((i<j)&&(poin>=a[i]))i++;//从左边寻找比标识数大的
                if(i<j)a[j]=a[i];//找到之后替换
                //System.out.println("i:\t"+i+"j:"+j);
            }
            a[i] = poin;//标识数放到中间
            pai(a, l, i - 1);//左边逆序递归
            pai(a, i + 1, n);//右边逆序递归
        }
    }
}
class guibing extends paixu{
    public void pai(int a[],int p[],int l,int n){
        if(l>=n)return ;
        int len=n-l;
        int tou1=l,end1=len/2+l;
        int tou2=end1+1,end2=n;
        pai(a,p,tou1,end1);//左边分开,并且合并
        pai(a,p,tou2,end2);//又边分开,并且合并
        int x=l;//到这里已经是最后一步合并了
        while(tou1<=end1&&tou2<=end2)
         p[x++]=a[tou1]<a[tou2]?a[tou1++]:a[tou2++];
        while(tou1<=end1)
            p[x++]=a[tou1++];
        while(tou2<=end2)
            p[x++]=a[tou2++];
        for (int i = l; i <=n ; i++) {
            a[i]=p[i];
        }
    }
}
