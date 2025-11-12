package com.bokliste2.bokliste2.repository;

import com.bokliste2.bokliste2.model.Bok;
import com.bokliste2.bokliste2.model.Forfatter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForfatterRepo extends JpaRepository<Forfatter, Integer> {
}
