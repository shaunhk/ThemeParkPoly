package stalls;

import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

public abstract class Stall implements IReviewed, ISecurity {

    private String name;
    private String ownerName;
    private ParkingSpot parkingSpot;
    private int rating;
    private int visitCount;

    public Stall(String name, String ownerName, ParkingSpot parkingSpot, int rating) {
        this.name = name;
        this.ownerName = ownerName;
        this.parkingSpot = parkingSpot;
        this.rating = rating;
        this.visitCount = 0;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public int getRating(){ return this.rating;}

    public void visit(Visitor visitor){
        this.visitCount += 1;
    }
}
