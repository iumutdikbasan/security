package sni.intern.security.service;

import sni.intern.security.domain.Role;
import sni.intern.security.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void  addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
