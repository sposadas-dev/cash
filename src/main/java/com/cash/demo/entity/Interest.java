package com.cash.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ApiModel(description = "All details about of the interests. ")
public class Interest {

    @Id
    @ApiModelProperty(notes = "The number of fees")
    private Integer fee;

    @Min(1)
    @ApiModelProperty(notes = "The interest")
    private double interest;

}
