package pl.coderslab.charity.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;
import java.util.List;


@Controller
public class DonationController {
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;

    public DonationController(InstitutionRepository institutionRepository, DonationRepository donationRepository, CategoryRepository categoryRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
    }

    @ModelAttribute("categories")
    public List<Category> returnAllCategories(){
        return categoryRepository.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> returnInstitutions() {
        return institutionRepository.findAll();
    }



@GetMapping("/form")
public String getForm(Model model) {
//    model.addAttribute("categories", categoryRepository.findAll());
//    model.addAttribute("institutions", institutionRepository.findAll());
    model.addAttribute("donation", new Donation());
    return "form";
}



    @PostMapping("/form")
    public String saveFormData(@Valid Donation donation,
                               BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {

            return "form";
        }
        donationRepository.save(donation);
        return "form-confirmation";
    }

    }