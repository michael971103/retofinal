package usa.mintic.com.example.retofinal.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.com.example.retofinal.Entities.Score;
import usa.mintic.com.example.retofinal.Repository.CrudRepository.ScoreCrudRepository;

import java.util.List;
import java.util.Optional;

//author michael971103
@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }

    public Score save(Score score){
        return scoreCrudRepository.save(score);
    }
    public void delete(Score score){
        scoreCrudRepository.delete(score);
    }
}
