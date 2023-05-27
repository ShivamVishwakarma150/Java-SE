import java.util.*;
class Example6{
    public static void main(String[] args) {
        String [] days={"Mon","Tue","Wed"};
        List<String> myList=new java.util.ArrayList<>();
        Collections.addAll(myList,days);
        myList.add("Thu");
        System.out.println(myList);
    }
}