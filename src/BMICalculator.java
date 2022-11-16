import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * A Body Mass Index Calculator using user input.
 *@version 11.16.2022
 *@author Srao2020
 */
public class BMICalculator {
    /** Convert English to metric units, perform the BMI calculation.
     * NOTE: this method must properly handle bad data
     * @param inches user's height in inches
     * @param pounds user's weight in inches
     * @return user's BMI weight(kg) / height(m)^2 a double
     */
    public static double computeBMI(int inches, int pounds) /*throws NumberFormatException*/ {
        double kgs, meters;
        if (inches <= 0 || pounds <= 0)
            return 0.;
            //throw new NumberFormatException("Blah");
        meters = inches * 0.0254;
        kgs = pounds * 0.454;
        return kgs / Math.pow(meters, 2);
    }

    /** Uses a Scanner to prompt the user for info, process the
     * feet/inches conversion, calls the computeBMI method and prints the
     * correct information.
     * Main method for BMICalculator
     * @param args command line arguments, if needed.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String userin = new String();
        int inches, pounds;
        DecimalFormat df = new DecimalFormat("0.00");
        while(true) {
            try {
                System.out.print("Enter your height in feet and inches (Ex 6'1\") or 0 to quit: ");
                userin = in.nextLine();

                if(userin.equals("0"))
                    break;
                inches = Integer.parseInt(userin.substring(0, userin.indexOf("'"))) * 12;
                inches += Integer.parseInt(userin.substring(userin.indexOf("'")+1, userin.length()-1));

                // Extra Start
                if (inches > 107) {
                    System.out.println("The tallest man ever in the world was Robert Wadlow, and he was shorter than you are (Mr Cochran).\nTry again");
                    continue;
                }
                // Extra End

                System.out.print("Enter your weight in pounds: ");
                userin = in.nextLine();
                pounds = Integer.parseInt(userin);
                System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches, pounds))+ " kg/m^2");
                    break;

                //System.out.println(inches);
            }
            catch(Exception e) {
                System.out.println("There was an error, see here: " + e.toString());
            }
        }
    }
}
