import java.util.*;
class Example4{
    public static void main(String[] args) {
        String [] days={"Mon","Tue","Wed"};
        // List<String> myList = Arrays.asList(days); 
        List<String> myList=new ArrayList<>(Arrays.asList(days));
        myList.add("Thu");
        System.out.println(myList);
    }
}