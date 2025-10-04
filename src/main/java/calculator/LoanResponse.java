package calculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponse {
    private Double monthlyPayment;  // kuumakse
    private Double totalPayment;    // tagasimakstav summa
    private Double totalInterest;   // intresside kogusumma
}
