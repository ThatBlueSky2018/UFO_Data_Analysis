package com.yhls.persistence;

import com.yhls.pojo.Role;
import com.yhls.pojo.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role,Integer> {

    Role findByRoleName(RoleName roleName);


}
