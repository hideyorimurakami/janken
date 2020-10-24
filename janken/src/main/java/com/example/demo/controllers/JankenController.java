package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Hantei;
import com.example.demo.models.User;
import com.example.demo.models.UserRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class JankenController {
private final UserRepository rep;

User u;
Hantei h ;
	@GetMapping("/janken")
	public String index(Model model) {
		u = new User();
		h = new Hantei();
		return "janken";
	}

	@PostMapping("/janken")
	public String janken(@RequestParam String te,Model model) {
			int you = Integer.parseInt(te);
			model.addAttribute("msg", h.judge(you));
			model.addAttribute("cpu",h.getCpu());
			model.addAttribute("you",h.getYou());
			u.setRound(h.getRound());;
			u.setWin(h.getWin());
			u.setLose(h.getLose());
			u.setDraw(h.getDraw());
			rep.save(u);
			model.addAttribute("id",u.getId());
			model.addAttribute("win",u.getWin());
			model.addAttribute("draw",u.getDraw());
			model.addAttribute("lose",u.getLose());
			return "/janken";
	}


}