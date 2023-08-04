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

        Role role1 = iRoleRepository.findByRoleName(RoleName.ADMIN);
        User user1 = iUserRepository.findByEmail("YangKaiwen@ufo.com").orElse(null);
        user1.getRoles().add(role1);
        userService.saverUser(user1);

        Role role2 = iRoleRepository.findByRoleName(RoleName.ADMIN);
        User user2 = iUserRepository.findByEmail("HanYue@ufo.com").orElse(null);
        user2.getRoles().add(role2);
        userService.saverUser(user2);

        Role role3 = iRoleRepository.findByRoleName(RoleName.ADMIN);
        User user3 = iUserRepository.findByEmail("LanMingang@ufo.com").orElse(null);
        user3.getRoles().add(role3);
        userService.saverUser(user3);

        Role role4 = iRoleRepository.findByRoleName(RoleName.ADMIN);
        User user4 = iUserRepository.findByEmail("SongKunyu@ufo.com").orElse(null);
        user4.getRoles().add(role4);
        userService.saverUser(user4);

        User user5 = iUserRepository.findByEmail("SongKunyu@ufo.com").orElse(null);
        Role role5 = iRoleRepository.findByRoleName(RoleName.SUPERADMIN);
        user5.getRoles().add(role5);
        userService.saverUser(user5);

    };}

}
