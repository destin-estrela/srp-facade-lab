package srpfacadelab;

import java.util.List;
import java.util.ArrayList;


public class Player {
    public static final int MAX_CARRYING_CAPACITY = 1000;

    private final IGameEngine gameEngine;

    private int health;

    private int maxHealth;

    private int armour;

    private List<Item> inventory;

    // How much the player can carry in pounds
    private int carryingCapacity;

    public Player(IGameEngine gameEngine) {
      this.gameEngine = gameEngine;
      inventory = new ArrayList<Item>();
      carryingCapacity = MAX_CARRYING_CAPACITY;
  }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getArmour() {
        return armour;
    }

    public void increaseArmour(int armour) {
        this.armour += armour;
    }

    public void setArmor(int armour)
    {
       this.armour = armour; 
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public void addToInventory(Item item)
    {
         inventory.add(item);
    }

    public List<Item> getInventory()
    {
       return inventory; 
    }
}
