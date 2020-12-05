/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Hassan
 * @param <Item>
 */
public class CircularLinkedList <Item>{
    private class Node
    {
        Item item;
        Node next;
    }
    private Node first;
    private Node last;
    private int N;
    public CircularLinkedList()
    {
        first=new Node();
        last =new Node();
    }
    
    public void insertAtBeginning(Item item)
    {
        
        Node Old=first;
        first = new Node();
        
        if(isempty())
        {
            Old.item=item;
            first=Old;
            last=Old; 
            Old.next=first;
        } 
        else
        {
           first.item=item;
           first.next=Old; 
           last.next=first;
        }
        N++;
    }
    public void insertAtEnd(Item item)
    {   
     Node Old = last;
     last = new Node();
     last.item=item;
     if(isempty())
     {
         last.next=last;
         first=last;
     }
     else
     {
        last.next=first;
        Old.next=last;

     }
     N++;
     
     
    }
    public Item removeFromBeginning()
    {
        if (isempty())return null;
        Item item = first.item;
        first=first.next;
        last.next=first;
        N--;
        return item;
    }
    public Item removeFromEnd()
    {
        if(isempty())return null;
        Node temp=first;
        Node tem=new Node();
        while(temp.next!=first)
        {
            tem = temp;
            temp=temp.next;   
        }
        Item item = temp.item;
        tem.next=first;
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
    
       public void display()
    {
        Node temp=first;
        if(N==0)System.out.println("Empty");
        else
        {
            System.out.println("DISPLAY");
            do{
                System.out.print("--"+temp.item);
                temp=temp.next;
            
        }while(temp!=first);
            
    }System.out.println();
    
} 
    
}
