import java.text.SimpleDateFormat;

/**
 * Created by jack on 2017/5/30.
 * 这里测试了一些内部类，匿名内部类的相关规则
 */
public class InnerClassTest {
    static int localV= 1;
    //public abstract void c();//这句是错的，不能在非abstract类里定义abstract方法
    SimpleDateFormat sd;
    public testInterface d(){
        return new testInterface(){
            public void xx(){
                System.out.println("xxxxxxxxx");
            }
        };
    };
    static class innerClass{
        public static void a(){ }
        public void b(){};
    }
    abstract class innerClass2{
        public abstract void a();
        public void b(){}
    }
    class innerClass3{
        public void a() {
            InnerClassTest.this.localV = 5;
        }
        protected void b(){ }
        int t = InnerClassTest.this.localV;
        //public static void b(){}//这句是错的，不能在非static内部类里定义static方法
    }
    public void test(){
        innerClass3 s = new innerClass3();
    }
    public static void main(String[] args){
        InnerClassTest s = new InnerClassTest();
        innerClass3 t = s.new innerClass3();
        t.b();
        testInterface d = s.d();
        d.xx();//这个是执行匿名内部类的方法
    }
    interface testInterface{
        public void xx();
    }
}
class testProtected{//这个是测试protected的作用范围
    int s = 3;
    public void s(){
        s = InnerClassTest.localV;
    }
}

