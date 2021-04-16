package com.br.erijhonson.springsecurityjwt.repositories;

import com.br.erijhonson.springsecurityjwt.models.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserProfile, Integer> {
    UserProfile findByUsername(String username);
}
