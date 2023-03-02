
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import CalcApp.*;
import CalcApp.CalcPackage.DivisionByZero;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import static java.lang.System.out;

public class CalcClient {

    static Calc calcImpl;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) {

        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext. This is
            // part of the Interoperable naming Service.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // resolve the Object Reference in Naming
            String name = "Calc";
            calcImpl = CalcHelper.narrow(ncRef.resolve_str(name));

//			System.out.println(calcImpl);

            while (true) {
                out.println("1. Sum");
                out.println("2. Sub");
                out.println("3. Mul");
                out.println("4. Div");
                out.println("5. Sum Fracciones"); //nuevas opciones de usuario
                out.println("6. Sub Fracciones");
                out.println("7. Mul Fracciones");
                out.println("8. Div Fracciones");
                out.println("9. exit");
                out.println("--");
                out.println("choice: ");

                try {
                    String opt = br.readLine();
                    if (opt.equals("9")) {
                        break;
                    } else if (opt.equals("1")) {
                        out.println("a+b= " + calcImpl.sum(getFloat("a"), getFloat("b")));
                    } else if (opt.equals("2")) {
                        out.println("a-b= " + calcImpl.sub(getFloat("a"), getFloat("b")));
                    } else if (opt.equals("3")) {
                        out.println("a*b= " + calcImpl.mul(getFloat("a"), getFloat("b")));
                    } else if (opt.equals("4")) {
                        try {
                            out.println("a/b= " + calcImpl.div(getFloat("a"), getFloat("b")));
                        } catch (DivisionByZero de) {
                            out.println("Division by zero!!!");
                        }
                    } else if (opt.equals("5")) {
                        out.println("Enter fraction 1 numerator: ");
                        long num1 = Long.parseLong(br.readLine());

                        out.println("Enter fraction 1 denominator: ");
                        long den1 = Long.parseLong(br.readLine());

                        out.println("Enter fraction 2 numerator: ");
                        long num2 = Long.parseLong(br.readLine());

                        out.println("Enter fraction 2 denominator: ");
                        long den2 = Long.parseLong(br.readLine());

                        Frac f1 = new Frac((int) num1, (int) den1);
                        Frac f2 = new Frac((int) num2, (int) den2);

                        Frac result = calcImpl.addFrac(f1, f2);

                        out.println("Result: " + result.num + "/" + result.den);

                    } else if (opt.equals("6")) {
                        out.println("Enter fraction 1 numerator: ");
                        long num1 = Long.parseLong(br.readLine());

                        out.println("Enter fraction 1 denominator: ");
                        long den1 = Long.parseLong(br.readLine());

                        out.println("Enter fraction 2 numerator: ");
                        long num2 = Long.parseLong(br.readLine());

                        out.println("Enter fraction 2 denominator: ");
                        long den2 = Long.parseLong(br.readLine());

                        Frac f1 = new Frac((int) num1, (int) den1);
                        Frac f2 = new Frac((int) num2, (int) den2);

                        Frac result = calcImpl.subFrac(f1, f2);

                        out.println("Result: " + result.num + "/" + result.den);

                    } else if (opt.equals("7")) {
                        out.println("Enter fraction 1 numerator: ");
                        long num1 = Long.parseLong(br.readLine());

                        out.println("Enter fraction 1 denominator: ");
                        long den1 = Long.parseLong(br.readLine());

                        out.println("Enter fraction 2 numerator: ");
                        long num2 = Long.parseLong(br.readLine());

                        out.println("Enter fraction 2 denominator: ");
                        long den2 = Long.parseLong(br.readLine());

                        Frac f1 = new Frac((int) num1, (int) den1);
                        Frac f2 = new Frac((int) num2, (int) den2);

                        Frac result = calcImpl.mulFrac(f1, f2);

                        out.println("Result: " + result.num + "/" + result.den);
                    } else if (opt.equals("8")) {
                        try {
                            out.println("Enter fraction 1 numerator: ");
                            long num1 = Long.parseLong(br.readLine());

                            out.println("Enter fraction 1 denominator: ");
                            long den1 = Long.parseLong(br.readLine());

                            out.println("Enter fraction 2 numerator: ");
                            long num2 = Long.parseLong(br.readLine());

                            out.println("Enter fraction 2 denominator: ");
                            long den2 = Long.parseLong(br.readLine());

                            Frac f1 = new Frac((int) num1, (int) den1);
                            Frac f2 = new Frac((int) num2, (int) den2);

                            Frac result = calcImpl.divFrac(f1, f2);

                            out.println("Result: " + result.num + "/" + result.den);
                        } catch (DivisionByZero de) {
                            out.println("Division by zero!!!");
                        }
                    }
                } catch (Exception e) {
                    out.println("===");
                    out.println("Error with numbers");
                    out.println("===");
                }
                out.println("");

            }
            //calcImpl.shutdown();
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }

    static float getFloat(String number) throws Exception {
        out.print(number + ": ");
        return Float.parseFloat(br.readLine());
    }
}
