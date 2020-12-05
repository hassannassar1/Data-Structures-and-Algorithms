/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures_and_algorithms;
import java.util.Iterator;
/**
 *
 * @author Hassan
 */
public class LinkedListBag<Item> implements Iterable<Item> {

private Node first; // first node in list
private class Node
{
Item item;
Node next;
}
public void add(Item item)
{ // same as push() in Stack
Node oldfirst = first;
first = new Node();
first.item = item;
first.next = oldfirst;
}
public Iterator<Item> iterator()
{ return new ListIterator(); }
private class ListIterator implements Iterator<Item>
{
private Node current = first;
public boolean hasNext()
{ return current != null; }
public void remove() { }
public Item next()
{
Item item = current.item;
current = current.next;
return item;
}
}
}
    

