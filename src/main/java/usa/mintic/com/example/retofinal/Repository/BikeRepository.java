package usa.mintic.com.example.retofinal.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.com.example.retofinal.Entities.Bike;
import usa.mintic.com.example.retofinal.Repository.CrudRepository.BikeCrudRepository;

import java.util.List;
import java.util.Optional;

//author michael971103
@Repository
public class BikeRepository {
    @Autowired
    private BikeCrudRepository bikeCrudRepository;

    public List<Bike> getAll(){
        return (List<Bike>) bikeCrudRepository.findAll();
    }
    public Optional<Bike> getBike(int id){
        return bikeCrudRepository.findById(id);
    }

    public Bike save(Bike bike){
        return bikeCrudRepository.save(bike);
    }

    public void delete(Bike bike){
        bikeCrudRepository.delete(bike);
    }
}
