package com.users.service.user.role;


import com.users.model.Role;

import java.util.List;

public interface IRoleService {



    Role findRole(Long id);
    Role findRole(String name);

    List<Role> findListRole();
    List<Role> findListRole(String name);
    List<Role> findListRole(Long id);
}
