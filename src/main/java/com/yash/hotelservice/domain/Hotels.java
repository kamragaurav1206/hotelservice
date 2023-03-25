package com.yash.hotelservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Entity
@Table(name = "hotels")
public class Hotels {
    @Id
    private String hotelId;
    @NotNull(message = "Hotel name can not be null")
    private String hotelName;
    @NotNull(message = "location can not be null")
    private String location;
    @NotNull(message = "description can not be null")
    private String description;

}
