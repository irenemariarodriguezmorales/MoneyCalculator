package moneycalculator_repositorio.control;

public interface Command {
    String name();
    void execute();
}
