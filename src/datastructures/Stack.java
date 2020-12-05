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
public class Stack {
     private int []a;
        private int N;
        public Stack(int M)
        {
            a = new int[M];
            N=0;
        }
        public void push(int i)
        {
           a[N++]=i; 
        }
        public int pop()
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
    
}
