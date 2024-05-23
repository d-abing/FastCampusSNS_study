package com.example.domain.usecase.file

import com.example.domain.model.Image

interface GetImageUseCase {

    operator fun invoke(contentUri: String): Image?
}