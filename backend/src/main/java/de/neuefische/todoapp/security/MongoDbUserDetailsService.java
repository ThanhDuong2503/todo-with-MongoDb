package de.neuefische.todoapp.security;
import de.neuefische.todoapp.db.UserDb;
import de.neuefische.todoapp.model.PlanningUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MongoDbUserDetailsService implements UserDetailsService {

    private final UserDb userDb;

    @Autowired
    public MongoDbUserDetailsService(UserDb userDb) {
        this.userDb = userDb;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<PlanningUser> optionalUser = userDb.findById(username);
        if (optionalUser.isEmpty()){
            throw new UsernameNotFoundException("user with username: \""+username+"\" not found");
        }

        PlanningUser planningUser = optionalUser.get();

        return new User(planningUser.getUsername(), planningUser.getPassword(), List.of(new SimpleGrantedAuthority("admin")));
    }
}