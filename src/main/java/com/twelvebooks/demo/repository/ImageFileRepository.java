package com.twelvebooks.demo.repository;

import com.twelvebooks.demo.domain.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {
}
