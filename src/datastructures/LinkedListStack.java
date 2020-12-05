/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Hassan
 */
public class LinkedListStack<Item>
{
    private class Node
    {
        Item item;
        Node next;
    }
    private Node first;
    private int N;
    
    public void push(Item item)
    {
        Node Old = first;
        first=new Node();
        first.item = item;
        first.next = Old;
        N++;
    }
    public Item pop()
    {
        Item item  = first.item;
        first = first.next;
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
    

}
