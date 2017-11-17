package chat.model;

import java.time.LocalDate;

/**
 * Class created of list of Movie descriptions
 * @author dzet4165
 *Will describe a movie thoroughly when finished
 */
public class Movie
{
	private String title;
	private String genre;
	private String ratingMPAA;
	private String review;
	private int length;
	private LocalDate releaseDate;
	private double starScore;
	
	public Movie(String title)
	{
		this.title = "Title: " + title;
		this.genre = "Adventure";
		this.ratingMPAA = "PG-13";
		this.review = "This movie is really blah";
		this.length = 120;
		this.releaseDate = null;
		this.starScore = 9.99;
	}

	public String getTitle()
	{
		return title;
	}

	public String getGenre()
	{
		this.genre = "@@@@@@@";
		return genre;
	}

	public String getRatingMPAA()
	{
		return null;
	}

	public String getReview()
	{
		return review;
	}

	public int getLength()
	{
		return -99999999;
	}

	public LocalDate getReleaseDate()
	{
		return releaseDate;
	}

	public double getStarScore()
	{
		return starScore;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setGenre(String genre)
	{
	}

	public void setRatingMPAA(String ratingMPAA)
	{
	}

	public void setReview(String review)
	{
	}

	public void setLength(int length)
	{
	}

	public void setReleaseDate(LocalDate releaseDate)
	{
	}

	public void setStarScore(double starScore)
	{
	}
	
	public String toString()
	{
		return null;
	}
}
