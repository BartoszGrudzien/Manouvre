/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manouvre.state;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import manouvre.game.Card;
import manouvre.game.Game;
import manouvre.game.Position;
import manouvre.game.Unit;
import manouvre.game.commands.CommandQueue;
import manouvre.game.commands.MoveUnitCommand;
import manouvre.gui.CustomDialog;
import manouvre.gui.GameWindow;

/**
 *
 * @author xeon
 */
public class MapCardUnitMoveState implements MapState{

    @Override
    public void handleInput(Position pos, Game game, CommandQueue cmdQueue , MapInputStateHandler handler) {
       
                Card playingCard = game.getCardCommandFactory().getPlayingCard();
                Unit selectedUnit = game.getSelectedUnit();
                
                if(getMovePositions(playingCard, game).contains(pos))
                {
                    MoveUnitCommand moveUnit = new MoveUnitCommand(game.getCurrentPlayer().getName() , selectedUnit,  pos);
                    /*
                    We attach move command to wrap it to postpone execution in card command
                    */
                    game.getCardCommandFactory().setAttachedCommand(moveUnit);
                    /*
                    Confirmation dialog
                    */
                    showConfirmationCardDialog(cmdQueue, game);
                    
                    handler.setState(MapInputStateHandler.NOSELECTION);
                }
                /*
                Deselect card and clear Card Factory
                */
                else {
                    game.getCardCommandFactory().resetPlayingCard();
                    handler.setState(MapInputStateHandler.NOSELECTION);

                }
                



    
    }
private ArrayList<Position> getPossibleUnitPostionToSelect(Game game){
    
     if(game.getCurrentPlayer().isPlayingCard())
        {
            Card playingCard = game.getCardCommandFactory().getPlayingCard();
            
            
            switch(playingCard.getCardType()){
                case Card.HQCARD:
                {
                if(playingCard.getHQType() == Card.SUPPLY)
                {
                   if(game.getPhase() == Game.MOVE)
                       return game.getCurrentPlayerNotMovedUnits();
                   
                   if(game.getPhase() == Game.RESTORATION)
                     return game.getCurrentPlayerInjuredUnitPositions();
                           
                }
                break;
                }
                case Card.UNIT:
                {
                    if(game.getPhase() == Game.RESTORATION)
                    {
                       ArrayList<Position>  positions = new ArrayList<>();
                       positions.add(game.getCurrentPlayerUnitByName(playingCard.getCardName()).getPosition());
                       return positions;
                    }  
                break;
                }    
                
                case Card.HQLEADER:
                {
                    if(game.getPhase() == Game.RESTORATION)
                     return game.getCurrentPlayerInjuredUnitPositions();
                break;        
                }    
                
                    
                
            }
                
        }
    return null;
    
    
    
    }
private void showConfirmationCardDialog(CommandQueue cmdQueue, Game game){
    /*
        Confirmation dialog
        */
       // game.lockGUI();
        CustomDialog dialog = 
                new CustomDialog(CustomDialog.YES_NO_TYPE, 
                        "Are You sure to play that card? " ,
                        cmdQueue, game);
        try {
            dialog.setOkCommand(game.getCardCommandFactory().createCardCommand());
            dialog.setCancelCommand(game.getCardCommandFactory().resetFactoryCommand());
            
            //dialog.setCancelCommand(moveUnit);
        } catch (Exception ex) {
            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        dialog.setVisible(true);
        
    }
private ArrayList<Position> getMovePositions(Card playingCard, Game game){
     
            ArrayList<Position> movePositions = new ArrayList<>();
            if(game.getSelectedUnit()!= null)
                {   
                    Unit selectedUnit = game.getSelectedUnit();
                    switch(playingCard.getCardType()){
                        
                        case Card.HQCARD :
                        {
                            switch(playingCard.getHQType()){
                           
                                case Card.FORCED_MARCH:
                                {
                                   movePositions = game.getOneSquareMovements(selectedUnit.getPosition()); 
                                   break;
                                }
                                case Card.SUPPLY:
                                {
                                   movePositions = game.getPossibleMovement(selectedUnit); 
                                   break;
                                }
                                
                                case Card.WITHDRAW:
                                {
                                   movePositions = game.getRetreatPositions(selectedUnit); 
                                   break;
                                }
                                
                            }
                            break;
                        }
     
                    }
                }
    return movePositions;
}
}