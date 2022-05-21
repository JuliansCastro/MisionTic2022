/*
 * Misión TIC 2022
 * Reto 1
 */
package main;

/*
 * @author JULIAN C
 */

import java.util.Scanner;

public class archivo {
    
    public static void main(String[] args) {      
        Scanner sc = new Scanner(System.in);
        
        int sam = sc.nextInt();
        int bucky = 2*sam + 4;
        int johnWalker = (bucky/2 + 2*sam +2) / 5;
                
        System.out.println(sam + " " + bucky + " " + johnWalker);
        
        if (johnWalker >=0 && johnWalker < 21){
            System.out.println("uno");
        }
        else if (johnWalker > 20 && johnWalker < 31){
            System.out.println("dos");
        }
        else if (johnWalker > 30 && johnWalker < 51){
            System.out.println("tres");
        }
        else if (johnWalker > 50){
            System.out.println("cuatro");
            
        }//end if
    }//end main
}//end class
