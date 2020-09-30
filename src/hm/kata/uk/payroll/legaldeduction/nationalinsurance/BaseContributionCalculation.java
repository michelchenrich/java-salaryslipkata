package hm.kata.uk.payroll.legaldeduction.nationalinsurance;

import static hm.kata.uk.payroll.legaldeduction.nationalinsurance.ThresholdsAndRates.BASE_CONTRIBUTION_THRESHOLD;
import static hm.kata.uk.payroll.legaldeduction.nationalinsurance.ThresholdsAndRates.CONTRIBUTION_FREE_LIMIT;

import hm.kata.uk.payroll.PayrollCalculation;
import hm.kata.uk.payroll.Result;

class BaseContributionCalculation implements PayrollCalculation {
  @Override
  public Result applyTo(Result result) {
    return result.withNiDeduction(
        result
            .getGross()
            .limitedTo(BASE_CONTRIBUTION_THRESHOLD)
            .minus(CONTRIBUTION_FREE_LIMIT)
            .multiplyBy(ThresholdsAndRates.BASE_CONTRIBUTION_RATE));
  }
}
