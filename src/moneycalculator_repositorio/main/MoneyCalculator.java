
package MoneyCalculator.main;

import MoneyCalculator.control.CalculateCommand;
import MoneyCalculator.persistence.CurrencyListLoader;
import MoneyCalculator.persistence.ExchangeRateLoader;
import MoneyCalculator.persistence.file.FileCurrencyListLoader;
import MoneyCalculator.persistence.rest.RestExchangeRateLoader;


public class MoneyCalculator {
    public static void main(String[] args) {
        CurrencyListLoader cLLoader = new FileCurrencyListLoader("currencies");
        ExchangeRateLoader eRLoader = new RestExchangeRateLoader();
        MoneyCalculatorFrame moneyCalculatorFrame = new MoneyCalculatorFrame(cLLoader.currencies());
        moneyCalculatorFrame.add(new CalculateCommand(moneyCalculatorFrame.getMoneyDialog(),moneyCalculatorFrame.getMoneyDisplay(), eRLoader));
    }
}
