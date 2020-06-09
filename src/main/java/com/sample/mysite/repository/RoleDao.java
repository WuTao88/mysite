package com.sample.mysite.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.mysite.entity.Role;

public interface RoleDao extends JpaRepository<Role, Integer>{

	
}
