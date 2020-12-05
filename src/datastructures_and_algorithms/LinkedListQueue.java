/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures_and_algorithms;

/**
 *
 * @author Hassan
 */

public class LinkedListQueue<Item> {
    private class Node
    {
        Item item;
        Node next;
    }
    private Node first;
    private Node last;
    private int N;
    
    public void enqueue(Item item)
    {   
     Node Old = last;
     last = new Node();
     last.item=item;
     last.next=null;
     if(isempty())
         first=last;
     else
         Old.next=last;
     N++;
    }
    public Item dequeue()
    { 
     Item item = first.item;
     first = first.next;
     if(isempty())
         last=null;
     N--;
     return item;
    }
    public int size()
    {
        return N;
    }
    public boolean isempty()
    {
        return N==0;//first.next==null;
    }
    public Node b()
    {
        return first;
    }
    
}
