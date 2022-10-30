package lab2.lab2_2;

class EmailContact extends Contact {
    String email;

    public EmailContact(String date, String email)
    {
        super(date);
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    @Override
    public String getType() {
        return "Email";
    }

    @Override
    public String toString() {
        return "\"" + email + '\"';
    }
}
