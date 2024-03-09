import java.awt.desktop.SystemEventListener;

public class Main {
  public static void main(String[] args){
   System.out.println("***");

   System.out.println("Test Case 1, Operations On Small Numbers:");

   String n1 = "64";
   LinkedList l1 = new LinkedList();
   l1.stringToIntList(n1);
   String n2 = "2";
   LinkedList l2 = new LinkedList();
   l2.stringToIntList(n2);
   System.out.println("1st Number:" + n1);
   System.out.println("2nd Number:" + n2);

   System.out.println("Addition:" + Calculation.add(l1,l2));
   System.out.println("Subtraction:" + Calculation.subtract(l1,l2));
   System.out.println("Multiplication:" + Calculation.multiply(l1,l2));
   System.out.println("Division:" + Calculation.divide(l1,l2));

   System.out.println("***");

   System.out.println("Test Case 2, Operations On Large Numbers:");
   String largenum = "20000000000000000000000000000000000000000000000000000000";
   LinkedList largenumList = new LinkedList();
   largenumList.stringToIntList(largenum);
   String num = "6";
   LinkedList numList = new LinkedList();
   numList.stringToIntList(num);
   System.out.println("1st Number:" + largenum);
   System.out.println("2nd Number:" + num);

   System.out.println("Addition:" + Calculation.add(largenumList,numList));
   System.out.println("Subtraction:" + Calculation.subtract(largenumList,numList));
   System.out.println("Multiplication:" + Calculation.multiply(largenumList,numList));
   System.out.println("Division:" + Calculation.divide(largenumList,numList));

  }
}
