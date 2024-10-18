package MovieTicketBookingSystem;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookTicket {
    Map<Integer , int[][]> seats = new HashMap<>();
    Map<String , List<String>> ticketListMap = new HashMap<>();
    Map<String , Booking> ticketBooking = new HashMap<>();
    int freeSeatsCount = 0;
    List<String> bookTicket(String ticketId,
                            Show show, int ticketsCount) {

        List<String> ans = new ArrayList<>();
        ticketBooking.put(ticketId , new Booking(ticketId , show , ticketsCount));
        Cinema cinema = show.getCinema();
        if(freeSeatsCount == 0) {
            int screenRow = show.getCinema().getScreenRow();
            int screenCol = show.getCinema().getScreenCol();
            freeSeatsCount = screenRow * screenCol;
            if(cinema.screenRow * cinema.screenCol < ticketsCount) {return null;}
        }
        else {
            if(ticketsCount >= freeSeatsCount) {return null;}
        }
        seats.putIfAbsent(show.getShowId() , new int[cinema.screenRow][cinema.screenCol]);
        int[][] hall = seats.get(show.getShowId());

        for(int i = 0; i < hall.length; i++) {
            for(int j = 0; j < hall[i].length; j++) {
                if(hall[i][j] != -1) {
                    ans.add(i +"-"+j);
                    hall[i][j] = -1;
                    ticketsCount--;
                    freeSeatsCount--;
                }
            }
            if(ticketsCount <= 0) {
                break;
            }
        }
        seats.put(show.getShowId(), hall);
        ticketListMap.put(ticketId , ans);
        return ans;
    }

    public boolean cancelTicket(String ticketId) {
        List<String> tickets = ticketListMap.get(ticketId);
        if(tickets == null) return false;
        int showId = ticketBooking.get(ticketId).getShow().getShowId();
        int[][] hall = seats.get(showId);
        for(int i = 0; i < tickets.size(); i++) {
            String[] seatNo = tickets.get(i).split("-");
            hall[Integer.parseInt(seatNo[0])][Integer.parseInt(seatNo[1])] = 0;
            freeSeatsCount++;
        }
        seats.put(showId, hall);
        ticketBooking.remove(ticketId);
        ticketListMap.remove(ticketId);
        return true;
    }

    public int getFreeSeatsCount(Show show) {
        if(freeSeatsCount == 0) {
            int screenRow = show.getCinema().getScreenRow();
            int screenCol = show.getCinema().getScreenCol();
            return screenRow * screenCol;
        }
        return freeSeatsCount;
    }
}
