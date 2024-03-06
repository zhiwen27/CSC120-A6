/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building{

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors) {
    super(name, address, nFloors);
    System.out.println("You have built a house 🏠: " + this.name);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = false;    /* assume the house doesn't have dining room initially */
  }

  /**
   * Setter for hasDiningRoom
   * @param hasDiningRoom indicate if the house has a dining room
   */
  public void setDiningRoom(boolean hasDiningRoom){
    this.hasDiningRoom = hasDiningRoom;
  }

  /**
   * Getter for hasDiningRoom
   * @return if the house has dining room
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * Getter for the size of array list resident
   * @return the number of residents in the house
   */
  public int nResidents(){
    return this.residents.size();
  }

  /**
   * Check if someone lives in the house
   * @param person pass in the person you want to inquire
   * @return whether the person lives in the house
   */
  public boolean isResident(String person){
    return residents.contains(person);
  }

  /**
   * Add a person to the house
   * @param name indicate the person you want to add to the house
   */
  public void moveIn(String name){
    if (this.isResident(name)){
      throw new RuntimeException(name + "is already in the house!");    /* check if the person is already in the house */
    }
    else{
      residents.add(name);
      System.out.println("Hi, " + name + "! Welcome to " + this.name + "!");
    }
  }

  /**
   * Remove a person from the house
   * @param name indicate the person you want to move out of the house
   * @return the name of the person moved out
   */
  public String moveOut(String name){
    if(!this.isResident(name)){
      throw new RuntimeException("Sorry, " + name + " is not in " + this.name);
    }
    else{
      residents.remove(name);
      System.out.println("Bye-bye, " + name + "!");
      return name;
    }
  }

  /* Do some printing */
  public String toString(){
    return this.name + " is a house at " + this.address + " with " + this.nResidents() + " residents.";
  }

  public static void main(String[] args) {
    try{
      House Tyler = new House("Tyler", "164 Green Street Northampton, MA 01063",4);
      System.out.println(Tyler);
      try{
        Tyler.moveIn("Nancy");
      } catch(Exception e){
        System.out.println(e.getMessage());
      }
      System.out.println(Tyler);
      try{
        Tyler.moveOut("Nancy");
      } catch(Exception e){
        System.out.println(e.getMessage());
      }
      System.out.println(Tyler);
    } catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}