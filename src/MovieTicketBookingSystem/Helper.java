package MovieTicketBookingSystem;

import java.util.List;

public class Helper {

    public void printNewCinemaDetail(Cinema cinema) {

        System.out.println("Cinema{" +
                    "cinemaId=" + cinema.getCinemaId() +
                    ", cityId=" + cinema.getCityId() +
                    ", screenCount=" + cinema.getScreenCount() +
                    ", screenRow=" + cinema.getScreenRow() +
                    ", screenCol=" + cinema.getScreenCol() +
                    '}');
    }

    public void printNewShowDetail(Show show) {

        System.out.println("Show{" +
                "showId=" + show.getShowId() +
                ", movieId=" + show.getMovieId() +
                ", screenIndex=" + show.getScreenIndex() +
                ", startTime=" + show.getStartTime() +
                ", endTime=" + show.getEndTime() +
                ", cinema=" + show.getCinema() +
                '}');
    }

    public void freeSeatsCount(int seatsCount) {
        if(seatsCount >= 0)
            System.out.println("Free seats count=" + seatsCount);
        else if(seatsCount < 0) {
            System.out.println("Show not valid");
        }
        else {
            System.out.println("No seats available");
        }
    }

    public void printAllShows(List<Integer> showIds) {
        System.out.println(showIds);
        for(Integer showId : showIds) {
            System.out.println("ShowId=" + showId);
        }
    }

    public void printAllCinemas(List<Integer> cinemaIds) {
        for(Integer cinemaId : cinemaIds) {
            System.out.println("CinemaId=" + cinemaId);
        }
    }
}
