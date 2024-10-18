package MovieTicketBookingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShowSubject {
    ArrayList<Observer> observers;
    Map<Integer , Show> cache;
    Map<Integer , Show> movieShow = new HashMap<>();

    public ShowSubject() {
        cache = new HashMap<Integer, Show>();
        this.observers = new ArrayList<>();
    }

    public Show getShow(Integer showId) {
        return cache.get(showId);
    }

    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void addShow(int showId , int movieId , Cinema cinema , int screenIndex , long startTime , long endTime) {
        Show show = new Show(showId, movieId, cinema, screenIndex, startTime, endTime);
        cache.put(showId, show);
        movieShow.put(movieId, show);
        notifyAllObservers(show);
    }

    public void notifyAllObservers(Show show) {
        for(Observer observer : observers) {
            observer.update(show);
        }
    }

}
