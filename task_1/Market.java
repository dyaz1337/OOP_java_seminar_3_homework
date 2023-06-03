import java.util.LinkedList;
import java.util.Queue;

@FunctionalInterface
interface CustomerAction {
    void perform(String customer);
}

public class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<String> queue;
    private int capacity;
    private int numCustomers;

    public Market(int capacity) {
        this.queue = new LinkedList<String>();
        this.capacity = capacity;
        this.numCustomers = 0;
    }

    public boolean enqueue(String customer) {
        if (queue.size() < capacity) {
            queue.add(customer);
            numCustomers++;
            return true;
        } else {
            return false;
        }
    }

    public String dequeue() {
        if (!queue.isEmpty()) {
            numCustomers--;
            return queue.remove();
        } else {
            return null;
        }
    }

    public int getNumCustomers() {
        return numCustomers;
    }

    public void addCustomer(String customer) {
        enqueue(customer);
    }

    public void removeCustomer() {
        dequeue();
    }

    public void update() {
    }

    public void performActionOnCustomers(CustomerAction action) {
        for (String customer : queue) {
            action.perform(customer);
        }
    }
}

Market market = new Market(5);
market.addCustomer("Alice");
market.addCustomer("Bob");
market.addCustomer("Charlie");
market.performActionOnCustomers((customer) -> System.out.println(customer));