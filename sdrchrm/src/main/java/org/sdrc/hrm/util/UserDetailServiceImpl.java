package org.sdrc.hrm.util;

import java.util.HashSet;
import java.util.Set;

import org.sdrc.hrm.domain.EmployeeDetails;
import org.sdrc.hrm.domain.EmployeeRoleMapping;
import org.sdrc.hrm.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
        EmployeeDetails employee = employeeRepository.findByEmailIdAndIsLiveTrue(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        for (EmployeeRoleMapping empRoleMapping : employee.getEmployeeRoleMappings()){
            grantedAuthorities.add(new SimpleGrantedAuthority(empRoleMapping.getRoleId().getRoleName()));
        }

        return new org.springframework.security.core.userdetails.User(employee.getEmailId(), employee.getPassword(), grantedAuthorities);
	}

}
