package com.avdelingCRUDRepo.avdelingCRUDRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnsattRepo extends JpaRepository<Ansatt, Integer> {
    List<Ansatt> findAllByAvdelingId(int id);
    Ansatt findByNavn(String navn);
}
