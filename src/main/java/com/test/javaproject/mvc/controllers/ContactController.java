package com.test.javaproject.mvc.controllers;

import com.test.javaproject.mvc.domains.RegEx;
import com.test.javaproject.mvc.dto.ContactDto;
import com.test.javaproject.mvc.dto.UserDto;
import com.test.javaproject.mvc.service.impl.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

@Controller
public class ContactController {

    private WorkService service;

    @Autowired
	public ContactController(WorkService service){
		this.service = service;
	}

	@RequestMapping(value="/showContacts", method= RequestMethod.GET)
	public ModelAndView showContacts(HttpSession session){
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		if(Objects.isNull(userDto)){
			return new ModelAndView("redirect:/");
		}
		ModelAndView modelAndView = new ModelAndView();
		//for further searching of contacts
		modelAndView.setViewName("mainPage");
		///all contacts will be searched
		return modelAndView;
	}

	@RequestMapping(value="/addContact", method= RequestMethod.GET)
	public ModelAndView addContact(Model model, HttpSession session){
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		ModelAndView modelAndView = new ModelAndView();
		if(Objects.isNull(userDto)){
			modelAndView.setViewName("redirect:/");
			return modelAndView;
		}
		if(!model.containsAttribute("contactDto")){
			modelAndView.addObject("contactDto", new ContactDto());
		}
		modelAndView.setViewName("contactRegistr");
		return modelAndView;
	}
	
	@RequestMapping(value="/saveNewContact", method= RequestMethod.POST)
	public String saveContact(@Validated @ModelAttribute("contactDto") ContactDto contactDto, BindingResult result,
                              RedirectAttributes attributes, HttpSession session){
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		if(Objects.isNull(userDto)){
			return "redirect:/";
		}
		if(result.hasErrors() || !RegEx.checkValidTelNumber(contactDto.getMobPhoneNumber()) ||
				!RegEx.checkValidHomeNumber(contactDto.getHomePhoneNumber())){
			///show entered data on reload page
			attributes.addFlashAttribute("org.springframework.validation.BindingResult.contactDto",result);
			attributes.addFlashAttribute("contactDto",contactDto);

			if(!RegEx.checkValidTelNumber(contactDto.getMobPhoneNumber()))
				attributes.addFlashAttribute("error1","errText.registration.errTelNumber");
			if(!RegEx.checkValidHomeNumber(contactDto.getHomePhoneNumber()))
				attributes.addFlashAttribute("error2","errText.registration.errHomeNumber");
			return "redirect:/addContact";
		} else{

			boolean isContactExist = service.getContactServiceImpl().checkExistingContact(userDto.getUserId(),contactDto.getMobPhoneNumber());
			if(isContactExist){
				attributes.addFlashAttribute("contactDto",contactDto);
				attributes.addFlashAttribute("error","Contact with such mobile number exists!");
				return "redirect:/addContact";
			}else {
				service.getContactServiceImpl().saveContact(userDto.getUserId(), contactDto);
				return "redirect:/showContacts";
			}
		}
	}
	///"editContact/{contact_id}"
	@RequestMapping(value="/{contactId}", method= RequestMethod.GET)
	public ModelAndView editContactToForm(@PathVariable("contactId") Long contactId, HttpSession session){
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		if(Objects.isNull(userDto)){
			return new ModelAndView("redirect:/");
		}
		ContactDto contactDto = service.getContactServiceImpl().getContactById(contactId);
		return new ModelAndView("contactOldEdit","contactDto", contactDto);
	}
	
	@RequestMapping(value="/{contactId}", method= RequestMethod.POST)
	public String editContactToDB(@Valid @ModelAttribute("contactDto") ContactDto contactDto, BindingResult result,
                                  @PathVariable("contactId") Long contactId,
                                  RedirectAttributes attributes, HttpSession session){
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		if(Objects.isNull(userDto)){
			return "redirect:/";
		}
		if(result.hasErrors() || !RegEx.checkValidTelNumber(contactDto.getMobPhoneNumber()) ||
				!RegEx.checkValidHomeNumber(contactDto.getHomePhoneNumber())){
			///show entered data on reload page
			attributes.addFlashAttribute("org.springframework.validation.BindingResult.contactDto",result);
			attributes.addFlashAttribute("contactDto",contactDto);
			if(!RegEx.checkValidTelNumber(contactDto.getMobPhoneNumber()))
				attributes.addFlashAttribute("error1","Incorrect telephone number format!");
			if(!RegEx.checkValidHomeNumber(contactDto.getHomePhoneNumber()))
				attributes.addFlashAttribute("error2","Incorrect home phone number format!");
//				model.addAttribute("edit2", true);
			return "redirect:/"+contactId;
		} else{
				service.getContactServiceImpl().editContact(contactDto);
				return "redirect:/showContacts";
		}
	}
	
	@RequestMapping(value="/deleteContact/{contactId}", method= RequestMethod.GET)
	public String deleteContact(@PathVariable("contactId") Long contactId, HttpSession session){
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		if(Objects.isNull(userDto)){
			return "redirect:/";
		}
		service.getContactServiceImpl().deleteContact(contactId);
		return "redirect:/showContacts";
	}

	@RequestMapping(value="/logOut", method= RequestMethod.GET)
	public String logOut(HttpSession session){
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		if(Objects.nonNull(userDto)){
			return "exitPage";
		}else
			return "redirect:/";

	}
	
	@RequestMapping(value="/exit", method= RequestMethod.GET)
	public String exit(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
}
