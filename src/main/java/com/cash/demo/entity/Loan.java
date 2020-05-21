package com.cash.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Loan {

    @Id
    @GeneratedValue(generator = "loans_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "loans_id_seq", sequenceName = "loans_id_seq")
    private Long id;

    @Min(10)
    private BigDecimal amount;

    private Long userId;

    public Loan(BigDecimal amount, Long userId) {
        this.amount = amount;
        this.userId = userId;
    }

}
