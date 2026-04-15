package com.barankul.keigoquiz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KeigoController {

    private int currentIndex = 0;

    @GetMapping("/")
    public String home(Model model) {
        List<Question> questions = KeigoQuestions.getQuestions();
        Question question = questions.get(currentIndex);

        model.addAttribute("question", question);
        model.addAttribute("currentIndex", currentIndex + 1);
        model.addAttribute("totalQuestions", questions.size());
        model.addAttribute("isLast", currentIndex == questions.size()-1);

        return "keigo";
    }

    @PostMapping("/answer")
    public String selectedAnswer(Model model, @RequestParam("selectedAnswer") String selectedAnswer) {
        List<Question> questions = KeigoQuestions.getQuestions();
        Question currentQuestion = questions.get(currentIndex);

        String correctAnswer = currentQuestion.getAnswer();
                
        boolean isCorrect = selectedAnswer.equals(currentQuestion.getAnswer());
        
        model.addAttribute("question", currentQuestion);
        model.addAttribute("selectedAnswer", selectedAnswer);
        model.addAttribute("isCorrect", isCorrect);
        model.addAttribute("correctAnswer", correctAnswer);
        model.addAttribute("currentIndex", currentIndex + 1);
        model.addAttribute("totalQuestions", questions.size());
        model.addAttribute("isLast", currentIndex == questions.size()-1);

        return "keigo";
    }

    @PostMapping("/next")
    public String nextQuestion(Model model) {
        List<Question> questions = KeigoQuestions.getQuestions();

        if(currentIndex < questions.size() - 1) {
            currentIndex++;
        }

        Question displayQuestion = questions.get(currentIndex);
        model.addAttribute("question", displayQuestion);
        model.addAttribute("currentIndex", currentIndex + 1);
        model.addAttribute("totalQuestions", questions.size());
        model.addAttribute("isLast", currentIndex == questions.size()-1);

        return "keigo";

    }

    @PostMapping("/restart")
    public String restartQuiz() {
        currentIndex = 0;
        return "redirect:/";
    }
}
