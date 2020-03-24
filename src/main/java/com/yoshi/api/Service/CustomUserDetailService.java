package com.yoshi.api.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yoshi.api.model.User;
import com.yoshi.api.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	private final UserRepository userRepository;

	@Autowired
	public CustomUserDetailService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = Optional.ofNullable(userRepository.findByUsername(username))
				.orElseThrow(()-> new UsernameNotFoundException(String.format("Usuário não existe!", username)));

		return new UserRepositoryUserDetails(user);
	}

	private final static class UserRepositoryUserDetails extends User implements UserDetails {

		private static final long serialVersionUID = 1L;

		private UserRepositoryUserDetails(User user) {
			super(user);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return getRoles();
		}

		@Override
		public String getUsername() {
			return this.getEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

		@Override
		public String getPassword() {
			return  super.getPassword();
		}

	}

}
