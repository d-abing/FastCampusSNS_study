package com.example.practice

import javax.inject.Inject

interface Engine

class GasolineEngine @Inject constructor(): Engine

class DieselEngine @Inject constructor(): Engine
