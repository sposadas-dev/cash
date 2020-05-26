package com.cash.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ApiModel(description = "All details about the payment. ")
public class Payment {

    @Id
    @GeneratedValue(generator = "payments_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "payments_id_seq", sequenceName = "payments_id_seq")
    @ApiModelProperty(notes = "The database generated payment ID")
    private Long id;

    @OneToOne(mappedBy = "payment")
    private Fee fee;

    @ApiModelProperty(notes = "Payment date")
    private LocalDateTime paymentDate;

    @ApiModelProperty(notes = "Amount from the payment")
    private BigDecimal amount;

}
