package MoneyCalculator.persistence;

import MoneyCalculator.model.Currency;
import java.util.List;

public interface CurrencyListLoader {
    public List<Currency> currencies();
}
