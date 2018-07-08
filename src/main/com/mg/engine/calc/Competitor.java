package com.mg.engine.calc;

/**
 * Parent class for the competitor of different sports.
 */
public class Competitor
{
	private final String name;
	private final Double score;

	public Competitor(String name, Double score)
	{
		this.name = name;
		this.score = score;
	}

	public String getName()
	{
		return name;
	}

	public Double getScore()
	{
		return score;
	}

	@Override
	public String toString()
	{
		return "Competitor: " +
				"name=" + name + ", " +
				"score=" + score + ".";
	}
}
