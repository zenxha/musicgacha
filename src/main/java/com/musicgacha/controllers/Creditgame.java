package com.social_credit_farming.controllers;

import com.social_credit_farming.controllers.Chris.SocialAdministration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class Creditgame {
    SocialAdministration sa = new SocialAdministration();

    @GetMapping("/game")
    public String creditgame(Model model) throws IOException {

        model.addAttribute("name", sa.u.name);
        model.addAttribute("age", sa.u.age);
        model.addAttribute("score", sa.u.score);

        model.addAttribute("phone_number", sa.u.phone_number);
        model.addAttribute("internet_speed", sa.u.internet_speed);
        model.addAttribute("right_to_travel_outside_country", sa.u.right_to_travel_outside_country);
        model.addAttribute("can_use_business_class", sa.u.can_use_business_class);
        model.addAttribute("highest_hotel_class", sa.u.highest_hotel_class);
        model.addAttribute("can_attend_top_college", sa.u.can_attend_top_college);
        model.addAttribute("can_receive_financial_aid", sa.u.can_receive_financial_aid);
        model.addAttribute("free_covid_masks", sa.u.free_covid_masks);
        model.addAttribute("weeks_of_vacation", sa.u.weeks_of_vacation);
        model.addAttribute("can_go_to_movies", sa.u.can_go_to_movies);

        model.addAttribute("current_question", sa.qdb.qtext);
        model.addAttribute("current_question_in_chinese", sa.qdb.chinese_qtext);

        model.addAttribute("current_question_id", sa.qdb.cqnumber);


        sa.qdb.getQuestion();
        sa.u.updateScore(sa.qdb.cq.points);
        model.addAttribute("user_image", sa.u.ladder);

        return "homesite/game";
    }

}




