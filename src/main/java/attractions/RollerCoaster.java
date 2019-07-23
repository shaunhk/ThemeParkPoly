package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity, ITicketed {

    private int visitCount;
    private double price;

    public RollerCoaster(String name, int rating) {
        super(name, rating);
        this.visitCount = 0;
        this.price = 8.40;
    }

    public boolean isAllowed(Visitor visitor) {
        if(visitor.getAge() > 12 && visitor.getHeight() >= 1.45){
            return true;
        }else {
            return false;
        }
    }

    public void visit(Visitor visitor){
        if(isAllowed(visitor)) {
            this.visitCount += 1;
            visitor.payMoney(priceFor(visitor));
        }
    }

    public int getVisitCount() {
        return this.visitCount;
    }

    public double defaultPrice(){
        return this.price;
    }

    public double priceFor(Visitor visitor) {
        if (visitor.getHeight() <= 2){
            return this.price;
        }else{
            return this.price * 2;
        }
    }

}
