package com.jfsaaved.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jfsaaved.domain.Author;
import com.jfsaaved.domain.Post;
import com.jfsaaved.service.AuthorService;
import com.jfsaaved.service.PostService;


@Controller
@Secured("ROLE_ADMIN")
public class AdminAuthorController {
	
	private PostService postService;
	private AuthorService authorService;

	
	@Autowired
	public AdminAuthorController(PostService postService, AuthorService authorService) {
		this.postService = postService;
		this.authorService = authorService;
	}
	
	@RequestMapping("/admin/authors")
	public String list(Model model) {
		model.addAttribute("authors", authorService.list());
		return "admin/author/list";
	}
	
	@RequestMapping("/admin/author/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("author", authorService.get(id));
		return "admin/author/view";
	}
	
	@RequestMapping("/admin/author/create")
	public String create(Model model) {
		model.addAttribute("author", new Author());
		model.addAttribute("authors", authorService.list());
		
		return "admin/author/authorForm";
	}
	
	@RequestMapping( value = "/admin/author/save", method = RequestMethod.POST )
	public String save(@Valid Author author, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("authors", authorService.list());
			return "admin/author/authorForm";
		} else {
			Author savedAuthor = authorService.save(author);
			return "redirect:/admin/author/" + savedAuthor.getId();
		}
	}
	
	@RequestMapping("/admin/author/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("author", authorService.get(id));
		return "admin/author/authorForm";
	}
	
	@RequestMapping("/admin/author/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		for(Post post : postService.list()) {
			if(post.getAuthor().getId() == id)
				postService.delete(post);
		}
		authorService.delete(id);
		redirectAttributes.addFlashAttribute("message", "Author and their posts has been deleted!");
		return "redirect:/admin/authors";
	}
	
}
