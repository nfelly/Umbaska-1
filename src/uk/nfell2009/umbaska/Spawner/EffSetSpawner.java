/*
 * EffSetSpawner.class - Made by nfell2009
 * nfell2009.uk (C) nfell2009 2014
 * Code by nfell2009
 * 
*/

package uk.nfell2009.umbaska.Spawner;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

import org.bukkit.Location;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.Event;
 
public class EffSetSpawner extends Effect {
 
  private Expression<Location> location;
  private Expression<String> entity;
 
  @Override
  protected void execute(Event event){
	  		Location l = location.getSingle(event);
	  		String e = entity.getSingle(event);
	  		if (l == null) {
	  			return;
	  		} else if (e == null) {
	  			return;
	  		}
	  		CreatureSpawner cs = (CreatureSpawner) l.getBlock().getState();
	  		cs.setCreatureTypeByName(e);
	  		cs.update();
	  		
        }
  
 
  @Override
  public String toString(Event event, boolean b){
    return "Set a spawner";
  }
 
  @Override
  @SuppressWarnings("unchecked")
  public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
	  	location = (Expression<Location>) expressions[0];
	  	entity = (Expression<String>) expressions[1];
        return true;
  }
}