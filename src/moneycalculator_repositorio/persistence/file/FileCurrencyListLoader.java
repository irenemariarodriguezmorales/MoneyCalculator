package moneycalculator_repositorio.persistence.file;

import moneycalculator_repositorio.model.Currency;
import moneycalculator_repositorio.persistence.CurrencyListLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCurrencyListLoader implements CurrencyListLoader{
    private final String fileName;

    
    public FileCurrencyListLoader(String fileName) {
        this.fileName = fileName;
    }

    private Currency currencyOf(String line) {
        String[] split = line.split(",");
        return new Currency(split[0],split[1],split[2]);
    }
    
    @Override
    public List<Currency> currencies() {
        List<Currency> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            while (true) {
                String line = reader.readLine();
                if(line == null) break;
                list.add(currencyOf(line));
            }

        }catch (FileNotFoundException e) { 
        }catch (IOException e) {
        }
        return list;
    }
    
    
}
