package com.jsonp.example.demo.service;

/**
 * @author lqm
 * @description
 * @createTime 2018 - 11 - 04 16:01
 */
public class Test {

    public static void main(String[] args) {
        String s="<h \"class=\"2\"><span class=\"cla\">ggggg</span></h>";
        int i = s.indexOf("\"");
        int start = s.indexOf("\"",i+1)+1;
        int end = s.indexOf("\"",start + 1);

        System.out.println(s);
        System.out.println(i);
        System.out.println("start="+start);
        System.out.println("end="+end);
        System.out.println("result="+s.substring(start,end));
    }
}
