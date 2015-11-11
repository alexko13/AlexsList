package controllers;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import models.Listing;

@Controller
public class ListingController {
	@RequestMapping("AddListing.do")
	public String addListing(Listing newListing, HttpSession session) {
		System.out.println(newListing);
		List<Listing> listings = getListings(session.getServletContext());
		listings.add(newListing);
		return "index.html";
	}

	@SuppressWarnings("unchecked")
	private List<Listing> getListings(ServletContext context) {
		return (List<Listing>) context.getAttribute("listings");
	}

	@RequestMapping("Detail.do")
	public ModelAndView showDetailedListing(@RequestParam("listing") String listingName, HttpSession session) {
		List<Listing> listings = getListings(session.getServletContext());
		for (Listing listing : listings)
			if (listing.getName().equals(listingName))
				return new ModelAndView("Detail.jsp", "listing", listing);
		return null;
	}
}
