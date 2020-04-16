package srpfacadelab;

public class DamageCalculator
{

   private IGameEngine gameEngine;

   public DamageCalculator(IGameEngine gameEngine)
   {
      this.gameEngine = gameEngine; 
   }

   public int calculateDamage(int damage, int armour, double damageModifier) {
         if (damage < armour) {
               gameEngine.playSpecialEffect("parry");
         }


         return damage - armour;
         

    }
}