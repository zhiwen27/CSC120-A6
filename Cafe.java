/* This is a stub for the Cafe class */
public class Cafe extends Building{

    private int nCoffeeOunces; /* The number of ounces of coffee remaining in inventory */
    private int nSugarPackets; /* The number of sugar packets remaining in inventory */
    private int nCreams; /* The number of "splashes" of cream remaining in inventory */
    private int nCups; /* The number of cups remaining in inventory */

    public Cafe(String name, String address, int nFloors){
        super(name, address, nFloors);
        System.out.println("You have built a cafe ☕: " + this.name);
        /* initialize all the items inside the inventory to be zero */
        this.nCoffeeOunces = 0;
        this.nSugarPackets = 0;
        this.nCreams = 0;
        this.nCups = 0;
    }

    /**
     * Decrease the remaining inventory after selling a cup of coffee
     * @param size the size of coffee
     * @param nSugarPackets the number of sugar packets required
     * @param nCreams cream required
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if ((this.nCoffeeOunces < size) || (this.nSugarPackets < nSugarPackets) || (this.nCreams < nCreams) || (this.nCups < 1)){
            System.out.println("There aren't enough inventories... need restock!");
            restock(size - this.nCoffeeOunces, nSugarPackets - this.nSugarPackets, nCreams - this.nCreams, 1);
        }
        else{
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }
    }

    /**
     * Restock the inventory of the cafe
     * @param nCoffeeOunces the number of ounces of coffee added to the supplement
     * @param nSugarPackets the number of sugar packets added to the supplement
     * @param nCreams cream added to the supplement
     * @param nCups the number of cups added to the supplement
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /* Do some printing */
    public String toString(){
        return this.name + " now has " + this.nCoffeeOunces + " ounces of coffee, " + this.nSugarPackets + " sugar packets, " + this.nCreams + " splashes of creams, and can take " + this.nCups + " more orders.";
    }

    public static void main(String[] args) {
        Cafe campusCenter = new Cafe("Campus Center Cafe", "100 Elm Street Northampton, MA 01063", 2);
        campusCenter.restock(10, 5, 5, 5);
        System.out.println(campusCenter);
        campusCenter.sellCoffee(2, 1, 1);
        System.out.println(campusCenter);
    }
}
