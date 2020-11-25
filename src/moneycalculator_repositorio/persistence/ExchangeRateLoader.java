package MoneyCalculator.persistence;

import MoneyCalculator.model.Currency;
import MoneyCalculator.model.ExchangeRate;

public interface ExchangeRateLoader {
    public ExchangeRate load(Currency from, Currency to);
}
