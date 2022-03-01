package com.sama.timinglyApi.domain.user

import com.sama.timinglyApi.entity.BaseEntity
import org.hibernate.envers.Audited
import java.util.*
import javax.persistence.Entity
import javax.persistence.Table

@Table(name = "users")
@Entity
@Audited
class UserEntity(

    val firstName: String,

    val lastName: String,
) : BaseEntity() {
    companion object {
        fun from(user: User): UserEntity {
            return UserEntity(
                firstName = user.firstName,
                lastName = user.lastName
            )
        }
    }
}
