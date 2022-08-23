package cs5004.animator.model;

import java.awt.Color;
import java.util.List;

/**
 * Interface class of model.
 * The interface contains all operations.
 * Models is able to support adding shapes and animations.
 * It also has some getters to get information about this model.
 */
public interface Model {
  /**
   * Add a shape to the shape list.
   * @param identifier name of the shape
   * @param s shape object
   */
  void addShape(String identifier, Shape s);

  /**
   * Do the designated action implemented in the enum ActionType on a shape.
   * @param name string, name of the shape.
   * @param actionType type of the action.
   * @param startTime integer, start time of the action.
   * @param endTime integer, end time of the action.
   */
  void action(String name, ActionType actionType, int startTime, int endTime);

  /**
   * Add an animation to the List of Animations.
   * Animation have a name, action-type, move-to-point, and start/end time.
   */
  void action(String name, ActionType actionType, Point2D moveTo, int startTime, int endTime);

  /**
   * Add an animation to the List of Animations.
   * AAnimation have a name, action-type, color-to, and start/end time.
   */
  void action(String name, ActionType actionType, Color colorTo, int startTime, int endTime);

  /**
   * Add an animation to the List of Animations.
   * Animation must have a name, action-type, scaled-factors, and start/end time.
   */
  void action(String name, ActionType actionType,
              double scaleBy1, double scaleBy2, int startTime, int endTime);

  /**
   * get the Shape given the identifier/name.
   * @return ShapeSet with the given name.
   */
  ShapeSet getShapeFromName(String name);

  /**
   * get the current state of the Shape given the identifier/name.
   * @return current state ShapeSet with the given name.
   */
  ShapeSet getCurrentShapeFromName(String name);

  /**
   * returns the list of shapes added through addShape.
   * @return a list of ShapeSets.
   */
  List<ShapeSet> getShapes();

  /**
   * returns the list of animations through the action method.
   * @return a list of Animations.
   */
  List<Animation> getAnimations();

  /**
   * returns the final animation time.
   * @return an integer, the final animation time.
   */
  int getFinalTime();

  /**
   * returns the x bounds.
   *
   * @return an integer, the x bounds.
   */
  int getBoundX();

  /**
   * returns the y bounds.
   *
   * @return an integer, the y bounds.
   */
  int getBoundY();

  /**
   * returns the width bounds.
   * @return an integer, the width bounds.
   */
  int getBoundWidth();

  /**
   * returns the height bounds.
   * @return an integer, the height bounds.
   */
  int getBoundHeight();

  /**
   * returns List of Shapes at current time tick.
   * @return a list of Shapes at given time
   */
  List<ShapeSet> getShapesAtTick(int time);

  /**
   * set the bounds given X.
   */
  void setBoundX(int boundX);


  /**
   * set the bounds given Y.
   */
  void setBoundY(int boundY);

  /**
   * set the bounds given width.
   */
  void setBoundWidth(int boundWidth);

  /**
   * set the bounds given Height.
   */
  void setBoundHeight(int boundHeight);
}