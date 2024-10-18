package MovieTicketBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    ShowSubject showSubject;
    CinemaManager cinemaManager;
    BookTicket bookTicket;
    ShowLister showLister;
    CinemaLister cinemaLister;
    Helper helper;

    public void init(Helper helper) {
        this.showSubject = new ShowSubject();
        this.cinemaManager = new CinemaManager();
        this.bookTicket = new BookTicket();
        this.showLister = new ShowLister();
        this.cinemaLister = new CinemaLister();
        this.showSubject.registerObserver(this.showLister);
        this.showSubject.registerObserver(this.cinemaLister);
        this.helper = helper;
    }

    public void addCinema(int cinemaId, int cityId,
                          int screenCount, int screenRow, int screenColumn) {
        this.cinemaManager.addCinema(cinemaId, cityId, screenCount, screenRow, screenColumn);
        this.helper.printNewCinemaDetail(this.cinemaManager.getCache().get(cinemaId));
    }

    public void addShow(int showId , int movieId , int cinemaId , int screenIndex , long startTime , long endTime) {
        Cinema cinema = this.cinemaManager.cache.get(cinemaId);
        if(cinema == null) {
            System.out.println("Cinema Not Found");
            return;
        }
        this.showSubject.addShow(showId , movieId , cinema , screenIndex , startTime , endTime);
        this.helper.printNewShowDetail(this.showSubject.getShow(showId));
    }

    public List<String> bookTicket(String ticketId,
                                   int showId, int ticketsCount) {
        Show show = showSubject.cache.get(showId);
        if(show == null) {
            System.out.println("Show Not available");
            return null;
        }
        return this.bookTicket.bookTicket(ticketId , show , ticketsCount);
    }

    public boolean cancelTicket(String ticketId) {
        return this.bookTicket.cancelTicket(ticketId);
    }

    int getFreeSeatsCount(int showId) {
        Show show = this.showSubject.cache.get(showId);
        if(show == null) return -1;
        return this.bookTicket.getFreeSeatsCount(show);
    }

    List<Integer> listCinemas(int movieId , int cityId) {
        return cinemaLister.listCinemas(movieId , cityId);
    }

    List<Integer> listShows(int movieId , int cinemaId) {
        return showLister.listShows(movieId , cinemaId);
    }

}
