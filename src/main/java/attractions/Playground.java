package attractions;

import behaviours.ISecurity;
import people.Visitor;

public class Playground extends Attraction implements ISecurity {

    private int visitCount;

    public Playground(String name, int rating) {
        super(name, rating);
        this.visitCount = 0;
    }

    public boolean isAllowed(Visitor visitor) {
        if(visitor.getAge() < 16){
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
