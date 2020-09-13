import java.util.*;

public class paixu {
    //排序都是从小到大.
     public void pai(){
     }
    public static void main(String[] args) {
        int a=0;
        int[] sum = new int[20];
        Random random = new Random();
        System.out.print("初始数组为：\n");
        for (int i = 0; i < sum.length; i++) {
            sum[i] = random.nextInt(101);//设置数的大小
            System.out.print("\t" + sum[i]);
        }//随机产生数组
        System.out.println("\n");
        {
            xuanzhe z = new xuanzhe();
            maopao y = new maopao();
            kuaipai x = new kuaipai();
            charu q = new charu();

            //z.pai(sum);//选择排序
            //y.pai(sum);//冒泡排序
            q.pai(sum);//插入排序
            //x.pai(sum, 0, sum.length - 1);//快速排序
        }
        System.out.print("变化之后数组为：\n");
        for (int i : sum) {
            System.out.print("\t" + i);
            a++;
            if(a%20==0){
                System.out.println("\n");
            }
        }
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
                while((i<j)&&(poin>a[i]))i++;//从左边寻找比标识数大的
                if(i<j)a[j]=a[i];//找到之后替换
                //System.out.println("i:\t"+i+"j:"+j);
            }
            a[i] = poin;//标识数放到中间
            pai(a, l, i - 1);//左边逆序递归
            pai(a, i + 1, n);//右边逆序递归
        }
    }
}
