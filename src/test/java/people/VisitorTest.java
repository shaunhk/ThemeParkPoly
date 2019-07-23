package people;

import attractions.Dodgems;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import stalls.IceCreamStall;
import stalls.ParkingSpot;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;
    Dodgems dodgems;
    RollerCoaster rollerCoaster;

    @Before
    public void before(){
        visitor = new Visitor(14, 1.2, 40.0);
        dodgems = new Dodgems("Bash bash", 7);
        rollerCoaster = new RollerCoaster("Zoom zoom", 3);
    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.1);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.1);
    }

    @Test
    public void canVisit(){
        visitor.visit(dodgems);
        visitor.visit(rollerCoaster);
        visitor.visit(dodgems);
        assertEquals(2, visitor.getVisitedAmount());
    }
}
