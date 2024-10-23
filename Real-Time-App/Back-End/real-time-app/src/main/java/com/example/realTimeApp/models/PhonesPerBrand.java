package com.example.realTimeApp.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "phones_per_brand")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhonesPerBrand {

    @Id
    @Column(name = "brand", length = 100)
    private String brand;

    @Column(name = "total_phones")
    private Integer totalPhones;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}
