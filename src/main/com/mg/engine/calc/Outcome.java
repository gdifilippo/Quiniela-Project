package com.mg.engine.calc;

import java.util.List;

/**
 * List of competitors which will be compared against one another for scoring.
 *
 * @param <C> the type of competitor we are dealing with.
 */
public class Outcome<C extends Competitor>
{
	private final List<C> competitorList;

	public Outcome(List<C> competitorList)
	{
		this.competitorList = competitorList;
	}

	public List<C> getCompetitorList()
	{
		return competitorList;
	}
}
