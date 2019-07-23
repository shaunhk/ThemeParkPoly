package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor visitor1;
    Visitor visitor2;

    @Before
    public void setUp() throws Exception {
        visitor1 = new Visitor(10, 1.5, 55.50);
        visitor2 = new Visitor(36, 5.7, 55.50);
        dodgems = new Dodgems("Bumper Cars", 5);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void chargesFolk(){
        dodgems.visit(visitor2);
        assertEquals(51.00, visitor2.getMoney(), 0.01);
    }

    @Test
    public void chargesWaynesLess(){
        dodgems.visit(visitor1);
        assertEquals(53.25, visitor1.getMoney(), 0.01);
    }
}
