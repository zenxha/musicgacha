package com.musicgacha.controllers.database.upload;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository<Upload, Long> {
}