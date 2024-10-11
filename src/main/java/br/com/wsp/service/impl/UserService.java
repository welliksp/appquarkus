package br.com.wsp.service.impl;

import br.com.wsp.entity.User;
import br.com.wsp.exception.UserNotFoundException;
import br.com.wsp.service.IUserService;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService implements IUserService {


    @Override
    public User save(User user) {

        User.persist(user);

        return user;
    }

    @Override
    public List<User> findAll(Integer page, Integer pageSize) {

        return User.findAll()
                .page(page, pageSize)
                .list();
    }

    @Override
    public User findById(UUID id) {
        return (User) User.findByIdOptional(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User update(UUID id, User user) {

        var userFound = findById(id);

        userFound.username = user.username;

        User.persist(userFound);

        return userFound;
    }

    @Override
    public void deleteById(UUID id) {

        User user = findById(id);

        User.deleteById(user.id);

    }


}
