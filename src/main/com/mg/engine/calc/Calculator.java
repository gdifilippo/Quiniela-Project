package com.mg.engine.calc;

import com.mg.sport.Sport;

import java.util.Optional;
import java.util.function.BiFunction;

/**
 * A calculator designated for a sport.
 * Once created, it takes two Outcomes (predicted and actual) and computes the points
 * that the predicted receives.
 *
 * @param <C> the type of competitor we are dealing with.
 */
public class Calculator<C extends Competitor>
{
	private final Sport<C> sport;

	public Calculator(Sport<C> sport)
	{
		this.sport = sport;
	}

	public int computeScore(Outcome<C> predicted, Outcome<C> actual)
	{
		int total = 0;

		for(BiFunction<Outcome<C>, Outcome<C>, Optional<Integer>> func : sport.getPotentialPoints())
		{
			Optional<Integer> optScore = func.apply(predicted, actual);

			//Check if we get back a score at all (save a tiny bit of computation)
			if(!optScore.isPresent())
			{
				continue;
			}

			//retrieve score.
			int score = optScore.get();

			if(sport.isStackPoints())
			{
				//if the sport allows stacking, add them
				total += score;
			}
			else
			{
				//if not, select whichever score gives the most points
				total = score > total ? score : total;
			}

		}

		return total;
	}


}
