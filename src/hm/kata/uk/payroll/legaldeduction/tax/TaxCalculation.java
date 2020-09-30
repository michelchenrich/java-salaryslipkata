package hm.kata.uk.payroll.legaldeduction.tax;

import hm.kata.uk.payroll.CompositePayrollCalculation;

public class TaxCalculation extends CompositePayrollCalculation {
  public TaxCalculation() {
    super(
        new TaxFreeAllowanceCalculation(),
        new PrimaryThresholdRateCalculation(),
        new SecondaryThresholdRateCalculation(),
        new ReclaimedTaxFreeAllowanceCalculation(),
        new AdditionalRateCalculation());
  }
}
