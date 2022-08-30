package patterns;

//abstract class TaxPayer {
//    public long income; // in cents
//    public TaxPayer(long income) { this.income = income; }
//    public long getIncome() { return income; }
//}
//class Person extends TaxPayer {
//    public Person(long income) { super(income); }
//}
//class Trust extends TaxPayer {
//    private boolean nonProfit;
//    public Trust(long income, boolean nonProfit) {
//        super(income); this.nonProfit = nonProfit;
//    }
//    public boolean isNonProfit() { return nonProfit; }
//}
//interface TaxStrategy<P extends TaxPayer> {
//    long computeTax(P p);
//}
//class DefaultTaxStrategy<P extends TaxPayer> implements TaxStrategy<P> {
//    private static final double RATE = 0.40;
//    public long computeTax(P payer) {
//        return Math.round(payer.getIncome() * RATE);
//    }
//}
//class DodgingTaxStrategy<P extends TaxPayer> implements TaxStrategy<P> {
//    public long computeTax(P payer) { return 0; }
//}
//class TrustTaxStrategy extends DefaultTaxStrategy<Trust> {
//    public long computeTax(Trust trust) {
//        return trust.isNonProfit() ? 0 : super.computeTax(trust);
//    }
//}

abstract class TaxPayer<P extends TaxPayer<P>> {
    public long income; // in cents
    private TaxStrategy<P> strategy;
    public TaxPayer(long income, TaxStrategy<P> strategy) {
        this.income = income; this.strategy = strategy;
    }
    protected abstract P getThis();
    public long getIncome() { return income; }
    public long computeTax() { return strategy.computeTax(getThis()); }
}
class Person extends TaxPayer<Person> {
    public Person(long income, TaxStrategy<Person> strategy) {
        super(income, strategy);
    }
    protected Person getThis() { return this; }
}
class Trust extends TaxPayer<Trust> {
    private boolean nonProfit;
    public Trust(long income, boolean nonProfit, TaxStrategy<Trust> strategy){
        super(income, strategy); this.nonProfit = nonProfit;
    }
    protected Trust getThis() { return this; }
    public boolean isNonProfit() { return nonProfit; }
}
interface TaxStrategy<P extends TaxPayer<P>> {
    public long computeTax(P p);
}
class DefaultTaxStrategy<P extends TaxPayer<P>> implements TaxStrategy<P> {
    private static final double RATE = 0.40;
    public long computeTax(P payer) {
        return Math.round(payer.getIncome() * RATE);
    }
}
class DodgingTaxStrategy<P extends TaxPayer<P>> implements TaxStrategy<P> {
    public long computeTax(P payer) { return 0; }
}
class TrustTaxStrategy extends DefaultTaxStrategy<Trust> {
    public long computeTax(Trust trust) {
        return trust.isNonProfit() ? 0 : super.computeTax(trust);
    }
}