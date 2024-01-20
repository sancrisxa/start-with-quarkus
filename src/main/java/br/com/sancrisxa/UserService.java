package br.com.sancrisxa;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;

import java.util.*;

@ApplicationScoped
public class UserService {

    Set<User> users = Collections.synchronizedSet(new LinkedHashSet<>());
    public Set<User> getUsers () {
        users.add(new User(UUID.randomUUID(), "Mariana"));
        users.add(new User(UUID.randomUUID(), "Daniel"));
        users.add(new User(UUID.randomUUID(), "Carol"));
        users.add(new User(UUID.randomUUID(), "Manoel"));

        return users;
    }

    public Optional<User> getUserByName(String name) {
        var findUser = this.users.stream().filter(user -> user.getName().equals(name));
        return findUser.findFirst();
    }
}
