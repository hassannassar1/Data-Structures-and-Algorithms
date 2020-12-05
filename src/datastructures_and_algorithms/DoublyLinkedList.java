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
public class DoublyLinkedList <Item> {
    private class Node
    {
        Item item;
        Node next;
        Node pre;
        
    }
    private Node first;
    private Node last;
    private int N;
    
    public void insertAtBeginning(Item item)
    {
        
        Node Old=first;
        first = new Node();
        first.item=item;
        first.pre=null;
        if(isempty())
        {
            first.next=null;
            last=first;
            
        }    
        else
            first.next=Old;
        N++;
    }
    public void insertAtEnd(Item item)
    {   
     Node Old = last;
     last = new Node();
     last.item=item;
     last.next=null;
     last.pre=Old;
     if(isempty())   
         first=last;
     else
         Old.next=last;
     N++;
     
     
    }
    public Item removeFromBeginning()
    {
        if (isempty())return null;
        Item item = first.item;
        if(first.next==null)return first.item;
        first=first.next;
        first.pre=null;
        N--;
        return item;
    }
    public Item removeFromEnd()
    {
        if(isempty())return null;
        Node temp=first;
        Node tem=new Node();
        Node te =new Node();
        if (temp.next==null)
        {
            return temp.item;
        }
        while(temp.next!=null)
        {
            te=tem;
            tem = temp;
            temp=temp.next;   
        }
        Item item = temp.item;
        tem.next=null;
        tem.pre=te;
        
        
        
        
       
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

   public Node f()
   {
       return first;
   }
}
