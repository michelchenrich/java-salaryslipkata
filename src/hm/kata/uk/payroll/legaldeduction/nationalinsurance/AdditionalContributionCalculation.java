package hm.kata.uk.payroll.legaldeduction.nationalinsurance;

import static hm.kata.uk.payroll.legaldeduction.nationalinsurance.ThresholdsAndRates.ADDITIONAL_CONTRIBUTION_RATE;
import static hm.kata.uk.payroll.legaldeduction.nationalinsurance.ThresholdsAndRates.BASE_CONTRIBUTION_THRESHOLD;

import hm.kata.uk.payroll.PayrollCalculation;
import hm.kata.uk.payroll.Result;

class AdditionalContributionCalculation implements PayrollCalculation {
  @Override
  public Result applyTo(Result result) {
    return result.plusNiDeduction(
        result.getGross().minus(BASE_CONTRIBUTION_THRESHOLD).multiplyBy(ADDITIONAL_CONTRIBUTION_RATE));
  }
}
