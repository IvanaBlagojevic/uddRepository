package com.example.scientificCentralService.domain;



import java.util.Date;

import javax.persistence.*;

@Entity
public class SubscriptionModel {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @OneToOne
	    private Magazine magazine;

	    @Column(nullable = false)
	    private Date tillDate;

	    public SubscriptionModel() {
	    }

	    public SubscriptionModel(Magazine magazine, Date tillDate) {
	        this.magazine = magazine;
	        this.tillDate = tillDate;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Magazine getMagazine() {
			return magazine;
		}

		public void setMagazine(Magazine magazine) {
			this.magazine = magazine;
		}

		public Date getTillDate() {
			return tillDate;
		}

		public void setTillDate(Date tillDate) {
			this.tillDate = tillDate;
		}


}
