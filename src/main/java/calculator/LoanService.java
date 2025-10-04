package calculator;

public class LoanService {
    public LoanResponse calculateLoan(LoanRequest requestFromClient) {

        double amount = requestFromClient.getAmount() == null ? 0 : requestFromClient.getAmount();
        double yearlyRate = requestFromClient.getYearlyRate() == null ? 0 : requestFromClient.getYearlyRate();
        int termInYears = requestFromClient.getTermInYears() == null ? 0 : requestFromClient.getTermInYears();

        if (!checkValidity(amount, yearlyRate, termInYears)) {
            throw new IllegalArgumentException("Invalid loan request parameters");
        }

        double monthlyRate = yearlyRate / 12 / 100;
        int months = termInYears * 12;

        // fixed intress loan formula like study loan, car loan, home loan
        double monthlyPayment = (amount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
        double totalPayment = monthlyPayment * months;
        double totalInterest = totalPayment - amount;

        return new LoanResponse(monthlyPayment, totalPayment, totalInterest);
    }

    public boolean checkValidity(double amount, double yearlyRate, int termInYears) {
        if (amount < 100 || amount > 10000) {
            throw new IllegalArgumentException("‼️ Amount must be between 100 and 1 000 000 ‼️");
        }
        if (yearlyRate < 5 || yearlyRate > 15) {
            throw new IllegalArgumentException("‼️ Yearly rate must be between 5% and 30% ‼️");
        }
        if (termInYears < 1 || termInYears > 30) {
            throw new IllegalArgumentException("‼️ Term must be between 1 and 30 years ‼️");
        }

        return true;
    }
}
