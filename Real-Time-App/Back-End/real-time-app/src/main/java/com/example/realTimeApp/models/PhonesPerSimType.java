package com.example.realTimeApp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "phones_per_sim_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhonesPerSimType {

    @Id
    @Column(name = "sim_type", length = 50)
    private String simType;

    @Column(name = "total_phones")
    private Integer totalPhones;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}
