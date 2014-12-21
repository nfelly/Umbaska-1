/*
 * ExprRDRegistered.class - Made by nfell2009
 * nfell2009.uk (C) nfell2009 2014
 * Code by nfell2009
 * 
*/


package uk.nfell2009.umbaska.Towny;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.TownyUniverse;


public class ExprRDRegistered extends SimpleExpression<Long>{

	private Expression<Player> player;
	
	public Class<? extends Long> getReturnType() {
		
		return Long.class;
	}

	@Override
	public boolean isSingle() {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] args, int arg1, Kleenean arg2, ParseResult arg3) {
		this.player = (Expression<Player>) args[0];
		return true;
	}

	@Override
	public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
		return "return last online time of player";
	}

	@Override
	@javax.annotation.Nullable
	protected Long[] get(Event arg0) {
		String p = this.player.getSingle(arg0).toString();
		Resident r = null;
		try {
			r = TownyUniverse.getDataSource().getResident(p);
		} catch (NotRegisteredException e) {
			e.printStackTrace();
		}
		
		Long out = r.getRegistered();
		
		if (out == null){
			return null;
		}

		return new Long[] { out };
	}

}