package com.example.football_aggregator.model;


import com.example.football_aggregator.entity.TeamKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "match_teams_id")
@Builder
public class MatchTeamsId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_key_id",referencedColumnName = "id")
    private TeamKey teamKey;

    private Long apiFootballResponseId;

    private Long footballProResponseId;
}
