import java.util.*;
public class sortInDecendingInHashMap {
    public static void main(String[] args) {
        Map<String,Integer>players=new HashMap<>();
        players.put("rohit",150);
        players.put("virat",200);
        players.put("shikhar",120);
        players.put("kedar",140);
        players.put("rahul",200);
        System.out.println("Before sorting:");
        for(Map.Entry<String,Integer>e:players.entrySet())
        {
            System.out.println(e.getKey()+","+e.getValue());
        }
        LinkedList<Map.Entry<String,Integer>> playersList=new LinkedList<>(players.entrySet());
        Collections.sort(playersList,new MyComparator());
        LinkedHashMap<String,Integer>sortedMap=new LinkedHashMap<>();
        for(Map.Entry<String,Integer>e:playersList)
        {
            sortedMap.put(e.getKey(),e.getValue());
        }
        System.out.println("After sorting:");
        for(Map.Entry<String,Integer>e:sortedMap.entrySet())
        {
            System.out.println(e.getKey()+","+e.getValue());
        }
     }
}
class MyComparator implements Comparator{
    public int compare(Object t1,Object t2){
        Map.Entry<String,Integer> e1=(Map.Entry<String,Integer>)t1;
        Map.Entry<String,Integer> e2=(Map.Entry<String,Integer>)t2;
        return e2.getValue().compareTo(e1.getValue());
    }
}