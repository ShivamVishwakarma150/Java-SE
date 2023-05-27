import java.util.*;
class Example5{
    public static void main(String[] args) {
       List<Integer> myList=Arrays.asList(10,20,30);
       Iterator <Integer>it=myList.iterator();
       while(it.hasNext()){
        System.out.println(it.next());
       }
    }
}