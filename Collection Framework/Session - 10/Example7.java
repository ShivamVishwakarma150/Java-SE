import java.util.*;
class Example7{
    public static void main(String[] args) {
        List <Integer>myList=new ArrayList<>();
        Collections.addAll(myList,10,15,20,25,30,40,50,55);
        
        Iterator<Integer>it=myList.iterator();
        while(true){
           Integer obj=it.next(); // Will throw NoSuchElementException at the end
           System.out.println(obj);
        }
      
    }
}