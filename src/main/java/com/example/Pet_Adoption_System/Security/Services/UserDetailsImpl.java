// package com.example.Pet_Adoption_System.Security.Services;

// import java.util.Collection;
// import java.util.List;
// import java.util.Objects;
// import java.util.stream.Collectors;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// //import org.springframework.security.core.userdetails.UserDetailsService;


// import com.example.Pet_Adoption_System.Model.User;
// import com.fasterxml.jackson.annotation.JsonIgnore;

// public class UserDetailsImpl implements UserDetails {
// 	private static final long serialVersionUID = 1L;

// 	private String id;

// 	private String username;

// 	private String email;

// 	@JsonIgnore
// 	private String password;

//     @JsonIgnore
//     private String confirmPassword;

// 	private Collection<? extends GrantedAuthority> authorities;

// 	public UserDetailsImpl(String id, String username, String email, String password, String confirmPassword,
// 			Collection<? extends GrantedAuthority> authorities) {
// 		this.id = id;
// 		this.username = username;
// 		this.email = email;
// 		this.password = password;
//         this.confirmPassword = confirmPassword;
//         this.authorities = authorities;
// 	}

// 	public static UserDetailsImpl build(User user) {
// 		List<GrantedAuthority> authorities = user.getRoles().stream()
// 				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
// 				.collect(Collectors.toList());

// 		return new UserDetailsImpl(
// 				user.getId(), 
// 				user.getName(), 
// 				user.getEmail(),
// 				user.getPassword(), 
//                 user.getConfirmPassword(),
// 				authorities);
// 	}

// 	@Override
// 	public Collection<? extends GrantedAuthority> getAuthorities() {
// 		return authorities;
// 	}

// 	public String getId() {
// 		return id;
// 	}

// 	public String getEmail() {
// 		return email;
// 	}

// 	@Override
// 	public String getPassword() {
// 		return password;
// 	}

// 	public String getUsername() {
// 		return username;
// 	}

//     public String getConfirmPassword() {
//         return confirmPassword;
//     }

// 	@Override
// 	public boolean isAccountNonExpired() {
// 		return true;
// 	}

// 	@Override
// 	public boolean isAccountNonLocked() {
// 		return true;
// 	}

// 	@Override
// 	public boolean isCredentialsNonExpired() {
// 		return true;
// 	}

// 	@Override
// 	public boolean isEnabled() {
// 		return true;
// 	}

// 	@Override
// 	public boolean equals(Object o) {
// 		if (this == o)
// 			return true;
// 		if (o == null || getClass() != o.getClass())
// 			return false;
// 		UserDetailsImpl user = (UserDetailsImpl) o;
// 		return Objects.equals(id, user.id);
// 	}




// }

