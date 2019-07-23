import attractions.*;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private Dodgems dodgems;
    private Park park;
    private Playground playground;
    private RollerCoaster rollerCoaster;
    private CandyflossStall candyflossStall;
    private IceCreamStall iceCreamStall;
    private TobaccoStall tobaccoStall;

    public ThemePark(Dodgems dodgems, Park park, Playground playground, RollerCoaster rollerCoaster, CandyflossStall candyflossStall, IceCreamStall iceCreamStall, TobaccoStall tobaccoStall){
       this.dodgems = dodgems;
       this.park = park;
       this.playground = playground;
       this.rollerCoaster = rollerCoaster;
       this.candyflossStall = candyflossStall;
       this.iceCreamStall = iceCreamStall;
       this.tobaccoStall = tobaccoStall;
   }

    public Dodgems getDodgems() {
        return this.dodgems;
    }

    public Park getPark() {
        return this.park;
    }

    public Playground getPlayground() {
        return this.playground;
    }

    public RollerCoaster getRollerCoaster() {
        return this.rollerCoaster;
    }

    public CandyflossStall getCandyflossStall() {
        return this.candyflossStall;
    }

    public IceCreamStall getIceCreamStall() {
        return this.iceCreamStall;
    }

    public TobaccoStall getTobaccoStall() {
        return this.tobaccoStall;
    }

    public ArrayList<IReviewed> getAllReviewed() {
        ArrayList<IReviewed> reviewed = new ArrayList<>();
        reviewed.add(this.getDodgems());
        reviewed.add(this.getPark());
        reviewed.add(this.getPlayground());
        reviewed.add(this.getRollerCoaster());
        reviewed.add(this.getCandyflossStall());
        reviewed.add(this.getIceCreamStall());
        reviewed.add(this.getTobaccoStall());
        return reviewed;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.visit(attraction);
        attraction.visit(visitor);
    }

    public HashMap<String, Integer> getReviewedHash() {
        ArrayList<IReviewed> reviewed = new ArrayList<>();
        reviewed.add(this.getDodgems());
        reviewed.add(this.getPark());
        reviewed.add(this.getPlayground());
        reviewed.add(this.getRollerCoaster());
        reviewed.add(this.getCandyflossStall());
        reviewed.add(this.getIceCreamStall());
        reviewed.add(this.getTobaccoStall());
        HashMap<String, Integer> reviewedHash = new HashMap<>();
        for(int i = 0; i < reviewed.size(); i++){
            if(reviewed.get(i).getRating() >= 0){
                reviewedHash.put(reviewed.get(i).getName(), reviewed.get(i).getRating());
            }
        }
        return reviewedHash;
    }

    public ArrayList<ISecurity> getAllowedFor(Visitor visitor) {
        ArrayList<ISecurity> allowed = new ArrayList<>();
        allowed.add(this.getDodgems());
        allowed.add(this.getPark());
        allowed.add(this.getPlayground());
        allowed.add(this.getRollerCoaster());
        allowed.add(this.getCandyflossStall());
        allowed.add(this.getIceCreamStall());
        allowed.add(this.getTobaccoStall());
        for(int i=0; i<allowed.size(); i++){
            if(!allowed.get(i).isAllowed(visitor)){
                allowed.remove(allowed.get(i));
            }
        }
        return allowed;
    }
}
