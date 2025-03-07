// package com.example.Pet_Adoption_System.Security.Services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.example.Pet_Adoption_System.Model.User;
// import com.example.Pet_Adoption_System.Repository.UserRepository;

// @Service
// public class UserDetailsServiceImpl implements UserDetailsService {
//     @Autowired
//     UserRepository userRepository;

//     @Override
//     @Transactional
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         // Changed to use name instead of email for authentication
//         User user = userRepository.findByName(username);
//         if (user == null) {
//             throw new UsernameNotFoundException("User Not Found with username: " + username);
//         }

//         return UserDetailsImpl.build(user);
//     }
// }