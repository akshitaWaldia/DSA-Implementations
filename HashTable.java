//Implementing HashTable
/*
Create HashNode class with K key, V value, int hashCode, constructor
Create Map Class which is implementation of HashTable using HashNode
Create array list with initial capacity and size, constructor: fill initial capacity with null
Functions:
getHashCode
getWhichBucketIndex
getSize //size of array currently filled
isEmpty
getValue(K key)
removeValue(K key)
add(K key, V value)
*/

import java.util.ArrayList;
import java.util.Objects;
class HashNode<K,V>{
     K key;
     V value;
     HashNode<K,V> next;
    final int hashCode;
    
    HashNode(K key, V value, int hashCode){
        this.key=key;
        this.value=value;
        this.hashCode=hashCode;
    }
}

class Map<K,V>{
    private ArrayList<HashNode<K,V>> indexChain;
    private int capacityOfChain;
    private int sizeOfChain;
    public Map(){
        indexChain=new ArrayList<>();
        capacityOfChain=10;
        sizeOfChain=0;
        for(int i=0;i<capacityOfChain;i++){
            indexChain.add(null);
        }
    }
    
    public int getHashCode(K key){
        return Objects.hashCode(key);
    }
    
    public int getWhichBucketIndex(K key){
        int hashCode = getHashCode(key);
        int thisBucketIndex= hashCode%capacityOfChain;
        thisBucketIndex= thisBucketIndex<0? thisBucketIndex*-1: thisBucketIndex;
        return thisBucketIndex;
    }
    
    public int getSize(){
        return sizeOfChain;
    }
    
    public boolean isEmpty(){
        return getSize()==0;
    }
    
    public V getValue(K key){
        /* we have key, we need to go to corresponding value: getWhichBucketIndex
        Traverse over arraylist starting from head
        */
        int hashCode = getHashCode(key);
        int thisBucket = getWhichBucketIndex(key);
        
        HashNode<K,V> head = indexChain.get(thisBucket);
        
        while(head!=null){
            if(head.key.equals(key)&&head.hashCode==hashCode)
                return head.value;
            head=head.next;
        }
        return null;
    }
    
    public V removeValue(K key){
        /*we have to remove value at particular key: find the key, hashcode match
        decrease size of indexChain
        we also need previous node in this case
        */
        int hashCode = getHashCode(key);
        int thisBucket = getWhichBucketIndex(key);
        
        HashNode<K,V> head = indexChain.get(thisBucket);
        HashNode<K,V> prev = null;
        while(head!=null){
            if(head.key.equals(key)&&hashCode==head.hashCode)
                break;
            prev=head;
            head=head.next;
        }
        
        if(head==null) //not found 
            return null;
        sizeOfChain--;
        
        if(prev!=null){
            prev.next=head.next;
        }
        else
            indexChain.set(thisBucket,head.next);
        
        return head.value;
    }
    
    public void add(K key, V value){
        int hashCode = getHashCode(key);
        int thisBucket = getWhichBucketIndex(key);
        
        HashNode<K,V> head = indexChain.get(thisBucket);
       
        while(head!=null){ //key already exists
            if(head.key.equals(key)&&head.hashCode==hashCode){
                head.value=value;
                return;
            }
            head=head.next;
        }
        sizeOfChain++;
        head = indexChain.get(thisBucket);
         HashNode<K,V> newNode = new HashNode<K,V>(key, value, hashCode);
        newNode.next=head;
        indexChain.set(thisBucket, newNode);
        
        if((1.0*sizeOfChain)/capacityOfChain >=0.7){
            ArrayList<HashNode<K,V>> temp = indexChain;
            indexChain = new ArrayList<>();
            capacityOfChain = 2*capacityOfChain;
            sizeOfChain = 0;
            for(int i=0;i<capacityOfChain;i++){
                indexChain.add(null);
            }
            for(HashNode<K,V> headNode: temp){
                while(headNode!=null){
                    add(headNode.key,headNode.value);
                    headNode=headNode.next;
                }
            }
        }
    }
    
    public static void main(String[] args){
        Map<String, Integer> map= new Map<>();
        map.add("this", 1);
        map.add("coder", 2);
        map.add("hi", 5);
        map.add("this", 6);
        map.add("0-43-",10);
        map.add("0-42L",20);
        System.out.println(map.getSize());
        System.out.println(map.getValue("hi"));
        System.out.println(map.getValue("0-43-"));
        System.out.println(map.getValue("0-42L"));
        System.out.println(map.removeValue("this"));
        System.out.println(map.getValue("this"));
        System.out.println(map.getSize());
        System.out.println(map.isEmpty());
    }
