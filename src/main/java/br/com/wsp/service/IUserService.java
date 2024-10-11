package br.com.wsp.service;

import br.com.wsp.entity.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    User save(User user);

    List<User> findAll(Integer page, Integer pageSize);

    User findById(UUID id);

    User update(UUID id, User user);

    void deleteById(UUID id);
}
