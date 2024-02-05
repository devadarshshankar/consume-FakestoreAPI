package dev.adarsh.productservice;

import dev.adarsh.productservice.inheritanceexamples.joinedtable.JT_MentorsRepository;
import dev.adarsh.productservice.inheritanceexamples.joinedtable.JT_UserRepository;
//import dev.adarsh.productservice.inheritanceexamples.joinedtable.Mentors;
//import dev.adarsh.productservice.inheritanceexamples.joinedtable.Users;
import dev.adarsh.productservice.inheritanceexamples.mappedsuperclass.MS_MentorsRepository;
//import dev.adarsh.productservice.inheritanceexamples.singleclass.Mentors;
import dev.adarsh.productservice.inheritanceexamples.singleclass.SC_MentorsRepository;
import dev.adarsh.productservice.inheritanceexamples.singleclass.SC_UserRepository;
//import dev.adarsh.productservice.inheritanceexamples.singleclass.Users;
import dev.adarsh.productservice.inheritanceexamples.tableperclass.Mentors;
import dev.adarsh.productservice.inheritanceexamples.tableperclass.TBC_MentorsRepository;
import dev.adarsh.productservice.inheritanceexamples.tableperclass.TBC_UserRepository;
import dev.adarsh.productservice.inheritanceexamples.tableperclass.Users;
import dev.adarsh.productservice.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {
//    @Autowired
//    JT_UserRepository userRepository;
//    @Autowired
//    JT_MentorsRepository mentorsRepository;
//    @Autowired
//    MS_MentorsRepository mentorsRepository;

//    @Autowired
//    SC_UserRepository userRepository;
//    @Autowired
//    SC_MentorsRepository mentorsRepository;
    @Autowired
    TBC_MentorsRepository mentorsRepository;
    @Autowired
    TBC_UserRepository userRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testDifferentInheritance(){
        Users user=new Users();
        user.setEmail("adarsh@shankar.in");
        user.setPassword("adarsh_sahnar");
        userRepository.save(user);

        Mentors mentors= new Mentors();
        mentors.setEmail("shankar@bacha.in");
        mentors.setPassword("shankar");
        mentors.setNumberOfMentees(12);
        mentors.setNumberOfSessions(22);
        mentorsRepository.save(mentors);
   }



}
