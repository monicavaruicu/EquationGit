package equation;

import java.util.Vector;

import exceptions.*;
import models.*;

public class Equation {
	public Vector<Factor> _factors;
	public Vector<Solution> _solutions;

	public Equation() {
		_factors = new Vector<Factor>();
		_solutions = new Vector<Solution>();
	}

	public Vector<Factor> getFactors() {
		return this._factors;
	}

	public void setFactors(Vector<Factor> value) {
		_factors = value;
	}

	public Vector<Solution> getSolution() {
		return this._solutions;
	}

	public void setSolution(Vector<Solution> value) {
		_solutions = value;
	}

	public void solveEcuation() throws Exception {
		if (this._factors.size() != 3 || this._factors.get(2).value == 0) {
			throw new EquationOfDegree2Exception("The equation is not an equation of degree 2!");
		}

		var delta = calculateDelta();

		if (delta < 0) {
			throw new NonPositiveDeltaException("Delta is non-positive number!");
		}

		if (delta == 0) {
			var aux = new Solution();
			aux.value = (-_factors.get(1).value + Math.sqrt(delta)) / (2 * _factors.get(2).value);
			_solutions.add(aux);
		} else {
			var aux = new Solution();
			aux.value = (-_factors.get(1).value + Math.sqrt(delta)) / (2 * _factors.get(2).value);
			_solutions.add(aux);

			var aux1 = new Solution();
			aux1.value = (-_factors.get(1).value - Math.sqrt(delta)) / (2 * _factors.get(2).value);
			_solutions.add(aux1);
		}
	}

	private Double calculateDelta() {
		var response = _factors.get(1).value * _factors.get(1).value
				- 4 * _factors.get(0).value * _factors.get(2).value;

		return response;
	}
}
