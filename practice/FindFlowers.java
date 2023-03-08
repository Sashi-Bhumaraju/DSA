package practice;

import java.util.HashMap;

public class FindFlowers {

    
    public static void main(String[] args) {
        HashMap<Character,String> phone = new HashMap<Character,String>();
        phone.put('1',"");
        phone.put('2',"abc");
        phone.put('3',"def");
        phone.put('4',"ghi");
        phone.put('5',"jkl");
        phone.put('6',"mno");
        phone.put('7',"pqrs");
        phone.put('8',"tuv");
        phone.put('9',"wxyz");
        phone.put('0',"");

        String input = "18003569377";

        StringBuffer pro = new StringBuffer();
        HashMap<Character,String> pros = new HashMap<Character,String>();
        for(int i = 0 ; i < input.length(); i++) {
            if( !pros.containsKey(input.charAt(i)) ){
                pros.put(input.charAt(i),phone.get(input.charAt(i)));
            }
        }
        System.out.print(pros);
    }
}
