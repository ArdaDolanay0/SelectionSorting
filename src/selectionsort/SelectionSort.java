/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionsort;

import java.util.Scanner;
import java.util.Arrays;

/**Class
 * des: prompts the user for an array: the number of elements, random elements or user selected, 
 * and displays the sorted array to the user. The time it took to sort and number of comparisons
 * @author Arda, Noah, Ofosu
 */
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
    private static Scanner input = new Scanner(System.in);
    private static String answer;

    public static void main(String[] args) {

        //sets a scanner to take the user's input
        //prompts the user for a number of numbers
        System.out.print("How many numbers?: ");
        int n = input.nextInt();
        int[] nums = new int[n];

        //prompts the user for either random or normal number selection
        System.out.print("Random or normal?: ");
        answer = input.next();

        //if the user wants random, this code runs
        if (answer.equalsIgnoreCase("R")) {

            //generates the amount random numbers that the user wanted between 1 and 10
            for (int k = 0; k < n; k++) {
                int rand = (int) (Math.random() * (10 - 1) + 1);
                nums[k] = rand;
            }

            //outputs the array and the elapsed time
            outputting(nums);

            //if the user want normal number selection, this code runs
        } else if (answer.equalsIgnoreCase("n")) {

            //prompts the user for a number as many times as the user wants
            for (int o = 0; o < nums.length; o++) {
                System.out.print("What is a number?: ");
                nums[o] = input.nextInt();
            }
            //outputs the array and the elapsed time
            outputting(nums);

        }else{  //if the user doesn't pick the required input the program closes itself.
            System.out.println("Please enter a valid input(closing program)");
        }
        

    }

    /**Method
     * des: This method displays all the data corresponding to the nums method, 
     * an object is implemented in order to sort and display all the required values proportional to the sorting. Later displayed.
     *pre:none
     * post:creates an object and displays all the values gathered from the objects accomplishments.
     * @param nums
     */
    public static void outputting(int[] nums) {
        SelectionSorting newSorting = new SelectionSorting(nums); //makes a SelectionSorting object
        System.out.print("Iterative or Recursive?: ");   //promts the user for ilerative or recursive
        answer = input.next();             
        if(answer.equalsIgnoreCase("I")){ //runs if user wants ilerative
             System.out.println(Arrays.toString(newSorting.Isorting())); //prints and calls on a ilerative sorting version of selection sort
             System.out.println(newSorting.Duration()); //prints the duration
        }
        else if(answer.equalsIgnoreCase("R")){ //runs if user wants recursive
            System.out.println(Arrays.toString(newSorting.Rsorting(0))); //prints and calls on a recursive sorting version of selection sort
            System.out.println(newSorting.DurationR(0)); //prints duration
        }
       
        
        System.out.println(newSorting.comparisons() + " comparisons"); //prints out the number of comparisons that the sorting method took in order to sort
    }
}
