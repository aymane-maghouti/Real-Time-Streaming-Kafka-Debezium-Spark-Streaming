package com.example.realTimeApp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "max_ram_per_brand")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaxRamPerBrand {

    @Id
    @Column(name = "brand", length = 100)
    private String brand;

    @Column(name = "max_ram")
    private Double maxRam;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}
