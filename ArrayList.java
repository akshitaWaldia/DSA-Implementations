import java.util.Scanner;
import java.util.Arrays;

class ArrayList
 {    
     private String[] al=new String[2];
     private int count=0;
     public void add (String s){
         if(count==al.length){
             String[] alBig = new String[2*count];
             alBig= Arrays.copyOf(al, 2*count);
             al = alBig;
         }
         al[count]=s;
         count++;
     }
     public void put(int i){
         System.out.println(al[i-1]);
     }
     
     public static void main(String args[])
     {
        
      ArrayList a = new ArrayList();
      a.add("abc");
      a.add("def");
      a.add("ghi");
      a.put(1);
      a.put(2);
      a.put(3);
      a.add("jkl");
      a.put(4);
      a.add("mno");
      a.put(5);
      a.add("pqr");
      a.put(6);
      String[] words={"stu","vwx","yz"};
      for(String w: words){
          a.add(w);
      }
      
          a.put(7);
          a.put(8);
          a.put(9);
      
     }
}
