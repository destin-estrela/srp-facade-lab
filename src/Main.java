import srpfacadelab.IGameEngine;
import srpfacadelab.Player;
import srpfacadelab.RpgFacade;
import srpfacadelab.SimpleGameEngine;

public class Main {

    public static void main(String[] args) {
        //This is meant to be simple and just show how you could instantiate the structure

        IGameEngine game = new SimpleGameEngine();
        RpgFacade facade = new RpgFacade(game);
        
        Player player1 = new Player(game);
        Player player2 = new Player(game);
        ((SimpleGameEngine) game).addPlayer(player1);
        ((SimpleGameEngine) game).addPlayer(player2);

        facade.takeDamage(22, player1);
        //Here you would create items

        //Here you would tell the history and make the game happen

        //You could make players pick up items
        //You could make players use items
        //etc.
        //You don't need to worry about it for the assignment
        //This is only to show how the 'external world' would instantiate the structure.
        //In the assignment, you're supposed to improve the design and not instantiate a game
    }
}
