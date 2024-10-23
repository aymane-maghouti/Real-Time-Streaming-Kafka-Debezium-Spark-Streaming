package com.example.realTimeApp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "max_battery_per_brand")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaxBatteryPerBrand {

    @Id
    @Column(name = "brand", length = 100)
    private String brand;

    @Column(name = "max_battery")
    private Double maxBattery;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}
