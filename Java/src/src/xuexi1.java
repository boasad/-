import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class xuexi1 {
    private String x;

    public void setX(String x) {
        this.x = x;
    }

    public String getX() {
        return x;
    }

    public static void main(String[] args) {
         String l;
        System.out.println("哈哈哈，配置完成");
        peizi w=new peizi("刘令");
        peizi s=new peizi(5);
    }
}
 class peizi{
    peizi(){

    }
    peizi(String x )
    {
        System.out.println("沙比"+x);
    }
    peizi(int y)
    {
        System.out.println("你的辛运数字为"+y);
    }
}