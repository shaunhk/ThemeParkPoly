package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor visitor1;
    Visitor visitor2;

    @Before
    public void setUp() throws Exception {
        visitor1 = new Visitor(10, 4.11, 10.50);
        visitor2 = new Visitor(36, 5.7, 10.50);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1,4);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void canBeVisited(){
        tobaccoStall.visit(visitor2);
        assertEquals(1, tobaccoStall.getVisitCount());
    }

    @Test
    public void barsNihilisticTeenagers(){
        tobaccoStall.visit(visitor1);
        assertEquals(0, tobaccoStall.getVisitCount());
    }
}
