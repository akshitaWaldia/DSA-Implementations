//Linked List Implementation: Circular Linked List
/* 
Operations:
Insertion: beginning, ith position, end 
Deletion: beginning, ith position, end
Search: ith element
*/
import java.util.*;
class CircularLinkedList{
    
    static Node tail;
    static Node head;
    class Node{
        Node next;
        int data;
        
        Node(int d){
            data=d;
            next=null;
        }
    }
        
    public  void insertAtBeginning(int j){
        Node n = new Node(j);
        if(head==null){
            head=n;
            tail=n;
            tail.next=head;
            return;
        }
        
        tail.next=n;
        n.next=head;
        head=n;
        
    }
        
   public  void insertAtEnd(int j){
       Node n=new Node(j);
        if(head==null){
            head=n;
            tail=n;
            tail.next=head;
            return;
        }
       tail.next=n;
       tail=n;
       tail.next=head;
       
    }
    
    public  void insertAti(int j, Node before){
       
        Node n=new Node(j);
         if(head==null){
            head=n;
            tail=n;
            tail.next=head;
            return;
        }
        if(before==tail){
        before.next=n;
        n.next=before.next;
        tail=n;
        return;
        }
        n.next=before.next;
        before.next=n;
    
        
    }
    
    public void deleteAti(int pos){
        if(pos==1){
            tail.next=head.next;
            head=head.next;
            return;
        }
        Node temp=head;
        for(int i=2;i<pos;i++){
            if(temp.next!=null)
                temp=temp.next;
        }
        
        temp.next=temp.next.next;
        
        
    }
    
    public boolean search(int ele){
        Node temp=head;
        do{
            if(temp.data==ele)
                return true;
            temp=temp.next;
        }while(temp.next!=head);
        return false;
    }
    
    
        
       
    
    public static void main(String[] args){
       CircularLinkedList l1=new CircularLinkedList();
       
       l1.insertAtBeginning(5);
       l1.insertAtBeginning(2);
       l1.insertAti(3,l1.head.next);
      l1.insertAtBeginning(1);
      l1.insertAtEnd(9);
     l1.deleteAti(3);
      
      System.out.println(l1.search(3));
      
      Node t=head;
       do{
                System.out.println(t.data);
                t=t.next;
            }while(t!=head);
    }
    
}
