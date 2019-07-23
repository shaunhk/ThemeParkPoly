package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(10, 1.5, 50.50);
        visitor2 = new Visitor(36, 5.7, 55.50);
        visitor3 = new Visitor(14, 1.4, 55.53);
        visitor4 = new Visitor(14, 1.8, 55.50);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canBeVisited(){
        rollerCoaster.visit(visitor2);
        assertEquals(1, rollerCoaster.getVisitCount());
    }

    @Test
    public void noShortiesOrBuddingThrillJunkies(){
        rollerCoaster.visit(visitor1);
        rollerCoaster.visit(visitor3);
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void chargesFolk(){
        rollerCoaster.visit(visitor4);
        assertEquals(47.10, visitor4.getMoney(), 0.01);
    }

    @Test
    public void chargesTallFolkMore(){
        rollerCoaster.visit(visitor2);
        assertEquals(38.70, visitor2.getMoney(), 0.01);
    }
}
