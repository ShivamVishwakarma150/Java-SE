interface Example{
    void m1();
    default void m2(){
        System.out.println("Example DM m2 from Example interface");
    };
    static void m3(){
        System.out.println("Example SM m3 from Example interface");
    };
}

class Sample implements Example {
    public void m1(){
        System.out.println("Example AM m1 from Sample class");
    }
    public void m4(){
        this.m1();
        this.m2();
        // this.m3(); // CE: c f s
        //Sample.m3(); // CE: c f s
        Example.m3();
        // Example e1=null;
        // e1.m3(); // CE: This static method of interface Example can only be accessed as Example.m3()
    }
};


class Xyz implements Example{
    public void m1(){System.out.println("Example AM m1 from Xyz xlass");}
    public void m2(){System.out.println("Example DM m1 from Xyz xlass");}
    public static void m3(){System.out.println("Example SM m3 from Xyz");}
}

class Pqr implements Example{
    public void m1(){System.out.println("Example AM m1 from Xyz class" ); }
    public void m2(){System.out.println("Example DM m2 from Xyx class" ); }
    public void m3(){System.out.println("Example SM m3 from Xyx class" ); }
}

abstract class Mno implements Example{
    // public int m1(){System.out.println("Example AM m1 from Xyz class" ); }
    //public int m2(){System.out.println("Example DM m2 from Xyx class" ); }
     int m3(){System.out.println("Example SM m3 from Xyx class" ); return 5; }
}

class Efg implements Example{
    public void m1(){System.out.println("Example AM m1 from Efg class" ); }
    public void  m2(){System.out.println("Example DM m2 from Efg class" ); }
    public static int m3(){System.out.println("Efg SM m3 from Efg class" ); return 5; }
    
    void m4(){
        this.m1();
        this.m2();
        // this.m3(); // No CE
        Efg.m3();
        Example.m3();
    }
};

class Test{
    public static void main(String[] args) {
        Sample s1 = new Sample();
        s1.m1();
        s1.m2();
        // s1.m3(); // CE : Cannot find symbol
        Example e1 = new Sample();
        e1.m1();
        e1.m2();
        // e1.m3(); // CE : illegal static interface method call the receiver expression should be replaces with the qualifier "Example"

        System.out.println();
        Example.m3();
        // Sample.m3(); //CE

        System.out.println();

        s1.m4();
    }
}
