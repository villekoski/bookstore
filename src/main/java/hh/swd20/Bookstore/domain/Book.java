package hh.swd20.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String title;
    private String author;
    private Integer year;
    private String isbn;
    private Double price;
    @JsonIgnoreProperties ("books") 
    @ManyToOne
    @JoinColumn(name = "Cid")
    private Category category;

    
    public Book(String title, String author, Integer year, String isbn, Double price) {
        super();
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }
    public Book(String title, String author, Integer year, String isbn, Double price, Category category) {
        super();
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }
    public Book() {
        super();
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
    public String toString() {
        if (this.category != null)
            return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price="
                    + price + ", category=" + this.getCategory() + "]";
        else
            return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price="
                    + price + "]";
    }

		
	}



