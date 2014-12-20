/*
 * ExprPlotAtLoc.class - Made by nfell2009
 * nfell2009.uk (C) nfell2009 2014
 * Code by nfell2009
 * 
*/

package uk.nfell2009.umbaska.PlotMe;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

import org.bukkit.Location;
import org.bukkit.event.Event;

import com.worldcretornica.plotme.PlotManager;



public class ExprPlotAtLoc extends SimpleExpression<String>{

	private Expression<Location> location;
	
	public Class<? extends String> getReturnType() {
		
		return String.class;
	}

	@Override
	public boolean isSingle() {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] args, int arg1, Kleenean arg2, ParseResult arg3) {
		this.location = (Expression<Location>) args[0];
		return true;
	}

	@Override
	public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
		return "return plot id at location";
	}

	@Override
	@javax.annotation.Nullable
	protected String[] get(Event arg0) {

		Location location = this.location.getSingle(arg0);
		
		if (location == null){
			return null;
		}
		String plot = PlotManager.getPlotId(location);
		
		return new String[] { plot };
	}

}