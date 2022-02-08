package com.cole.asciiapp.repository;

import com.cole.asciiapp.model.Ascii;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsciiRepository extends JpaRepository<Ascii, Long> {
    List<Ascii> findByTitleContaining(String title);

}
