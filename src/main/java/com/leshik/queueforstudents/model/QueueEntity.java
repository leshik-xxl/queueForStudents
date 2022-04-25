package com.leshik.queueforstudents.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "queue_table")
@Getter
@Setter
@ToString
public class QueueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "entry_time")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date entryTime = Calendar.getInstance().getTime();

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", unique = true)
    private UserEntity user;

    public QueueEntity() {

    }

    public QueueEntity(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueEntity queue = (QueueEntity) o;
        return Objects.equals(id, queue.id) && Objects.equals(entryTime, queue.entryTime) && Objects.equals(user, queue.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entryTime, user);
    }
}
