package com.Greentech.CQRS.domain;

import javax.persistence.*;

import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ZonegéoraphiqueCommand {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
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
