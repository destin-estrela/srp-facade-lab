package srpfacadelab;

public class RpgFacade {
    public static final int MAX_CARRYING_CAPACITY = 1000;

    private final IGameEngine gameEngine;
    private ItemManager itemManager;
    private DamageCalculator damageCalculator; 

    public RpgFacade(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
         itemManager = new ItemManager(gameEngine); 
         damageCalculator = new DamageCalculator(gameEngine);
    }

    public void useItem(Item item, Player player) {
      itemManager.useItem(item, player);
    }

    public boolean pickUpItem(Item item, Player player) {
      return itemManager.pickUpItem(item, player);
    }

    public void takeDamage(int damage, Player player) {
      double damageModifier = 
      itemManager.calculateInventoryWeight(player) / (double)MAX_CARRYING_CAPACITY < .5 ? .75 : 1; 

      player.setHealth(player.getHealth() - damageCalculator.calculateDamage(damage, player.getArmour(), damageModifier));

      gameEngine.playSpecialEffect("lots_of_gore");

    }

}
