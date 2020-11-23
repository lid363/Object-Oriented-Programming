

import java.text.DecimalFormat;

public class PersonalLoan extends Loan {
    public PersonalLoan(double prime_rate, int loan_number, String last_name, double loan_amount, int term) throws IllegalAccessException {
        super(loan_number, last_name, loan_amount, term);
        this.interest_rate=0.02+prime_rate;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat(".00");
        return super.toString() + " at " + interest_rate +"% interest." + "\nTotal amount owned: $" + df.format(loan_amount*(1+(interest_rate/100)*term)) + '.';
    }
}
