package com.vinci;

import java.util.ArrayList;
import java.util.List;

public class Test {
    
    int test(){
        try{
            return 1;
        }
        catch(Exception e){
            return 2;
        }
        finally{
            return 3;
        }
    }
    public static void main(String[] args) {
        int test = new Test().test();
        System.out.println(test);
    }
}


class Item{

}

interface Itemable{
    void doIt();
}