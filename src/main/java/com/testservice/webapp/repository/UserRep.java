package com.testservice.webapp.repository;

import com.testservice.webapp.entity.WebUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRep extends CrudRepository<WebUser, Integer> {

    List<WebUser> getDistinctByIsAdmin(boolean isAdmin);

    WebUser getById(int id);

    WebUser getByUsername(String username);

    WebUser getByIdAndUsername(int id, String username);

    boolean existsWebUserByUsername(String username);

    boolean existsWebUserByEmail(String email);
}
