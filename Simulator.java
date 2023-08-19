import java.util.*;

public class Simulator
{
    public static void main(String args[])
    {
        boolean word = true;
        //Separate grids for user and computer.
        Grid uframe = new Grid();
        Grid cframe = new Grid();
        String[][] userGrid = uframe.setGrid();
        String[][] compGrid = cframe.setGrid();
        Location uloc = new Location();
        Location cloc = new Location();
        
        Scanner obj = new Scanner(System.in);
        System.out.println("BATTLESHIP.\n");

        for(int i = 0; i < 5; i++)
        {
            String loc = "N";
            String dir = "N";
            while(((int)loc.charAt(0) < 65 || (int)loc.charAt(0) > 74) || loc.length() < 2)
            {   
                System.out.println("Enter ship location of length " + Ship.lengths[i] + " [A-J/1-10]:");
                loc = obj.nextLine();
            }
            while((int)dir.charAt(0) != 72 && (int)dir.charAt(0) != 86)
            {    
                System.out.println("Direction [V/H]: ");
                dir = obj.nextLine();
            }
            
            //Final user grid adds location and direction to Ship class, then adds ship to grid, returning grid.
            userGrid = uframe.finalGrid(uframe, loc, Ship.lengths[i], dir, Ship.userShip, userGrid, Ship.userMiss);
            System.out.println(uframe.getStringGrid(userGrid));
            
            //Computer ship grid.
            dir = Computer.getCDir();
            loc = Computer.getCLoc(dir, Ship.lengths[i]);
            compGrid = cframe.finalGrid(cframe, loc, Ship.lengths[i], dir, Ship.compShip, compGrid, Ship.compMiss);
        }

        ArrayList<String> userloc = uloc.shipLocation(userGrid, word);
        ArrayList<String> comploc = cloc.shipLocation(compGrid, word);

        //Empty grids to print out.
        userGrid = uframe.setGrid();
        compGrid = cframe.setGrid();

        //After grids are initialized, start game, choose location of enemy ships.
        while(uloc.shipLocation(userGrid, false).size() != 0 && cloc.shipLocation(compGrid, false).size() != 0)
        {
            String loc = "N";
            System.out.println("USER'S TURN\n" + cframe.getStringGrid(compGrid));
            while(((int)loc.charAt(0) < 65 || (int)loc.charAt(0) > 74) || loc.length() < 2)
            {
                System.out.println("Enter ship location [A-J/1-10]:");
                loc = obj.nextLine();
            }
            Ship user = new Ship(loc, 1, "H");
            uloc.guessLoc(cloc, compGrid, loc, user, cframe, Ship.userGuess, Ship.userMiss);
            
            //Computer's turn.
            loc = Computer.compTurn();
            System.out.println("COMPUTER'S TURN: " + loc + "\n" + uframe.getStringGrid(userGrid));
            Ship comp = new Ship(loc, 1, "H");
            cloc.guessLoc(uloc, userGrid, loc, comp, uframe, Ship.compGuess, Ship.compMiss);

            Location.findWin(uloc.shipLocation(userGrid, false).size(), cloc.shipLocation(compGrid, false).size());
        }
    }
}