//import java.util.Iterator;
//import java.util.Arrays;
import java.util.ArrayList;

public class Ship
{
    public int ro;
    public int co;
    public int lth;
    public String dir;
    public static final int x = 11;
    public static final int y = 11;

    public static Integer[] lengths = {2, 3, 3, 4, 5};

    //ArrayList of user ships.
    public static ArrayList<Ship> userShip = new ArrayList<Ship>();
    //ArrayList of computer ships.
    public static ArrayList<Ship> compShip = new ArrayList<Ship>();

    //ArrayList of user guesses.
    public static ArrayList<Ship> userGuess = new ArrayList<Ship>();
    //ArrayList of computer guesses.
    public static ArrayList<Ship> compGuess = new ArrayList<Ship>();

    //ArrayList of user misses.
    public static ArrayList<Ship> userMiss = new ArrayList<Ship>();
    //ArrayList of computer misses.
    public static ArrayList<Ship> compMiss = new ArrayList<Ship>();
    
    public Ship(String loc, int lth, String dir)
    {
        this.ro = (int)loc.charAt(0) - 64;
        if(loc.length() == 3)
        {
            this.co = 10;
        }
        else
        {
            this.co = loc.charAt(1) - 48;
        }
        this.lth = lth;
        this.dir = dir;
    }

    public int getRow()
    {
        return ro;
    }

    public int getCol()
    {
        return co;
    }

    public int getLth()
    {
        return lth;
    }

    public String getDir()
    {
        return dir;
    }

    public String toString()
    {
        return "Row: " + getRow() + " Col: " + getCol() + " for Lth: " + getLth() + " and Dir: " + getDir();
    }
}