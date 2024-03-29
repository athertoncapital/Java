/*
* William Chuang
* Demos constructors, static vs instance methods, n method of overloadings
* 2015
*/
public class DemoClass
{
    private int x;

    public DemoClass()
    {
        // assign default value
        x = 0;
    }

    public DemoClass(int x)
    {
        this.x = x;
    }

    public DemoClass(DemoClass otherDemo)
    {
        this.x = otherDemo.x;
    }

    public static void s1() {
        return;
    }

    public void i1() {
        return;
    }

    public static void s2() {
	//        i1();     // compile-time error
        s1();
        return;
    }

    public void i2() {
        s1();
        i1();       // this.i1();
        return;
    }

    public void overloadTester() {
        System.out.println("overload testing:\n");

        overload((byte)1);
        overload((short)1);
        overload(1);
        overload(1L);
        overload(1.0f);
        overload(1.0);
        overload('1');
        overload(true);
    }
    
    public void overload(byte b) {
        System.out.println("byte");
    }    
    public void overload(short s) {
        System.out.println("short");
    }    
    public void overload(int i) {
        System.out.println("int");
    }
    public void overload(long l) {
        System.out.println("long");
    }
    public void overload(float f) {
        System.out.println("float");
    }
    public void overload(double d) {
        System.out.println("double");
    }    
    public void overload(char c) {
        System.out.println("char");
    }    
    public void overload(boolean b) {
        System.out.println("boolean");
    }    

    public static void main(String[] args) {
        DemoClass dc = new DemoClass();
        dc.overloadTester();
    }
}

// end the class
