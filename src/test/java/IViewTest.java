import cs5004.animator.model.Model;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.IView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextView;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;

import static org.junit.Assert.assertEquals;

/**
 * Testing Iview. Read file from absolute path of local computer.
 * Read the smalldemo.txt file and convert to text toString, and show the SVG toString.
 */
public class IViewTest {
  Model m;

  @Before
  public void setUp() throws Exception {
    m = AnimationReader.parseFile(
        new FileReader("/Users/ivyzhou/Documents/Developer/Java_workingspace"
            + "/CS5004/cs5004/src/main/resources/testfiles/smalldemo.txt"),
        new ModelImpl.AnimationBuilderImpl());
  }

  /**
   * This method tests text format that converted from smalldemo.txt file.
   */
  @Test
  public void testShowTxtString() {
    IView textview = new TextView();
    assertEquals(
        "Create canvas with X: 200 Y: 70 Width: 360 Height: 360\n"
            + "Create (255,0,0) rectangle R with corner at (200,200) , width 50 and height 100\n"
            + "Create (0,0,255) oval C with center at (440,70) , radius 120 and 60\n"
            + "Shape R appears at time t=1 and disappears at time t=10\n"
            + "Shape R moves from (200,200) to (300,300) from time t=10 to time t=50\n"
            + "Shape R appears at time t=50 and disappears at time t=51\n"
            + "Shape R changes from Width: 50, Height: 100 to Width: 25, "
            + "Height: 100 from time t=51 to time t=70\n"
            + "Shape R moves from (300,300) to (200,200) from time t=70 to time t=100\n"
            + "Shape C appears at time t=6 and disappears at time t=20\n"
            + "Shape C moves from (440,70) to (440,250) from time t=20 to time t=50\n"
            + "Shape C moves from (440,250) to (440,370) from time t=50 to time t=70\n"
            + "Shape C changes color from (0,0,255) to (0,170,85) from time t=50 to time t=70\n"
            + "Shape C changes color from (0,170,85) to (0,255,0) from time t=70 to time t=80\n"
            + "Shape C appears at time t=80 and disappears at time t=100\n",
        textview.showString(m.toString()));
  }


