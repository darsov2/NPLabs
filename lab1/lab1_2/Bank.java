package lab1.lab1_2;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

class Bank {
    String name;
    Account[] accounts;
    String transfer, provision;

    public Bank(String name, Account[] accounts)
    {
        this.name = name;
        this.accounts = new Account[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            this.accounts[i] = accounts[i];
        }
        transfer = "0.00$";
        provision = "0.00$";

    }

    public Account[] getAccounts() {
        return accounts;
    }

    public Optional<Account> checkAccount(long id)
    {
        return Arrays.stream(accounts).filter(account -> account.getId() == id).findFirst();
    }

    public boolean checkBalance(Account acc, String amt, String prov)
    {
        return getAmountFloat(acc.getBalance()) > (getAmountFloat(amt) + getAmountFloat(prov)) ? true : false;
    }

    private void changeSum (String amt, String provision)
    {
        transfer = String.format(Locale.US, "%.2f$", getAmountFloat(transfer) + getAmountFloat(amt));
        this.provision = String.format(Locale.US, "%.2f$", getAmountFloat(this.provision) + getAmountFloat(provision));
    }

    private void accountChanges(Account send, Account receive, String amt, String prov)
    {
        send.setBalance(String.format(Locale.US, "%.2f$", getAmountFloat(send.getBalance()) - getAmountFloat(amt) - getAmountFloat(prov)));
        receive.setBalance(String.format(Locale.US, "%.2f$", getAmountFloat(receive.getBalance()) + getAmountFloat(amt)));
    }
    public boolean makeTransaction(Transaction t)
    {
        Optional<Account> sender = checkAccount(t.fromId);
        Optional<Account> receiver = checkAccount(t.toId);

        if(sender.isPresent() && receiver.isPresent())
        {
            Account senderAcc = sender.get();
            Account receiverAcc = receiver.get();

            String provision = t.getProvision();

            if(checkBalance(senderAcc, t.amount, provision))
            {
                accountChanges(senderAcc, receiverAcc, t.amount, provision);
                changeSum(t.amount, provision);
                return true;
            }
        }

        return false;
    }

    public String totalTransfers ()
    {
        return transfer;
    }

    public static double getAmountFloat(String s)
    {
        return Double.parseDouble((s == null || s.length() == 0) ? null : (s.substring(0, s.length() - 1)));
    }

    public String totalProvision()
    {
        return provision;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Name: " + name + "\n\n");

        for(int i = 0; i < accounts.length; i++)
        {
            sb.append(accounts[i].toString());
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Arrays.equals(accounts, bank.accounts) && Objects.equals(transfer, bank.transfer) && Objects.equals(provision, bank.provision);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, transfer, provision);
        result = 31 * result + Arrays.hashCode(accounts);
        return result;
    }
}
