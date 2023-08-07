package com.yhls;

import com.yhls.persistence.IRoleRepository;
import com.yhls.persistence.IUserRepository;
import com.yhls.pojo.Role;
import com.yhls.pojo.RoleName;
import com.yhls.pojo.User;
import com.yhls.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@MapperScan("com.yhls.mapper")
public class UfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UfoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService , IRoleRepository iRoleRepository , IUserRepository iUserRepository , PasswordEncoder passwordEncoder)
    {return  args ->
    {   userService.saveRole(new Role(RoleName.USER));
        userService.saveRole(new Role(RoleName.ADMIN));
        userService.saveRole(new Role(RoleName.SUPERADMIN));
        userService.saverUser(new User("YangKaiwen@ufo.com", passwordEncoder.encode("NKcs123456"), new ArrayList<>()));
        userService.saverUser(new User("HanYue@ufo.com", passwordEncoder.encode("NKcs123456"), new ArrayList<>()));
        userService.saverUser(new User("LanMingang@ufo.com",passwordEncoder.encode("NKcs123456"),new ArrayList<>()));
        userService.saverUser(new User("SongKunyu@ufo.com",passwordEncoder.encode("NKcs123456"),new ArrayList<>()));

        Role user = iRoleRepository.findByRoleName(RoleName.USER);
        Role admin = iRoleRepository.findByRoleName(RoleName.ADMIN);
        Role superAdmin = iRoleRepository.findByRoleName(RoleName.SUPERADMIN);


        User user1 = iUserRepository.findByEmail("YangKaiwen@ufo.com").orElse(null);
        user1.getRoles().add(user);
        user1.getRoles().add(admin);
        userService.saverUser(user1);

        User user2 = iUserRepository.findByEmail("HanYue@ufo.com").orElse(null);
        user2.getRoles().add(user);
        user2.getRoles().add(admin);
        userService.saverUser(user2);

        User user3 = iUserRepository.findByEmail("LanMingang@ufo.com").orElse(null);
        user3.getRoles().add(user);
        user3.getRoles().add(admin);
        userService.saverUser(user3);

        User user4 = iUserRepository.findByEmail("SongKunyu@ufo.com").orElse(null);
        user4.getRoles().add(user);
        user4.getRoles().add(admin);
        user4.getRoles().add(superAdmin);
        userService.saverUser(user4);
    };}

}
