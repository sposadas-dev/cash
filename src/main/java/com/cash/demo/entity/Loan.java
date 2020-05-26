package com.cash.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ApiModel(description = "All details about the Loan. ")
public class Loan {

    @Id
    @GeneratedValue(generator = "loans_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "loans_id_seq", sequenceName = "loans_id_seq")
    @ApiModelProperty(notes = "The database generated loan ID")
    private Long id;

    @ApiModelProperty(notes = "The id from user of loan")
    private Long userId;

    @Min(10)
    @ApiModelProperty(notes = "The amount from loan")
    private BigDecimal amount;

    @Min(1)
    @Max(24)
    @ApiModelProperty(notes = "The Initial number of fee")
    private Integer numberFee;

    @OneToMany(mappedBy = "loanId", cascade = CascadeType.ALL, orphanRemoval = true)
    @ApiModelProperty(notes = "The shares from loan")
    private List<Fee> fees;

}
