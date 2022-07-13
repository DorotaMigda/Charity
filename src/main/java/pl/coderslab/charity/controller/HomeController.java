package pl.coderslab.charity.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;


@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("/")
    public String showHomepage(Model model) {
        model.addAttribute("institutions", institutionRepository.findAll(PageRequest.of(0, 4)).getContent());
        //umożliwia ograniczenie widoku do 4 na stronie
        model.addAttribute("bagsQuantity", donationRepository.bagsQuantity());
        model.addAttribute("donationsQuantity", donationRepository.count());
        return "index";
    }

}
