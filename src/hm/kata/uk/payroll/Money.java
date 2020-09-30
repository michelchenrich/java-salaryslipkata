package hm.kata.uk.payroll;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
  private final BigDecimal amount;

  public static Money zero() {
    return new Money(BigDecimal.ZERO);
  }

  public static Money valueOf(double amount) {
    return new Money(BigDecimal.valueOf(amount));
  }

  private Money(BigDecimal amount) {
    this.amount = amount;
  }

  public Money plus(Money other) {
    return new Money(amount.add(other.amount));
  }

  public Money limitedTo(Money other) {
    return new Money(amount.min(other.amount));
  }

  public Money limitedTo(double amount) {
    return limitedTo(Money.valueOf(amount));
  }

  public Money minus(double amount) {
    return minus(Money.valueOf(amount));
  }

  public Money minus(Money other) {
    return new Money(amount.subtract(other.amount).max(BigDecimal.ZERO));
  }

  public Money multiplyBy(double multiplier) {
    return new Money(amount.multiply(BigDecimal.valueOf(multiplier)));
  }

  public Money divideBy(double divisor) {
    return new Money(amount.divide(BigDecimal.valueOf(divisor), 9, RoundingMode.HALF_UP));
  }

  @Override
  public String toString() {
    return amount.setScale(2, RoundingMode.HALF_UP).toString();
  }

  @Override
  public boolean equals(Object other) {
    return other instanceof Money && equals((Money) other);
  }

  public boolean equals(Money other) {
    return this.toString().equals(other.toString());
  }

  @Override
  public int hashCode() {
    return amount.hashCode();
  }
}
