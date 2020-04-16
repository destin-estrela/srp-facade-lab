package srpfacadelab;

import java.util.List;

public class ItemManager {

   private final IGameEngine gameEngine;

   public ItemManager(IGameEngine gameEngine)
   {
      this.gameEngine = gameEngine; 
   }
   
   public void useItem(Item item, Player player) {
      if (item.getName().equals("Stink Bomb"))
      {
          List<IEnemy> enemies = gameEngine.getEnemiesNear(player);

          for (IEnemy enemy: enemies){
              enemy.takeDamage(100);
          }
      }
  }

  public boolean pickUpItem(Item item, Player player) {
      int weight = calculateInventoryWeight(player);
      if (weight + item.getWeight() > player.getCarryingCapacity())
          return false;

      if (item.isUnique() && checkIfItemExistsInInventory(item, player))
          return false;

      // Don't pick up items that give health, just consume them.
      if (item.getHeal() > 0) {
          player.setHealth(player.getHealth()+ item.getHeal()); 

          if (player.getHealth() > player.getMaxHealth())
              player.setHealth(player.getMaxHealth());

          if (item.getHeal() > 500) {
              gameEngine.playSpecialEffect("green_swirly");
          }

          return true;
      }

      if (item.isRare())
      {
          gameEngine.playSpecialEffect("cool_swirly_particles");

          if(item.isUnique())
          {
             gameEngine.playSpecialEffect("blue_swirly");
          }
      }
          

      player.addToInventory(item);

      calculateStats(player);

      return true;
  }

  private void calculateStats(Player player) {
   for (Item i: player.getInventory()) {
       player.increaseArmour(i.getArmour()); 
   }
}

public boolean checkIfItemExistsInInventory(Item item, Player player) {
   for (Item i: player.getInventory()) {
       if (i.getId() == item.getId())
           return true;
   }
   return false;
}

int calculateInventoryWeight(Player player) {
   int sum = 0;
   for (Item i: player.getInventory()) {
       sum += i.getWeight();
   }
   return sum;
}
}