package functions.using.the.toolkit.model

data class Course(val id: String,
                  val title: String,
                  val courseType: CourseType,
                  val duration: Int,
                  val instructors: List<Trainer>)