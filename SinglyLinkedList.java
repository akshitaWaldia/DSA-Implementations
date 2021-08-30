//Linked List Implementation: Singly Linked List
/* 
Operations:
Insertion: beginning, ith position, end 
Deletion: beginning, ith position, end
Search: ith element
Sort: linked list
*/
import java.util.*;
class SinglyLinkedList{
    
    Node head;
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
        n.next=head;
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
    }
    
    public  void insertAti(int j, Node prev){
        Node n=new Node(j);
        n.next=prev.next;
        prev.next=n;
        
    }
    
    public void deleteAti(int pos){
        if(pos==1){
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
       SinglyLinkedList l1=new SinglyLinkedList();
       
       l1.insertAtBeginning(5);
       l1.insertAtEnd(2);
       l1.insertAti(3,l1.head.next);
       l1.insertAtEnd(1);
       l1.insertAtEnd(9);
       l1.deleteAti(1);
       l1.sort();
       System.out.println(l1.search(6));
       while(l1.head!=null){
                System.out.println(l1.head.data);
                l1.head=l1.head.next;
            }
    }
    
}
