/**
 * 
 */
package com.cognizant9.UserProfileService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant9.UserProfileService.entity.Role;

/**
 * @author mohit
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{

	/**
	 * @param string
	 * @return
	 */
	Role findByRoleName(String string);
	

}
