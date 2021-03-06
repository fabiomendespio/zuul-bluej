import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room {
    private String description;
    private HashMap<String, Room> exits;
    private Item item;
    private ArrayList<Item> itens = new ArrayList<>();

    private HashMap<String, Direction> validDirection;

    public String getListNameItens() {
        String result = "";

        if (itens.isEmpty()) {
            return "sem itens aqui";
        }
        for (Item itemRoom : itens) {
            result += "[" + itemRoom.getItemName() + "] ";
        }

        return result;
    }

    public String getListDescriptionItens() {
        String result = "";

        if (itens.isEmpty()) {
            return "sem itens aqui";
        }
        for (Item itemRoom : itens) {
            result += itemRoom.getItemDescription();
        }

        return result;
    }

    public void addItens(Item item) {
        if (item != null)
            itens.add(item);
    }

    public ArrayList<Item> getItemList() {
        return itens;
    }

    public Item getItem(int i) {
        return itens.get(i);
    }

    public void removeItemList(int i) {
        itens.remove(i);
    }

//    public Room(){
//        validDirection.put("norte", Direction.NORTH);
//        validDirection.put("leste", Direction.EAST);
//        validDirection.put("sul", Direction.SOUTH);
//        validDirection.put("oeste", Direction.WEST);
//    }

    /**
     * Create a room described "description "Initially, it
     * has no exits. "description" is something like "a
     * kitchen" or "an open courtyard".
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor The room in the given direction.
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * Return the room that is reached if we go from this
     * room in direction "direction "If there is no room in
     * that direction, return null.
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    /**
     * Return the description of the room (the one that was
     * defined in the constructor).
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Return a description of the room’s exits,
     * for example, "Exits: north west".
     * @return A description of the available exits.
     */
    public String getExitString() {
        String returnString = "Saídas:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += "[" + exit + "] ";
        }
        return returnString;
    }

    /**
     * Return a long description of this room, of the form:
     * You are in the kitchen.
     * Exits: north west
     * @return A description of the room, including exits.
     */
    public String getLongDescription() {

        return "Você está " + description + "\n" + getExitString() + "\n" + "Itens encontrados: " + getListNameItens();
    }
}
