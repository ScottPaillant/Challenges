/* package whatever; // don't place package name! */

import java.io.*;
import java.lang.*;
import java.util.*;

class NumberPronunciation
{
    public static void main (String[] args) throws java.lang.Exception
    {
       System.out.println(pronunciation(12313519));
    }
    
    // input : 1234 (type int)
    // output : one thousand two hundred thirty four (pronunciaton)
    // 
    // for every 3, index 0 is hundred, index 1 is tens ('four'-ty) , index 
    // 2 is the number 
    
    public static String pronunciation(int number){
    
        //intialized dictionary of edge cases (11-19) and to help 1-9 , 10-90 "-ty" words
        Hashtable<Integer, String> dictionary = new Hashtable<Integer, String>();
        dictionary.put(0,"");
        dictionary.put(1,"one");
        dictionary.put(2,"two");
        dictionary.put(3,"three");
        dictionary.put(4,"four");
        dictionary.put(5,"five");
        dictionary.put(6,"six");
        dictionary.put(7,"seven");
        dictionary.put(8,"eight");
        dictionary.put(9,"nine");
        dictionary.put(10,"ten");
        dictionary.put(11,"eleven");
        dictionary.put(12,"twelve");
        dictionary.put(13,"thirteen");
        dictionary.put(14,"fourteen");
        dictionary.put(15,"fifteen");
        dictionary.put(16,"sixteen");
        dictionary.put(17,"seveteen");
        dictionary.put(18,"eighteen");
        dictionary.put(19,"nineteen");
        dictionary.put(20,"twenty");
        dictionary.put(30,"thirty");
        dictionary.put(40,"fourty");
        dictionary.put(50,"fifty");
        dictionary.put(60,"sixty");
        dictionary.put(70,"seventy");
        dictionary.put(80,"eighty");
        dictionary.put(90,"ninety");
        
        Hashtable<Integer, String> places = new Hashtable<Integer, String>();
        places.put(0,"");
        places.put(1,"thousand ");
        places.put(2,"million ");
        places.put(3,"billion ");
        places.put(4,"trillion ");
        String numStr = Integer.toString(number);
        String totalPronunciation = "";
        
        //counter for thousands, millions, billions 
        int place = 0;
        
        int length = numStr.length();
        while(length > 0){
            String pronunciation = "";

            if( length-3 >= 0){
            
                //each section is the hundreds,tens, and ones place if applicable to whats left in the string.
                int section = Integer.parseInt(numStr.substring(length-3, length));
            
                pronunciation += dictionary.get( section / 100 ) + " hundred ";
                
                //if it is an known edge case 11-19
                if(dictionary.containsKey(section % 100))
                    pronunciation +=  dictionary.get( section % 100)   + " ";
                 else {
                    pronunciation +=  dictionary.get( Character.getNumericValue(numStr.charAt(length-2)) * 10)   + " ";
                    pronunciation +=  dictionary.get( section % 10 ) + " ";
                }
                    

            } else {
                if(length-2 >= 0){
                    int section = Integer.parseInt(numStr.substring(length-2, length));
            
                    if(dictionary.containsKey(section % 100))
                        pronunciation +=  dictionary.get( section % 100)   + " ";
                    else {
                            pronunciation += dictionary.get( Character.getNumericValue(numStr.charAt(length-2)) * 10)   + " ";
                            pronunciation += dictionary.get( section % 10 ) + " ";
                     }
                    
                 } else {
                    if(length-1 >= 0){  
                       int section = Integer.parseInt(numStr.substring(length-1, length));
            
                       if(section >= 1)
                           pronunciation += dictionary.get( section % 10 ) + " ";
                    } 
                }      
            }
               
            pronunciation += places.get(place);           
            totalPronunciation = pronunciation + totalPronunciation ;
            place++;
            length -= 3;     
        }
  
        return totalPronunciation;
    }
}
