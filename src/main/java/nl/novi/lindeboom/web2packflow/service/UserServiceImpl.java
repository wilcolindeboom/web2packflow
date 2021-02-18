package nl.novi.lindeboom.web2packflow.service;

import nl.novi.lindeboom.web2packflow.domain.User;
import nl.novi.lindeboom.web2packflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;


@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Collection<User> getUsers() {
           return userRepository.findAll();
        }


    //todo
}
// implements UserService, UserDetailsService {
//
//    UserRepository userRepository;
//
//    @Autowired
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username)  {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found: " + username));
//        return UserDetailsImpl.build(user);
//    }
//
//
//    @Override
//    public String createUser(User user) {
//        return null;
//    }
//
//    @Override
//    public void updateUser(String username, User user) {
//
//    }
//
//    @Override
//    public void deleteUser(String username) {
//
//    }
//
//    @Override
//    public Collection<User> getUsers() {
//        return null;
//    }
//
//    @Override
//    public Optional<User> getUser(String username) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<User> getUserByUsername(String username) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean userExists(String username) {
//        return false;
//    }
//
//    @Override
//    public Set<Role> getRoles(String username) {
//        return null;
//    }
//
//    @Override
//    public void addAuthority(String username, String authority) {
//
//    }
//
//    @Override
//    public void removeAuthority(String username, String authority) {
//
//    }
//}
