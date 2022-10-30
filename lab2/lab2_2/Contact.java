package lab2.lab2_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract class Contact {
    String date;

    public Contact(String date)
    {
        this.date = date;
    }

    public boolean isNewerThan(Contact c)
    {
        return date.compareTo(c.date) > 0;
    }

    @Override
    public abstract String toString();

    public abstract String getType();
}

