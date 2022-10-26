package lab1.lab1_1;


class RomanConverter {
    public static String toRoman(int n) {

        String out = "";

        while(n > 0)
        {
            if (n >= 1000)
            {
                out += "M";
                n -= 1000;
            } else if (n >= 900)
            {
                out += "CM";
                n -= 900;
            } else if (n >= 500)
            {
                out += "D";
                n -= 500;
            }
            else if(n >= 400)
            {
                out += "CD";
                n -= 400;
            }
            else if(n >= 100)
            {
                out += "C";
                n -= 100;
            }
            else if(n >= 90)
            {
                out += "XC";
                n -= 90;
            }
            else if(n >= 50)
            {
                out += "L";
                n -= 50;
            }
            else if(n >= 40)
            {
                out += "XL";
                n -= 40;
            }
            else if(n >= 10)
            {
                out += "X";
                n -= 10;
            }
            else if(n >= 9)
            {
                out += "IX";
                n -= 9;
            }
            else if(n >= 5)
            {
                out += "V";
                n -= 5;
            }
            else if(n >= 4)
            {
                out += "IV";
                n -= 4;
            }
            else if(n >= 1)
            {
                out += "I";
                n -= 1;
            }
        }
        return out;
    }

}