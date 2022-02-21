package model_test;

import model.type.Color;
import model.Glass;
import model.Mouse;
import model.Table;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MouseGlassTableModuleTest {
    private Mouse mouse;
    private Glass glass;
    private Table table;

    @Before
    public void init() {
        this.glass = new Glass();
        this.mouse = new Mouse();
        this.table = new Table();
    }

    @Test
    public void testMouseColor() {
        Mouse mouse = new Mouse(Color.WHITE);
        assertEquals("белый", mouse.getColor());
    }

    @Test
    public void testPutMouseToGlass() {
        glass.putIn(mouse);
        assertEquals(glass.getInner(), mouse);
    }

    @Test
    public void testMouseGetIntoGlass() {
        mouse.getInto(glass);
        assertEquals(glass.getInner(), mouse);
    }

    @Test
    public void testMouseDoublePutMouseToGlass() {
        try {
            glass.putIn(mouse);
            glass.putIn(new Mouse());
            fail("Нет валидации на пустоту стакана со стороны стакана");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void testMouseDoubleGetIntoGlass() {
        try {
            mouse.getInto(glass);
            (new Mouse()).getInto(glass);
            fail("Нет валидации на пустоту стакана со стороны мыши");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void testContainsGlassMouse() {
        glass.putIn(mouse);
        assertTrue(glass.contains(mouse));
    }

    @Test
    public void testMouseGetOutGlass() {
        glass.putIn(mouse);
        mouse.getOutFrom(glass);
        assertFalse(glass.contains(mouse));
    }

    @Test
    public void testRemoveMouseFromGlass() {
        glass.putIn(mouse);
        glass.clear();
        assertFalse(glass.contains(mouse));
    }

    @Test
    public void testMouseGetOutEmptyGlass() {
        try {
            mouse.getOutFrom(glass);
            fail("Нет валидации на нахождение мыши в стакане");
        } catch (Exception e) {
            assertFalse(glass.contains(mouse));
        }
    }

    @Test
    public void testPutGlassOnTable() {
        table.put(glass);
        assertTrue(table.contains(glass));
    }

    @Test
    public void testGlassOnTable() {
        table.put(glass);
        assertEquals(glass.getLocation(), table);
    }

    @Test
    public void testMultiplePutGlassOnTable() {
        Glass glass1 = new Glass();
        Glass glass2 = new Glass();
        table.put(glass, glass1, glass2);
        Glass[] exceptedStaff = {glass, glass1, glass2};
        assertArrayEquals(exceptedStaff, table.getAll().toArray());
    }

    @Test
    public void testMultipleNonUniquePutGlassOnTable() {
        Glass glass1 = new Glass();
        Glass glass2 = new Glass();
        table.put(glass, glass1, glass2, glass1, glass2, glass, glass1, glass2, glass);
        Glass[] exceptedStaff = {glass, glass1, glass2};
        assertArrayEquals(exceptedStaff, table.getAll().toArray());
    }

    @Test
    public void testTransitionMouseTable1() {
        table.put(glass);
        glass.putIn(mouse);
        assertEquals(glass.getLocation(), table);
        assertEquals(mouse.getLocation(), table);
    }

    @Test
    public void testTransitionMouseTable2() {
        glass.putIn(mouse);
        table.put(glass);
        assertEquals(glass.getLocation(), table);
        assertEquals(mouse.getLocation(), table);
    }

    @Test
    public void testTransitionMouseTable3() {
        table.put(glass);
        mouse.getInto(glass);
        assertEquals(glass.getLocation(), table);
        assertEquals(mouse.getLocation(), table);
    }

    @Test
    public void testTransitionMouseTable4() {
        mouse.getInto(glass);
        table.put(glass);
        assertEquals(glass.getLocation(), table);
        assertEquals(mouse.getLocation(), table);
    }
}
