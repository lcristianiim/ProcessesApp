package com.example.repo;

import com.example.model.App;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by internship on 15.09.2016.
 */
public interface AppRepo extends CrudRepository<App, Long> {
    @Query("select a from App a where a.processName = :processName")
    public List<App> checkIfAppExists(@Param("processName") String processName);

    @Query("select a from App a where a.processName = :processName")
    public List<App> findByProcessName(@Param("processName") String processName);

}
