
package palindrome;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
        
/* @Author: Moses Charles Jr.
 * 
 * @Due Date:11/6/12
 * 
 * @Purpose: The purpose of this program is to read words from a file, push the
 * characters of the words into a stack and a queue one by one, then compare 
 * those characters to see if the total word is a palindrome.
 * 
 * @Data Structures: Stack and Queue
 * 
 * @Program usage: All the user has to do is supply an input file and the program
 * will find an print the palindromes in the file
 */
public class Palindrome {
    
    /**
     * The isPalindrome method returns true if the word is a palindrome
     * @param initWord
     * @return 
     */
    public static boolean isPalindrome(String initWord){
        Stack area1 = new Stack();                            //new stack
        Queue<Character> area2 = new LinkedList<Character>(); //new queue
        
            //set a new string to the first, but lowercase
            String currWord = initWord.toLowerCase();

            //pushes the letters into a stack 1 by 1
            for(int i=0; i<currWord.length(); i++){
                //convert the char to a Char object (Symmetry) 
                Character a = new Character(currWord.charAt(i));   
                
                //push the object ot the top of the stack
                area1.push(a);                                     
            }
            
            //same operation as above, but for the queue
            for(int i=0; i<currWord.length(); i++){
                Character a = new Character(currWord.charAt(i));   
                area2.add(a);                                     
            }
            
            //a boolean used to check if the characters in the stack and queue are equal
            boolean equalChars = true;
            
            /*while the queue has letters and equalChars remains true,
             *compare the stack and queue
             */
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
            
            return equalChars;  //return true or false.
        } 

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);  //takes user input
        Scanner fileInput = null;                   //takes a file specified by user
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
