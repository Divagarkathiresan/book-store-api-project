package com.divagar.springapp.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Democontroller {

	@GetMapping("/abc")
	public String abc(){
		return "<div class=\"container\">\n" + //
						"        <h2>Registration Form</h2>\n" + //
						"        <form action=\"/submit_registration\" method=\"POST\">\n" + //
						"            <div class=\"form-group\">\n" + //
						"                <label for=\"username\">username</label>\n" + //
						"                <input type=\"text\" id=\"username\" name=\"username\" placeholder=\"Enter your username\" required>\n" + //
						"            </div>\n" + //
						"            <div class=\"form-group\">\n" + //
						"                <label for=\"email\">Email</label>\n" + //
						"                <input type=\"email\" id=\"email\" name=\"email\" placeholder=\"Enter your email\" required>\n" + //
						"            </div>\n" + //
						"            <div class=\"form-group\">\n" + //
						"                <label for=\"password\">Password</label>\n" + //
						"                <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Enter your password\" required>\n" + //
						"            </div>\n" + //
						"            <div class=\"form-group\">\n" + //
						"                <label for=\"confirm-password\">Confirm Password</label>\n" + //
						"                <input type=\"password\" id=\"confirm-password\" name=\"confirm-password\" placeholder=\"Confirm your password\" required>\n" + //
						"            </div>\n" + //
						"            <div class=\"form-group\">\n" + //
						"                <input type=\"submit\" value=\"Register\">\n" + //
						"            </div>\n" + //
						"            <p class=\"note\">By registering, you agree to our terms and conditions.</p>\n" + //
						"        </form>\n" + //
						"    </div>";
	}

	@GetMapping("/home")
	public String home()
	{
		return "Home page";
	}

	@GetMapping("/contact")
	public String contact()
	{
		return "contact page";
	}

	@GetMapping("/about")
	public String about()
	{
		return "about page";
	}

	@GetMapping("/Id")
	public String GetName(@RequestParam String Name , @RequestParam int Id)
	{
		return ("Good Morning "+ Name +" "+ Id);
	}

	@GetMapping("/Avg")
	public float GetAvg(@RequestParam float n1,@RequestParam float n2,@RequestParam float n3)
	{
		float a =(n1+n2+n3)/3;
		return a;
	}

	@GetMapping("/{Std_Name}")
	public String getName(@PathVariable("Std_Name") String name)
	{
		return "Good Morning "+name;
	}
}