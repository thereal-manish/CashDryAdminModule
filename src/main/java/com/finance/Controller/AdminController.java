package com.finance.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finance.model.AdminModel;
import com.finance.model.LoanAuthority;
import com.finance.model.Manager;
import com.finance.repository.AdminRepository;
import com.finance.repository.LoanAuthorityRepository;
import com.finance.repository.ManagerRepository;
import com.finance.service.AdminService;
import com.finance.service.LoanAuthorityService;
import com.finance.service.ManagerService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	LoanAuthorityRepository loanAuth_repo;
	@Autowired
	ManagerRepository mana_repo;
	@Autowired
	AdminRepository admin_repo;

	@Autowired
	LoanAuthorityService laaService;
	@Autowired
	ManagerService manaService;
	@Autowired
	AdminService adminService;
	
	@PostConstruct
    private void postConstruct() {
        AdminModel adminDefaults = new AdminModel("admin", "Adminpass@123");
        admin_repo.save(adminDefaults);
    }

	
	@GetMapping("/adminLogin")
	public String showForm(AdminModel admin) {
		
		
		return "AdminLogin";
	}
	
	@PostMapping("/adminLoginPageValidation")
	public String getValidation(@Valid @ModelAttribute("adminModel")AdminModel adminModel,BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "AdminLogin";
		}
		else if(adminService.authenticateAdmin(adminModel.getAdminUsername(), adminModel.getAdminPassword())) {
			AdminModel adminLogin=adminService.retrieveAdmin(adminModel.getAdminUsername(), adminModel.getAdminPassword());
			model.addAttribute(adminLogin);
			return "redirect:/admin/dashBoard";
		}
		else {
			String error="Enter valid credentials";
			model.addAttribute("badlogin", error);
			return "AdminLogin";
		}
		
	}
	
	

	@GetMapping("/dashBoard")
	public String adminDashborad(Model model) {
		List<Manager> listmanager = manaService.find();
		model.addAttribute("listmanager", listmanager);
		List<LoanAuthority> listlaa = laaService.find();
		model.addAttribute("listlaa", listlaa);
		return "AdminDashBoard/AdminDashboard";
	}

	@GetMapping("/manager")
	public String adminDashboradManager(Model model) {
		List<Manager> listmanager = manaService.find();
		model.addAttribute("listmanager", listmanager);
		return "AdminDashBoard/adminManagerDetails";

	}


	@GetMapping("/authority")
	public String adminDashboradAuthority(Model model) {
		List<LoanAuthority> listlaa = laaService.find();
		model.addAttribute("listlaa", listlaa);
		return "AdminDashBoard/adminLoanAuthorityDetails";
	}



	@GetMapping("/logout")
	public String adminDashboradLogout() {
		return "index";
	}

	@GetMapping("/manageUpdate")
	public String updateManage() {

		return "AdminDashBoard/adminManagerUpdate";
	}


	
	@GetMapping("/managerAdd")
	public String addManagers(Manager manager) {

		return "AdminDashBoard/adminManagerAdd";
	}

	@GetMapping("/laaAdd")
	public String addLaa(LoanAuthority loanAuthority) {

		return "AdminDashBoard/adminLoanAuthorityAdd";
	}



	@PostMapping("/addingLoanAuthority")
	public String addingLoanAuthority(@ModelAttribute("loanAuthority") LoanAuthority Laa, Model mod) {

		laaService.save(Laa);

		mod.addAttribute("loanAuthority", Laa);

		return "redirect:/admin/dashBoard";
	}

	@RequestMapping(value = "/saveLaa", method = RequestMethod.POST)
	public String saveLoanAuth(@ModelAttribute("loan_Auth") LoanAuthority loanAuth) {
		laaService.save(loanAuth);

		return "redirect:/dashBoard";
	}

	@RequestMapping("/editLaa/{id}")
	public ModelAndView showEditLoanAuth(@PathVariable(name = "id") String id) {

		ModelAndView mav = new ModelAndView("adminLoanAuthorityUpdate");

		LoanAuthority loan_auth = laaService.getLoanAuthority(id);

		mav.addObject("loanAutho", loan_auth);

		return mav;
	}

	@RequestMapping("/deleteLaa/{id}")
	public String deleteLaa(@PathVariable(name = "id") String id) {
		laaService.delete(id);

		return "redirect:/dashBoard";
	}

	// manager methods



	@PostMapping("/addingManager")
	public String addingManager(@Valid @ModelAttribute("manager") Manager manager,BindingResult br, Model mod) {

		System.out.println("Adding manager successfully executed");
		
		if(br.hasErrors()) {


			return "AdminDashBoard/adminManagerAdd";
		}
		
		manaService.save(manager);
		mod.addAttribute("manager", manager);

		return "redirect:/admin/dashBoard";
	}

	@PostMapping("/savemana/{managerId}")
	public String savemana(@PathVariable("managerId") String managerId, @ModelAttribute("manager") Manager manager,
			Model mod) {
		System.out.println("saved");
		manaService.save(manager);
		System.out.println("after update");

		return "redirect:/admin/dashBoard";
	}

	@GetMapping("editmana/{managerId}")
	public String showEditMana(@PathVariable(name = "managerId") String managerId, Model mod) {

		Manager manager = manaService.currentManager(managerId);

		mod.addAttribute("manager", manager);

		return "AdminDashBoard/adminManagerUpdate";
	}

	@GetMapping("/deletemana/{managerId}")
	public String deletemana(@PathVariable(name = "managerId") String managerId) {
		manaService.delete(managerId);

		return "redirect:/admin/dashBoard";
	}

	// laa methods
	@PostMapping("/addinglaa")
	public String addingLAA(@Valid @ModelAttribute("loanAuthority") LoanAuthority loanAuthority,BindingResult br, Model mod) {
		System.out.println("hello again");
		if(br.hasErrors()) {

			return "AdminDashBoard/adminLoanAuthorityAdd";
		}
		
		laaService.save(loanAuthority);
		mod.addAttribute("loanAuthority", loanAuthority);

		return "redirect:/admin/dashBoard";
	}

	@PostMapping("/savelaa/{loanAuth_Id}")
	public String saveLAA(@PathVariable("loanAuth_Id") String loanAuth_Id,
			@ModelAttribute("loanAuthority") LoanAuthority lauth, Model mod) {
		laaService.save(lauth);

		return "redirect:/admin/dashBoard";
	}

	@GetMapping("editlaa/{loanAuth_Id}")
	public String showEditLAA(@PathVariable(name = "loanAuth_Id") String loanAuth_Id, Model mod) {


		LoanAuthority lauth = laaService.currentLoanAuthority(loanAuth_Id);
		mod.addAttribute("loanAuthority", lauth);

		return "AdminDashBoard/adminLoanAuthorityUpdate";
	}

	@GetMapping("/deletelaa/{loanAuth_Id}")
	public String deleteLAA(@PathVariable(name = "loanAuth_Id") String loanAuth_Id) {
		laaService.delete(loanAuth_Id);

		return "redirect:/admin/dashBoard";
	}

}
