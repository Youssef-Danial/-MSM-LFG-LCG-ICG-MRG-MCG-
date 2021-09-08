import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class mainn {
    public static void main(String[] args) {
        // getting input from the user
        String mode = "";
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the mode you want (MSM, LFG, LCG, ICG, MRG, MCG) or exit");
            mode = input.nextLine();
            if (mode.equals("MSM")) {
                // taking the input for MSM from the user and calling the function afterward
                System.out.println("Please Enter X");
                int num = input.nextInt();
                System.out.println("Please Enter m");
                int m = input.nextInt();
                System.out.println("Please Enter the number of random numbers to be generated");
                int count = input.nextInt();
                MSM(num, count, m);
            } else if (mode.equals("LFG")) {
                System.out.println("Please Enter X1");
                double x1 = input.nextDouble();
                System.out.println("Please Enter X2");
                double x2 = input.nextDouble();
                System.out.println("Please Enter number of random numbers to be generated");
                double count = input.nextDouble();
                System.out.println("Please Enter m");
                double m = input.nextDouble();
                System.out.println("Please Enter the operator (+,-,*,/)");
                char operate = input.next().charAt(0);
                LFG(x1, x2, count, m, operate);
            } else if (mode.equals("LCG")) {
                System.out.println("Plesae Enter n number of random numbers to generated");
                int n = input.nextInt();
                System.out.println("Plesae Enter m");
                float m = input.nextFloat();
                System.out.println("Plesae Enter a");
                float a = input.nextFloat();
                System.out.println("Plesae Enter c");
                float c = input.nextFloat();
                System.out.println("Plesae Enter X");
                float x = input.nextFloat();
                LCG(n, m, a, c, x);
            } else if (mode.equals("ICG")) {
                System.out.println("Please Enter x");
                float x = input.nextFloat();
                System.out.println("Please Enter a");
                float a = input.nextFloat();
                System.out.println("Please Enter m");
                float m = input.nextFloat();
                System.out.println("Please Enter number of random numbers to be generated");
                int count = input.nextInt();
                ICG(x, a, m, count);
            } else if (mode.equals("MRG")) {
                System.out.println("Please Enter the number of element for the X array");
                int size = input.nextInt();
                double[] x = new double[size];
                System.out.println("Now Please Enter each element");
                for (int i = 0; i < size; i++) {//for reading array
                    x[i] = input.nextDouble();
                }
                System.out.println("Please Enter the number of element for the abc array");
                size = input.nextInt();
                double[] abc = new double[size];
                for (int i = 0; i < size; i++) {//for reading array
                    abc[i] = input.nextDouble();
                }
                System.out.println("Please Enter m");
                double m = input.nextDouble();
                System.out.println("Please Enter number of random Number to be generated");
                int count = input.nextInt();
                MRG(x, abc, m, count);

            } else if (mode.equals("MCG")) {
                System.out.println("Please Enter number of random numbers to be generated");
                int n = input.nextInt();
                System.out.println("Please Enter X0");
                float x0 = input.nextFloat();
                System.out.println("Please Enter a");
                float a = input.nextFloat();
                System.out.println("Please Enter m");
                float m = input.nextFloat();
                MCG(n, x0, a, m);

            } else if (mode.equals("exit")) {
                break;
            } else {

            }
        }
    }

    public static void MSM(int num, int count, int m) {
        int num_square = (int) Math.pow(num, 2);
        int newnumber = 0;
        String numstring = Integer.toString(num_square);
        while (numstring.length() < 6) {
            numstring = numstring + "0";
        }
        System.out.println(" the square of the number" + numstring);
        // System.out.println(numstring);
        // geting the number that is in the middle of the square
        int length = numstring.length();
        if (count != 0 && length != 6) {
            String word1 = numstring.substring(0, length / 2);
            String word2 = numstring.substring(length / 2);
            System.out.println("half one of the string " + word1);
            System.out.println("half two of the string " + word2);
            String word3 = word1.substring(word1.length() / 2);
            String word4 = word2.substring(0, word2.length() / 2);
            System.out.println("the next number is " + (word3 + word4));
            word1 = word3 + word4;
            System.out.println("the word before removing the zero " + word1);
            // for removing any zeros in the start of the number
            word1.replaceFirst("^0+(?!$)", "");
            newnumber = Integer.parseInt(word1);
            System.out.println(newnumber);
            count = count - 1;
            // setting the Rn
            double Rn = ((double) newnumber / (double) m);
            System.out.println("The Rn = " + Rn);
            System.out.println("=====================");
            MSM(newnumber, count, m);
        }
        if (numstring.length() == 6 && count != 0) {
            numstring.replaceFirst("^0+(?!$)", "");
            String word = numstring.substring(0, length - 2);
            newnumber = Integer.parseInt(word);
            System.out.println(newnumber);
            count = count - 1;
            System.out.println("=====================");
            MSM(newnumber, count, m);
        }
    }

    public static void LFG(double x1, double x2, double count, double m, char operate) {
        System.out.println("X0 " + x1 + " Rn = " + ((double) x1 / (double) m));
        System.out.println("X1 " + x2 + " Rn = " + ((double) x2 / (double) m));
        LFGin(x1, x2, count, m, operate);
    }

    public static void LFGin(double x1, double x2, double count, double m, char operate) {
        double x1temp = x1;
        x1 = operators(x1, operate, x2, m);
        System.out.println("X1 " + x1);
        System.out.println("X0 " + x1temp);
        System.out.println("Rn = " + ((double) x1 / (double) m));
        if (count > 0) {
            LFG(x1, x1temp, --count, m, operate);
        }
    }

    public static double operators(double x, char operator, double y, double m) {
        switch (operator) {
            case '+':
                x = (x + y) % m;
                break;

            case '-':
                x = (x - y) % m;
                break;

            case '*':
                x = (x * y) % m;
                break;

            case '/':
                x = (x / y) % m;
                break;
            default:
                System.out.println("Something wrong with the operators");
        }
        return x;
    }

    public static void LCG(int n, float m, float a, float c, float x) {
        float rn0 = x / m;
        System.out.println("the x0=" + x + "and the RN" + rn0);
        for (int i = 1; i < n; i++) {
            float result = (a * x + c) % m;
            float rn = x / m;
            System.out.println("the x" + i + "=" + result + "and the RN" + i + "=" + rn);
            x = result;
        }

    }

    public static void ICG(float x, float a, float m, int count) {
        System.out.println("Rn = " + x / m);
        System.out.println("============");
        float result = (a / x) % m;
        System.out.println("X =" + result);
        if (count > 0) {
            ICG(result, a, m, --count);
        }
    }

    public static void MRG(double[] x, double[] abc, double m, int count) {
        List X = new LinkedList();
        for (int i = 0; i < x.length; i++) {
            System.out.println("X = " + x[i] + " | Rn = " + (x[i] / m));
            X.add(x[i]);
        }
        double result = 0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < abc.length; j++) {
                result = result + (((double) X.get(j)) * abc[j]);
            }
            result = result % m;
            System.out.println("X = " + result + " Rn = " + (result / m));
            X.remove(X.get(i));
            X.add(result);
            result = 0;
        }
    }

    public static void MCG(int n, float x0, float a, float m) {
        //𝑥(𝑖+1)=(𝑎𝑥𝑖) 𝑚𝑜𝑑 m
        int rn0 = (int) (x0 / m);
        System.out.println(" x0=" + x0 + "            " + " RN " + rn0);
        for (int i = 1; i <= n; i++) {
            int x = (int) ((a * x0) % m);
            float random = x / m;
            System.out.println("x" + i + "=" + x + "            " + "RN" + i + "=" + random);
            x0 = x;
        }
    }
}
