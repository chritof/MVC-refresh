package com.buttonsNettbutikk.buttonsNettbutikk;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VareRepository extends JpaRepository<Vare, Integer> {}
