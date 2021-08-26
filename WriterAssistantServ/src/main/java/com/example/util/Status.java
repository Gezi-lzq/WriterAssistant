package com.example.util;

public class Status {
    public static String makeStatus(Integer status){
        if(status==1)return "complete";
        else if (status==2) return "incomplete";
        else return "draft";
    }

    public static Integer makeCode(String status){
        if (status.equals("complete")) return 1;
        else if (status.equals("incomplete")) return 2;
        else return 0;
    }
}
