import java.util.Iterator;

public class MarketIterator implements Iterator<String> {
    private Market market;

    public MarketIterator(Market market) {
        this.market = market;
    }

    @Override
    public boolean hasNext() {
        return market.getNumCustomers() > 0;
    }

    @Override
    public String next() {
        return market.dequeue();
    }
}

Market market = new Market(5);
market.addCustomer("Alice");
market.addCustomer("Bob");
market.addCustomer("Charlie");

Iterator<String> iterator = new MarketIterator(market);
while (iterator.hasNext()) {
    string customer = iterator.next();
    System.out.println(customer);
}