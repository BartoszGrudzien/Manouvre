/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manouvre.state;

import manouvre.game.Game;
import manouvre.game.Position;
import manouvre.game.commands.CommandQueue;

/**
 *
 * @author piotr_grudzien
 */
public class MapPickNoneState  implements MapState{

    @Override
    public void handleInput(Position pos, Game game, CommandQueue cmdQueue, MapInputStateHandler handler) {
       
        /*
        Do nothing
        */
    }
    
}
