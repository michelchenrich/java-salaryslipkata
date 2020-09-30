package hm.kata.uk.payroll;

import hm.kata.uk.payroll.frequency.monthly.MonthlyProrataCalculation;
import hm.kata.uk.payroll.legaldeduction.nationalinsurance.NationalInsuranceCalculation;
import hm.kata.uk.payroll.legaldeduction.tax.TaxCalculation;

class MonthlyPayrollCalculation extends CompositePayrollCalculation {
  MonthlyPayrollCalculation() {
    super(new NationalInsuranceCalculation(), new TaxCalculation(), new MonthlyProrataCalculation());
  }
}
