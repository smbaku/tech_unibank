package az.uni.tech.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;
    private Double balance;
    @CreationTimestamp
    private LocalDateTime createDate;
    private boolean active;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
