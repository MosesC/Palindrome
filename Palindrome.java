/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
        
/**
 *
 * @author SirCharles
 */
public class Palindrome {
    
    /**
     * The isPalindrome method returns true if 
     * @param initWord
     * @return 
     */
    public static boolean isPalindrome(String initWord){
        Stack area1 = new Stack();                            //new stack
        Queue<Character> area2 = new LinkedList<Character>(); //new queue
        
            String currWord = initWord.toLowerCase();//set a new string to the first, but lowercase

            //pushes the letters into a stack 1 by 1
            for(int i=0; i<currWord.length(); i++){
                Character a = new Character(currWord.charAt(i));   //convert the char to a Char object (Symmetry) 
                area1.push(a);                                     //push the object ot the top of the stack
            }
            
            //places  the letters into a queue
            for(int i=0; i<currWord.length(); i++){
                Character a = new Character(currWord.charAt(i));   //convert the char to a Char object
                area2.add(a);                                      //place the Char object into the Queue
            }
            
            boolean equalChars = true;
            
            while(area2.isEmpty() == false && equalChars == true){
                Character queueFront = (Character) area2.remove();
                Character stackTop = (Character) area1.pop();
                
                //if the front of the queue is not equal to the top of the stack, return false
                if(queueFront.equals(stackTop)==false){
                    equalChars = false;
                }
            }
            //if the word is a Palindrome, print it
            if(equalChars == true){
                System.out.println(currWord);
            }
            return equalChars;
        } 

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);  //takes user input
        Scanner fileInput = null;                          //takes a file specified by user
        File inFile;                                //handle of the input file
        
        try{
            System.out.println("Enter name of file to use: ");
            inFile = new File(keyboard.nextLine()); //reads input
            
            //sets user file to fileInput
            fileInput = new Scanner(inFile);        
            
            //if the file is empty exit
            if(fileInput.hasNext()==false){
                System.out.println();
                System.exit(1);
            }
        }
        //if the file does not exist, exit
        catch(FileNotFoundException e){
            System.out.println();
            System.exit(1);
        }
        
        //prints the string if it's a Palindrome
        while(fileInput.hasNext()){
            isPalindrome(fileInput.next());
        }
    }
}
