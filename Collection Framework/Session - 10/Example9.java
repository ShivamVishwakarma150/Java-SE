import java.util.*;
class Example9{
    public static void main(String[] args) {
        List <Integer>myList=new ArrayList<>();
        Collections.addAll(myList,10,15,20,25,30,40,50,55);
        
        Iterator<Integer>it=myList.iterator();
        it.remove();
      System.out.println("Final data:"+myList);
    }
}