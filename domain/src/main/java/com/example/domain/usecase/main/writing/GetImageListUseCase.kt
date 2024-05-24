package com.example.domain.usecase.main.writing

import com.example.domain.model.Image

interface GetImageListUseCase {
    suspend operator fun invoke(): List<Image>
}