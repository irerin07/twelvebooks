package com.twelvebooks.twelvebook.service.implementation;

import com.twelvebooks.twelvebook.domain.ImageFile;
import com.twelvebooks.twelvebook.repository.ImageFileRepository;
import com.twelvebooks.twelvebook.service.ImageFileService;
import org.springframework.transaction.annotation.Transactional;

public class ImageFileServiceImpl implements ImageFileService {

    private ImageFileRepository imageFileRepository;

    @Transactional(readOnly = true)
    public ImageFile getImageFile(Long id) {
        return imageFileRepository.findById(id).get();

    }
}