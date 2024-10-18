package MovieTicketBookingSystem;

public class Show {


    int showId;

    int movieId;

    int screenIndex;


    long startTime;

    long endTime;

    Cinema cinema;

    public Show(int showId, int movieId, Cinema cinema, int screenIndex, long startTime, long endTime) {
        this.showId = showId;
        this.movieId = movieId;
        this.cinema = cinema;
        this.screenIndex = screenIndex;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }


    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getScreenIndex() {
        return screenIndex;
    }

    public void setScreenIndex(int screenIndex) {
        this.screenIndex = screenIndex;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Cinema getCinema() {
        return cinema;
    }
}
