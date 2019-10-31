package UnitTesting.UnitTesting;

import java.util.Iterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

@SuppressWarnings("rawtypes")
public class SolutionIterator implements Iterator {
	SolutionList solutionlist;

	/// CurrentSolutionNumber: point to the location before the first element
	int currentSolutionNumber = -1;

	public SolutionIterator() {
	}

	public SolutionIterator(SolutionList thesolutionlist) {
		solutionlist = thesolutionlist;
		MoveToHead();
	}

	public void MoveToHead() {
		/// currentSolutionNumber: point to the location before the first element
		currentSolutionNumber = -1;
	}

	public boolean hasNext() {
		/** @todo: Implement this java.util.Iterator method */
		if (currentSolutionNumber >= solutionlist.size() - 1)
			return false;
		else
			return true;
	}

	public Object next() {
		/** @todo: Implement this java.util.Iterator method */
		if (hasNext() == true) {
			currentSolutionNumber++;
			return solutionlist.get(currentSolutionNumber);
		} else {
			return null;
		}

	}

	/// get the next Solution that fits the Username;
	public Object next(String UserName) {
		Solution theSolution;
		theSolution = (Solution) next();
		while (theSolution != null) {
			if (UserName.compareTo(theSolution.theAuthor) == 0) {
				return theSolution;
			}
			theSolution = (Solution) next();
		}
		return null;
	}

	public void remove() {
		solutionlist.remove(currentSolutionNumber);
	}

}