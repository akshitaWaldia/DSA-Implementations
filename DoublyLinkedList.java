//Linked List Implementation: Doubly Linked List
/* 
Operations:
Insertion: beginning, ith position, end 
Deletion: beginning, ith position, end
Search: ith element
*/
import java.util.*;
class DoublyLinkedList{
    
    Node head;
    class Node{
        Node next;
        Node prev;
        int data;
        
        Node(int d){
            data=d;
            next=null;
            prev=null;
        }
    }
        
    public  void insertAtBeginning(int j){
        Node n = new Node(j);
        if(head==null){
            head=n;
            return;
        }
        n.next=head;
        head.prev=n;
        head=n;
        
    }
        
   public  void insertAtEnd(int j){
       Node n=new Node(j);
        if(head==null){
            head=n;
            return;
        }
        Node temp=head;
        n.next=null;
        while(temp.next!=null)
            temp=temp.next;
        temp.next=n;
        n.prev=temp;
    }
    
    public  void insertAti(int j, Node before){
       
        Node n=new Node(j);
         if(head==null){
            head=n;
            return;
        }
        if(before.next!=null){
        before.next.prev=n;
        n.next=before.next;
        }
        n.prev=before;
        before.next=n;
    
        
    }
    
    public void deleteAti(int pos){
        if(pos==1){
            head=head.next;
            head.prev=null;
            return;
        }
        Node temp=head;
        for(int i=2;i<=pos;i++){
            if(temp.next!=null)
                temp=temp.next;
        }
      if(temp.next==null){
            temp.prev.next=null;
            return;
        }
        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
        
        
    }
    
    public boolean search(int ele){
        Node temp=head;
        while(temp.next!=null){
            if(temp.data==ele)
                return true;
            temp=temp.next;
        }
        return false;
    }
    
    public void sort(){
        Node current=head;
        Node after=null;
        
        int temp;
        while(current!=null){
            after=current.next;
            while(after!=null){
                if(after.data<current.data){
                    temp=after.data;
                    after.data=current.data;
                    current.data=temp;
                }after=after.next;
            }current=current.next;
        }
        
    }
        
       
    
    public static void main(String[] args){
       DoublyLinkedList l1=new DoublyLinkedList();
       
       l1.insertAtBeginning(5);
       l1.insertAtEnd(2);
       l1.insertAti(3,l1.head.next);
       l1.insertAtEnd(1);
       //l1.insertAtEnd(9);
       l1.deleteAti(3);
      // l1.sort();
      // System.out.println(l1.search(6));
       while(l1.head!=null){
                System.out.println(l1.head.data);
                l1.head=l1.head.next;
            }
    }
    
}
