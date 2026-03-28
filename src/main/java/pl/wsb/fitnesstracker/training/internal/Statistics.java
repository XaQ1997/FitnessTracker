package pl.wsb.fitnesstracker.training.internal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Statistics")
@Getter
@NoArgsConstructor
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user; // Jednostronna - User nie wie o Statistics

    private int totalTrainings;
    private double totalDistance;
    private double totalCaloriesBurned;

    public Statistics(final User user, final int totalTrainings, final double totalDistance, final double totalCaloriesBurned) {
        this.user = user;
        this.totalTrainings = totalTrainings;
        this.totalDistance = totalDistance;
        this.totalCaloriesBurned = totalCaloriesBurned;
    }
}