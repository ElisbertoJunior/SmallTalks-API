package com.tahto.smallTalks.repository;

import com.tahto.smallTalks.entity.Salutation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalutationRepository extends JpaRepository<Salutation, Long> {
}
