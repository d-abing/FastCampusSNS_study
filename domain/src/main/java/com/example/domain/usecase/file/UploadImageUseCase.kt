package com.example.domain.usecase.file

import com.example.domain.model.Image

interface UploadImageUseCase {
    suspend operator fun invoke(
        image: Image
    ): Result<String>
}