package moneycalculator_repositorio.persistence;

import moneycalculator_repositorio.model.Currency;
import java.util.List;

public interface CurrencyListLoader {
    public List<Currency> currencies();
}
