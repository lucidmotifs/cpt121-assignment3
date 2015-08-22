/*
 * class BookingSystem
 * 
 * This code is a partially complete application for the booking system which 
 * implements a fully functional menu for CPT121 Assignment 3 in SP2 2015.
 * 
 * You are expected to work off this sample implementation of the BookingSystem
 * class - you *DO NOT* need to implement your own version of this program menu.
 * 
 * Note that the required program features as described in Stages 2 and 4 of the
 * Assignment 3 specification should be implemented in the corresponding helper 
 * methods further * down in the class.
 * 
 */

import java.util.Scanner;

public class BookingSystem
{
   // Declare the array of Tour references in which the Tour and
   // ScheduledTour objects that the user adds will be stored in and
   // the corresponding tour count.
   //
   // Note that this array and the corresponding counter will be
   // accessible both from within the main method as well as from
   // within any helper methods you may decide to implement.

   private static final Attraction[] attractionList = new Attraction[100];
   private static int attractionCount = 0;
   

   // Declaring a shared scanner just in case you choose to
   // implement some helper methods in your application class
   // that need access to one.

   private static final Scanner sc = new Scanner(System.in);

   public static void main(String[] args)
   {
      // variables required to process user's menu selection
      String input;
      char selection = '\0';

      // keep repeating the menu until the user chooses to exit
      do
      {
         // display menu options
         System.out.println("******* Tour Booking System Menu *******");
         System.out.println("");
         System.out.println("A - Add New Attraction");
         System.out.println("B - Display Attraction Summary");
         System.out.println("C - Sell Passes");
         System.out.println("D - Refund Passes");
         System.out.println("E - Add New Scheduled Tour");
         System.out.println("F - Update Maximum Group Size");
         System.out.println("X - Exit Program");
         System.out.println();

         // prompt the user to enter their selection
         System.out.print("Enter your selection: ");
         input = sc.nextLine();

         System.out.println();

         // check to see if the user failed to enter exactly one character
         // for their menu selection

         if (input.length() != 1)
         {
            System.out.println("Error - selection must be a single character!");

         }
         else
         {
            // extract the user's menu selection as a char value and
            // convert it to upper case so that the menu becomes
            // case-insensitive

            selection = Character.toUpperCase(input.charAt(0));

            // process the user's selection
            switch (selection)
            {
               case 'A':
                  
                  // call addNewAttraction() helper method
                  addNewAttraction();
                  break;

               case 'B':

                  // call displayAttractionSummary() helper method
                  displayAttractionSummary();
                  break;

               case 'C':

                  // call sellPasses() helper method
                  sellPasses();
                  break;

               case 'D':

                  // call refundPasses() helper method
                  refundPasses();
                  break;

               case 'E':

                  // call addNewScheduledTour() helper method
                  addNewScheduledTour();
                  break;
                  
               case 'F':

                  // call updateMaxTourGroupSize() helper method
                  updateMaxGroupSize();
                  break;
                  
               case 'X':

                  System.out.println("Booking system shutting down – goodbye...");
                  break;

               default:

                  // default case - handles invalid selections
                  System.out.println("Error - invalid selection!");

            }
         }
         System.out.println();

      } while (selection != 'X');

   }
   
      
   /*
    * addNewAttraction()
    * 
    * (insert brief description of method here - don't forget
    *  to include comments for each logical step in the method
    *  code itself!)
    */
   private static final void addNewAttraction()
   {   
      // Implement your code for Stage 2 Requirement A) here      
      // ...
      
      System.out.println("Add New Attraction Feature Selected!");
      
      
      
   }

   /*
    * displayAttractionSummary()
    * 
    * (insert brief description of method here - don't forget
    *  to include comments for each logical step in the method
    *  code itself!)
    */
   private static final void displayAttractionSummary()
   {
      // Implement your code for Stage 2 Requirement B) here      
      // ...

      System.out.println("Display Attraction Summary Feature Selected!");
   }
   
   /*
    * sellPasses()
    * 
    * (insert brief description of method here - don't forget
    *  to include comments for each logical step in the method
    *  code itself!)
    */
   private static final void sellPasses()
   {

      // Implement your code for Stage 2 Requirement C) here      
      // ...
      
      System.out.println("Sell Passes Feature Selected!");
   }
   
   /*
    * refundPasses()
    * 
    * (insert brief description of method here - don't forget
    *  to include comments for each logical step in the method
    *  code itself!)
    */
   private static final void refundPasses()
   {
      // Implement your code for Stage 2 Requirement D) here      
      // ...
      
      System.out.println("Refund Passes Feature Selected!");
   }
   


   /*
    * addNewScheduledTour()
    * 
    * (insert brief description of method here - don't forget
    *  to include comments for each logical step in the method
    *  code itself!)
    */
   private static void addNewScheduledTour()
   {

      // Implement your code for Stage 4 Requirement A) here      
      // ...

      System.out.println("Add New Scheduled Tour Feature Selected!");
   }
   
   /*
    * updateMaxTourGroupSize()
    * 
    * (insert brief description of method here - don't forget
    *  to include comments for each logical step in the method
    *  code itself!)
    */
   private static void updateMaxGroupSize()
   {
      // Implement your code for Stage 4 Requirement B) here      
      // ...
      
      System.out.println("Update Maximum Group Size Feature Selected!");
   }
}
