
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/**
 * Write a description of class Light here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Light extends Animal
{
    public CopyOnWriteArrayList<Line> lines = new CopyOnWriteArrayList<Line>();
    public CopyOnWriteArrayList<Line> linesred = new CopyOnWriteArrayList<Line>();
    public CopyOnWriteArrayList<Line> linesgreen = new CopyOnWriteArrayList<Line>();
    public CopyOnWriteArrayList<Line> linesredonly = new CopyOnWriteArrayList<Line>();
    public CopyOnWriteArrayList<Line> linesgreenonly = new CopyOnWriteArrayList<Line>();
    public CopyOnWriteArrayList<Line> linesupdating = new CopyOnWriteArrayList<Line>();
    
    public CopyOnWriteArrayList<Vector> points = new CopyOnWriteArrayList<Vector>();
    public CopyOnWriteArrayList<Vector> pointsswitchred = new CopyOnWriteArrayList<Vector>();
    public CopyOnWriteArrayList<Vector> pointsswitchgreen = new CopyOnWriteArrayList<Vector>();
    
    public CopyOnWriteArrayList<Vector> innercorners = new CopyOnWriteArrayList<Vector>();
    public int timer = 0;
    public boolean setBlack = false;
    
    public static GreenfootImage img = new GreenfootImage(2000,2000);
    /**
     * Act - do whatever the Light wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        getImage().clear();
        img.setColor(Color.WHITE);
        initial();
        updateBoundaries();
        IllumWorld illumWorld = (IllumWorld) getWorld();
        Player player = illumWorld.getPlayer();
        setpos(player.x,player.y);
        showLight(img);
    }
    public void initial()
    {
        if (timer == 0)
        {
            IllumWorld illumWorld = (IllumWorld) getWorld();
            
            for (Cube obj : (ArrayList<Cube>)illumWorld.getObjects(Cube.class))
            {
                for (Line line : obj.lines)
                {
                    lines.add(line);
                    linesred.add(line);
                    linesgreen.add(line);
                }
                for (Vector point : obj.points)
                {
                    points.add(point);
                }
            }
            
            for (CubeInvisible obj : (ArrayList<CubeInvisible>)illumWorld.getObjects(CubeInvisible.class))
            {
                for (Line line : obj.lines)
                {
                    lines.add(line);
                    linesred.add(line);
                    linesgreen.add(line);
                }
                for (Vector point : obj.points)
                {
                    points.add(point);
                }
            }
            
            for (CubeBorder obj : (ArrayList<CubeBorder>)illumWorld.getObjects(CubeBorder.class))
            {
                for (Line line : obj.lines)
                {
                    lines.add(line);
                    linesred.add(line);
                    linesgreen.add(line);
                }
                for (Vector point : obj.points)
                {
                    points.add(point);
                }
            }
            
            //
            
            CopyOnWriteArrayList<Vector> points1 = (CopyOnWriteArrayList)points.clone();
            for (Vector point1 : points1)
            {
                CopyOnWriteArrayList<Vector> points2 = (CopyOnWriteArrayList)points1.clone();
                points2.remove(point1);
                for (Vector point2 : points2)
                {
                    if (point1.x == point2.x && point1.y == point2.y)
                    {
                        CopyOnWriteArrayList<Vector> points3 = (CopyOnWriteArrayList)points2.clone();
                        points3.remove(point1);
                        points3.remove(point2);
                        for (Vector point3 : points3)
                        {
                            if (point1.x == point3.x && point1.y == point3.y)
                            {
                                innercorners.add(point3);
                            }
                        }
                        points.remove(point1);
                        points.remove(point2);
                    }
                }
            }
            
            for (Vector point : innercorners)
            {
                points.add(point);
            }
            
            CopyOnWriteArrayList<Line> linestoremove = new CopyOnWriteArrayList<Line>();
            CopyOnWriteArrayList<Line> lines1 = (CopyOnWriteArrayList)lines.clone();
            for (Line line1 : lines1)
            {
                CopyOnWriteArrayList<Line> lines2 = (CopyOnWriteArrayList)lines1.clone();
                lines2.remove(line1);
                for (Line line2 : lines2)
                {
                    if (line1.a.x == line2.a.x && line1.a.y == line2.a.y && line1.b.x == line2.b.x && line1.b.y == line2.b.y)
                    {
                        linestoremove.add(line1);
                        linestoremove.add(line2);
                    }
                    /*
                    double line1maxy = getMax(line1.a.y, line1.b.y);
                    double line1miny = getMin(line1.a.y, line1.b.y);
                    double line1maxx = getMax(line1.a.x, line1.b.x);
                    double line1minx = getMin(line1.a.x, line1.b.x);
                    double line2maxy = getMax(line2.a.y, line2.b.y);
                    double line2miny = getMin(line2.a.y, line2.b.y);
                    double line2maxx = getMax(line2.a.x, line2.b.x);
                    double line2minx = getMin(line2.a.x, line2.b.x);
                    double line1height = line1maxy-line1miny;
                    double line1width = line1maxx-line1minx;
                    double line2height = line2maxy-line2miny;
                    double line2width = line2maxx-line2minx;
                    double slope1 = 0;
                    double slope2 = 0;
                    boolean setslope1 = false;
                    boolean setslope2 = false;
                    if (line1.a.x == line1.b.x)
                    {
                        slope1 = line1height;
                        setslope1 = true;
                    }
                    if (line2.a.x == line2.b.x)
                    {
                        slope2 = line2height;
                        setslope2 = true;
                    }
                    if (setslope1 == false)
                    {
                        slope1 = line1height/line1width;
                    }
                    if (setslope2 == false)
                    {
                        slope2 = line2height/line2width;
                    }
                    
                    if (slope1 == slope2)
                    {
                        boolean setLine = false;
                        if (line1.a.x == line2.a.x && line1.a.y == line2.a.y && line1.b.x == line2.b.x && line1.b.y == line2.b.y)
                        {
                            linestoremove.add(line1);
                            linestoremove.add(line2);
                            
                            lines1.remove(line1);
                            lines1.remove(line2);
                            lines2.remove(line1);
                            lines2.remove(line2);
                            
                            setLine = true;
                        }
                        
                        if (line1.a.x == line2.a.x && line1.a.y == line2.a.y && setLine == false)
                        {
                            linestoremove.add(line1);
                            linestoremove.add(line2);
                            lines.add(new Line(new Vector(line1.b.x,line1.b.y),new Vector(line2.b.x,line2.b.y)));
                            
                            lines1.add(new Line(new Vector(line1.b.x,line1.b.y),new Vector(line2.b.x,line2.b.y)));
                            lines1.remove(line1);
                            for (Line line1x : lines1)
                            {
                                if (line1x.a.x == line2.a.x && line1x.a.y == line2.a.y && line1x.b.x == line2.b.x && line1x.b.y == line2.b.y)
                                {
                                    lines1.remove(line1x);
                                }
                            }
                            
                            setLine = true;
                        }
                        if (line1.a.x == line2.b.x && line1.a.y == line2.b.y && setLine == false)
                        {
                            linestoremove.add(line1);
                            linestoremove.add(line2);
                            lines.add(new Line(new Vector(line1.b.x,line1.b.y),new Vector(line2.a.x,line2.a.y)));
                            
                            lines1.add(new Line(new Vector(line1.b.x,line1.b.y),new Vector(line2.a.x,line2.a.y)));
                            lines1.remove(line1);
                            for (Line line1x : lines1)
                            {
                                if (line1x.a.x == line2.a.x && line1x.a.y == line2.a.y && line1x.b.x == line2.b.x && line1x.b.y == line2.b.y)
                                {
                                    lines1.remove(line1x);
                                }
                            }
                            
                            setLine = true;
                        }
                        if (line1.b.x == line2.a.x && line1.b.y == line2.a.y && setLine == false)
                        {
                            linestoremove.add(line1);
                            linestoremove.add(line2);
                            lines.add(new Line(new Vector(line1.a.x,line1.a.y),new Vector(line2.b.x,line2.b.y)));
                            
                            lines1.add(new Line(new Vector(line1.a.x,line1.a.y),new Vector(line2.b.x,line2.b.y)));
                            lines1.remove(line1);
                            for (Line line1x : lines1)
                            {
                                if (line1x.a.x == line2.a.x && line1x.a.y == line2.a.y && line1x.b.x == line2.b.x && line1x.b.y == line2.b.y)
                                {
                                    lines1.remove(line1x);
                                }
                            }
                            
                            setLine = true;
                        }
                        if (line1.b.x == line2.b.x && line1.b.y == line2.b.y && setLine == false)
                        {
                            linestoremove.add(line1);
                            linestoremove.add(line2);
                            lines.add(new Line(new Vector(line1.a.x,line1.a.y),new Vector(line2.a.x,line2.a.y)));
                            
                            lines1.add(new Line(new Vector(line1.a.x,line1.a.y),new Vector(line2.a.x,line2.a.y)));
                            lines1.remove(line1);
                            for (Line line1x : lines1)
                            {
                                if (line1x.a.x == line2.a.x && line1x.a.y == line2.a.y && line1x.b.x == line2.b.x && line1x.b.y == line2.b.y)
                                {
                                    lines1.remove(line1x);
                                }
                            }
                            
                            setLine = true;
                        }
                    
                    }
                    */
                }
            }
            
            for (Line linetoremove : linestoremove)
            {
                for (Line line : lines)
                {
                    if (line.a.x == linetoremove.a.x && line.a.y == linetoremove.a.y && line.b.x == linetoremove.b.x && line.b.y == linetoremove.b.y)
                    {
                        lines.remove(line);
                    }
                }
            }
            
            //
            
            for (CubeTRed obj : (ArrayList<CubeTRed>)illumWorld.getObjects(CubeTRed.class))
            {
                for (Line line : obj.lines)
                {
                    lines.add(line);
                    linesgreen.add(line);
                    linesredonly.add(line);
                }
                for (Vector point : obj.points)
                {
                    points.add(point);
                }
            }
            
            for (CubeTGreen obj : (ArrayList<CubeTGreen>)illumWorld.getObjects(CubeTGreen.class))
            {
                for (Line line : obj.lines)
                {
                    lines.add(line);
                    linesred.add(line);
                    linesgreenonly.add(line);
                }
                for (Vector point : obj.points)
                {
                    points.add(point);
                }
            }
            
            for (CubeFade obj : (ArrayList<CubeFade>)illumWorld.getObjects(CubeFade.class))
            {
                for (Vector point : obj.points)
                {
                    points.add(point);
                }
            }
            
            for (CubeDoor obj : (ArrayList<CubeDoor>)illumWorld.getObjects(CubeDoor.class))
            {
                for (Vector point : obj.points)
                {
                    points.add(point);
                }
            }
            
            //
            
            for (SwitchRed obj : (ArrayList<SwitchRed>)illumWorld.getObjects(SwitchRed.class))
            {
                for (Vector point : obj.points)
                {
                    pointsswitchred.add(point);
                }
            }
            
            for (SwitchGreen obj : (ArrayList<SwitchGreen>)illumWorld.getObjects(SwitchGreen.class))
            {
                for (Vector point : obj.points)
                {
                    pointsswitchgreen.add(point);
                }
            }
        }
        timer = 1;
    }
    
    public void updateBoundaries()
    {
        IllumWorld illumWorld = (IllumWorld) getWorld();
        linesupdating.clear();
        for (CubeFade obj : (ArrayList<CubeFade>)illumWorld.getObjects(CubeFade.class))
        {
            for (Line line : obj.lines)
            {
                linesupdating.add(line);
            }
        }
        
        for (CubeDoor obj : (ArrayList<CubeDoor>)illumWorld.getObjects(CubeDoor.class))
        {
            for (Line line : obj.lines)
            {
                linesupdating.add(line);
            }
        }
    }
    
    public double getMax(double a, double b)
    {
        double max = a;
        if (b > a) max = b;
        return max;
    }
    public double getMin(double a, double b)
    {
        double min = a;
        if (b < a) min = b;
        return min;
    }
    
    public void setpos(int x, int y)
    {
        setLocation(x,y);
    }
    
    /**
     * Method showLight
     *
     * @param img A parameter
     * @param degreeinterval A parameter
     */
    
    public void showLight(GreenfootImage img)
    {
        double x = getX();
        double y = getY();
        
        Map<Double,Vector> pointsDraw = getPoints(points,lines);
        Map<Double,Vector> pointsDrawRed = getPoints(points,linesred);
        Map<Double,Vector> pointsDrawGreen = getPoints(points,linesgreen);
        
        /*
        for (Line line : lines)
        {
            img.drawLine((int)line.a.x+1000-getX(),(int)line.a.y+1000-getY(),(int)line.b.x+1000-getX(),(int)line.b.y+1000-getY());
            img.fillOval((int)line.a.x+1000-getX(),(int)line.a.y+1000-getY(),5,5);
            img.fillOval((int)line.b.x+1000-getX(),(int)line.b.y+1000-getY(),5,5);
        }
        */
       
        drawPolygons(img, Color.RED, pointsDrawRed);
        drawPolygons(img, Color.GREEN, pointsDrawGreen);
        if (this.setBlack == false)
        {
            drawPolygons(img, Color.WHITE, pointsDraw);
        }
        if (this.setBlack == true)
        {
            drawPolygons(img, Color.BLACK, pointsDraw);
            setBlack = false;
        }
        
        IllumWorld illumWorld = (IllumWorld) getWorld();
        
        
        for (Object switchGreenTemp : illumWorld.getObjects(SwitchGreen.class))
        {
            SwitchGreen switchGreen = (SwitchGreen)switchGreenTemp;
            switchGreen.setOff();
        }
        for (Object switchRedTemp : illumWorld.getObjects(SwitchRed.class))
        {
            SwitchRed switchRed = (SwitchRed)switchRedTemp;
            switchRed.setOff();
        }
        
        Player player = illumWorld.getPlayer();
        if (player.reset == false)
        {
            ArrayList<SwitchRed> switchesRed = (ArrayList<SwitchRed>)illumWorld.getObjects(SwitchRed.class);
            for (SwitchRed switchRed : switchesRed)
            {
                for (Vector point : switchRed.points)
                {
                    if (checkSwitch(point,linesred,linesredonly) == true)
                    {
                        switchRed.setOn();
                        break;
                    }
                }
            }
            
            ArrayList<SwitchGreen> switchesGreen = (ArrayList<SwitchGreen>)illumWorld.getObjects(SwitchGreen.class);
            for (SwitchGreen switchGreen : switchesGreen)
            {
                for (Vector point : switchGreen.points)
                {
                    if (checkSwitch(point,linesgreen,linesgreenonly) == true)
                    {
                        switchGreen.setOn();
                        break;
                    }
                }
            }
        }
       
        ArrayList<Enemy> enemies = (ArrayList<Enemy>)illumWorld.getObjects(Enemy.class);
        for (Enemy enemy : enemies)
        {
            for (Vector point : enemy.points)
            {
                if (checkEnemy(point,lines) == true || checkEnemy(point,linesred) == true || checkEnemy(point,linesgreen) == true)
                {
                    resetlevel();
                    break;
                }
            }
        }
        
        setImage(img);
    }
    
    public void drawPolygons(GreenfootImage img, Color color, Map<Double, Vector> map)
    {
        img.setColor(color);
        Vector firstpoint = new Vector(0,0);
        Vector point1 = new Vector(0,0);
        Vector point2 = new Vector(0,0);
        int index = 0;
        for (Map.Entry<Double, Vector> entry : map.entrySet()) {
            if (index == 0)
            {
                firstpoint = entry.getValue();
            }
            point1 = point2;
            point2 = entry.getValue();
            if (index > 0)
            {
                int[] xlist = {(int)point1.x,(int)point2.x,1000};
                int[] ylist = {(int)point1.y,(int)point2.y,1000};
                img.fillPolygon(xlist,ylist,3);
            }
            index++;
        }
        int[] xlist = {(int)point2.x,(int)firstpoint.x,1000};
        int[] ylist = {(int)point2.y,(int)firstpoint.y,1000};
        img.fillPolygon(xlist,ylist,3);
    }
    
    public Map<Double, Vector> getPoints(CopyOnWriteArrayList<Vector> pointsx, CopyOnWriteArrayList<Line> linesx)
    {
        double x = getX();
        double y = getY();
        Map<Double,Vector> pointsDrawUnsorted = new HashMap<Double,Vector>();
        for (Vector point : pointsx)
        {
            Ray ray = new Ray(new Vector(x,y),new Vector(point.x, point.y));
            double length = Math.sqrt(Math.pow(x-point.x,2)+Math.pow(y-point.y,2));
            boolean drawLine = true;
            double x2 = 1000000;
            double y2 = 1000000;
            double length2 = 0;
            for (Line line : linesx)
            {
                Vector intersect = findIntersect(ray,line);
                if (intersect != null)
                {
                    if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < length)
                    {
                        drawLine = false;
                        break;
                    }
                }
            }
            
            for (Line line : linesupdating)
            {
                Vector intersect = findIntersect(ray,line);
                if (intersect != null)
                {
                    if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < length)
                    {
                        drawLine = false;
                        break;
                    }
                }
            }
            
            if (drawLine == true)
            {
                double angle = getAngle(point.x,x,point.y,y);
                //0.0000001
                Ray ray2 = new Ray(new Vector(x,y),new Vector(x+Math.sin(Math.toRadians(angle+0.0000001)),y+Math.cos(Math.toRadians(angle+0.0000001))));
                Ray ray3 = new Ray(new Vector(x,y),new Vector(x+Math.sin(Math.toRadians(angle-0.0000001)),y+Math.cos(Math.toRadians(angle-0.0000001))));
                //Ray ray2 = new Ray(new Vector(x,y),new Vector(point.x+0.1,point.y+0.1));
                //Ray ray3 = new Ray(new Vector(x,y),new Vector(point.x-0.1,point.y-0.1));
                boolean drawLine2 = true;
                boolean drawLine3 = true;
                double xr2 = 1000000;
                double yr2 = 1000000;
                double xr3 = 1000000;
                double yr3 = 1000000;
                for (Line line : linesx)
                {
                    Vector intersect = findIntersect(ray2,line);
                    if (intersect != null)
                    {
                        if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < length)
                        {
                            drawLine2 = false;
                            break;
                        }
                        if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < Math.sqrt(Math.pow(x-xr2,2)+Math.pow(y-yr2,2)))
                        {
                            xr2 = intersect.x;
                            yr2 = intersect.y;
                        }
                    }
                }
                
                if (drawLine2 == true)
                {
                    for (Line line : linesupdating)
                    {
                        Vector intersect = findIntersect(ray2,line);
                        if (intersect != null)
                        {
                            if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < length)
                            {
                                drawLine2 = false;
                                break;
                            }
                            if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < Math.sqrt(Math.pow(x-xr2,2)+Math.pow(y-yr2,2)))
                            {
                                xr2 = intersect.x;
                                yr2 = intersect.y;
                            }
                        }
                    }
                }
                
                if (drawLine2 == true & xr2 != 1000000 & yr2 != 1000000)
                {
                    //img.fillOval((int)(xr2+1000-getX()),(int)(yr2+1000-getY()),10,10);
                    double xr2set = xr2+1000-getX();
                    double yr2set = yr2+1000-getY();
                    pointsDrawUnsorted.put(angle+0.0000001,new Vector(xr2set,yr2set));
                    //img.drawLine((int)Math.round(xr2set),(int)Math.round(yr2set),1000,1000);
                }
                
                for (Line line : linesx)
                {
                    Vector intersect = findIntersect(ray3,line);
                    if (intersect != null)
                    {
                        if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < length)
                        {
                            drawLine3 = false;
                            break;
                        }
                        if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < Math.sqrt(Math.pow(x-xr3,2)+Math.pow(y-yr3,2)))
                        {
                            xr3 = intersect.x;
                            yr3 = intersect.y;
                        }
                    }
                }
                
                if (drawLine3 == true)
                {
                    for (Line line : linesupdating)
                    {
                        Vector intersect = findIntersect(ray3,line);
                        if (intersect != null)
                        {
                            if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < length)
                            {
                                drawLine3 = false;
                                break;
                            }
                            if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < Math.sqrt(Math.pow(x-xr3,2)+Math.pow(y-yr3,2)))
                            {
                                xr3 = intersect.x;
                                yr3 = intersect.y;
                            }
                        }
                    }
                }
                
                if (drawLine3 == true & xr3 != 1000000 & yr3 != 1000000)
                {
                    //img.fillOval((int)(xr3+1000-getX()),(int)(yr3+1000-getY()),10,10);
                    double xr3set = xr3+1000-getX();
                    double yr3set = yr3+1000-getY();
                    pointsDrawUnsorted.put(angle-0.0000001,new Vector(xr3set,yr3set));
                    //img.drawLine((int)Math.round(xr3set),(int)Math.round(yr3set),1000,1000);
                }
            }
            if (drawLine == true)
            {
                x2 = point.x;
                y2 = point.y;
                //img.fillOval((int)(x2+1000-getX()),(int)(y2+1000-getY()),10,10);
                double xset = x2+1000-getX();
                double yset = y2+1000-getY();
                double angle = getAngle(x2,x,y2,y);
                pointsDrawUnsorted.put(angle,new Vector(xset,yset));
                //img.drawLine((int)Math.round(xset),(int)Math.round(yset),1000,1000);
            }
        }
        Map<Double, Vector> pointsDraw = new TreeMap<Double, Vector>(pointsDrawUnsorted);
        return pointsDraw;
    }
    
    public boolean checkSwitch(Vector point, CopyOnWriteArrayList<Line> linesx, CopyOnWriteArrayList<Line> linesy)
    {
        int x = getX();
        int y = getY();
        Ray ray = new Ray(new Vector(x,y),new Vector(point.x, point.y));
        double length = Math.sqrt(Math.pow(x-point.x,2)+Math.pow(y-point.y,2));
        boolean activateSwitch = true;
        double x2 = 1000000;
        double y2 = 1000000;
        double length2 = 0;
        for (Line line : linesx)
        {
            Vector intersect = findIntersect(ray,line);
            if (intersect != null)
            {
                if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < length)
                {
                    activateSwitch = false;
                    break;
                }
            }
        }
        
        for (Line line : linesupdating)
        {
            Vector intersect = findIntersect(ray,line);
            if (intersect != null)
            {
                if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < length)
                {
                    activateSwitch = false;
                    break;
                }
            }
        }
        
        if (activateSwitch == true)
        {
            activateSwitch = false;
            for (Line line : linesy)
            {
                Vector intersect = findIntersect(ray,line);
                if (intersect != null)
                {
                    if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < length)
                    {
                        activateSwitch = true;
                        break;
                    }
                }
            }
        }
        
        return activateSwitch;
    }
    
    public boolean checkEnemy(Vector point, CopyOnWriteArrayList<Line> linesx)
    {
        int x = getX();
        int y = getY();
        Ray ray = new Ray(new Vector(x,y),new Vector(point.x, point.y));
        double length = Math.sqrt(Math.pow(x-point.x,2)+Math.pow(y-point.y,2));
        boolean activateSwitch = true;
        double x2 = 1000000;
        double y2 = 1000000;
        double length2 = 0;
        for (Line line : linesx)
        {
            Vector intersect = findIntersect(ray,line);
            if (intersect != null)
            {
                if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < length)
                {
                    activateSwitch = false;
                    break;
                }
            }
        }
        
        for (Line line : linesupdating)
        {
            Vector intersect = findIntersect(ray,line);
            if (intersect != null)
            {
                if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < length)
                {
                    activateSwitch = false;
                    break;
                }
            }
        }
        
        return activateSwitch;
    }
    
    public static double getAngle(double x1, double x2, double y1, double y2)
    {
        double angle = Math.toDegrees(Math.atan((x1-x2)/(y1-y2)));
                
        if (x1 > x2 && y1 < y2 || x1 < x2 && y1 < y2)
        {
            angle = 180+Math.toDegrees(Math.atan((x1-x2)/(y1-y2)));
        }
        
        if (x1 == x2 && y1 < y2)
        {
            angle = 180;
        }
        
        if (x1 == x2 && y1 > y2)
        {
            angle = 0;
        }
        
        if (x1 < x2 && y1 == y2)
        {
            angle = 90;
        }
        
        if (x1 > x2 && y1 == y2)
        {
            angle = 270;
        }
        
        return angle;
    }
    
    public static Vector findIntersect(Ray ray, Line line)
    {
        double s1_x, s1_y, s2_x, s2_y, s, t;
        s1_x = ray.direction.x - ray.source.x;
        s1_y = ray.direction.y - ray.source.y;
        s2_x = line.b.x - line.a.x;
        s2_y = line.b.y - line.a.y;
        
        s = (-s1_y * (ray.source.x - line.a.x) + s1_x * (ray.source.y - line.a.y)) / (-s2_x * s1_y + s1_x * s2_y);
        t = ( s2_x * (ray.source.y - line.a.y) - s2_y * (ray.source.x - line.a.x)) / (-s2_x * s1_y + s1_x * s2_y);
        
        if (s >= 0 && s<=1 && t >= 0)
        {
            // Collision detected
            Vector intersection = new Vector(0,0);
            intersection.x = ray.source.x + (t * s1_x);
            intersection.y = ray.source.y + (t * s1_y);
            if ((intersection.x < line.a.x && intersection.x < line.b.x) || (intersection.y < line.a.y && intersection.y < line.b.y)
            || (intersection.x > line.a.x && intersection.x > line.b.x) || (intersection.y > line.a.y && intersection.y > line.b.y))
            {
                return null;
            }
            
            return intersection;
        }
        
        return null;
    }
    
    public void resetlevel()
    {
        IllumWorld illumWorld = (IllumWorld) getWorld();
        Player player = illumWorld.getPlayer();
        //ArrayList<CubeDoor> cubeDoorList = (ArrayList<CubeDoor>)illumWorld.getObjects(CubeDoor.class);
        //ArrayList<CubeDoor3d> cubeDoor3dList = (ArrayList<CubeDoor3d>)illumWorld.getObjects(CubeDoor3d.class);
        ResetImage resetImage = illumWorld.getResetImage();
        //ArrayList<Enemy> enemies = (ArrayList<Enemy>)illumWorld.getObjects(Enemy.class);
        if (player.resettimer == 0)
        {
            resetImage.timer = 1;
            player.resettimer = 20;
            /*
            for (CubeDoor cubeDoor : cubeDoorList)
            {
                cubeDoor.timer = 0;
            }
            for (CubeDoor3d cubeDoor3d : cubeDoor3dList)
            {
                cubeDoor3d.timer = 0;
            }
            for (Enemy enemy : enemies)
            {
                enemy.reset();
            }
            */
        }
        player.reset = true;
    }
}
