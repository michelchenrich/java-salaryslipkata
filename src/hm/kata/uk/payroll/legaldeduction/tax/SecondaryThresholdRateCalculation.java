package hm.kata.uk.payroll.legaldeduction.tax;

import static hm.kata.uk.payroll.legaldeduction.tax.ThresholdsAndRates.HIGH_RATE;
import static hm.kata.uk.payroll.legaldeduction.tax.ThresholdsAndRates.PRIMARY_THRESHOLD;
import static hm.kata.uk.payroll.legaldeduction.tax.ThresholdsAndRates.SECONDARY_THRESHOLD;

import hm.kata.uk.payroll.PayrollCalculation;
import hm.kata.uk.payroll.Result;

class SecondaryThresholdRateCalculation implements PayrollCalculation {
  @Override
  public Result applyTo(Result result) {
    var secondaryThresholdEarnings =
        result.getGross().limitedTo(SECONDARY_THRESHOLD).minus(PRIMARY_THRESHOLD);
    return result
        .plusTaxableGross(secondaryThresholdEarnings)
        .plusTaxDeduction(secondaryThresholdEarnings.multiplyBy(HIGH_RATE));
  }
}
