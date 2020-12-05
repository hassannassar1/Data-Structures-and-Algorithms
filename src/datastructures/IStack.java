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
public class IStack <Item>
{
    private Item []a;
    private int N;
    public IStack(int M)
    {
        a = (Item[])new Object[M];
        N=0;
    }
    public void push(Item i)
        {
           a[N++]=i; 
        }
        public Item pop()
        {
            return a[--N];
        }
        public int size()
        {
            return N;
        }
        public boolean isempty()
        {
            return N==0;
        }
        public void display()
        {
            for(int i=N-1;i>=0;i--)
            {
              System.out.println(a[i]);
            }
                
        }
    
}