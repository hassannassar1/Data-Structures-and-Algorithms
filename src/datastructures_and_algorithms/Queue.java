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
public class Queue {
     private int []a;
        private int N;
        private int o;
        public Queue(int M)
        {
            a = new int[M];
            N=0;
            o=0;
        }
        public void enqueue(int i)
        {
           a[N++]=i; 
        }
        public int Dequeue()
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
    
    
}
