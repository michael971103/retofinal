package usa.mintic.com.example.retofinal.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.com.example.retofinal.Entities.Admin;
import usa.mintic.com.example.retofinal.Repository.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin) {
        if (admin.getId() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> e = adminRepository.getAdmin(admin.getId());
            if (e.isPresent()) {
                return admin;
            } else {
                return adminRepository.save(admin);
            }
        }
    }

    public Admin update(Admin admin){
        if(admin.getId()!=null){
            Optional<Admin> q = adminRepository.getAdmin(admin.getId());
            if(q.isPresent()){
                if (admin.getName() != null) {
                    q.get().setName(admin.getName());
                }
                if (admin.getEmail() != null) {
                    q.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null) {
                    q.get().setPassword(admin.getPassword());
                }
                adminRepository.save(q.get());
                return q.get();
            } else {
                return admin;
            }
        }else{
            return admin;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Admin> p = adminRepository.getAdmin(id);
        if(p.isPresent()){
            adminRepository.delete(p.get());
            flag = true;
        }
        return flag;
    }
}
