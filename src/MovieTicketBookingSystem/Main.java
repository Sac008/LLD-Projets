package MovieTicketBookingSystem;

public class Main {

    public static void main(String[] args) {
        ShowSubject showSubject = new ShowSubject();
        CinemaManager cinemaManager = new CinemaManager();
        BookTicket bookTicket = new BookTicket();
        Solution solution = new Solution();
        Helper helper = new Helper();
        solution.init(helper);
        solution.addCinema(1 , 2 , 4 , 10 , 10);
        solution.addShow(5 , 3 , 1, 3 , 1710516108725L , 1710523308725L);
        System.out.println(solution.bookTicket("tkt165" , 5 , 80));
        System.out.println(solution.bookTicket("tkt168" , 5 , 5));
        System.out.println(solution.cancelTicket("tkt166"));
        helper.freeSeatsCount(solution.getFreeSeatsCount(6));
        solution.addShow(1 , 3 , 1, 4 , 1710516108800L , 1710523308900L);
        helper.printAllShows(solution.listShows(3 , 1));
        helper.printAllCinemas(solution.listCinemas(3 , 2));
    }
}