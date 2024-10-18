package MovieTicketBookingSystem;

import java.util.*;

public class CinemaLister implements Observer {
    Map<String , TreeSet<Integer>> cinemaList = new HashMap<>();


    List<Integer> listCinemas(int movieId , int cityId) {
        List<Integer> ans = new ArrayList<>();
        TreeSet<Integer> set = cinemaList.get(movieId + "-" + cityId);
        if (set != null) {
            ans.addAll(set);
        }
        return ans;
    }


    @Override
    public void update(Show show) {
        int movieId = show.getMovieId();
        int cityId = show.getCinema().getCityId();
        cinemaList.putIfAbsent(movieId + "-" + cityId , new TreeSet<Integer>());
        cinemaList.get(movieId + "-" + cityId).add(show.getCinema().getCinemaId());
    }
}































// Check why ShowLister and CinemaLister are returning NULL: even though show and cinema already added



























