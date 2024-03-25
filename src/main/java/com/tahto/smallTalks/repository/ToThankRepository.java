package com.tahto.smallTalks.repository;

import com.tahto.smallTalks.entity.ToThank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToThankRepository extends JpaRepository<ToThank, Long> {

}
