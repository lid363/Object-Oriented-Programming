
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

abstract class Loan implements LoanConstants {
    int loan_number;
    String last_name;
    double loan_amount;
    double interest_rate;
    int term;

    public Loan(int loan_number, String last_name, double loan_amount, int term) {
        this.loan_number = loan_number;
        this.last_name = last_name;
        this.loan_amount = loan_amount;
       
        this.term = term;
    }

    @Override
    public String toString() {
       
      
 
       DecimalFormat df = new DecimalFormat(".00");

        return "Loan number:  " + loan_number + "\nName:   " + last_name +
                "\nLoan amount: $" + df.format(loan_amount) +
                " for " + term + " year(s)";  
    }
  
}

