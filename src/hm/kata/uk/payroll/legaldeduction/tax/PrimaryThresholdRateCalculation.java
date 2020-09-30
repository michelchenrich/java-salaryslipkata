package hm.kata.uk.payroll.legaldeduction.tax;

import static hm.kata.uk.payroll.legaldeduction.tax.ThresholdsAndRates.MAXIMUM_TAX_FREE_ALLOWANCE;
import static hm.kata.uk.payroll.legaldeduction.tax.ThresholdsAndRates.PRIMARY_THRESHOLD;

import hm.kata.uk.payroll.PayrollCalculation;
import hm.kata.uk.payroll.Result;

class PrimaryThresholdRateCalculation implements PayrollCalculation {
  @Override
  public Result applyTo(Result result) {
    var primaryThresholdEarnings =
        result.getGross().limitedTo(PRIMARY_THRESHOLD).minus(MAXIMUM_TAX_FREE_ALLOWANCE);
    return result
        .withTaxableGross(primaryThresholdEarnings)
        .withTaxDeduction(primaryThresholdEarnings.multiplyBy(ThresholdsAndRates.LOW_RATE));
  }
}
