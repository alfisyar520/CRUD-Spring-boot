package com.domain.crudapi;

import com.domain.crudapi.model.entities.User;
import com.domain.crudapi.model.repos.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace =  AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepo userRepo;


    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("asd@gmail.com");
//        user.setPassword("qwerty");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("qwerty");
        user.setPassword(encodedPassword);
        user.setFirstName("aaaahgfa");
        user.setLastName("zzzzzfd");

        System.out.println(user);

        User saveUser = userRepo.save(user);

        User existUser = entityManager.find(User.class, saveUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }

    @Test
    public void testFindUserByEmail(){
        String email = "alfi@gmail.com";

        User user = userRepo.findByEmail(email);

        assertThat(user).isNotNull();
    }
}

