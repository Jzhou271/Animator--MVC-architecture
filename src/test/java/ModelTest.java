import cs5004.animator.model.ModelImpl;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.ActionType;
import cs5004.animator.model.Point2D;
import cs5004.animator.model.Shape;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import static org.junit.Assert.assertEquals;


/**
 * Testing Model.
 */
public class ModelTest {
  ModelImpl m;
  Shape s1;
  Shape s2;
  Shape s3;
  Shape s4;
  Shape s5;

  @Before
  public void setUp() {
    m = new ModelImpl();
    s1 = new Oval(new Point2D(3, 4), 5, 6, Color.WHITE);
    s2 = new Rectangle(new Point2D(-7, -24), 1, 2, Color.RED);
    s3 = new Oval(new Point2D(4, 3), 3, 3, Color.BLACK);
    s4 = new Rectangle(new Point2D(24, -7), 5, 5, Color.BLUE);
    s5 = s4.resize(2, 1);
  }


  /**
   * This testing action of AppearDisappear, Move, Color, and Scale.
   */
  @Test
  public void testAction() {
    m.addShape("1", s1);
    m.addShape("2", s2);
    m.addShape("3", s3);
    m.addShape("4", s4);
    m.action("1", ActionType.AppearDisappear, 0, 2);
    m.action("3", ActionType.Move, new Point2D(1, 1), 1, 3);
    m.action("3", ActionType.Move, new Point2D(0, 0), 3, 10);
    m.action("2", ActionType.Color, Color.CYAN, 2, 3);
    m.action("4", ActionType.Scale, 2, 1, 4, 5);
    assertEquals("Create canvas with X: 0 Y: 0 Width: 0 Height: 0\n"
            + "Create (255,255,255) oval 1 with center at (3,4) , radius 5 and 6\n"
            + "Create (255,0,0) rectangle 2 with corner at (-7,-24) , width 1 and height 2\n"
            + "Create (0,0,0) oval 3 with center at (4,3) , radius 3 and 3\n"
            + "Create (0,0,255) rectangle 4 with corner at (24,-7) , width 10 and height 5\n"
            + "Shape 1 appears at time t=0 and disappears at time t=2\n"
            + "Shape 3 moves from (4,3) to (1,1) from time t=1 to time t=3\n"
            + "Shape 3 moves from (1,1) to (0,0) from time t=3 to time t=10\n"
            + "Shape 2 changes color from (255,0,0) to (0,255,255) from time t=2 to time t=3\n"
            + "Shape 4 changes from Width: 10, Height: 5 to Width: 20, Height: 5 from "
            + "time t=4 to time t=5\n", m.toString());
  }

  /**
   * This testing shape changes its shape, position and color in a given time.
   */
  @Test
  public void testShapesAtTick() {
    Shape s1 = new Rectangle(new Point2D(0,0), 50,100,Color.RED);
    Shape s2 = new Oval(new Point2D(10,10),60,30,Color.BLUE);
    m.addShape("R", s1);
    m.addShape("C",s2);
    m.action("R", ActionType.Move, new Point2D(10,10),0,10);
    m.action("C", ActionType.Move, new Point2D(0,0), 0, 10);
    assertEquals(2,m.getShapesAtTick(5).size());
  }
}