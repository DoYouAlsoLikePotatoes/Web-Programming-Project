package sen3004.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import sen3004.project.dao.UserRepository;
import sen3004.project.model.UserData;

@Service
@Transactional
public class ProjectService {
    
    @Autowired
    private UserRepository userRepository;

    public List<UserData> findAllData(){
        return userRepository.findAll();
    }

    public UserData findUserById(long id){
        return userRepository.findById(id).get();
    }

    public void saveUserData(UserData data){
        userRepository.save(data);
    }

    public void deleteUserData(UserData data){
        userRepository.delete(data);
    }
}
