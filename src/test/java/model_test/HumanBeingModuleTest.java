package model_test;

import model.Entity;
import model.Glass;
import model.HumanBeing;
import model.Mouse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class HumanBeingModuleTest {
    private HumanBeing human;

    @Before
    public void init() {
        this.human = new HumanBeing("Артур");
    }


    @Test
    public void testMultipleLook() {
        Mouse mouse1 = new Mouse();
        Mouse mouse2 = new Mouse();
        human.lookAt(mouse1, mouse2);
        Entity[] exceptedVisibles = {mouse1, mouse2};
        assertArrayEquals(exceptedVisibles, human.getVisibleEntities().toArray());

        Glass glass = new Glass();
        human.lookAt(glass);
        exceptedVisibles = new Entity[]{glass};
        assertArrayEquals(exceptedVisibles, human.getVisibleEntities().toArray());
    }

    @Test
    public void testTransparentLook() {
        Mouse mouse = new Mouse();
        Glass glass = new Glass();
        mouse.getInto(glass);

        human.lookAt(mouse);
        Entity[] exceptedVisibles = {mouse, glass};
        assertArrayEquals(exceptedVisibles, human.getVisibleEntities().toArray());
    }
}
