import java.util.Scanner;
import java.util.Arrays;

class StringBuilder
 {
     private char[] char_array = new char[2]; //string-builder char-array
     private int length=0; //initial length of stringbuilder
     
     public StringBuilder append(char c){
         if(length==char_array.length){   //initial capacity(2) meeted
             char[] charBig = new char[2*length];
             charBig= Arrays.copyOf(char_array,2*length);   //copy all elements to 2x size bigger array
             char_array = charBig;  //reference our string-builder array to bigger array
         }
         char_array[length]=c;  //add the new character to string-builder 
         length++;  //length of string-builder increased by one
         return this;
         
     }
     public String toString(){
         return new String(char_array,0,length);  //return string-builder char-array from 0 to current length
     }
     public static void main(String args[])
     {
        StringBuilder s1 = new StringBuilder();
        s1.append('c');
        System.out.println(s1.toString());
       s1.append('b');
       System.out.println(s1.toString());
       s1.append('d');
       System.out.println(s1.toString());
        s1.append('c');
        System.out.println(s1.toString());
       s1.append('b');
       System.out.println(s1.toString());
       s1.append('d');
       System.out.println(s1.toString());
      
     }
}
