package MovieTicketBookingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowLister implements Observer{

    Map<String , ArrayList<Show>> showListMap = new HashMap<>();

    List<Integer> listShows(int movieId , int cinemaId) {
        List<Integer> ans = new ArrayList<>();
        String key = movieId + "-" + cinemaId;
        ArrayList<Show> list = showListMap.get(key);
        if (list != null) {
            list.sort((a , b) -> a.getStartTime() > b.getStartTime() ? -1 : a.getStartTime() < b.getStartTime() ? 1 : a.getShowId() - b.getShowId());
            for(Show show : list) ans.add(show.getShowId());
        }
        return ans;
    }


    @Override
    public void update(Show show) {
        int movieId = show.getMovieId();
        int cinemaId = show.getCinema().getCinemaId();
        String key = movieId + "-" + cinemaId;
        showListMap.putIfAbsent(key , new ArrayList<>());
        showListMap.get(key).add(show);
    }
}
