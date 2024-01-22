package study.cursach.services;

import org.springframework.stereotype.Service;
import study.cursach.entity.Admin;
import study.cursach.repo.AdminRepository;

import java.util.List;

@Service
public class AuthService {
    AdminRepository adminRepository;

    public AuthService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public boolean auth(String login, String pass){
        List<Admin> results = adminRepository.findByLogin(login);
        for (Admin admin: results){
            if (admin.getLogin().equals(login) && admin.getPass().equals(pass)) {
                return true;
            }
        }
        return false;
    }
}
