interface Test1{
    void m1();
    default void m2(){
        System.out.println("Test1 m2");

    }

    default void m3(){
        System.out.println("Test1 m3");

    }
}

interface Test2{
    void m1();
    default void m2(){
        System.out.println("Test2 m2");

    }
    default void m4(){
        System.out.println("Test2 m4");

    }
}

class Sample implements Test1,Test2{
    @Override
    public void m1(){
        System.out.println("Sample m1");
        
     }
    
    @Override
    public void m2(){
        System.out.println("Sample m2");
        // super.m2(); // CE: because searching m2() in super Object class
        Test1.super.m2();
        Test2.super.m2();
     }
};

class Example{
    public static void main(String[] args) {

        Sample s1 = new Sample();
        s1.m1(); // searching in Sample executed from Sample
        s1.m2(); // searching in Sample executed from Sample
        s1.m3(); // searching in Sample,Test1 and Test3, executed from Test1
        s1.m4(); // searching in Sample,Test1 and Test3, executed from Test2

        System.out.println();

        Test1 t1 = new Sample();
        t1.m1(); // searching in Test1 interface executed from Sample class
        t1.m2(); // searching in Test1 interface executed from Sample class
        t1.m3(); // searching in Test1 executed from Test1 , because it is not implemented in class Sample
        // t1.m4(); // CE

        System.out.println();

        Test2 t2 = new Sample();
        t2.m1(); // searching in Test2 interface executed from Sample class
        t2.m2(); // searching in Test2 interface executed from Sample class
        // t2.m3(); //CE
        t2.m4();// searching in Test2 executed from Test2 because not implemented in class Sample
    }
};

interface Example3{
    // void m1(){}; // CE: interface abstract methods canont have body, default kw is missing

    default void m2(){}
    // private default void m3(){} // CE: modifier private is not allowed here

    // protected default void m3(){} // CE: modifier protected not allowed here
    
    public default void m5(){} // No CE 

    // static default void m6(){} //CE: illegal combination of modifiers static and default

    // final default void m6(){} // CE: modifier final not allowed here 

    // native default void m7(){} //CE: modifiers native not allowed here

    //  synchronized default void m8(){} // CE: modifiers synchronized not allowed here

    /*strictfp default void m9(){
        // in DM we can dp floating point (fp) 
        //hence strictfp is allowed here

        // for forcing JVM to do floating point calculations
        // strictly by following IEEE 754 standards we must declare a method as strictfp 
    } */
    
    default void m10(){}
    default int m1(){return 5;}
    default int[] m12(){return new int[5];}
    default String m13(){return "SK";}
    default String[] m14(){return new String[]{"SK","PK"};}
    default Sample m15() {return new Sample();}
    default Sample[] m16() {return new Sample[]{new Sample(),new Sample()};};

    default void m17(){};
    default void m18(int i){};
    default void m19(int []i){};
    default void m20(String i){};
    default void m21(String[] i){};
    default void m22(Sample i){};
    default void m23(Sample[] i){};

    default void m24() throws ArithmeticException{};
    default void m25() throws ArithmeticException,ClassNotFoundException{};

    // public strictfp default int m25(String s) throws InterruptedException{return 5;}
    
    // default abstract void m27(){}; // CE: illegal combination of modifiers : abstract and default
    // default abstract void m28(); // CE: illegal combination of modifiers : abstract and default


    
}

interface Example5{
    public abstract int hashCode(); // as abstract method allowed

    // public default boolean equals(Object obj){ // CE : as default method not allowed
        // CE: default method equals in interface Example5 overrides a member of java.lang.Object
    //     return true;
    // }
}