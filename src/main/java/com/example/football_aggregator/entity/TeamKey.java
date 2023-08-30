package com.example.football_aggregator.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;


@RequiredArgsConstructor
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "team_key")
public class TeamKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private int founded;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamKey teamKey = (TeamKey) o;
        return founded == teamKey.founded && Objects.equals(firstName, teamKey.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, founded);
    }
}
