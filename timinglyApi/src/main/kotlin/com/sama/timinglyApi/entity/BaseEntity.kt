package com.sama.timinglyApi.entity

import com.vladmihalcea.hibernate.type.array.StringArrayType
import com.vladmihalcea.hibernate.type.array.UUIDArrayType
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import org.hibernate.annotations.UpdateTimestamp
import org.hibernate.envers.Audited
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant
import java.util.UUID
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@Audited
@MappedSuperclass
@TypeDefs(
    TypeDef(name = "jsonb", typeClass = JsonBinaryType::class),
    TypeDef(name = "uuid-array", typeClass = UUIDArrayType::class),
    TypeDef(name = "string-array", typeClass = StringArrayType::class)
)
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: UUID = UUID.randomUUID(),

    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    val createdTime: Instant = Instant.now(),

    @Column(nullable = false)
    @UpdateTimestamp
    val updatedTime: Instant = Instant.now(),

    @Column(updatable = false, nullable = false)
    @CreatedBy
    var createdBy: String = "",

    @Column(nullable = false)
    @LastModifiedBy
    var updatedBy: String = ""
) {

    override fun equals(other: Any?): Boolean {
        if (other !is BaseEntity) return false

        return other.id == id &&
            other.createdTime == createdTime &&
            other.updatedTime == updatedTime &&
            other.createdBy == createdBy &&
            other.updatedBy == updatedBy
    }
}
