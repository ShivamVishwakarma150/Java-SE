import java.util.*;
class Example8a{
    public static void main(String[] args) {
        List <Integer>myList=new ArrayList<>();
        Collections.addAll(myList,10,15,20,25,30,40,50,55);
        for(Integer obj:myList){
            System.out.println(obj);
            if(obj%20==0)
            {
                myList.remove(obj);
            }
        }
      System.out.println("Final data:"+myList);
    }
}