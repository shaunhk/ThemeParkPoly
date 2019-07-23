package attractions;

import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    private double price;
    private int visitCount;

    public Dodgems(String name, int rating) {
        super(name, rating);
        this.price = 4.50;
        this.visitCount = 0;
    }

    public double defaultPrice() {
        return this.price;
    }

    public double priceFor(Visitor visitor) {
        if(visitor.getAge() > 11){
            return this.defaultPrice();
        }else {
            return this.defaultPrice() / 2;
        }
    }

    public void visit(Visitor visitor){
            this.visitCount += 1;
            visitor.payMoney(priceFor(visitor));
    }
}
