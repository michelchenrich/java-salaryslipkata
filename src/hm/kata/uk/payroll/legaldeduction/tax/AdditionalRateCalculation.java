package hm.kata.uk.payroll.legaldeduction.tax;

import static hm.kata.uk.payroll.legaldeduction.tax.ThresholdsAndRates.ADDITIONAL_RATE;
import static hm.kata.uk.payroll.legaldeduction.tax.ThresholdsAndRates.SECONDARY_THRESHOLD;

import hm.kata.uk.payroll.PayrollCalculation;
import hm.kata.uk.payroll.Result;

public class AdditionalRateCalculation implements PayrollCalculation {
  @Override
  public Result applyTo(Result result) {
    var earningsWithAdditionalRate = result.getGross().minus(SECONDARY_THRESHOLD);
    return result
        .plusTaxableGross(earningsWithAdditionalRate)
        .plusTaxDeduction(earningsWithAdditionalRate.multiplyBy(ADDITIONAL_RATE));
  }
}
