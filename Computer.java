import java.util.*;
import java.lang.Math;

public class Computer{
    
    Scanner obj = new Scanner(System.in);
    static String[] direction = {"V", "H"};
    static boolean statement = true;
    static char row;
    static int col;
    static ArrayList<String> guessloc = new ArrayList<String>();
    

    public static String getCLoc(String dir, int lth)
    {
        row = (char)((int)(Math.random()*10) + 65);
        col = ((int)(Math.random()*10) + 1);
        if(dir.equals("V"))
        {
            //Ship cannot pass column 10.
            while(((int)row - 64) > (11 - lth))
            {
                row = (char)((int)(Math.random()*10) + 65);
            }
        }
        if(dir.equals("H"))
        {
            //Ship cannot pass row J.
            while(col > (11 - lth))
            {
                col = ((int)(Math.random()*10) + 1);
            }
        }
        return row + "" + col;
    }

    public static String getCDir()
    {
        return direction[(int)(Math.random()*2)];
    }

    public static String compTurn()
    { 
        row = (char)((int)(Math.random()*10) + 65);
        col = ((int)(Math.random()*10) + 1);
        String loc = row + "" + col;
        //Computer allowed to choose any grid with - , then location is added to a list.
        //Any locations on the list cannot be chosen again from randomized list.
        for(String location: guessloc)
        {
            if(loc.equals(location))
            {
                while(loc.equals(location))
                {
                    row = (char)((int)(Math.random()*10) + 65);
                    col = ((int)(Math.random()*10) + 1);
                    loc = row + "" + col;
                }
            }
        }
        guessloc.add(loc);
        //Ship user = new Ship(loc, 1, "H");
        //uloc.userGuessLoc(cloc, compGrid, loc, user, cframe, Ship.userGuess);
        return loc;
    }
}
