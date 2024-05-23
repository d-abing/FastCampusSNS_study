package com.example.domain.usecase.file

import java.io.InputStream

interface GetInputStreamUseCase {
    operator fun invoke(contentUri: String): Result<InputStream>
}