package com.mg.engine.calc;

import com.mg.engine.calc.Competitor;
import com.mg.engine.calc.Outcome;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * List of functions which decide from a predicted and a actual Outcome,
 * what the score given is.
 * Also a boolean to decide if the scores stack or not.
 *
 * @param <C> the type of competitor we are dealing with.
 */
public class Sport<C extends Competitor>
{
	private final List<BiFunction<Outcome<C>, Outcome<C>, Optional<Integer>>> potentialPoints;
	private final boolean stackPoints;

	public Sport(List<BiFunction<Outcome<C>, Outcome<C>, Optional<Integer>>> potentialPoints, boolean stackPoints)
	{
		this.potentialPoints = potentialPoints;
		this.stackPoints = stackPoints;
	}

	public List<BiFunction<Outcome<C>, Outcome<C>, Optional<Integer>>> getPotentialPoints()
	{
		return potentialPoints;
	}

	public boolean isStackPoints()
	{
		return stackPoints;
	}
}
