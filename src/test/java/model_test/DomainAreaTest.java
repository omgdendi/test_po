package model_test;

import model.*;
import model.type.Color;
import model.type.Feeling;
import model.type.SilenceType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DomainAreaTest {
    private static HumanBeing human;
    private static Mouse mouse1;
    private static Mouse mouse2;
    private static Glass glass1;
    private static Glass glass2;
    private static Table table;

    @BeforeClass
    public static void init() {
        human = new HumanBeing("Артур");
        mouse1 = new Mouse(Color.WHITE);
        mouse2 = new Mouse(Color.WHITE);
        glass1 = new Glass();
        glass2 = new Glass();
        table = new Table();
    }

    @Test
    public void testSilence() {
        Silence silence = new Silence(SilenceType.AWKWARD);
        assertEquals("неловкое", silence.getType().getTitle());
    }

    @Test
    public void testPutMouesIntoGlasses() {
        glass1.putIn(mouse1);
        glass2.putIn(mouse2);
        table.put(glass1, glass2);
        assertTrue(glass1.contains(mouse1));
        assertTrue(glass2.contains(mouse2));
        assertTrue(table.contains(glass1));
        assertTrue(table.contains(glass2));
        assertEquals(mouse1.getContainer().getLocation(), table);
        assertEquals(mouse2.getContainer().getLocation(), table);
    }

    @Test
    public void testLookAtMoues() {
        human.lookAt(mouse1, mouse2);
        List exceptedVisibles = Arrays.asList(mouse1, glass1, mouse2, glass2);
        List obtainedVisibles =  human.getVisibleEntities();

        assertFalse(exceptedVisibles.size() == obtainedVisibles.size()
                && exceptedVisibles.containsAll(obtainedVisibles)
                && obtainedVisibles.containsAll(exceptedVisibles));
    }

    @Test
    public void testFeeling() {
        this.human.setFeeling(Feeling.AWKWARDNESS);
        assertEquals("неловкость", human.getFeeling().getTitle());
    }
}
