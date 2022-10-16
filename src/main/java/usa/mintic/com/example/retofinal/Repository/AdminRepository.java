package usa.mintic.com.example.retofinal.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.com.example.retofinal.Entities.Admin;
import usa.mintic.com.example.retofinal.Repository.CrudRepository.AdminCrudRepository;

import java.util.List;
import java.util.Optional;

//author michael971103
@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }

    public Admin save(Admin admin){
        return adminCrudRepository.save(admin);
    }

    public void delete(Admin admin){
        adminCrudRepository.delete(admin);
    }
}
