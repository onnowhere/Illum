import greenfoot.*; 
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class IllumWorld extends World
{
    public Light light;
    public Glow glow;
    public Player player;
    public ResetImage resetImage;
    public FinishImage finishImage;
    public YouWin youWin;
    public SpaceCube spaceCube;
    
    public String[] levelmap;
    public IllumWorld() 
    {
        super(1000, 600, 1);
        Greenfoot.setSpeed(51);
        //c f i W G R 1g 1r 2e 1gd 1rd
        levelmap = new String[]
        {
            "xxxixxxiioxo2cxxoxxx1gxoxxxxoxxxx4exxxxxxxx",
            "xiiixiiixx1coxoxoxoxxxxxooxoxxxxxxxxxxxxx",
            "xixxxixxxoxoxoxxxxxoxxxxxxoxxxoxxooooxxo",
            "xixixxxiioxoxxxxxoxxxxoxxxox3cxoxxWxxxxxx",
            "xixiiiiixoxoxx2eoxxxxoxxxoxoo3gdooxxWxiiiix",
            "xxxxxxxxxoxoxxxxxxoxxxxxxxoxxxoxxWxxxxxx",
            "ooooooxixoxo1gdoooooooooxoxooxxxoxxoRRoooo",
            "xxxoxoiixoxxxxxxxxoxxxxxxxoxxxoxxoffoxxx",
            "xxxoxoxxxoxxxxxxxxoxoxoxoxxxxxoxxoxxoxxx",
            "xSxxxoxixoxxxxooxxoxxxxxxxxxxxoxxoxxxxFx",
            "xSxxxoxxxoxxxxo1rxxoooooWGWoooooxxfxxxxFx",
            "xxxoxoo2gdoooxx1exxxxoxxixxxxxxoxxxxfxxoxxx",
            "xxxoxoxxxoxxxxxxxxoxxxxxiixxoxixxfxxoxxx",
            "ooooxoxxxoxooooooRoxiiixxxxioxxxxo2rd2rdoooo",
            "2gxfxxoxxxoxxxxoxx1rixxxixiixxoooxxoxxxxix",
            "xxfxxoxxxoxxxxoxixxxxxi3gixxxoxxxxoiiixix",
            "fffxxoxxxoxxxxoxixiixiiiixiioxxxxoixixix",
            "xxxxxxxxxoxxxxoxixixxxxixxxxoxxxxoixxxxx",
            "xxxxxGxxxoxxxx1rdxixix3eixxxxixoffxxxiiiixi",
            "xxxxxxxxxoxxxxoxxxixxxxxixixo2rfxxxxxxxxx"
        };
        setShadow();
        //addObject(new DarkLight(1),0,0);
        //addObject(new DarkLight(2),0,0);
        removeObject(light);
        removeObject(glow);
        removeObject(player);
        light = new Light();
        addLight(110,300);
        populateWithCheckpoints(levelmap);
        player = new Player();
        setPlayer(110,300);
        player.xspawn = 110;
        player.yspawn = 300;
        addObject(new Finish(),880,300);
        populateWithEnemies(levelmap);
        populateWithCubes(levelmap);
        glow = new Glow();
        addGlow(110,300);
        addObject(new SpaceBorder(),500,300);
        setBorder();
        addObject(new CheckpointFlag(),500,300);
        resetImage = new ResetImage();
        addObject(resetImage,500,300);
        finishImage = new FinishImage();
        addObject(finishImage,500,300);
        youWin = new YouWin();
        addObject(youWin,500,420);
        spaceCube = new SpaceCube();
        addObject(spaceCube,500,800);
        act();
    }
    public IllumWorld(int level) 
    {
        super(1000, 600, 1);
        Greenfoot.setSpeed(51);
        boolean generateMaze = false;
        levelmap = new String[]
        {
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
        };
        if (level == -1)
        {
            levelmap = new String[]
            {
                "ofxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxoxxx9e",
                "ooxx4cxxxxxxxxxxxxxxxxxxxGRxxxxxxxxxoxxoo",
                "xooxxxxxxx1gxxxxfffxooooxxWfixx2cxxxxoxxxx",
                "xxooxxxxxxxxxxxxxxxxxxxxRGRGooxxxxxoxxxx",
                "xxxoooxxGGxxxxxxxxxxxxxxxxxxooxxxxxoo1rdoo",
                "xxxxxoxxxxxRxx1rxxxxxxxxxxxxxxxxxxxxxxxii",
                "ooooxoxxxxxRxxxxxxx3cxxxoxxxxxxxxxxxxxxxi",
                "xxxoxxxxxxxRxxxxxxxxxxxxxxiixxxixxxxxxxx",
                "xxxoxxxxxxxxxxxxxxWxxxxxxxxiixxiixxixxxx",
                "SxxxxxxxoxxxxxxxxWfWxxxxxxxxixxxxxxiixxx",
                "SxxxxxoxxxxxxixxxxWxxxxxxxxxxxiiixxixxxx",
                "xxxoxx1gdxxxxixxxxxxixxxxxxxxxxxxxxxxxxxxx",
                "xxxoxooxxxxxxiiiiiixiixxxxxxxxxxxxxxxxxx",
                "ooooooxxxxxxxxxxxxixxxxxxxxxxxGxxxxxxxxx",
                "xxxxxooxxxxxxixiixi1cxixxxRRxxGxxxxxxxxxx",
                "xxxxxxoxiixxxixxixxxxixxxRxxxGxxxxxxxxxx",
                "xxxxxxoxxiiixixxixixxixxxxxxxxxxxxxxxxxx",
                "xxxxxxoxxxxxxixxxxixxixxxxxxxxxxxxxxxxxx",
                "x1exxxxxxxxxxxxxixxxxxxxxxxxxxxxxx5cxxxxxx",
                "oxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxo"
            };
        }
        if (level == 1)
        {
            levelmap = new String[]
            {
                "xxxixxxiioxo2cxxoxxx1gxoxxxxoxxxx4exxxxxxxx",
                "xiiixiiixx1coxoxoxoxxxxxooxoxxxxxxxxxxxxx",
                "xixxxixxxoxoxoxxxxxoxxxxxxoxxxoxxooooxxo",
                "xixixxxiioxoxxxxxoxxxxoxxxox3cxoxxWxxxxxx",
                "xixiiiiixoxoxx2eoxxxxoxxxoxoo3gdooxxWxiiiix",
                "xxxxxxxxxoxoxxxxxxoxxxxxxxoxxxoxxWxxxxxx",
                "ooooooxixoxo1gdoooooooooxoxooxxxoxxoRRoooo",
                "xxxoxoiixoxxxxxxxxoxxxxxxxoxxxoxxoffoxxx",
                "xxxoxoxxxoxxxxxxxxoxoxoxoxxxxxoxxoxxoxxx",
                "xSxxxoxixoxxxxooxxoxxxxxxxxxxxoxxoxxxxFx",
                "xSxxxoxxxoxxxxo1rxxoooooWGWoooooxxfxxxxFx",
                "xxxoxoo2gdoooxx1exxxxoxxixxxxxxoxxxxfxxoxxx",
                "xxxoxoxxxoxxxxxxxxoxxxxxiixxoxixxfxxoxxx",
                "ooooxoxxxoxooooooRoxiiixxxxioxxxxo2rd2rdoooo",
                "2gxfxxoxxxoxxxxoxx1rixxxixiixxoooxxoxxxxix",
                "xxfxxoxxxoxxxxoxixxxxxi3gixxxoxxxxoiiixix",
                "fffxxoxxxoxxxxoxixiixiiiixiioxxxxoixixix",
                "xxxxxxxxxoxxxxoxixixxxxixxxxoxxxxoixxxxx",
                "xxxxxGxxxoxxxx1rdxixix3eixxxxixoffxxxiiiixi",
                "xxxxxxxxxoxxxxoxxxixxxxxixixo2rfxxxxxxxxx"
            };
        }
        if (level == 2)
        {
            generateMaze = true;
            levelmap = new String[]
            {
                "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                "ooooiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiioooo",
                "xxxoiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiioxxx",
                "xxxoiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiioxxx",
                "xSxxxiiiiiiiiiiiiiiiiiiiiiiiiiiiiiixxxFx",
                "xSxoiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiioxFx",
                "xxxoiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiioxxx",
                "xxxoiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiioxxx",
                "ooooiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiioooo",
                "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
            };
        }
        setShadow();
        removeObject(light);
        removeObject(glow);
        removeObject(player);
        light = new Light();
        addLight(110,300);
        populateWithCheckpoints(levelmap);
        player = new Player();
        setPlayer(110,300);
        player.xspawn = 110;
        player.yspawn = 300;
        addObject(new Finish(),880,300);
        populateWithEnemies(levelmap);
        populateWithCubes(levelmap);
        if (generateMaze == true)
        {
            addObject(new MazeMarker(),190,290);
            MazeGenerator mazeGenerator = new MazeGenerator(190,290);
            addObject(mazeGenerator,230,290);
            mazeGenerator.generateMaze();
        }
        glow = new Glow();
        addGlow(110,300);
        addObject(new SpaceBorder(),500,300);
        setBorder();
        addObject(new CheckpointFlag(),500,300);
        resetImage = new ResetImage();
        addObject(resetImage,500,300);
        finishImage = new FinishImage();
        addObject(finishImage,500,300);
        youWin = new YouWin();
        addObject(youWin,500,420);
        spaceCube = new SpaceCube();
        addObject(spaceCube,500,800);
        act();
    }
    public void addLight(int x, int y)
    {
        addObject(light, x, y);
    }
    public Light getLight()
    {
        return light;
    }
    public void addGlow(int x, int y)
    {
        addObject(glow, x, y);
    }
    public Glow getGlow()
    {
        return glow;
    }
    public Player getPlayer()
    {
        return player;
    }
    public ResetImage getResetImage()
    {
        return resetImage;
    }
    public FinishImage getFinishImage()
    {
        return finishImage;
    }
    public YouWin getYouWin()
    {
        return youWin;
    }
    public SpaceCube getSpaceCube()
    {
        return spaceCube;
    }
    /*
    public ArrayList<Cube> getCubeList()
    {
        return this.cubeList;
    }
    */
    /*
    public ArrayList<CubeFade> getCubeFadeList()
    {
        return this.cubeFadeList;
    }
    */
    public void setBorder()
    {
        CubeBorder cubeBorder = new CubeBorder(840,20);
        addObject(cubeBorder, 500, 90);
        cubeBorder.setLines();
        cubeBorder = new CubeBorder(840,20);
        addObject(cubeBorder, 500, 510);
        cubeBorder.setLines();
        cubeBorder = new CubeBorder(20,420);
        addObject(cubeBorder, 90, 300);
        cubeBorder.setLines();
        cubeBorder = new CubeBorder(20,420);
        addObject(cubeBorder, 910, 300);
        cubeBorder.setLines();
    }
    public void setShadow()
    {
        addObject(new CubeShadow(800,400), 500, 300);
    }
    public void populateWithCheckpoints(String[] level)
    {
        int x = 890;
        int y = 110;
        for (String line : level)
        {
            int index = line.length();
            while (index > 0)
            {
                if (line.charAt(index-1) == 'g')
                {
                    index--;
                }
                if (line.charAt(index-1) == 'r')
                {
                    index--;
                }
                if (line.charAt(index-1) == 'd')
                {
                    index-=2;
                }
                if (line.charAt(index-1) == 'e')
                {
                    index--;
                }
                if (line.charAt(index-1) == 'c')
                {
                    addObject(new Checkpoint(line.charAt(index-2)), x-4, y+4);
                    index--;
                }
                x -= 20;
                index--;
            }
            x = 890;
            y += 20;
        }
    }
    public void setPlayer(int x, int y)
    {
        addObject(player, x, y);
    }
    public void populateWithEnemies(String[] level)
    {
        int x = 890;
        int y = 110;
        for (String line : level)
        {
            int index = line.length();
            while (index > 0)
            {
                if (line.charAt(index-1) == 'g')
                {
                    index--;
                }
                if (line.charAt(index-1) == 'r')
                {
                    index--;
                }
                if (line.charAt(index-1) == 'd')
                {
                    index-=2;
                }
                if (line.charAt(index-1) == 'c')
                {
                    index--;
                }
                if (line.charAt(index-1) == 'e')
                {
                    addObject(new Enemy(line.charAt(index-2)), x-4, y+4);
                    index--;
                }
                x -= 20;
                index--;
            }
            x = 890;
            y += 20;
        }
    }
    public void populateWithCubes(String[] level)
    {
        int x = 890;
        int y = 110;
        for (String line : level)
        {
            int index = line.length();
            while (index > 0)
            {
                if (line.charAt(index-1) == 'o')
                {
                    Cube cube = new Cube();
                    addObject(cube, x-4, y+4);
                    cube.setLines();
                    addObject(new Cube3d(), x-2, y+2);
                }
                if (line.charAt(index-1) == 'i')
                {
                    CubeInvisible cubeInvisible = new CubeInvisible();
                    addObject(cubeInvisible, x-4, y+4);
                    cubeInvisible.setLines();
                }
                if (line.charAt(index-1) == 'f')
                {
                    CubeFade cubeFade = new CubeFade();
                    addObject(cubeFade, x-4, y+4);
                    cubeFade.setPoints();
                    addObject(new CubeFade3d(), x-2, y+2);
                }
                if (line.charAt(index-1) == 'W')
                {
                    addObject(new CubeTWhite(), x-4, y+4);
                    addObject(new CubeTWhite3d(), x-2, y+2);
                }
                if (line.charAt(index-1) == 'R')
                {
                    CubeTRed cubeTRed = new CubeTRed();
                    addObject(cubeTRed, x-4, y+4);
                    cubeTRed.setLines();
                    addObject(new CubeTRed3d(), x-2, y+2);
                }
                if (line.charAt(index-1) == 'G')
                {
                    CubeTGreen cubeTGreen = new CubeTGreen();
                    addObject(cubeTGreen, x-4, y+4);
                    cubeTGreen.setLines();
                    addObject(new CubeTGreen3d(), x-2, y+2);
                }
                if (line.charAt(index-1) == 'g')
                {
                    SwitchGreen switchGreen = new SwitchGreen(line.charAt(index-2));
                    addObject(switchGreen, x-4, y+4);
                    switchGreen.setPoints();
                    index--;
                }
                if (line.charAt(index-1) == 'r')
                {
                    SwitchRed switchRed = new SwitchRed(line.charAt(index-2));
                    addObject(switchRed, x-4, y+4);
                    switchRed.setPoints();
                    index--;
                }
                if (line.charAt(index-1) == 'd')
                {
                    CubeDoor cubeDoor = new CubeDoor(line.charAt(index-3),line.charAt(index-2));
                    addObject(cubeDoor, x-4, y+4);
                    cubeDoor.setPoints();
                    addObject(new CubeDoor3d(line.charAt(index-3),line.charAt(index-2)), x-2, y+2);
                    index-=2;
                }
                if (line.charAt(index-1) == 'e')
                {
                    index--;
                }
                if (line.charAt(index-1) == 'c')
                {
                    index--;
                }
                
                x -= 20;
                index--;
            }
            x = 890;
            y += 20;
        }
    }
    public void act()
    {
        List Players = getObjects(Player.class);
        if(Players.size() == 0)
        {
            //Greenfoot.playSound("fanfare.wav");
            Greenfoot.stop();
        }
    }
}