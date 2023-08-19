import java.util.*;

public class Grid
{
    public static final int r = 11;
    public static final int c = 12;

    String[][] grid = new String[r][c];

    //Initializes grids.
    public String[][] setGrid()
    {
        for(int row = 0; row < r; row++)
        {
            for(int col = 0; col < c; col++)
            {
                // Numbers every column from 1 to 10.
                if(col > 0 && row == 0)
                {
                    grid[row][col] = " " + col + " ";
                    if(col == 11)
                    {
                        grid[row][col] = "\n";
                    }
                }
                // Numbers every row from 1 to 10.
                else if(row > 0 && col == 0)
                {
                    grid[row][col] = "" + (char)(row + 64);
                }
                else if(col == 11)
                {
                    grid[row][col] = "\n";
                }
                else if(row != 0 && col != 0)
                {
                    grid[row][col] = " - ";
                }
                else
                {
                    grid[row][col] = "  ";
                }
            }
        }
        return grid;
    }
    
    public String getStringGrid(String[][] grid)
    {
        String gridNew = Arrays.deepToString(grid);
        gridNew = gridNew.replaceAll("[\\[,\\]]", "");
        return gridNew;
    }
    
    public String[][] setShip(String[][] grid, ArrayList<Ship> ship, ArrayList<Ship> miss)
    {
        for(int row = 0; row < r; row++)
        {
            for(int col = 0; col < c; col++)
            {
                try
                {
                    for(Ship boat: ship)
                    {
                        if(row == boat.getRow() && col == boat.getCol())
                        {
                            for(int i = 0; i < boat.getLth(); i++)
                            {
                                if(boat.getDir().equals("H"))
                                {
                                    //Horizontal.
                                    grid[row][col + i] = " X ";
                                }
                                if(boat.getDir().equals("V"))
                                {
                                    //Vertical.
                                    grid[row + i][col] = " X ";
                                }
                            }
                        }
                    }
                    for(Ship fail: miss)
                    {
                        if(row == fail.getRow() && col == fail.getCol())
                        {
                            grid[row][col] = " O ";
                        }
                    }
                }
                catch(Exception e)
                {
                }
            }
        }
        return grid;
    }

    public String[][] finalGrid(Grid frame, String loc, int lth, String dir, ArrayList<Ship> ship, String[][] grid, ArrayList<Ship> miss)
    {
        Ship user = new Ship(loc, lth, dir);
        ship.add(user);
        grid = frame.setShip(grid, ship, miss);
        return grid;
    }
}