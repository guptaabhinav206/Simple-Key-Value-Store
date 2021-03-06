package com.company;

import java.util.*;

/**
 * Created by abhinav on 3/12/16.
 */
public class Cache {

    protected int capacity;
    protected LinkedHashMap<Integer, Node> map = new LinkedHashMap<Integer, Node>();
    protected Node head=null;
    protected Node tail=null;
    
    // Assigning cache capacity
    public Cache(int capacity) {
        this.capacity = capacity;
    }

    // Get value based on key O(1)
    public int get(int key) {

        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            bringFront(node);
            return node.value;
        }
        return -1;
    }
    
    // Get values based on key and version O(N)
    public int get(int key, int version) {

        if (map.containsKey(key)) {
                Node node = map.get(key);
                while(node!=null && version>0 ){
                    node=node.next;
                    if(node.key==key){
                        version--;
                    }
                }
                return node.value;
            }
/*
        List<Node> list = new ArrayList<Node>(map.values());
        List<Integer> list2 = new ArrayList<Integer>(map.keySet());
        System.out.println(list2.get(0));
        for(Iterator<Node> itr = list.iterator(); itr.hasNext();){
            System.out.print(itr.next().value+" ");
        }
*/
        return -1;
    }
    
    // Deletes node when try to exceed the cache capacity O(1)
    public void remove(Node node){

        if(node.pre!=null)
            node.pre.next = node.next;
        else
            head = node.next;
        if(node.next!=null)
            node.next.pre = node.pre;
        else
            tail = node.pre;
    }

    // Assign head of the list to the latest key queried O(1)
    public void bringFront(Node node){

        node.next = head;
        node.pre = null;
        if(head!=null)
            head.pre = node;
        head = node;
        if(tail ==null)
            tail = head;
    }
    
    // Adding key and value pair to the Map and List O(1)
    public void set(int key, int value) {

        if(map.containsKey(key)){
            Node node= new Node(key, value);
            bringFront(node);
            map.put(key, node);
        }else{
            Node newNode = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(tail.key);
                remove(tail);
                bringFront(newNode);
            }else{
                bringFront(newNode);
            }
            map.put(key, newNode);
        }
    }
    
    // Displaying cache
    public void display(){

        Node temp = head;
        while (temp!=null){
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
        System.out.println();
    }

}
