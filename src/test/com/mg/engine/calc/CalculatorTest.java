package com.mg.engine.calc;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

class CalculatorTest
{
	@Test
	public void simpleCalcTest()
	{
		//Creates list of predicted competitor/score
		Competitor[] predictedArray = {new Competitor("comp1", 1.0),
				new Competitor("comp2", 2.0)};
		List<Competitor> predicted = Arrays.asList(predictedArray);

		//Creates list of actual competitor/score
		Competitor[] actualArray = {new Competitor("comp1", 1.0),
				new Competitor("comp2", 2.0)};
		List<Competitor> actual = Arrays.asList(actualArray);

		//Creates outcome objects based on lists
		Outcome<Competitor> predictedOutcome = new Outcome<>(predicted);
		Outcome<Competitor> actualOutcome = new Outcome<>(actual);

		//creates list of functions to create potential points
		List<BiFunction<Outcome<Competitor>, Outcome<Competitor>, Optional<Integer>>> biFuncArray = Arrays
				.asList(this::guessWinner);

		//creates sport from that list
		Sport<Competitor> sport = new Sport<>(biFuncArray, true);

		//creates calc from that sport
		Calculator<Competitor> calc = new Calculator<>(sport);

		//tries to compute score based on outcomes. Resulting points must be equal to 1
		Assert.assertEquals(1, calc.computeScore(predictedOutcome, actualOutcome));
	}

	private Optional<Integer> guessWinner(Outcome<Competitor> p, Outcome<Competitor> a)
	{
		//for both of these, sorts the competitors by score (reverse order so more points = first) and gets the name of the top competitor
		Optional<String> predWinner = p.getCompetitorList().stream()
				.sorted(Comparator.comparingDouble(Competitor::getScore).reversed()).map(Competitor::getName)
				.findFirst();
		Optional<String> actWinner = a.getCompetitorList().stream()
				.sorted(Comparator.comparingDouble(Competitor::getScore).reversed()).map(Competitor::getName)
				.findFirst();

		//if there is missing data it should fail
		if(!predWinner.isPresent() || !actWinner.isPresent())
		{
			Assert.fail("Missing data");
		}

		//if the names are the same, then the resulting score is 1.
		return actWinner.get().equals(predWinner.get()) ? Optional.of(1) : Optional.empty();
	}
}