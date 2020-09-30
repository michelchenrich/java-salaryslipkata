package hm.kata.uk.payroll.legaldeduction.tax;

import static hm.kata.uk.payroll.legaldeduction.tax.ThresholdsAndRates.HIGH_RATE;
import static hm.kata.uk.payroll.legaldeduction.tax.ThresholdsAndRates.MAXIMUM_TAX_FREE_ALLOWANCE_ELIGIBLE_GROSS;

import hm.kata.uk.payroll.PayrollCalculation;
import hm.kata.uk.payroll.Result;

class ReclaimedTaxFreeAllowanceCalculation implements PayrollCalculation {
  @Override
  public Result applyTo(Result result) {
    var earningsPastTaxFreeAllowanceEligibility =
        result.getGross().minus(MAXIMUM_TAX_FREE_ALLOWANCE_ELIGIBLE_GROSS);
    var reclaimedTaxFreeAllowance =
        earningsPastTaxFreeAllowanceEligibility.divideBy(2).limitedTo(result.getTaxFreeAllowance());
    return result
        .minusTaxFreeAllowance(reclaimedTaxFreeAllowance)
        .plusTaxableGross(reclaimedTaxFreeAllowance)
        .plusTaxDeduction(reclaimedTaxFreeAllowance.multiplyBy(HIGH_RATE));
  }
}
