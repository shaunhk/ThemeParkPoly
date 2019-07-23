package people;

import attractions.Attraction;
import attractions.Dodgems;
import behaviours.IReviewed;

import java.util.ArrayList;

public class Visitor {

    private int age;
    private double height;
    private double money;
    private ArrayList<Attraction> visitedAttractions;

    public Visitor(int age, double height, double money) {
        this.age = age;
        this.height = height;
        this.money = money;
        this.visitedAttractions = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getMoney() {
        return money;
    }

    public void payMoney(double price) {
        this.money -= price;
    }

    public void visit(Attraction attraction) {
        if (!this.visitedAttractions.contains(attraction)){
            this.visitedAttractions.add(attraction);
        }
    }

    public int getVisitedAmount() {
        return this.visitedAttractions.size();
    }
}
