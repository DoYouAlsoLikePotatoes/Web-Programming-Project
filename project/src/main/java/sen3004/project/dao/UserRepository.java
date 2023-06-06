package sen3004.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sen3004.project.model.UserData;

public interface UserRepository extends JpaRepository<UserData, Long> {

}
