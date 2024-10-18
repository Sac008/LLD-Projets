package MovieTicketBookingSystem;

public class Booking {

    String ticketId;

    Show show;

    int ticketsCount;

    public Booking(String ticketId, Show show, int ticketsCount) {
        this.ticketId = ticketId;
        this.show = show;
        this.ticketsCount = ticketsCount;
    }


    public int getTicketsCount() {
        return ticketsCount;
    }

    public void setTicketsCount(int ticketsCount) {
        this.ticketsCount = ticketsCount;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }



}
