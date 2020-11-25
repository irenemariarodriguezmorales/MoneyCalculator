package moneycalculator_repositorio.persistence;

import moneycalculator_repositorio.model.Currency;
import moneycalculator_repositorio.model.ExchangeRate;

public interface ExchangeRateLoader {
    public ExchangeRate load(Currency from, Currency to);
}
