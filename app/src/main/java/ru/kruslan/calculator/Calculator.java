package ru.kruslan.calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class Calculator {
    public static double calculate(String srs, String srs1) {
        Character buf_char;
        String buf_str="";
        ArrayList<String> buf=new ArrayList<>();
        ArrayList<String> buf_2=new ArrayList<>();
        for (int i=0;i<srs.length();i++) {
            buf_char=srs.charAt(i);
            if (Character.isDigit(buf_char)||buf_char=='.') buf_str+=buf_char;
            else {
                if (buf_str!="") buf.add(buf_str);
                buf.add(buf_char.toString());
                buf_str="";
            }
        }
        if (buf_str!="") buf.add(buf_str);
        buf_str="";
        ArrayList<String> buf1=strToPPN(buf);

        double res=calcPPN(buf1);
        if (srs1!="") {
            for (int i=0;i<srs1.length();i++) {
                buf_char=srs1.charAt(i);
                if (Character.isDigit(buf_char)||buf_char=='.') buf_str+=buf_char;
                else {
                    if (buf_str!="") buf_2.add(buf_str);
                    buf_2.add(buf_char.toString());
                    buf_str="";
                }
            }
            if (buf_str!="") buf_2.add(buf_str);

            ArrayList<String> buf2=strToPPN(buf_2);
            res=res/calcPPN(buf2);
        }


        return res;


    }

    private static double calcPPN(ArrayList<String> srs) {
        Stack<Double> stack = new Stack<>();
        Character buf_char;
        String buf_str;
        Double p1;
        Double p2;
        for (int i=0;i<srs.size();i++) {
            buf_str=srs.get(i);
            buf_char=buf_str.charAt(0);
            if (Character.isDigit(buf_char)||buf_char=='.') stack.push(Double.valueOf(buf_str));
            else  {
                switch(buf_char) {
                    case '+':
                        p2=stack.pop();
                        p1=stack.pop();
                        stack.push(p1+p2);
                        break;
                    case '-':

                        p2=stack.pop();
                        p1=stack.pop();
                        stack.push(p1-p2);
                        break;
                    case 'x':

                        p2=stack.pop();
                        p1=stack.pop();
                        stack.push(p1*p2);
                        break;
                    case '/':
                        p2=stack.pop();
                        p1=stack.pop();
                        stack.push(p1/p2);
                        break;
                }
            }
        }
        return stack.pop();
    }


    private static ArrayList<String> strToPPN(ArrayList<String> srs){
        HashMap<Character, Integer> map=new HashMap<>();
        map.put('+',2);
        map.put('-',2);
        map.put('x',3);
        map.put('/',3);
        map.put('%',3);
        map.put('(',1);
        Stack<Character> stack = new Stack<>();
        ArrayList<String> res=new ArrayList<>();;
        Character buf_char;
        String buf_str;
        for (int i=0;i<srs.size();i++){
            buf_str=srs.get(i);
            buf_char=buf_str.charAt(0);
            if (Character.isDigit(buf_char)||buf_char=='.') res.add(buf_str);

            if(buf_char=='x'||buf_char=='/'||buf_char=='+'||buf_char=='-'||buf_char=='%'){



                if (!stack.empty()&&map.get(buf_char)<map.get(stack.peek())) {
                    while(!stack.empty()&&map.get(buf_char)<map.get(stack.peek())) res.add(stack.pop().toString());
                    stack.push(buf_char);
                }
                else stack.push(buf_char);

            }
            if(buf_char=='(') stack.push(buf_char);
            if (buf_char==')') {
                while (!stack.empty()&&map.get(stack.peek())!=1) res.add(stack.pop().toString());
                if (!stack.empty()&&map.get(stack.peek())==1) stack.pop();
            }
        }
        while (!stack.empty()) res.add(stack.pop().toString());
        return res;

    }



}
