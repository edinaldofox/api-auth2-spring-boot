package com.yoshi.api.config.dataInitializr;

import com.yoshi.api.constant.RoleConst;
import com.yoshi.api.model.Role;
import com.yoshi.api.model.User;
import com.yoshi.api.repository.RoleRepository;
import com.yoshi.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UsuarioInitializr implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {

        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            createUser("Admin", "admin", passwordEncoder.encode("123"), RoleConst.ROLE_ADMIN);
            createUser("Cliente", "cliente", passwordEncoder.encode("123"), RoleConst.ROLE_CLIENT);
        }

    }

    public void createUser(String name, String email, String password, String roleName) {

        Role role = new Role(roleName);

        this.roleRepository.save(role);
        User user = new User(name, email, password, Arrays.asList(role));
        userRepository.save(user);
    }
}
