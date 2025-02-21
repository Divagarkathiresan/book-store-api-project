package com.divagar.springapp.Entity;
import jakarta.persistence.*;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int ReviewID;
	public int Rating;
	public String Comment;
	public int getReviewID() {
		return ReviewID;
	}
	public void setReviewID(int reviewID) {
		ReviewID = reviewID;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public Review(int reviewID, int rating, String comment) {
		ReviewID = reviewID;
		Rating = rating;
		Comment = comment;
	}
	public Review() {
	}
	
}
