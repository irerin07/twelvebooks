package com.twelvebooks.demo.repository;

import com.twelvebooks.demo.domain.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
}
