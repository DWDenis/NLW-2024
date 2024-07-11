package com.rocketseat.planner.trip;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Collumn(nullable = false, name = "")
    private String destination;

    @Collumn(name = "start_at", nullable = false)
    private LocalDateTime startsAt;

    @Collumn(name = "ends_at", nullable = false)
    private LocalDateTime endsAt;

    @Collumn(name = "is_confirmed", nullable = false)
    private Boolean isConfirmed;

    @Collumn(name = "owner_name", nullable = false)
    private String ownerName;

    @Collumn(name = "owner_email", nullable = false)
    private String owner_email;

    public Trip(TripRequestPayload data){
        this.destination = data.destination();
        this.isConfirmed = false;
        this.owner_email = data.owner_email();
        this.ownerName = data.owner_name();
        this.startsAt = LocalDateTime.parse(data.starts_at(), DateTimeFormatter.ISO_DATE_TIME);
        this.endsAt = LocalDateTime.parse(data.ends_at(), DateTimeFormatter.ISO_DATE_TIME);
    }
}
