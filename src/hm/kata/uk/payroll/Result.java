package hm.kata.uk.payroll;

public class Result {
  private final Money niDeduction;
  private final Money taxFreeAllowance;
  private final Money gross;
  private final Money taxableGross;
  private final Money taxDeduction;

  public Result(Money gross) {
    this(gross, Money.zero(), Money.zero(), Money.zero(), Money.zero());
  }

  public Result(
      Money gross,
      Money niDeduction,
      Money taxFreeAllowance,
      Money taxableGross,
      Money taxDeduction) {
    this.gross = gross;
    this.niDeduction = niDeduction;
    this.taxFreeAllowance = taxFreeAllowance;
    this.taxableGross = taxableGross;
    this.taxDeduction = taxDeduction;
  }

  public Money getGross() {
    return gross;
  }

  public Money getNiDeduction() {
    return niDeduction;
  }

  public Result withNiDeduction(Money niDeduction) {
    return new Result(gross, niDeduction, taxFreeAllowance, taxableGross, taxDeduction);
  }

  public Result plusNiDeduction(Money amount) {
    return withNiDeduction(niDeduction.plus(amount));
  }

  public Money getTaxFreeAllowance() {
    return taxFreeAllowance;
  }

  public Result withTaxFreeAllowance(Money taxFreeAllowance) {
    return new Result(gross, niDeduction, taxFreeAllowance, taxableGross, taxDeduction);
  }

  public Money getTaxableGross() {
    return taxableGross;
  }

  public Result withTaxableGross(Money taxableGross) {
    return new Result(gross, niDeduction, taxFreeAllowance, taxableGross, taxDeduction);
  }

  public Result plusTaxableGross(Money amount) {
    return withTaxableGross(taxableGross.plus(amount));
  }

  public Money getTaxDeduction() {
    return taxDeduction;
  }

  public Result withTaxDeduction(Money taxDeduction) {
    return new Result(gross, niDeduction, taxFreeAllowance, taxableGross, taxDeduction);
  }

  public Result plusTaxDeduction(Money amount) {
    return withTaxDeduction(taxDeduction.plus(amount));
  }

  public Result minusTaxFreeAllowance(Money amount) {
    return withTaxFreeAllowance(taxFreeAllowance.minus(amount));
  }

  public Result prorateToOnePartOf(int numberOfParts) {
    return new Result(
        gross.divideBy(numberOfParts),
        niDeduction.divideBy(numberOfParts),
        taxFreeAllowance.divideBy(numberOfParts),
        taxableGross.divideBy(numberOfParts),
        taxDeduction.divideBy(numberOfParts));
  }
}
