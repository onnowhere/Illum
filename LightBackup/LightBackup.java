import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.awt.geom.Line2D;
/**
 * Write a description of class LightBackup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightBackup extends Animal
{
    public ArrayList<Line> lines = new ArrayList<Line>();
    //public ArrayList<Vector> points = new ArrayList<Vector>();
    public CopyOnWriteArrayList<Vector> points = new CopyOnWriteArrayList<Vector>();
    public CopyOnWriteArrayList<Vector> points1 = new CopyOnWriteArrayList<Vector>();
    public CopyOnWriteArrayList<Vector> innercorners = new CopyOnWriteArrayList<Vector>();
    public int timer = 0;
    /**
     * Act - do whatever the LightBackup wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        getImage().clear();
        GreenfootImage img = new GreenfootImage(2000,2000);
        img.setColor(Color.WHITE);
        //showLightx(img, 1);
        initial();
        updateBoundaries();
        showLightz(img, 2);
        //showLighty(img, 1);
    }
    public void initial()
    {
        if (timer == 0)
        {
            IllumWorld illumWorld = (IllumWorld) getWorld();
            
            for (Cube obj : illumWorld.getObjects(Cube.class))
            {
                for (Line line : obj.lines)
                {
                    lines.add(line);
                }
                for (Vector point : obj.points)
                {
                    points.add(point);
                    points1.add(point);
                }
            }
            
            for (CubeBorder obj : illumWorld.getObjects(CubeBorder.class))
            {
                for (Line line : obj.lines)
                {
                    lines.add(line);
                }
                for (Vector point : obj.points)
                {
                    points.add(point);
                    points1.add(point);
                }
            }
            
            //
            
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
        }
        timer = 1;
    }
    public void updateBoundaries()
    {
        
    }
    public void showLight(GreenfootImage img, double degreeinterval)
    {
        double degree = 0.0;
        /*
        for (Cube cube : getObjectsInRange(1000, Cube.class)) cube.setInvisible();
        for (Cube3d cube3d : getObjectsInRange(1000, Cube3d.class)) cube3d.setInvisible();
        for (CubeFade cubeFade : getObjectsInRange(1000, CubeFade.class)) cubeFade.setInvisible();
        for (CubeFade3d cubeFade3d : getObjectsInRange(1000, CubeFade3d.class)) cubeFade3d.setInvisible();
        for (CubeTWhite cubeTWhite : getObjectsInRange(1000, CubeTWhite.class)) cubeTWhite.setInvisible();
        for (CubeTWhite3d cubeTWhite3d : getObjectsInRange(1000, CubeTWhite3d.class)) cubeTWhite3d.setInvisible();
        */
        for (Object switchGreenTemp : getWorld().getObjects(SwitchGreen.class))
        {
            SwitchGreen switchGreen = (SwitchGreen)switchGreenTemp;
            switchGreen.setOff();
        }
        for (Object switchRedTemp : getWorld().getObjects(SwitchRed.class))
        {
            SwitchRed switchRed = (SwitchRed)switchRedTemp;
            switchRed.setOff();
        }
        while (degree < 360)
        {
            double x = (double)getX();
            double y = (double)getY();
            double xred = x;
            double yred = y;
            double xgreen = x;
            double ygreen = y;
            double xinterval = (double)Math.sin(Math.toRadians(degree))*10;
            double yinterval = (double)Math.cos(Math.toRadians(degree))*10;
            int xyscale = 1;
            int xyscalered = 1;
            int xyscalegreen = 1;
            double xz = 0;
            double yz = 0;
            double xredz = 0;
            double yredz = 0;
            double xgreenz = 0;
            double ygreenz = 0;
            boolean checkPoint = true;
            boolean checkPointRed = true;
            boolean checkPointGreen = true;
            while (
            getWorld().getObjectsAt((int)Math.round(x - xinterval/2),(int)Math.round(y - yinterval/2),Cube.class).isEmpty()
            && getWorld().getObjectsAt((int)Math.round(x - xinterval/2),(int)Math.round(y - yinterval/2),CubeBorder.class).isEmpty()
            && x>0 && y>0 && checkPoint == true)
            {
                x += xinterval;
                y += yinterval;
                xred = x;
                yred = y;
                xgreen = x;
                ygreen = y;
                xyscale++;
                xyscalered = xyscale;
                xyscalegreen = xyscale;
                xz = x-xinterval/2;
                yz = y-yinterval/2;
                if (!getWorld().getObjectsAt((int)Math.round(xz),(int)Math.round(yz),CubeFade.class).isEmpty())
                {
                    CubeFade cubeFadeCheck = (CubeFade)getWorld().getObjectsAt((int)Math.round(xz),(int)Math.round(yz),CubeFade.class).get(0);
                    if (cubeFadeCheck.faded == false)
                    {
                        checkPoint = false;
                    }
                }
                if (!getWorld().getObjectsAt((int)Math.round(xz),(int)Math.round(yz),CubeDoor.class).isEmpty())
                {
                    CubeDoor cubeDoorCheck = (CubeDoor)getWorld().getObjectsAt((int)Math.round(xz),(int)Math.round(yz),CubeDoor.class).get(0);
                    if (cubeDoorCheck.visible == true)
                    {
                        checkPoint = false;
                    }
                }
                if (!getWorld().getObjectsAt((int)Math.round(xz),(int)Math.round(yz),CubeTRed.class).isEmpty())
                {
                    checkPoint = false;
                    while (
                    getWorld().getObjectsAt((int)Math.round(xred-xinterval/2),(int)Math.round(yred-yinterval/2),Cube.class).isEmpty()
                    && getWorld().getObjectsAt((int)Math.round(xred-xinterval/2),(int)Math.round(yred-yinterval/2),CubeBorder.class).isEmpty()
                    && xred>0 && yred>0 && checkPointRed == true)
                    {
                        xred += xinterval;
                        yred += yinterval;
                        xyscalered++;
                        xredz = xred-xinterval/2;
                        yredz = yred-yinterval/2;
                        if (!getWorld().getObjectsAt((int)Math.round(xredz),(int)Math.round(yredz),SwitchRed.class).isEmpty())
                        {
                            SwitchRed switchRed = (SwitchRed)getWorld().getObjectsAt((int)Math.round(xredz), (int)Math.round(yredz), SwitchRed.class).get(0);
                            switchRed.setOn();
                        }
                        if (!getWorld().getObjectsAt((int)Math.round(xredz),(int)Math.round(yredz),CubeFade.class).isEmpty())
                        {
                            CubeFade cubeFadeCheck = (CubeFade)getWorld().getObjectsAt((int)Math.round(xredz),(int)Math.round(yredz),CubeFade.class).get(0);
                            if (cubeFadeCheck.faded == false)
                            {
                                checkPointRed = false;
                            }
                        }
                    }
                }
                if (!getWorld().getObjectsAt((int)Math.round(xz),(int)Math.round(yz),CubeTGreen.class).isEmpty())
                {
                    checkPoint = false;
                    while (
                    getWorld().getObjectsAt((int)Math.round(xgreen),(int)Math.round(ygreen),Cube.class).isEmpty()
                    && getWorld().getObjectsAt((int)Math.round(xgreen),(int)Math.round(ygreen),CubeBorder.class).isEmpty()
                    && xgreen>0 && ygreen>0 && checkPointGreen == true)
                    {
                        xgreen += xinterval;
                        ygreen += yinterval;
                        xyscalegreen++;
                        xgreenz = xgreen-xinterval/2;
                        ygreenz = ygreen-yinterval/2;
                        if (!getWorld().getObjectsAt((int)Math.round(xgreenz),(int)Math.round(ygreenz),SwitchGreen.class).isEmpty())
                        {
                            SwitchGreen switchGreen = (SwitchGreen)getWorld().getObjectsAt((int)Math.round(xgreenz), (int)Math.round(ygreenz), SwitchGreen.class).get(0);
                            switchGreen.setOn();
                        }
                        if (!getWorld().getObjectsAt((int)Math.round(xgreenz),(int)Math.round(ygreenz),CubeFade.class).isEmpty())
                        {
                            CubeFade cubeFadeCheck = (CubeFade)getWorld().getObjectsAt((int)Math.round(xgreenz),(int)Math.round(ygreenz),CubeFade.class).get(0);
                            if (cubeFadeCheck.faded == false)
                            {
                                checkPointGreen = false;
                            }
                        }
                    }
                }
            }
            x = x-(double)getX()+1000;
            y = y-(double)getY()+1000;
            xred = xred-(double)getX()+1000;
            yred = yred-(double)getY()+1000;
            xgreen = xgreen-(double)getX()+1000;
            ygreen = ygreen-(double)getY()+1000;
            double x2 = 0;
            double y2 = 0;
            double xred2 = 0;
            double yred2 = 0;
            double xgreen2 = 0;
            double ygreen2 = 0;
            x2 = xyscale/3.5*(double)Math.cos(Math.toRadians(degree-90));
            y2 = xyscale/3.5*(double)Math.sin(Math.toRadians(degree-90));
            xred2 = xyscalered/3.5*(double)Math.cos(Math.toRadians(degree-90));
            yred2 = xyscalered/3.5*(double)Math.sin(Math.toRadians(degree-90));
            xgreen2 = xyscalegreen/3.5*(double)Math.cos(Math.toRadians(degree-90));
            ygreen2 = xyscalegreen/3.5*(double)Math.sin(Math.toRadians(degree-90));
            int[] xlist = {(int)Math.round(x-y2),(int)Math.round(x+y2),1000};
            int[] ylist = {(int)Math.round(y-x2),(int)Math.round(y+x2),1000};
            int[] xredlist = {(int)Math.round(xred-yred2),(int)Math.round(xred+yred2),(int)Math.round(x+y2),(int)Math.round(x-y2)};
            int[] yredlist = {(int)Math.round(yred-xred2),(int)Math.round(yred+xred2),(int)Math.round(y+x2),(int)Math.round(y-x2)};
            int[] xgreenlist = {(int)Math.round(xgreen-ygreen2),(int)Math.round(xgreen+ygreen2),(int)Math.round(x+y2),(int)Math.round(x-y2)};
            int[] ygreenlist = {(int)Math.round(ygreen-xgreen2),(int)Math.round(ygreen+xgreen2),(int)Math.round(y+x2),(int)Math.round(y-x2)};
            img.setColor(Color.RED);
            img.fillPolygon(xredlist,yredlist,4);
            img.setColor(Color.GREEN);
            img.fillPolygon(xgreenlist,ygreenlist,4);
            img.setColor(Color.WHITE);
            img.fillPolygon(xlist,ylist,3);
            //img.drawLine((int)Math.round(x),(int)Math.round(y),1000,1000);
            degree += degreeinterval;
        }
        img.setTransparency(250);
        setImage(img);
    }
    
    /**
     * Method showLightx
     *
     * @param img A parameter
     * @param degreeinterval A parameter
     */
    /*
    public void showLightx(GreenfootImage img, double degreeinterval)
    {
        IllumWorld illumWorld = (IllumWorld) getWorld();
        ArrayList<Cube> cubeList = illumWorld.getCubeList();
        double degree = 0.0;
        while (degree < 360)
        {
            double x = (double)getX();
            double y = (double)getY();
            double xinterval = (double)Math.sin(Math.toRadians(degree));
            double yinterval = (double)Math.cos(Math.toRadians(degree));
            Ray ray = new Ray(new Vector(x,y),new Vector(xinterval, yinterval));
            Vector intersection = new Vector(0,0);
            double nearest = -1;
            int xyscale = 0;
            for (Cube cube : cubeList)
            {
                double checkY = cube.cubeX()*(yinterval/xinterval);
                if (checkY < cube.cubeY()+10 && checkY > cube.cubeY()-10 && cube.cubeY()-getY() < y && cube.cubeX()-getX() < x)
                {
                    x = cube.cubeX();
                    y = cube.cubeY();
                }
            }
            x = x-(double)getX()+1000;
            y = y-(double)getY()+1000;
            double x2 = 0;
            double y2 = 0;
            if ((degree >= 0 && degree < 45) || (degree >= 315 && degree < 360) || (degree >= 135 && degree < 225))
            {
                x2 = 0;
                y2 = 0.2*xyscale;
            }
            else
            {
                x2 = 0.2*xyscale;
                y2 = 0;
            }
            int[] xlist = {(int)Math.round(x-y2),(int)Math.round(x+y2),1000};
            int[] ylist = {(int)Math.round(y-x2),(int)Math.round(y+x2),1000};
            img.fillPolygon(xlist,ylist,3);
            img.drawLine((int)Math.round(x),(int)Math.round(y),1000,1000);
            //img.drawLine((int)Math.round(x),(int)Math.round(y),1000,1000);
            degree += degreeinterval;
        }
        setImage(img);
    }
    */
    /**
     * Method showLightx
     *
     * @param img A parameter
     * @param degreeinterval A parameter
     */
    /*
    public void showLighty(GreenfootImage img, double degreeinterval)
    {
        IllumWorld illumWorld = (IllumWorld) getWorld();
        ArrayList<Cube> cubeList = illumWorld.getCubeList();
        double degree = 0.0;
        while (degree < 360)
        {
            double x = (double)getX();
            double y = (double)getY();
            double xinterval = (double)Math.sin(Math.toRadians(degree));
            double yinterval = (double)Math.cos(Math.toRadians(degree));
            Ray ray = new Ray(new Vector(x,y),new Vector(xinterval, yinterval));
            Vector intersect = new Vector(0,0);
            double nearest = -1;
            int xyscale = 0;
            for (Cube cube : cubeList)
            {
                for (Line line : cube.lines)
                {
                    Vector pintersect = ray.intersect(line);
                    double distsquared = Math.pow(pintersect.x-x,2)+Math.pow(pintersect.y-y,2);
                    if (distsquared < nearest || nearest == -1)
                    {
                        nearest = distsquared;
                        intersect = pintersect;
                    }
                }
            }
            x = intersect.x;
            y = intersect.y;
            x = x-(double)getX()+1000;
            y = y-(double)getY()+1000;
            double x2 = 0;
            double y2 = 0;
            if ((degree >= 0 && degree < 45) || (degree >= 315 && degree < 360) || (degree >= 135 && degree < 225))
            {
                x2 = 0;
                y2 = 0.2*xyscale;
            }
            else
            {
                x2 = 0.2*xyscale;
                y2 = 0;
            }
            int[] xlist = {(int)Math.round(x-y2),(int)Math.round(x+y2),1000};
            int[] ylist = {(int)Math.round(y-x2),(int)Math.round(y+x2),1000};
            //img.fillPolygon(xlist,ylist,3);
            img.drawLine((int)Math.round(x),(int)Math.round(y),1000,1000);
            degree += degreeinterval;
        }
        setImage(img);
    }
    */
    
    
    public void setpos(int x, int y)
    {
        setLocation(x,y);
    }
    
    public <T> ArrayList<T> getObjectsInRegion(double x, double y, double xoffset, double yoffset, Class type)
    {
        ArrayList<T> objCheck = new ArrayList<>();
        if (!getWorld().getObjectsAt((int)(x+xoffset),(int)(y+yoffset),type).isEmpty())
        {
            objCheck.add((T)getWorld().getObjectsAt((int)(x+xoffset),(int)(y+yoffset),type).get(0));
        }
        if (!getWorld().getObjectsAt((int)(x+xoffset),(int)(y-yoffset),type).isEmpty())
        {
            objCheck.add((T)getWorld().getObjectsAt((int)(x+xoffset),(int)(y-yoffset),type).get(0));
        }
        if (!getWorld().getObjectsAt((int)(x-xoffset),(int)(y+yoffset),type).isEmpty())
        {
            objCheck.add((T)getWorld().getObjectsAt((int)(x-xoffset),(int)(y+yoffset),type).get(0));
        }
        if (!getWorld().getObjectsAt((int)(x-xoffset),(int)(y-yoffset),type).isEmpty())
        {
            objCheck.add((T)getWorld().getObjectsAt((int)(x-xoffset),(int)(y-yoffset),type).get(0));
        }
        return objCheck;
    }
    
    /**
     * Method showLightx
     *
     * @param img A parameter
     * @param degreeinterval A parameter
     */
    
    public void showLightz(GreenfootImage img, double degreeinterval)
    {
        double degree = 360.0;
        double x = getX();
        double y = getY();
        for (Vector point : points)
        {
            //Ray line2 = new Ray(new Vector(x,y),new Vector(point.x, point.y));
            Ray ray = new Ray(new Vector(x,y),new Vector(point.x, point.y));
            ArrayList<Cube> cubesCheck = getObjectsInRegion(point.x,point.y,10,10,Cube.class);
            ArrayList<CubeBorder> bordersCheck = getObjectsInRegion(point.x,point.y,10,10,CubeBorder.class);
            double length = Math.sqrt(Math.pow(x-point.x,2)+Math.pow(y-point.y,2));
            boolean drawLine = true;
            boolean lineextend = true;
            double x2 = 1000000;
            double y2 = 1000000;
            double length2 = 0;
            //double x2 = vector.x;
            //double y2 = vector.y;
            for (Line line : lines)
            {
                Vector intersect = findIntersect(ray,line);
                if (intersect != null)
                {
                    if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < length
                    //&& intersect.x != point.x && intersect.y != point.y)
                    )
                    {
                        drawLine = false;
                        lineextend = false;
                        break;
                    }
                    /*
                    if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < Math.sqrt(Math.pow(x-x2,2)+Math.pow(y-y2,2))
                    //&& intersect.x != point.x && intersect.y != point.y)
                    )
                    {
                        lineextend = true;
                        /*
                        for (Cube cubeCheck : cubesCheck)
                        {
                            for (Line cubeLine : cubeCheck.lines)
                            {
                                if (line == cubeLine)
                                {
                                    lineextend = false;
                                    break;
                                }
                            }
                        }
                    }
                    */
                    /*
                    if (Math.sqrt(Math.pow(x-intersect.x,2)+Math.pow(y-intersect.y,2)) < Math.sqrt(Math.pow(x-x2,2)+Math.pow(y-y2,2))
                    && intersect.x == point.x && intersect.y == point.y)
                    {
                        x2 = point.x;
                        y2 = point.y;
                        lineextend = false;
                    }
                    */
                    /*
                    if (Math.sqrt(Math.pow(getX()-intersect.x,2)+Math.pow(getY()-intersect.y,2)) < Math.sqrt(Math.pow(getX()-x2,2)+Math.pow(getY()-y2,2))
                    && intersect.x == point.x && intersect.y == point.y)
                    {
                        for (CubeBorder borderCheck : bordersCheck)
                        {
                            for (Line borderLine : borderCheck.lines)
                            {
                                if (line == borderLine)
                                {
                                    drawLine = true;
                                    lineextend = false;
                                }
                            }
                        }
                    }
                    */
                    /*
                    intersectCount++;
                    
                    if (intersectCount == 1)
                    {
                        
                        x2 = intersect.x;
                        y2 = intersect.y;
                        drawLine = true;
                    }
                    if (intersectCount > 1)
                    {
                        drawLine = false;
                    }
                    */
                    
                    
                }
                //if (intersect != null)
                //{
                //    if (Math.sqrt(Math.pow(getX()-intersect.x,2)+Math.pow(getY()-intersect.y,2)) < Math.sqrt(Math.pow(getX()-x2,2)+Math.pow(getY()-y2,2)))
                //    {
                //        drawLine = true;
                //        x2 = intersect.x;
                //        y2 = intersect.y;
                //    }
                //}
                
                //if (Line2D.linesIntersect(line.a.x,line.a.y,line.b.x,line.b.y,line2.a.x,line2.a.y,line2.b.x,line2.b.y) == true)
                //{
                //    drawLine = false;
                //}
            }
            
            if (lineextend == true)
            {
                double angle = Math.toDegrees(Math.atan((point.y-y)/(point.x-x)));
                //Ray ray2 = new Ray(new Vector(x,y),new Vector(x+Math.sin(Math.toRadians(angle+1)),y+Math.cos(Math.toRadians(angle+1))));
                //Ray ray3 = new Ray(new Vector(x,y),new Vector(x+Math.sin(Math.toRadians(angle-1)),y+Math.cos(Math.toRadians(angle-1))));
                Ray ray2 = new Ray(new Vector(x,y),new Vector(point.x+0.1,point.y+0.1));
                Ray ray3 = new Ray(new Vector(x,y),new Vector(point.x-0.1,point.y-0.1));
                boolean drawLine2 = true;
                boolean drawLine3 = true;
                double xr2 = 1000000;
                double yr2 = 1000000;
                double xr3 = 1000000;
                double yr3 = 1000000;
                for (Line line : lines)
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
                if (drawLine2 == true & xr2 != 1000000 & yr2 != 1000000)
                {
                    double xr2set = xr2+1000-getX();
                    double yr2set = yr2+1000-getY();
                    img.drawLine((int)Math.round(xr2set),(int)Math.round(yr2set),1000,1000);
                }
                for (Line line : lines)
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
                if (drawLine3 == true & xr3 != 1000000 & yr3 != 1000000)
                {
                    double xr3set = xr3+1000-getX();
                    double yr3set = yr3+1000-getY();
                    img.drawLine((int)Math.round(xr3set),(int)Math.round(yr3set),1000,1000);
                }
            }
            if (drawLine == true)
            {
                x2 = point.x;
                y2 = point.y;
                //img.fillOval((int)(x2+1000-getX()),(int)(y2+1000-getY()),10,10);
                double xset = x2+1000-getX();
                double yset = y2+1000-getY();
                img.drawLine((int)Math.round(xset),(int)Math.round(yset),1000,1000);
            }
        }
        /*
        for (Vector innercorner : innercorners)
        {
            Ray ray = new Ray(new Vector(x,y),new Vector(innercorner.x, innercorner.y));
            boolean drawLine = true;
            double x2 = innercorner.x;
            double y2 = innercorner.y;
            for (Line line : lines)
            {
                Vector intersect = findIntersect(ray,line);
                if (intersect != null)
                {
                    if (Math.sqrt(Math.pow(getX()-intersect.x,2)+Math.pow(getY()-intersect.y,2)) < Math.sqrt(Math.pow(getX()-innercorner.x,2)+Math.pow(getY()-innercorner.y,2))
                    && intersect.x != innercorner.x && intersect.y != innercorner.y)
                    {
                        drawLine = false;
                        break;
                    }
                }
            }
            if (drawLine == true)
            {
                double xset = x2+1000-getX();
                double yset = y2+1000-getY();
                img.drawLine((int)Math.round(xset),(int)Math.round(yset),1000,1000);
            }
        }
        */
        while (degree < 360)
        {
            x = (double)getX();
            y = (double)getY();
            double xinterval = (double)Math.sin(Math.toRadians(degree));
            double yinterval = (double)Math.cos(Math.toRadians(degree));
            Ray ray = new Ray(new Vector(x,y),new Vector(xinterval, yinterval));
            Vector intersect = new Vector(0,0);
            double nearest = -1;
            int xyscale = 0;
            for (Line line : lines)
            {
                Vector pintersect = ray.intersect(line);
                double distsquared = Math.pow(pintersect.x-x,2)+Math.pow(pintersect.y-y,2);
                if (distsquared < nearest || nearest == -1)
                {
                    nearest = distsquared;
                    intersect = pintersect;
                }
            }
            x = intersect.x;
            y = intersect.y;
            x = x-(double)getX()+1000;
            y = y-(double)getY()+1000;
            double x2 = 0;
            double y2 = 0;
            if ((degree >= 0 && degree < 45) || (degree >= 315 && degree < 360) || (degree >= 135 && degree < 225))
            {
                x2 = 0;
                y2 = 0.2*xyscale;
            }
            else
            {
                x2 = 0.2*xyscale;
                y2 = 0;
            }
            int[] xlist = {(int)Math.round(x-y2),(int)Math.round(x+y2),1000};
            int[] ylist = {(int)Math.round(y-x2),(int)Math.round(y+x2),1000};
            //img.fillPolygon(xlist,ylist,3);
            img.drawLine((int)Math.round(x),(int)Math.round(y),1000,1000);
            degree += degreeinterval;
        }
        setImage(img);
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
        
        //if (-s2_x * s1_y + s1_x * s2_y == 0)
        //{
        //    
        //}
        //else
        //{
        //    return null;
        //}
        
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
    public static Vector findIntersect2(Ray ray, Line line)
    {
        double r, s, d;
        
        // Make sure the lines aren't parallel
        if ((ray.direction.y - ray.source.y) / (ray.direction.x - ray.source.x) != (line.b.y - line.a.y) / (line.b.x - line.a.x))
        {
            d = (((ray.direction.x - ray.source.x) * (line.b.y - line.a.y)) - (ray.direction.y - ray.source.y) * (line.b.x - line.a.x));
            if (d != 0)
            {
                r = (((ray.source.y - line.a.y) * (line.b.x - line.a.x)) - (ray.source.x - line.a.x) * (line.b.y - line.a.y)) / d;
                s = (((ray.source.y - line.a.y) * (ray.direction.x - ray.source.x)) - (ray.source.x - line.a.x) * (ray.direction.y - ray.source.y)) / d;
                if (r >= 0)
                {
                    if (s >= 0 && s <= 1)
                    {
                        return new Vector(ray.source.x + r * (ray.direction.x - ray.source.x), ray.source.y + r * (ray.direction.y - ray.source.y));
                    }
                }
            }
        }
        return null;
    }
    public static Vector findIntersect3(Line line1, Line line2)
    {
        double x1 = line1.a.x;
        double y1 = line1.a.y;
        double x2 = line1.b.x;
        double y2 = line1.b.y;
        
        double x3 = line2.a.x;
        double y3 = line2.a.y;
        double x4 = line2.b.x;
        double y4 = line2.b.y;
        
        double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
        if (d == 0) return null;
   
        double xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
        double yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;
        
        if (line1.a.x < line1.b.x)
        {
            if (line1.a.y < line1.b.y)
            {
                if (xi < line1.a.x || yi < line1.a.y)
                {
                    return null;
                }
            }
            if (line1.a.y > line1.b.y)
            {
                if (xi < line1.a.x || yi > line1.a.y)
                {
                    return null;
                }
            }
        }
        if (line1.a.x > line1.b.x)
        {
            if (line1.a.y < line1.b.y)
            {
                if (xi > line1.a.x || yi < line1.a.y)
                {
                    return null;
                }
            }
            if (line1.a.y > line1.b.y)
            {
                if (xi > line1.a.x || yi > line1.a.y)
                {
                    return null;
                }
            }
        }
        if ((xi < line2.a.x && xi < line2.b.x) || (yi < line2.a.y && yi < line2.b.y)
        || (xi > line2.a.x && xi > line2.b.x) || (yi > line2.a.y && yi > line2.b.y))
        {
            return null;
        }
        
        return new Vector(xi,yi);
    }
    public static Vector findIntersect4(Ray ray, Line line)
    {
        //if (true)
        //return ray.source;
        
        Vector v1 = ray.source.subtract(line.a);
        Vector v2 = line.b.subtract(line.a);
        Vector v3 = ray.direction.normal();
        double t1 = v2.cross(v1)/v2.dot(v3);
        double t2 = v1.dot(v3)/v2.dot(v3);
        if (t1 > 0 && 0 < t2 && t2 < 1) {
            Vector intersection = ray.source.add(ray.direction.scalarmultiply(t1));
            intersection.y = ray.source.y+ray.source.y-intersection.y;
            return intersection;
        }
        return null; // No collision
    }
    public static Vector findIntersect5(Ray ray, Line line)
    {
        double s1x = ray.direction.x - ray.source.x;
        double s1y = ray.direction.y - ray.source.y;
        double s2x = line.b.x - line.a.x;
        double s2y = line.b.y - line.a.y;
    
        double s = (-s1y * (ray.source.x - line.a.x) + s1x * (ray.source.y - line.a.y)) / (-s2x * s1y + s1x * s2y);
        double t = (s2x * (ray.source.y - line.a.y) - s2y * (ray.source.x - line.a.x)) / (-s2x * s1x + s1x * s2y);
    
        if (s >= 0 && s <= 1 && t >= 0 && t <= 1)
        {
            // Collision detected
            // Return the point of intersection
            return new Vector(ray.source.x + (t * s1x), ray.source.y + (t * s1y));
        }
        
        return null; // No collision
    }
}
