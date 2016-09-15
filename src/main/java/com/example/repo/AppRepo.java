package com.example.repo;

import com.example.model.App;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by internship on 15.09.2016.
 */
public interface AppRepo extends CrudRepository<App, Long> {

}
