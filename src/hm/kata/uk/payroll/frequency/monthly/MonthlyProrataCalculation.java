package hm.kata.uk.payroll.frequency.monthly;

import hm.kata.uk.payroll.PayrollCalculation;
import hm.kata.uk.payroll.Result;

public class MonthlyProrataCalculation implements PayrollCalculation {
  @Override
  public Result applyTo(Result result) {
    return result.prorateToOnePartOf(12);
  }
}
