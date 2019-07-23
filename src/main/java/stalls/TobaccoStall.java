package stalls;

import behaviours.ISecurity;
import people.Visitor;

public class TobaccoStall extends Stall implements ISecurity {

    private int visitCount;

    public TobaccoStall(String name, String ownerName, ParkingSpot parkingSpot, int rating) {
        super(name, ownerName, parkingSpot, rating);
        this.visitCount = 0;
    }

    public boolean isAllowed(Visitor visitor) {
        if(visitor.getAge() > 17){
            return true;
        }else {
            return false;
        }
    }

    public void visit(Visitor visitor){
        if(isAllowed(visitor)) {
            this.visitCount += 1;
        }
    }

    public int getVisitCount() {
        return this.visitCount;
    }
}
