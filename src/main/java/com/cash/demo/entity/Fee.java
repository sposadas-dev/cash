package com.cash.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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
@IdClass(Fee.IdClass.class)
@ApiModel(description = "All details about the fees. ")
public class Fee {

    @Id
    @ApiModelProperty(notes = "Fee number")
    private Integer feeNumber;

    @Id
    @ApiModelProperty(notes = "Id from loan")
    private Long loanId;

    @ApiModelProperty(notes = "Amount from the fee")
    private BigDecimal amount;

    @ApiModelProperty(notes = "Payment due date")
    private LocalDateTime paymentDue;

    @ApiModelProperty(notes = "Payment")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Payment payment;

    public Fee(Integer feeNumber, Long loanId, BigDecimal amount, LocalDateTime paymentDue) {
        this.feeNumber = feeNumber;
        this.loanId = loanId;
        this.amount = amount;
        this.paymentDue = paymentDue;
    }

    @Data
    static class IdClass implements Serializable {
        private Integer feeNumber;
        private Long loanId;
    }

}
