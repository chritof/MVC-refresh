package com.bokliste2.bokliste2.repository;

import com.bokliste2.bokliste2.model.Bok;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BokRepo extends JpaRepository<Bok, Integer> {
}
