//package com.domain.crudapi.controllers;
//
//import com.domain.crudapi.model.entities.User;
//import com.domain.crudapi.model.repos.UserRepo;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace =  AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class UserRepoTest {
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private UserRepo userRepo;
//
//
//    @Test
//    public void testCreateUser(){
//        User user = new User();
//        user.setEmail("alfi@gmail.com");
//        user.setPassword("qwerty");
//        user.setFirstName("alfi");
//        user.setLastName("prana");
//
//        System.out.println(user);
//
////        User saveUser = userRepo.save(user);
////
////        User existUser = entityManager.find(User.class, saveUser.getId());
////
////        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
//
//    }
//}
