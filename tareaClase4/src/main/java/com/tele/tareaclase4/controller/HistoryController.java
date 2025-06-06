package com.tele.tareaclase4.controller;

import com.tele.tareaclase4.DTO.HistoryDTO;
import com.tele.tareaclase4.repository.JobHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class HistoryController {
    @Autowired
    JobHistoryRepository jobHistoryRepository;
    @GetMapping("/jobHistory")
    public String jobHistory(Model model) {
        List<HistoryDTO> history = jobHistoryRepository.obtenerHistorias();
        model.addAttribute("history", history);
        return "history";
    }
}
