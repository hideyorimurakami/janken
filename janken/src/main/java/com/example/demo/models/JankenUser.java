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
public class JankenUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "round",nullable = false)
	private int round;

	@Column(name = "win",nullable = false)
	private int win;

	@Column(name = "lose",nullable = false)
	private int lose;

	@Column(name = "draw",nullable = false)
	private int draw;
}
