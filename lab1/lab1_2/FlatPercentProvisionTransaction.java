package lab1.lab1_2;

import java.util.Objects;

class FlatPercentProvisionTransaction extends Transaction{
    int centsPerDolar;

    public FlatPercentProvisionTransaction(long fromId, long toId, String amount, int centsPerDolar) {
        super(fromId, toId, "FlatPercent", amount);
        this.centsPerDolar = centsPerDolar;
    }

    public int getPercent() {
        return centsPerDolar;
    }

    @Override
    public String getProvision() {
        return (int)(Bank.getAmountFloat(amount)) * getPercent() / 100. + "$";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FlatPercentProvisionTransaction that = (FlatPercentProvisionTransaction) o;
        return centsPerDolar == that.centsPerDolar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), centsPerDolar);
    }
}

