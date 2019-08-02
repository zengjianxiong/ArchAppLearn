package com.zeng.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher

class AppDispatchers(val main: MainCoroutineDispatcher, val io: CoroutineDispatcher)
