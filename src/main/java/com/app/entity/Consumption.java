package com.app.entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Consumption")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Consumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consumption_id", nullable = false)
    private Long consumption_id;

    @Column(name = "years")
    private Integer years;
    @Column(name = "jan")
    private Integer jan;
    @Column(name = "feb")
    private Integer feb;
    @Column(name = "mar")
    private Integer mar;
    @Column(name = "april")
    private Integer april;
    @Column(name = "may")
    private Integer may;
    @Column(name = "june")
    private Integer june;
    @Column(name = "july")
    private Integer july;
    @Column(name = "august")
    private Integer august;
    @Column(name = "sept")
    private Integer sept;
    @Column(name = "oct")
    private Integer oct;
    @Column(name = "nov")
    private Integer nov;
    @Column(name = "december")
    private Integer dec;

    @ManyToOne @JsonIgnore
    @JoinColumn(name = "consumer_id", nullable = false)
    private Consumer consumer;

}