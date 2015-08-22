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

                  System.out.println("Booking system shutting down � goodbye...");
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
    * attractionExists(String attractionID)
    *
    * Search the attraction list using the unique ID and return the index
    * or the attraction in the list, if exists, otherwise -1 indicating
    * an attracion with that ID doesn't exist.
    *
    */
   private static final int attractionLookup(String attractionID)
   {
      for (int i; i < attractionCount; i++)
      {
         if ( attractionList[i].compareTo( attractionID ) == 0 )
            return i;
      }
      return -1;
   }


   /*
    * addNewAttraction()
    *
    * Takes user input and adds new attraction to the list if the ID
    * the user enters is unique.
    *
    */
   private static final void addNewAttraction()
   {
      System.out.println("Add New Attraction Feature Selected!");

      // Declare input variables;
      String attractionID;
      String description;
      double admissionFee;

      // prompt the user to enter the ID
      System.out.print("Enter the unique Attraction ID: ");
      attractionID = sc.nextLine();

      // prompt the user to enter the description
      System.out.print("Enter a description: ");
      description = sc.nextLine();

      // prompt the user to enter the fee
      System.out.print("Enter the admission fee: ");
      admissionFee = sc.nextDouble();

      // clear the scanner
      sc.nextLine();

      // Check there is room for another attraction in the list
      if ( this.attractionCount < this.attractionList.length)
      {
         // Ensure an attraction with this ID doesn't exist
         if ( this.attractionLookup(attractionID) == -1 )
         {
            // Create new attraction object
            Attraction _attraction;
            _attraction = new Attraction(attractionID, description, admissionFee);

           // Add attraction to the list
           this.attractionList[this.attractionCount] = _attraction;
           this.attractionCount++;
        }
        else
        {
           System.out.println("An Attraction with this ID already exists!");
        }
      }

   }

   /*
    * displayAttractionSummary()
    *
    * Loop through the currently stored attractions and print the details
    * for each item.
    *
    */
   private static final void displayAttractionSummary()
   {
      System.out.println("Display Attraction Summary Feature Selected!");
      System.out.println();

      // Loop through and print details
      for (int i; i < attractionCount; i++)
         this.attractionList[i].printDetails();
   }

   /*
    * sellPasses()
    *
    * Sell passes to a user specified attraction by prompting the user
    * for the attraction's ID and then calling the method from an attraction
    * object if the ID supplied is valid.
    */
   private static final void sellPasses()
   {
      System.out.println("Sell Passes Feature Selected!");

      // Declare input variables;
      String attractionID;
      int numberOfTourists;

      // prompt the user to enter the ID
      System.out.print("Enter the unique Attraction ID: ");
      attractionID = sc.nextLine();

      // declare variable to hold result of sellPasses
      double result;

      // Find the attraction via ID and call sellPasses, or error.
      if ( int index = this.attractionLookup(attractionID) )
      {
         // prompt the user to enter the number of tourists
         System.out.print("Enter the number of tourists: ");
         numberOfTourists = sc.nextInt();

         // clear scanner
         sc.nextLine();

         result = this.attractionList[index].sellPasses(numberOfTourists);
      }
      else
      {
         // Attraction not found in list, print error and set result to NaN
         result = double.NaN;

         System.out.println("Attraction could not be found!");
      }

      if ( result == double.NaN )
      {
         System.out.println("Attempt to purchase passes was unsuccessful.");
      }
      else
      {
         System.out.printf(
            "Passes booked successfully. Booking cost: %.2f", result);
      }
   }

   /*
    * refundPasses()
    *
    * Ask the user to supply an attraction ID and number of tourists
    * and then call the refund method from the specified attraction if the
    * ID supplied is valid.
    */
   private static final void refundPasses()
   {
      System.out.println("Refund Passes Feature Selected!");

      // Declare input variables;
      String attractionID;
      int numberOfTourists;

      // prompt the user to enter the ID
      System.out.print("Enter the unique Attraction ID: ");
      attractionID = sc.nextLine();

      // declare variable to hold result of sellPasses
      double result;

      // Find the attraction via ID and call sellPasses, or error.
      if ( int index = this.attractionLookup(attractionID) )
      {
         // prompt the user to enter the number of tourists
         System.out.print("Enter the number of tourists: ");
         numberOfTourists = sc.nextInt();

         // clear scanner
         sc.nextLine();

         result = this.attractionList[index].refundPasses(numberOfTourists);
      }
      else
      {
         // Attraction not found in list, print error and set result to NaN
         result = double.NaN;

         System.out.println("Attraction could not be found!");
      }

      if ( result == double.NaN )
      {
         System.out.println("Attempt to refund passes was unsuccessful.");
      }
      else
      {
         System.out.printf(
            "Passes refunded successfully. Amount refunded: %.2f", result);
      }
   }



   /*
    * addNewScheduledTour()
    *
    * Creates and adds a Scheduled Tour object to the attraction list
    *
    *
    */
   private static void addNewScheduledTour()
   {
      System.out.println("Add New Scheduled Tour Feature Selected!");

      // Declare input variables;
      String attractionID;
      String description;
      double admissionFee;
      String tourDate;
      String tourLeader;
      int maxGroupSize;

      // prompt the user to enter the ID
      System.out.print("Enter the unique Attraction ID: ");
      attractionID = sc.nextLine();

      // prompt the user to enter the description
      System.out.print("Enter a description: ");
      description = sc.nextLine();

      // prompt the user to enter the fee
      System.out.print("Enter the admission fee: ");
      admissionFee = sc.nextDouble();

      // clear the scanner
      sc.nextLine();

      // prompt the user to enter the tour date
      System.out.print("Enter the tour date: ");
      tourDate = sc.nextLine();

      // prompt the user to enter the tour leader's name
      System.out.print("Enter a tour leader: ");
      tourLeader = sc.nextLine();

      // prompt the user to enter the maximum group size
      System.out.print("Enter the maximum group size: ");
      maxGroupSize = sc.nextInt();

      // clear the scanner
      sc.nextLine();

      // Check there is room for another attraction in the list
      if ( this.attractionCount < this.attractionList.length )
      {
         // Ensure an attraction with this ID doesn't exist
         if ( this.attractionLookup(attractionID) == -1 )
         {
            // Create new ScheduledTour object
            ScheduledTour _tour;
            _tour = new ScheduledTour( attractionID,
                                       description,
                                       admissionFee,
                                       tourDate,
                                       tourLeader,
                                       maxGroupSize);

            // Add attraction to the list
            this.attractionList[this.attractionCount] = _tour;
            this.attractionCount++;
        }
        else
        {
           System.out.println(
              "An Attraction or Tour with this ID already exists!");
        }
      }
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
      System.out.println("Update Maximum Group Size Feature Selected!");

      // Declare input variables;
      String attractionID;
      int maxGroupSize;

      // prompt the user to enter the ID
      System.out.print("Enter the unique Attraction ID: ");
      attractionID = sc.nextLine();

      // Find the tour via ID and call sellPasses, or error.
      if ( int index = this.attractionLookup(attractionID) )
      {
         // Check return object is a ScheduledTour
         if ( this.attractionList[index] instanceof ScheduledTour )
         {
            // prompt the user to enter the number of tourists
            System.out.print("Enter the new max group size: ");
            maxGroupSize = sc.nextInt();

            // clear scanner
            sc.nextLine();

            _tour = (ScheduledTour)_tour;
           _tour.setMaxGroupSize(maxGroupSize);

           System.out.println("Maximum group size updated successfully.");
        }
        else
        {
           System.out.println(
              "Only a Scheduled Tour can have a maximum group size.");
        }
      }
      else
      {
         System.out.println("No Tour found using provided ID!");
      }
   }
}
