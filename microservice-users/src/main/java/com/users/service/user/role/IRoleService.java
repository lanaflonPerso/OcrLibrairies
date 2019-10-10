package com.users.service.user.role;


import com.users.model.user.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll();
    void save(Role role);

    Role findRole(Long id);
    Role findRole(String name);

    List<Role> findListRole();
}
