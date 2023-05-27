import java.util.*;
class Example8{
    public static void main(String[] args) {
        List <Integer>myList=new ArrayList<>();
        Collections.addAll(myList,10,15,20,25,30,40,50,55);
        
        Iterator<Integer>it=myList.iterator();
        while(it.hasNext()){
          Integer obj=it.next(); 
           System.out.println(obj);
           if(obj%20==0)
              it.remove();
        }
      System.out.println("Final data:"+myList);
    }
}