package com.spring.university.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Binod Bhandari on 6/21/18.
 */

@Data
@Entity
@Table(name = "table")
public class DrexelDomain {

    private String itemOne;
    private String itemTwo;
    private String itemFive;
}
