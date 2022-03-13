package lab8;

public class IntListTest {

   public static void main(String[] args) {
      
      IntListSorted list = new IntListSorted();
      
      list.add(5);
      list.add(4);
      list.add(3);
      list.add(6);
      list.add(8);
      list.add(22);
      list.add(233);
//      list.add(0);
      System.out.println(list);
      System.out.println();
      System.out.println("Size: " + list.size());
      System.out.println("Min: " + list.getMinimum());
      System.out.println("Max: " + list.getMaximum());
      
      System.out.println("Median: " + list.getMedian());
      
   }
}