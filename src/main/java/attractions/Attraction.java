package attractions;

import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

public abstract class Attraction implements IReviewed, ISecurity {
    private String name;
    private int rating;
    private int visitCount;

    public Attraction(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.visitCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void visit(Visitor visitor){
        this.visitCount += 1;
    }
}
