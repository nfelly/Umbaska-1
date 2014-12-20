/*
 * ExprTDTaxes.class - Made by nfell2009
 * nfell2009.uk (C) nfell2009 2014
 * Code by nfell2009
 * 
*/


package uk.nfell2009.umbaska.Towny;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

import org.bukkit.event.Event;

import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownyUniverse;


public class ExprTDTaxes extends SimpleExpression<Double>{

	private Expression<String> town;
	
	public Class<? extends Double> getReturnType() {
		
		return Double.class;
	}

	@Override
	public boolean isSingle() {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] args, int arg1, Kleenean arg2, ParseResult arg3) {
		this.town = (Expression<String>) args[0];
		return true;
	}

	@Override
	public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
		return "return taxes of a town";
	}

	@Override
	@javax.annotation.Nullable
	protected Double[] get(Event arg0) {
		String t = this.town.getSingle(arg0);
		Town tw = null;
		try {
			tw = TownyUniverse.getDataSource().getTown(t);
		} catch (NotRegisteredException e) {
			e.printStackTrace();
		}
		
		if (tw == null){
			return null;
		}

		Double i = tw.getTaxes();
		
		return new Double[] { i };
	}

}
