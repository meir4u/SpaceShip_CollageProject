public interface SpaceShip {
    //return TRUE if launch success or FALSE
    boolean launch();
    //return TRUE if land success or FALSE
    boolean land();
    //return TRUE if ship can carry the item.
    boolean canCarry(Item item);
    //update weight of the ship
    void carry(Item item);
    //return cost data
    int getTotalCost();
}