  /**
   * This method tests svg format that converted from smalldemo.txt file.
   */
  @Test
  public void testShowSVGString() {
    IView svg = new SVGView(1);
    assertEquals(
        "<svg viewBox=\"200 70 360 360\" xmlns=\"http://www.w3.org/2000/svg\" "
            + "version=\"1.1\">\n" + "\n" + "<rect id=\"R\" x=\"200\" y=\"200\" width=\""
            + "50\" height=\"100\" fill=\"rgb(255,0,0)\" visibility=\"hidden\" >\n"
            + "    <set attributeName=\"visibility\" attributeType=\"CSS\" to=\"visible\""
            + " begin=\"1000ms\" dur=\"9000ms\" fill=\"freeze\" />\n" + "    "
            + "<set attributeName=\"visibility\" attributeType=\"CSS\" to=\"visible\""
            + " begin=\"10000ms\" dur=\"40000ms\" fill=\"freeze\" />\n" + "    <animate "
            + "attributeType=\"xml\" begin=\"10000ms\" dur=\"40000ms\" attributeName="
            + "\"x\" from=\"200\" to=\"300\" fill=\"freeze\" />\n" + "    <anim"
            + "ate attributeType=\"xml\" begin=\"10000ms\" dur=\"40000ms\" attribut"
            + "eName=\"y\" from=\"200\" to=\"300\" fill=\"freeze\" />\n" + "    <set at"
            + "tributeName=\"visibility\" attributeType=\"CSS\" to=\"visible\" begin=\""
            + "50000ms\" dur=\"1000ms\" fill=\"freeze\" />\n" + "    <set attributeNam"
            + "e=\"visibility\" attributeType=\"CSS\" to=\"visible\" begin=\"51000ms\" d"
            + "ur=\"19000ms\" fill=\"freeze\" />\n" + "    <animate attributeName=\"widt"
            + "h\" attributeType=\"XML\" begin=\"51000ms\" dur=\"19000ms\" fill=\"freeze\""
            + " from=\"50\" to=\"25\" />\n" + "    <animate attributeName=\"height\" attri"
            + "buteType=\"XML\" begin=\"51000ms\" dur=\"19000ms\" fill=\"freeze\" from=\"1"
            + "00\" to=\"100\" />\n" + "    <set attributeName=\"visibility\" attributeT"
            + "ype=\"CSS\" to=\"visible\" begin=\"70000ms\" dur=\"30000ms\" fill=\"freez"
            + "e\" />\n" + "    <animate attributeType=\"xml\" begin=\"70000ms\" dur=\"30"
            + "000ms\" attributeName=\"x\" from=\"300\" to=\"200\" fill=\"freeze\" />\n"
            + "    <animate attributeType=\"xml\" begin=\"70000ms\" dur=\"30000ms\" attrib"
            + "uteName=\"y\" from=\"300\" to=\"200\" fill=\"freeze\" />\n"
            + "</rect>\n"
            + "\n"
            + "<ellipse id=\"C\" cx=\"440\" cy=\"70\" rx=\"60\" ry=\"30\" fill=\"rgb(0,"
            + "0,255)\" visibility=\"hidden\" >\n"
            + "    <set attributeName=\"visibility\" attributeType=\"CSS\" to=\"visible\" "
            + "begin=\"6000ms\" dur=\"14000ms\" fill=\"freeze\" />\n"
            + "    <set attributeName=\"visibility\" attributeType=\"CSS\" to=\"visible\""
            + " begin=\"20000ms\" dur=\"30000ms\" fill=\"freeze\" />\n"
            + "    <animate attributeType=\"xml\" begin=\"20000ms\" dur=\"30000ms\" "
            + "attributeName=\"cx\" from=\"440\" to=\"440\" fill=\"freeze\" />\n"
            + "    <animate attributeType=\"xml\" begin=\"20000ms\" dur=\"30000ms\" "
            + "attributeName=\"cy\" from=\"70\" to=\"250\" fill=\"freeze\" />\n"
            + "    <set attributeName=\"visibility\" attributeType=\"CSS\" to=\"visible\" "
            + "begin=\"50000ms\" dur=\"20000ms\" fill=\"freeze\" />\n"
            + "    <animate attributeType=\"xml\" begin=\"50000ms\" dur=\"20000ms\" "
            + "attributeName=\"cx\" from=\"440\" to=\"440\" fill=\"freeze\" />\n"
            + "    <animate attributeType=\"xml\" begin=\"50000ms\" dur=\"20000ms\" "
            + "attributeName=\"cy\" from=\"250\" to=\"370\" fill=\"freeze\" />\n"
            + "    <animate attributeName=\"fill\" attributeType=\"CSS\" from=\"rgb(0,0,255)\" "
            + "to=\"rgb(0,170,85)\" begin=\"50000ms\" dur=\"20000ms\" fill=\"freeze\" />\n"
            + "    <animate attributeName=\"fill\" attributeType=\"CSS\" "
            + "from=\"rgb(0,170,85)\" to=\"rgb(0,255,0)\" begin=\"70000ms\" dur=\"10000ms\" "
            + "fill=\"freeze\" />\n"
            + "    <set attributeName=\"visibility\" attributeType=\"CSS\" "
            + "to=\"visible\" begin=\"80000ms\" dur=\"20000ms\" fill=\"freeze\" />\n"
            + "</ellipse>\n"
            + "\n"
            + "</svg>", svg.showSVGString(m.toString()));
  }

  /**
   * This method throw an exception if an empty svg string format that converted
   * from the smalldemo.txt file.
   */
  @Test (expected = IllegalStateException.class)
  public void testShowSVGException() {
    IView svg = new SVGView(1);
    assertEquals("", svg.showString(m.toString()));
  }
}
