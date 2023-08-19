import java.util.*;

public class Location extends Grid{
    //Marks hit ships.
    ArrayList<String> location = new ArrayList<String>();

    public Location()
    {
    }

    public ArrayList<String> shipLocation(String[][] grid, boolean word)
    {
        for(int row = 0; row < r; row++)
        {
            for(int col = 0; col < c; col++)
            {
                if(grid[row][col].equals(" X ") && word == true)
                {
                    location.add((char)(row + 64) + "" + col);
                }
            }
        }
        return location;
    }

    public void guessLoc(Location loca, String[][] grid, String loc, Ship boat, Grid frame, ArrayList<Ship> guess, ArrayList<Ship> miss)
    {
        boolean hit = false;
        for(int g = 0; g < loca.shipLocation(grid, false).size(); g++)
        {
            if(loca.shipLocation(grid, false).get(g).equals(loc))
            {
                guess.add(boat);
                grid = frame.setShip(grid, guess, miss);
                System.out.println("\nHIT ON: " + loc + "!!!\n");
                hit = true;
                loca.shipLocation(grid, false).remove(loc);
                break;
            }
        }
        if(hit == false)
        {
            System.out.println("MISS: " + loc + "\n");
            miss.add(boat);
            grid = frame.setShip(grid, guess, miss);
        }
    }

    public static void findWin(int uShips, int cShips)
    {
        if(uShips == 0)
        {
            System.out.println("Computer WINS!");
        }
        if(cShips == 0)
        {
            System.out.println("User WINS!");
        }
    }
}
