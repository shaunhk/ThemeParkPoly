import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import behaviours.ISecurity;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    private ThemePark themePark;
    private Dodgems dodgems;
    private Park park;
    private Playground playground;
    private RollerCoaster rollerCoaster;
    private CandyflossStall candyflossStall;
    private IceCreamStall iceCreamStall;
    private TobaccoStall tobaccoStall;
    private Visitor visitor;
    private Visitor visitor2;

    @Before
    public void setup(){
        visitor = new Visitor(24, 1.8, 250.00);
        visitor2 = new Visitor(13, 2, 100.00);
        dodgems = new Dodgems("Bumper Cars", 5);
        park = new Park("Leafy Meadows", 9);
        playground = new Playground("Fun Zone", 7);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 4);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 4);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1,4);
        themePark = new ThemePark(dodgems, park, playground, rollerCoaster, candyflossStall, iceCreamStall, tobaccoStall);
    }

    @Test
    public void canGetReviewed(){
        ArrayList<IReviewed> reviewed;
        reviewed = themePark.getAllReviewed();
        assertEquals(7, reviewed.size());
    }

    @Test
    public void visitsRecorded(){
        themePark.visit(visitor, park);
        assertEquals(1, visitor.getVisitedAmount());
        assertEquals(1, park.getVisitCount());
    }

    @Test
    public void canGetThemeParkHash(){
        HashMap<String, Integer> reviewedHash;
        reviewedHash = themePark.getReviewedHash();
        assertEquals(7 ,reviewedHash.size());
    }

    @Test
    public void canReturnAllowed(){
        ArrayList<ISecurity> allowed;
        allowed = themePark.getAllowedFor(visitor2);
        assertEquals(6, allowed.size());
    }
}
