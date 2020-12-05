/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Hassan
 * @param <Key>
 * @param <Value>
 */
public class ST<Key extends Comparable<Key>, Value>
{
    private int N=0;
    private class Node
    {
       Value val;
       Key key;
       Node next;
       public Node(Key key, Value val, Node next)
       {
            this.key = key;
            this.val = val;
            this.next = next;
       }
    }
       Node first =null;
       Node last =null;
    public ST()
    {


    }
    public void put(Key key,Value value)
    {
        if (first==null)
        {
           Node newnode=new Node(key,value,null); 
           last=first=newnode;
           N++;
        }
        else if(first!=null)
        {
            if(first.key.compareTo(key)==1)
            {
                Node old=first;
                first = new Node(key,value,old); 
                N++;
            }
            else if(last.key.compareTo(key)==-1)
            {
                Node newnode=new Node(key,value,null);
                last.next=newnode;
                last=newnode;
                N++;
            }
            else
            {
                
                Node temp=first;
                Node current=null;
                while(temp.next!=null)
                {
                    current=temp.next;
                    if(temp.key.compareTo(key)==-1&&current.key.compareTo(key)==1)
                    {
                       Node old = current;
                       Node newnode = new Node(key,value,old);
                       temp.next=newnode;
                       N++;
                       break;
                    }
                    temp=current;
                }
            }
        }
        
    }
    public Value kget(Key key)
    {
        if (first.key.compareTo(key)==0)return first.val;
        else if(last.key.compareTo(key)==0)return last.val;
        else
        {
            Node temp =first.next;
            while (temp!=last)
            {
             if (temp.key.compareTo(key)==0)  return temp.val;
                     temp=temp.next;
            }
        }
        return null;
    }
    public void remove(Key key)
    {
     if(first.key==key)removeMin();  
     else if(last.key==key)removeMax();
     else
     {
         Node temp =first.next;
         Node current = first;
         while (temp.next!=last)
         {
          if (temp.key.compareTo(key)==0) 
          {
              current.next=temp.next;
              temp.next=null;
              break;
          }
          current=current.next;
          temp=temp.next;
          
          
         }
         
     }
     N--;
    }
    
    public int rank(Key key)
    {
        if (first.key.compareTo(key)==0)return 0;
        else if(last.key.compareTo(key)==0)return size()-1;
        else
        {
            int rank = 1;
            Node temp =first.next;
            while (temp!=last)
            {
             if (temp.key.compareTo(key)==0)  return rank;
                     temp=temp.next;
                     rank++;
            }
        }
        return -1;
        
    }
    public Key select(int rank)
    {
        if(rank>size()-1||rank<0)return null;
        {
            
        }
        Node item =first;
        for (int i=0;i<rank;i++)
        {
            item=item.next;
        }
        return item.key;
    }
    public void max()
    {
        System.out.println("Key : "+last.key+" Value : "+last.val);
    }
    public void min()
    {
        System.out.println("Key : "+first.key+" Value : "+first.val);
    }
    public void removeMax()
    {
     Node temp =first;
     while(temp.next!=last)
     {
         temp=temp.next;
     }
     temp.next=null;
     last=temp;
     N--;
    }
    public void removeMin()
    {
        Node temp =first;
        temp=temp.next;
        //first.next=null;
        first=temp;
        N--;
    }
    
    public Key floor(Key key)
    {
        Node temp=first;
        Node current=null;
        if (first.key.compareTo(key)==0)return null;
        while(temp.next!=null)
        {
            current=temp.next;
            
            if((temp.key.compareTo(key)==-1&&current.key.compareTo(key)==1)||current.key.compareTo(key)==0)
            {
               return temp.key;
            }
            temp=current;
        }
        return null;
        
    }
    public Key ceilling(Key key)
    {
        Node temp=first;
        Node current=null;
        if (last.key.compareTo(key)==0)return null;
        while(temp.next!=null)
        {
            current=temp.next;
            if((temp.key.compareTo(key)==-1&&current.key.compareTo(key)==1)||temp.key.compareTo(key)==0)
            {
               return current.key;
            }
            temp=current;
        } 
        return null;
    }
    public void display()
    {
        Node temp=first;
        while(temp.next!=null)
        {
            System.out.println(temp.val);
            temp=temp.next;
        }
        System.out.println(temp.val);
    }
    public int size()
    {
        return N;
    }
    public int size(Key lo, Key hi)
    {
        if (hi.compareTo(lo) < 0)return 0;

        return rank(hi)-rank(lo)-1;
    }
    public boolean isempty()
    {
        return N==0;
    }
    
}
