/**
 * 
 */
package com.cognizant9.UserProfileService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant9.UserProfileService.entity.Role;
import com.cognizant9.UserProfileService.repository.RoleRepository;

/**
 * @author mohit
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepo;
	public Role createNewRole(Role role) {
		return roleRepo.save(role);
	}

}
