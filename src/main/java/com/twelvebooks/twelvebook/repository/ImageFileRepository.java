package com.twelvebooks.twelvebook.repository;

import com.twelvebooks.twelvebook.domain.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {
}
