package hm.kata.uk.payroll.legaldeduction.tax;

import static hm.kata.uk.payroll.legaldeduction.tax.ThresholdsAndRates.MAXIMUM_TAX_FREE_ALLOWANCE;

import hm.kata.uk.payroll.PayrollCalculation;
import hm.kata.uk.payroll.Result;

class TaxFreeAllowanceCalculation implements PayrollCalculation {
  @Override
  public Result applyTo(Result result) {
    return result.withTaxFreeAllowance(result.getGross().limitedTo(MAXIMUM_TAX_FREE_ALLOWANCE));
  }
}
