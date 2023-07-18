public class StringEx {
    public static void main(String[] args) {
        StringBuffer sb1=new StringBuffer("sachin");
        StringBuffer sb2=new StringBuffer("sachin");

        System.out.println(sb1==sb2);// compares the reference so it gives => false
        System.out.println(sb1.equals(sb2));//false

        System.out.println("****************************************************");
        String s1=new String("sachin");
        String s2=new String("sachin");

        System.out.println(s1==s2);//false
        System.out.println(s1.equals(s2));//true
    }
}

/*
op:-

false
false
****************************************************
false
true


*/