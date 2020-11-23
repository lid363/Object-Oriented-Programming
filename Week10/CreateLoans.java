/**
 *
 * @author Danhong Li 
 * Advanced HW9 with GUI features.
 */

import java.util.Scanner;
import javax.swing.JOptionPane;


public class CreateLoans implements LoanConstants{
    public static void main(String[] args) throws IllegalAccessException {
        Loan[] loans = new Loan[5];

        Scanner sc = new Scanner(System.in);
        // variables
        int choice,term,loan_number,button_choice;
        double loan_amount,prime_rate;
        String last_name;
       
      
        for (int i=0; i < loans.length;i++){

            prime_rate = Double.parseDouble(JOptionPane.showInputDialog("Enter the current prime interest rate as a decimal number: "));
             
            Object[] options1 ={"1.Business loan", "2.Personal loan"};
            choice = JOptionPane.showOptionDialog(null,"Select the loan type:","Loan Type",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options1,options1[1]);
            if(choice == JOptionPane.YES_OPTION){ choice = 1;}
            else if(choice == JOptionPane.NO_OPTION) {choice = 2; }
         
            loan_number = Integer.parseInt(JOptionPane.showInputDialog("Enter loan account number:"));
            last_name = JOptionPane.showInputDialog("Enter name:");
            loan_amount = Double.parseDouble(JOptionPane.showInputDialog("Enter loan amount:"));
           
            while (loan_amount>MAX_lOAN_AMOUNT){
                JOptionPane.showMessageDialog(null, "Over $500000 is not allowed.","Input Error", JOptionPane.ERROR_MESSAGE );
                loan_amount = Double.parseDouble(JOptionPane.showInputDialog("Enter loan amount:"));
            }
            
            // showOptionDialog
            Object[] options2 ={"1 year", "3 years", "5 years"};
            term = JOptionPane.showOptionDialog(null,"Select the term:","Term Selection",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options2,options2[2]
                      );

            if (term == JOptionPane.YES_OPTION)
                {
                     term = 1;
                     
                }
            else if(term == JOptionPane.NO_OPTION)
                {
                     term = 3;
                }
           
            else if(term == JOptionPane.CANCEL_OPTION)
                {
                     term = 5;
                }
            
       
            switch (choice){
                case 1:
                    BusinessLoan b = new BusinessLoan(prime_rate,loan_number,last_name,loan_amount,term);
                    loans[i] = b;
                    break;
                case 2:
                    PersonalLoan p = new PersonalLoan(prime_rate,loan_number,last_name,loan_amount,term);
                    loans[i] = p;
                    break;
            }
            
       System.out.println();
        }
        // output
        System.out.println("");
        System.out.println(COMPANY_NAME);
        int n=1;
        for (Loan loan : loans) {
            JOptionPane.showMessageDialog(null, loan.toString(), "Result" + n,JOptionPane.INFORMATION_MESSAGE );
            System.out.println("");
            n+=1;
        }

          
          
        


    }
}
