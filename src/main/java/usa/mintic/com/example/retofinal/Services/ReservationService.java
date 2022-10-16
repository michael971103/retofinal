package usa.mintic.com.example.retofinal.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.com.example.retofinal.Entities.Reservation;
import usa.mintic.com.example.retofinal.Repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
            if (e.isPresent()) {
                return reservation;
            } else {
                return reservationRepository.save(reservation);
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> q = reservationRepository.getReservation(reservation.getIdReservation());
            if(q.isPresent()){
                if (reservation.getStartDate() != null) {
                    q.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate()!= null) {
                    q.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getScore() != null) {
                    q.get().setScore(reservation.getScore());
                }
                if (reservation.getBike() != null) {
                    q.get().setBike(reservation.getBike());
                }
                if (reservation.getClient() != null) {
                    q.get().setClient(reservation.getClient());
                }
                reservationRepository.save(q.get());
                return q.get();
            } else {
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation> p = reservationRepository.getReservation(id);
        if(p.isPresent()){
            reservationRepository.delete(p.get());
            flag = true;
        }
        return flag;
    }
}

