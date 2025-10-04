package calculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    private Double amount;  // laenusumma
    private Double yearlyRate;  // aastane intress protsentides
    private Integer termInYears;  // laenuperiood aastates
}
