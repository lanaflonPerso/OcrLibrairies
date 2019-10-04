package com.libraries.service.user.role;



import com.libraries.model.Role;

import java.util.List;

public interface IRoleService {



    Role findRole(Long id);
    Role findRole(String name);

    List<Role> findListRole();
    List<Role> findListRole(String name);
    List<Role> findListRole(Long id);
}
