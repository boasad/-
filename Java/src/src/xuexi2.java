import java.util.*;
public class xuexi2 {
    public static void main(String[] args) {
         High students1=new High();
         students1.setAge(17);
         students1.setName("刘令");
         students1.situation();
    }
}
 class xuesheng{
   private String name;
   private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
class High extends  xuesheng {
    String a;

    public void situation(){
        //单词意思：成年
        if(getAge()>=18){
            a="成年";
        }
        else {
            a = "未成年";
        }
        System.out.println("该学生的名字是:"+getName()+"\n该学生的年龄为:"+getAge()+"\n该学生是"+a+"人");
        System.out.println("该学生为高中生");
    }
}
class small extends xuesheng{

}