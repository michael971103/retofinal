package usa.mintic.com.example.retofinal.Repository.CrudRepository;



import org.springframework.data.repository.CrudRepository;
import usa.mintic.com.example.retofinal.Entities.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
