package MovieTicketBookingSystem;

public class Cinema {

    int cinemaId;

    int cityId;

    int screenCount;

    int screenRow;

    int screenCol;

    public Cinema(int cinemaId, int cityId, int screenCount, int screenRow, int screenCol) {
        this.cinemaId = cinemaId;
        this.cityId = cityId;
        this.screenCount = screenCount;
        this.screenRow = screenRow;
        this.screenCol = screenCol;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getScreenCount() {
        return screenCount;
    }

    public void setScreenCount(int screenCount) {
        this.screenCount = screenCount;
    }

    public int getScreenRow() {
        return screenRow;
    }

    public void setScreenRow(int screenRow) {
        this.screenRow = screenRow;
    }

    public int getScreenCol() {
        return screenCol;
    }

    public void setScreenCol(int screenCol) {
        this.screenCol = screenCol;
    }

}
