package lab2.lab2_2;

class PhoneContact extends Contact{
    String phone;
    Operator operator;

    public PhoneContact(String date, String phone)
    {
        super(date);
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }

    @Override
    public String getType()
    {
        return "Phone";
    }

    @Override
    public String toString() {
        return "\"" + phone + '\"';
    }
    public Operator getOperator()
    {
        String prefix = phone.substring(0, 3);
        if(prefix.equals("070") || prefix.equals("071") || prefix.equals("072"))
        {
            return operator.TMOBILE;
        }
        else if(prefix.equals("075") || prefix.equals("076"))
        {
            return operator.ONE;
        }
        else if(prefix.equals("077") || prefix.equals("078"))
        {
            return operator.VIP;
        }
        return null;
    }
}
