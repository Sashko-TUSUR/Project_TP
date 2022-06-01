package com.projectTP.web_recipes.payload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class СonstructorParam {


  static final class MyResult {
        private final int denominator;
        private final int numerator;
        private final String cos;
        private final String sin;

        public MyResult(int denominator, int numerator, String cos, String sin) {
            this.denominator = denominator;
            this.numerator = numerator;
            this.cos = cos;
            this.sin = sin;
        }

        public int getDenominator() {
            return denominator;
        }

        public int getNumerator() {
            return numerator;
        }

        public String getCos() {
            return cos;
        }

        public String getSin() {
            return sin;
        }
    }

    public static MyResult something() {
        final int min = 2; // Минимальное число для диапазона
        final int max = 9; // Максимальное число для диапазона
        int chisl = chisl(min, max);
        final int denominator = denominator(min, max);
        while(denominator<=chisl)
        {
            chisl =--chisl;
        }
        final int numerator = chisl;

        String cos="cos";
        String sin="sin";
        return new MyResult(denominator, numerator, cos, sin);
    }

    private static int denominator(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static int chisl(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    ///////////////////////

        static final class CheckResult  {

            private final String sign;
            private final int number1;
            private final int number2;
            private boolean check;

            CheckResult(String sign, int number1, int number2,boolean check) {
                this.sign = sign;
                this.number1 = number1;
                this.number2 = number2;
                this.check=check;
            }


            public int getNumber1() {return number1;}
            public int getNumber2() {return number2;}
            public String getSign() {return sign;}
            public boolean getCheck() {return check;}

        }

        public String result(String sing, int number1, int number2)
        {
            MyResult denominator = null;
            int den = denominator.getDenominator();
            int num =denominator.getNumerator();
            String message;
            boolean check =true;
            boolean param1 =checkSign(sing,check);
            boolean param2 = checkNumber1(number1,check,den);
            boolean param3 = checkNumber2(number2,check,num);

            if(param1||param2||param3 == false)
            {
                message= "Задание выполнено не верно!";
            }
            else
            {
                message ="Задание выполнено верно!";
            }
            return message;
        }



    private boolean checkSign(String sign, boolean check)
        {
            if(!sign.equals("-"))
            {
                check =false;
            }
            return  check;
        }

        private boolean checkNumber1(int number1, boolean check, int denominator)
        {
            if(number1-denominator>1 && number1-denominator<1)
            {
                check = false;
            }
                return check;
        }
    private boolean checkNumber2(int number2, boolean check, int denominator) {
        if (number2 - denominator > 1 && number2 - denominator < 1) {
            check = false;
        }
        return check;
    }



}
