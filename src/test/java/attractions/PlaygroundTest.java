package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class PlaygroundTest {
    Playground playground;
    Visitor visitor1;
    Visitor visitor2;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
        visitor1 = new Visitor(10, 4.11, 10.50);
        visitor2 = new Visitor(36, 5.7, 10.50);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void canBeVisited(){
        playground.visit(visitor1);
        assertEquals(1, playground.getVisitCount());
    }

    @Test
    public void barsCreepsAndLostOldPeople(){
        playground.visit(visitor2);
        assertEquals(0, playground.getVisitCount());
    }
}
