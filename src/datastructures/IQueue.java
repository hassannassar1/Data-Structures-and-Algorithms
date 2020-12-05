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
public class IQueue<Item> {
        private Item []a;
        private int N;
        private int o;
        public IQueue(int M)
        {
            a = (Item[])new Object[M];
            N=0;
            o=0;
        }

        public void enqueue(Item i)
        {
           a[N++]=i; 
        }
        public Item Dequeue()
        {  
            N--;
            return a[o++];
            
        }
        public int size()
        {
            return N;
        }
        public boolean isempty()
        {
            return a.length==0;//return N==0
        }
        public void display()
        {
            for(int i=0;i<N;i++)
            {
              System.out.println(a[i]);
            }
                
        }
}
