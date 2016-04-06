package ewu.embroidit.parkc.shape;

import ewu.embroidit.parkc.fill.A_EmbFill;
import ewu.embroidit.parkc.pattern.EmbStitch;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;


/*-----------------------------------------------------------------------*/
/**
 * Base abstract class for Shape wrappers. 
 * @author Chris Park (christopherpark@eagles.ewu.edu)
 */
public abstract class A_EmbShapeWrapper
{
    /*-----------------------------------------------------------------------*/
    
    protected static final double DEFAULT_STITCH_LENGTH = A_EmbFill.MM_TO_PXL;
            
    /*-----------------------------------------------------------------------*/
    
    protected Shape wrappedShape;
    protected List<Line> lineList;
    protected List<EmbStitch> stitchList;
    protected Point2D startPoint;
    protected Color threadColor;
    protected double stitchLength;
    
    /*-----------------------------------------------------------------------*/
    
    /**
     * Constructs a wrapper containing a JavaFX shape, and default values.
     * @param wrappedShape Shape
     */
    public A_EmbShapeWrapper(Shape wrappedShape)
    {
        this.wrappedShape = wrappedShape;
        this.startPoint = new Point2D(0, 0);
        this.stitchList = new ArrayList<>();
        this.lineList = new ArrayList<>();
        this.threadColor = Color.BLACK;
        this.stitchLength = DEFAULT_STITCH_LENGTH;
    }
    
    /*-----------------------------------------------------------------------*/
    
    /**
     * Constructs a wrapper containing a JavaFXS Shape, the shapes fill stitch
     * length, and default values. Ensures a minimum stitch length of 1mm.
     * @param wrappedShape Shape
     * @param stitchLength double
     */
    public A_EmbShapeWrapper(Shape wrappedShape, double stitchLength)
    {
        this.wrappedShape = wrappedShape;
        this.startPoint = new Point2D(0, 0);
        this.stitchList = new ArrayList<>();
        this.lineList = new ArrayList<>();
        this.threadColor = Color.BLACK;
        this.stitchLength = stitchLength;
        
        if(stitchLength < DEFAULT_STITCH_LENGTH)
            this.stitchLength = DEFAULT_STITCH_LENGTH;
        
    }
    /*-----------------------------------------------------------------------*/
    
    /**
     * Constructs a wrapper containing a JavaFX shape, the starting location
     * for stitch filling, an empty list of line segments to fill, the threads 
     * rgb color value, and an empty list of stitches to hold point data once
     * calculated.
     * @param wrappedShape Shape
     * @param startPoint Point2D
     */
    public A_EmbShapeWrapper(Shape wrappedShape, Point2D startPoint)
    {
        this.wrappedShape = wrappedShape;
        this.startPoint = startPoint;
        this.stitchList = new ArrayList<>();
        this.lineList = new ArrayList<>();
        this.threadColor = Color.BLACK;
        this.stitchLength = DEFAULT_STITCH_LENGTH;
    }
    
    /*-----------------------------------------------------------------------*/
    
    /**
     * Returns the fill line list for the wrappers corresponding shape.
     * @return List&lt;Line&gt;
     */
    public List<Line> getLineList()
    { return this.lineList; }
    
    /*-----------------------------------------------------------------------*/
    
    /**
     * Sets the fill line list for this wrappers corresponding shape
     * @param lineList List&lt;Line&gt;
     */
    public void setLineList(List<Line> lineList)
    {
        this.validateObject(lineList);
        this.lineList = lineList;
    }
    /*-----------------------------------------------------------------------*/
    
    /**
     * Gets the list of stitches.
     * @return List&lt;EmbStitch&gt;
     */
    public List<EmbStitch> getStitchList()
    { return this.stitchList; }
    
    /*-----------------------------------------------------------------------*/
    
    /**
     * Sets the list of stitches.
     * @param stitchList List&lt;EmbStitch&gt;
     */
    public void setStitchList(List<EmbStitch> stitchList)
    {
        this.validateObject(stitchList);
        this.stitchList = stitchList;
    }
    
    /*-----------------------------------------------------------------------*/
    
    /**
     * gets the starting point for this stitch fill.
     * @return Point2D
     */
    public Point2D getStartPoint()
    { return this.startPoint; }
    
    /*-----------------------------------------------------------------------*/
    
    /**
     * Sets the start point for this stitch fill.
     * @param startPoint Point2D
     */
    public void setStartPoint(Point2D startPoint)
    {
        this.validateObject(startPoint);
        this.startPoint = startPoint;
    }
    
    /*-----------------------------------------------------------------------*/
    
    /**
     * Gets the JavaFx shape wrapped by this fill object
     * @return Shape
     */
    public Shape getWrappedShape()
    {
        this.validateObject(this.wrappedShape);
        return this.wrappedShape;
    }
    
    /*-----------------------------------------------------------------------*/
    
    /**
     * Sets the JavaFX shape wrapped by this fill object
     * @param wrappedShape Shape
     */
    public void setWrappedShape(Shape wrappedShape)
    {
        this.validateObject(wrappedShape);
        this.wrappedShape = wrappedShape;
    }
    
    /*-----------------------------------------------------------------------*/
    
    /**
     * Gets the rgb color value of the thread for this shape.
     * @return Color
     */
    public Color getThreadColor()
    { return this.threadColor; }
    
    /*-----------------------------------------------------------------------*/
    
    /**
     * Sets the rgb color value of the thread for this shape.
     * @param color Color
     */
    public void setThreadcolor(Color color)
    {
        this.validateObject(color);
        this.threadColor = color;
    }
    
    /*-----------------------------------------------------------------------*/
    
    /**
     * Gets the stitch length for this wrapped shape.
     * @return double
     */
    public double getStitchLength()
    { return this.stitchLength; }
    
    /*-----------------------------------------------------------------------*/
    
    /**
     * Sets the stitch length for this wrapped shape.
     * @param length double
     */
    public void setStitchLength(double length)
    { this.stitchLength = length; }
    
    /*-----------------------------------------------------------------------*/
    
    
    //Subdivide Segments
        //for each line in line list
        //break that line down into subdivisions based on the set stitch length
        //add all of those into a new list
        //replace the old list with the new list.
    
    /*-----------------------------------------------------------------------*/
    
    //Create stitchList
    //override in child classes for specific implementations (make abstract here)
    
    /*-----------------------------------------------------------------------*/
    
    /**
     * Ensures the object sent as a parameter is not null.
     * @param obj Object
     */
    private void validateObject(Object obj)
    {
        if (obj == null)
        { throw new RuntimeException("EmbShapeWrapper: Null reference error"); }
    }
}
