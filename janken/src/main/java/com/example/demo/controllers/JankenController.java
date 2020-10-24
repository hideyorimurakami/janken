package com.example.demo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Hantei;
import com.example.demo.models.JankenUser;
import com.example.demo.models.JankenUserRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class JankenController {
private final JankenUserRepository rep;

JankenUser u;
Hantei h ;
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		String sessionId = session.getId();
		u = new JankenUser();
		u.setSessionId(sessionId);
		h = new Hantei();
		return "janken";
	}

	@PostMapping("/janken")
	public String janken(@RequestParam String te,Model model,HttpSession session) {
			String sessionId = session.getId();
			if(sessionId.equals(u.getSessionId())) {
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
			return "janken";
			}else {
				return "janken";
			}

	}


}
