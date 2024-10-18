package MovieTicketBookingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CinemaManager {
    Map<Integer , Cinema> cache;

    public CinemaManager() {
        cache = new HashMap<Integer, Cinema>();
    }

    public Map<Integer , Cinema> getCache() {
        return cache;
    }

    public void addCinema(int cinemaId, int cityId,
                          int screenCount, int screenRow, int screenColumn) {

        Cinema cinema = new Cinema(cinemaId, cityId, screenCount, screenRow, screenColumn);
        this.cache.put(cinemaId, cinema);
    }
}
