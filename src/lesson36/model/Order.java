package lesson36.model;

import java.util.Date;

public class Order extends Entity implements Comparable<Order> {

    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    public Order(long id, User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        super(id);
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public Order(User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public Order() {
    }

    public void setId(long id) {
        super.setId(id);
    }

    public long getId() {
        return super.getId();
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    @Override
    public String toString() {
        return super.getId() + "," + '\t' + user.getId() + "," + '\t' + room.getId() + "," + '\t'
                + dateFrom.getDate() + "-" + (dateFrom.getMonth() + 1) + "-" + (dateFrom.getYear() + 1900) + "," + '\t'
                + dateTo.getDate() + "-" + (dateTo.getMonth() + 1) + "-" + (dateTo.getYear() + 1900) + "," + '\t'
                + moneyPaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (Double.compare(order.moneyPaid, moneyPaid) != 0) return false;
        if (!user.equals(order.user)) return false;
        if (!room.equals(order.room)) return false;
        if (!dateFrom.equals(order.dateFrom)) return false;
        return dateTo.equals(order.dateTo);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = user.hashCode();
        result = 31 * result + room.hashCode();
        result = 31 * result + dateFrom.hashCode();
        result = 31 * result + dateTo.hashCode();
        temp = Double.doubleToLongBits(moneyPaid);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public int compareTo(Order o) {
        if (!this.dateFrom.equals(o.getDateFrom())) {
            return this.dateFrom.compareTo(o.getDateFrom());
        }
        if (!this.getUser().equals(o.getUser())) {
            return this.getUser().compareTo(o.getUser());
        }
        return 0;
    }

    public boolean canBeAdd() {
        if (user != null &&
                room != null &&
                dateFrom != null &&
                dateTo != null) {
            return true;
        }
        return false;
    }

}
