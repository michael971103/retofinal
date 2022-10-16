package usa.mintic.com.example.retofinal.Repository.CrudRepository;



import org.springframework.data.repository.CrudRepository;
import usa.mintic.com.example.retofinal.Entities.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
