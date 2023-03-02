
import CalcApp.*;
import CalcApp.CalcPackage.DivisionByZero;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

import java.util.Properties;

class CalcImpl extends CalcPOA {

    @Override
    public float sum(float a, float b) {
        return a + b;
    }

    @Override
    public float div(float a, float b) throws DivisionByZero {
        if (b == 0) {
            throw new CalcApp.CalcPackage.DivisionByZero();
        } else {
            return a / b;
        }
    }

    @Override
    public float mul(float a, float b) {
        return a * b;
    }

    @Override
    public float sub(float a, float b) {
        return a - b;
    }

    //nuevas funciones de operaciones aritmeticas.
    @Override
    public Frac addFrac(Frac f1, Frac f2) {
        Frac result = new Frac();
        result.num = f1.num * f2.den + f2.num * f1.den;
        result.den = f1.den * f2.den;
        return simplifyFrac(result);
    }
    @Override
    public Frac subFrac(Frac f1, Frac f2) {
        Frac result = new Frac();
        result.num = f1.num * f2.den - f2.num * f1.den;
        result.den = f1.den * f2.den;
        return simplifyFrac(result);
    }
    @Override
    public Frac mulFrac(Frac f1, Frac f2) {
        Frac result = new Frac();
        result.num = f1.num * f2.num;
        result.den = f1.den * f2.den;
        return simplifyFrac(result);
    }
    @Override
    public Frac divFrac(Frac f1, Frac f2) throws DivisionByZero {
        Frac result = new Frac();
        result.num = f1.num * f2.den;
        result.den = f1.den * f2.num;
        if (result.den == 0) {
            throw new DivisionByZero();
        }
        return simplifyFrac(result);
    }

    public Frac simplifyFrac(Frac f) {
        int gcd = getGCD(f.num, f.den);
        f.num /= gcd;
        f.den /= gcd;
        return f;
    }

    public int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }

    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }
}

public class CalcServer {

    public static void main(String args[]) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get reference to rootpoa & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // create servant and register it with the ORB
            CalcImpl helloImpl = new CalcImpl();
            helloImpl.setORB(orb);

            // get object reference from the servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
            Calc href = CalcHelper.narrow(ref);

            // get the root naming context
            // NameService invokes the name service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // Use NamingContextExt which is part of the Interoperable
            // Naming Service (INS) specification.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // bind the Object Reference in Naming
            String name = "Calc";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("Ready..");

            // wait for invocations from clients
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("Exiting ...");

    }
}
