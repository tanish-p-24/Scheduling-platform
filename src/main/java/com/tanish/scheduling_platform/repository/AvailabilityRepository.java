package com.tanish.scheduling_platform.repository;

import com.tanish.scheduling_platform.model.Availability;
import com.tanish.scheduling_platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByUser(User user);
}