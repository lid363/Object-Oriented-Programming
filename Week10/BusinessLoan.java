
import java.text.DecimalFormat;

public class BusinessLoan extends Loan{
    public BusinessLoan(double prime_rate, int loan_number, String last_name, double loan_amount, int term) throws IllegalAccessException {
        super(loan_number, last_name, loan_amount, term);
        this.interest_rate=1+prime_rate*100;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat(".00");
        return super.toString() + " at " + interest_rate +"% interest." + "\nTotal amount owned: $" + df.format(loan_amount*(1+(interest_rate/100)*term)) + '.';
    }
}

