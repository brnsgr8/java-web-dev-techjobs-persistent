package org.launchcode.javawebdevtechjobspersistent.data;

import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPRepository extends CrudRepository<Job, Integer> {
}
