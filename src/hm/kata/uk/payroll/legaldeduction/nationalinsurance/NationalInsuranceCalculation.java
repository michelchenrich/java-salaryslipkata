package hm.kata.uk.payroll.legaldeduction.nationalinsurance;

import hm.kata.uk.payroll.CompositePayrollCalculation;

public class NationalInsuranceCalculation extends CompositePayrollCalculation {
  public NationalInsuranceCalculation() {
    super(new BaseContributionCalculation(), new AdditionalContributionCalculation());
  }
}
