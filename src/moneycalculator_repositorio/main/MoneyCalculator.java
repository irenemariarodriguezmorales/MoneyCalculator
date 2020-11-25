
package moneycalculator_repositorio.main;

import moneycalculator_repositorio.control.CalculateCommand;
import moneycalculator_repositorio.persistence.CurrencyListLoader;
import moneycalculator_repositorio.persistence.ExchangeRateLoader;
import moneycalculator_repositorio.persistence.file.FileCurrencyListLoader;
import moneycalculator_repositorio.persistence.rest.RestExchangeRateLoader;


public class MoneyCalculator {
    public static void main(String[] args) {
        CurrencyListLoader cLLoader = new FileCurrencyListLoader("currencies");
        ExchangeRateLoader eRLoader = new RestExchangeRateLoader();
        MoneyCalculatorFrame moneyCalculatorFrame = new MoneyCalculatorFrame(cLLoader.currencies());
        moneyCalculatorFrame.add(new CalculateCommand(moneyCalculatorFrame.getMoneyDialog(),moneyCalculatorFrame.getMoneyDisplay(), eRLoader));
    }

}
