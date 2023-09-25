package com.Greentech.CQRS.domain;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ZonegéographiqueQuery {
    @Id
    private Long id;
    private String groupe;
    private String details;
    private String symbole;
    private String visibilite;
    @Temporal(TemporalType.DATE)
    private Date creationDate;


    @OneToOne
    public User createdBy;

    @ManyToMany()
    public Set<User> members;
}
