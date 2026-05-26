package GreeksForGeeks;

import java.util.*;
public class Insert_Element_At_Bottom_Of_a_Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= 5; i++){
            stack.push(i);
        }

        insertAtBottom(stack, 7);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }



    }

    public static Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {

        //base case..
        insert(st, x);
        return st;
    }

    static void insert(Stack<Integer> stack, int x){


        if(stack.isEmpty()){
            stack.push(x);
            return;
        }
        int element = stack.pop();
        insert(stack, x);
        stack.push(element);

        return;
    }
}
