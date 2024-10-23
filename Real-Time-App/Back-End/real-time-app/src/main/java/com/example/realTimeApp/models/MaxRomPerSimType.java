package com.example.realTimeApp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "max_rom_per_sim_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaxRomPerSimType {

    @Id
    @Column(name = "sim_type", length = 50)
    private String simType;

    @Column(name = "max_rom")
    private Double maxRom;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}
