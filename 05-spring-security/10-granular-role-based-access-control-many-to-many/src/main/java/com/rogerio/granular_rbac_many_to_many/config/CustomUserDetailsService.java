package com.rogerio.granular_rbac_many_to_many.config;

import com.rogerio.granular_rbac_many_to_many.Repository.UserRepository;
import com.rogerio.granular_rbac_many_to_many.model.AbstractUser;
import com.rogerio.granular_rbac_many_to_many.model.Privilege;
import com.rogerio.granular_rbac_many_to_many.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    AbstractUser user = userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

    return new org.springframework.security.core.userdetails.User(
        user.getEmail(),
        user.getPassword(),
        user.isEnabled(),
        true, true, true,
        getAuthorities(user.getRoles())
    );
  }

  private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
    Set<GrantedAuthority> authorities = new HashSet<>();

    for (Role role : roles) {
      authorities.add(new SimpleGrantedAuthority(role.getName()));

      for (Privilege privilege : role.getPrivileges()) {
        authorities.add(new SimpleGrantedAuthority(privilege.getName()));
      }
    }

    return authorities;
  }
}
