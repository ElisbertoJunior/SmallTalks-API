package com.tahto.smallTalks.repository;

import com.tahto.smallTalks.entity.Swearing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwearingRepository extends JpaRepository<Swearing, Long> {

}
