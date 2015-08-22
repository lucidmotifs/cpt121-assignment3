import Attraction;

class ScheduledTour extends Attraction
{
  // Declare additional properties required by ScheduledTour

  // private:
  private String tourDate;
  private String tourLeader;

  private int maxGroupSize;

  // Dclare a new constructor to accept additional parameters
  public ScheduledTour( String attractionID,
                        String description,
                        double admissionFee,
                        String tourDate,
                        String tourLeader,
                        int maxGroupSize)
  {
    // Call the parent constructor to set basic properties
    super(attractionID, description, admissionFee);

    this.tourDate = tourDate;
    this.tourLeader = tourLeader;
    this.maxGroupSize = maxGroupSize;
  }

  // Mutator for the maxGroupSize property
  public void setMaxGroupSize(int value)
  {
    this.maxGroupSize = value;
  }

  // Override the sellPasses method to add a check for a group size
  // restriction
  public double sellPasses(int numberOfTourists)
  {
    // Ensure that this new booking won't cause maxGroupSize to be exceeded
    if ( this.bookingCount + numberOfTourists > this.maxGroupSize )
    {
      return double.NaN;
    }
    else
    {
      return super.sellPasses(numberOfTourists);
    }
  }

  public void printDetails()
  {
    // Call parent method first to print out basic details
    super.printDetails();

    // Print additional details
    System.out.printf("%s %s\n", "Tour Date:", tourDate);
    System.out.printf("%s %s\n", "Tour Leader:", tourLeader);
    System.out.printf("%s $%.2f\n", "Max Group Size:", maxGroupSize);
  }
}
