package com.instil.courses.model

import kotlinx.serialization.Serializable

@Serializable
class Course(var id: String, var title: String, var difficulty: CourseDifficulty, var duration: Int)
