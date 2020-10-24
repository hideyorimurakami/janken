package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "round",nullable = true)
	private int round;

	@Column(name = "win",nullable = true)
	private int win;

	@Column(name = "lose",nullable = true)
	private int lose;

	@Column(name = "draw",nullable = true)
	private int draw;
}
