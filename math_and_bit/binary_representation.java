package math_and_bit;

public class binary_representation {
    
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public static String binaryRepresentation(String n) {
        int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
        double decimalPart = Double.parseDouble(n.substring(n.indexOf('.')));
        
        String intStr = Integer.toBinaryString(intPart);
        String decimalStr = "";
        
        while (decimalPart > 0.0) {
            if (decimalStr.length() > 32) {
                return "ERROR";
            }
            
            decimalPart = decimalPart * 2;
            if (decimalPart >= 1) {
                decimalStr += "1";
                decimalPart -= 1;
            } else {
                decimalStr += "0";
            }
        }
        
        if (decimalStr.length() == 0) {
            return intStr;
        } else {
            return String.format("%s.%s", intStr, decimalStr);
        }
    }

    public static void main(String[] args) {
        System.out.println(binaryRepresentation("3.5"));
        System.out.println(binaryRepresentation("3.72"));
    }

}
