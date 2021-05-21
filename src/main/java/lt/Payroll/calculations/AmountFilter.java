//package lt.Payroll.calculations;
//
//import lt.Payroll.amounts.Amount;
//
//import java.lt.Payroll.time.LocalDate;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class AmountFilter {
//    private List<Amount> amountList;
//
//    public AmountFilter(List<Amount> amountList) {
//        this.amountList = amountList;
//    }
//
//    public List<Amount> getAmountsForPeriod(LocalDate fromDate, LocalDate toDate){
//        return amountList
//                .stream()
//                .filter(x -> x.getCalculationDate().isAfter(fromDate))
//                .filter(x -> x.getCalculationDate().isBefore(toDate))
//                .collect(Collectors.toList());
//    }




//}
