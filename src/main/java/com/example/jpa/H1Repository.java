package com.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface H1Repository extends JpaRepository<H1, Long> {
}
