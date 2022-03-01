package com.sama.timinglyApi.domain.project

import com.sama.timinglyApi.entity.BaseEntity
import org.hibernate.envers.Audited
import java.util.*
import javax.persistence.Entity
import javax.persistence.Table

@Table(name = "projects")
@Entity
@Audited
data class ProjectEntity(
    val userId: UUID,

    val projectName: String,

    val projectDescription: String?,

    val isDeleted: Boolean
) : BaseEntity() {
    companion object {
        fun from(project: Project): ProjectEntity {
            return ProjectEntity(
                userId = project.userId,
                projectName = project.projectName,
                projectDescription = project.projectDescription,
                isDeleted = project.isDeleted
            )
        }
    }
}
