package CalcApp;


/**
* CalcApp/CalcPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./Calc.idl
* jueves 2 de marzo de 2023 21H32' CET
*/

public abstract class CalcPOA extends org.omg.PortableServer.Servant
 implements CalcApp.CalcOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("sum", new java.lang.Integer (0));
    _methods.put ("div", new java.lang.Integer (1));
    _methods.put ("mul", new java.lang.Integer (2));
    _methods.put ("sub", new java.lang.Integer (3));
    _methods.put ("addFrac", new java.lang.Integer (4));
    _methods.put ("subFrac", new java.lang.Integer (5));
    _methods.put ("mulFrac", new java.lang.Integer (6));
    _methods.put ("divFrac", new java.lang.Integer (7));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // CalcApp/Calc/sum
       {
         float a = in.read_float ();
         float b = in.read_float ();
         float $result = (float)0;
         $result = this.sum (a, b);
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       case 1:  // CalcApp/Calc/div
       {
         try {
           float a = in.read_float ();
           float b = in.read_float ();
           float $result = (float)0;
           $result = this.div (a, b);
           out = $rh.createReply();
           out.write_float ($result);
         } catch (CalcApp.CalcPackage.DivisionByZero $ex) {
           out = $rh.createExceptionReply ();
           CalcApp.CalcPackage.DivisionByZeroHelper.write (out, $ex);
         }
         break;
       }

       case 2:  // CalcApp/Calc/mul
       {
         float a = in.read_float ();
         float b = in.read_float ();
         float $result = (float)0;
         $result = this.mul (a, b);
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       case 3:  // CalcApp/Calc/sub
       {
         float a = in.read_float ();
         float b = in.read_float ();
         float $result = (float)0;
         $result = this.sub (a, b);
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       case 4:  // CalcApp/Calc/addFrac
       {
         CalcApp.Frac f1 = CalcApp.FracHelper.read (in);
         CalcApp.Frac f2 = CalcApp.FracHelper.read (in);
         CalcApp.Frac $result = null;
         $result = this.addFrac (f1, f2);
         out = $rh.createReply();
         CalcApp.FracHelper.write (out, $result);
         break;
       }

       case 5:  // CalcApp/Calc/subFrac
       {
         CalcApp.Frac f1 = CalcApp.FracHelper.read (in);
         CalcApp.Frac f2 = CalcApp.FracHelper.read (in);
         CalcApp.Frac $result = null;
         $result = this.subFrac (f1, f2);
         out = $rh.createReply();
         CalcApp.FracHelper.write (out, $result);
         break;
       }

       case 6:  // CalcApp/Calc/mulFrac
       {
         CalcApp.Frac f1 = CalcApp.FracHelper.read (in);
         CalcApp.Frac f2 = CalcApp.FracHelper.read (in);
         CalcApp.Frac $result = null;
         $result = this.mulFrac (f1, f2);
         out = $rh.createReply();
         CalcApp.FracHelper.write (out, $result);
         break;
       }

       case 7:  // CalcApp/Calc/divFrac
       {
         try {
           CalcApp.Frac f1 = CalcApp.FracHelper.read (in);
           CalcApp.Frac f2 = CalcApp.FracHelper.read (in);
           CalcApp.Frac $result = null;
           $result = this.divFrac (f1, f2);
           out = $rh.createReply();
           CalcApp.FracHelper.write (out, $result);
         } catch (CalcApp.CalcPackage.DivisionByZero $ex) {
           out = $rh.createExceptionReply ();
           CalcApp.CalcPackage.DivisionByZeroHelper.write (out, $ex);
         }
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CalcApp/Calc:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Calc _this() 
  {
    return CalcHelper.narrow(
    super._this_object());
  }

  public Calc _this(org.omg.CORBA.ORB orb) 
  {
    return CalcHelper.narrow(
    super._this_object(orb));
  }


} // class CalcPOA
