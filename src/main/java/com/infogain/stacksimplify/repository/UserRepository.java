package com.infogain.stacksimplify.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infogain.stacksimplify.entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
