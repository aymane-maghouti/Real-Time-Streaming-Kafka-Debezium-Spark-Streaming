package com.example.realTimeApp.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "statistics_summary")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatisticsSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "total_phones")
    private Integer totalPhones;

    @Column(name = "max_price")
    private Double maxPrice;

    @Column(name = "max_screen_size")
    private Double maxScreenSize;

    @Column(name = "max_ram")
    private Double maxRam;

    @Column(name = "max_rom")
    private Double maxRom;

    @Column(name = "max_battery")
    private Double maxBattery;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}
