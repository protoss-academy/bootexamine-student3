package com.protosstechnology.train.bootexamine.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Document {
    private @Id
    @GeneratedValue
    Long id;

    @NonNull
    private String documentNumber;
    @NonNull private String description;



}