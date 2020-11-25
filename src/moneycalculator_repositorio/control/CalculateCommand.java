package moneycalculator_repositorio.control;

import moneycalculator_repositorio.control.Command;
import moneycalculator_repositorio.model.Currency;
import moneycalculator_repositorio.model.Money;
import moneycalculator_repositorio.persistence.ExchangeRateLoader;
import moneycalculator_repositorio.ui.MoneyDialog;
import moneycalculator_repositorio.ui.MoneyDisplay;

public class CalculateCommand implements Command{

    private final MoneyDialog moneyDialog;
    private final MoneyDisplay moneyDisplay;
    private final ExchangeRateLoader loader;
    private Currency eur = new Currency("EUR","Euro","�");

    public CalculateCommand(MoneyDialog moneyDialog, MoneyDisplay moneyDisplay,ExchangeRateLoader loader) {
        this.moneyDialog = moneyDialog;
        this.moneyDisplay = moneyDisplay;
        this.loader = loader;
    }

    @Override
    public String name() {
      return "calculate";
    }

    @Override
    public void execute() {
        moneyDisplay.display(exchange(moneyDialog.get()));
    }

    private Money exchange(Money money) {
        return new Money(money.getAmount() * rateOf(money.getCurrency()),eur);
    }

    private double rateOf(Currency currency) {
       return loader.load(currency,eur).getRate();
    }

}
