package com.carreer.vinylTracker.repositories;

import com.carreer.vinylTracker.models.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<Creator, Long> {
}
