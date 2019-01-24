package dto;

public class TourData {
	private int tourID;
	private String tourType;
	private String tourLocation;
	private String tourCity;
	private String tourCountry;
	private String tourHotel;
	private int tourDuration;
	private double tourPrice;

	public int getToursID() {
		return tourID;
	}

	public void setToursID(int tourID) {
		this.tourID = tourID;
	}

	public String getToursType() {
		return tourType;
	}

	public void setToursType(String tourType) {
		this.tourType = tourType;
	}

	public String getToursLocation() {
		return tourLocation;
	}

	public void setToursLocation(String tourLocation) {
		this.tourLocation = tourLocation;
	}

	public String getToursCity() {
		return tourCity;
	}

	public void setToursCity(String tourCity) {
		this.tourCity = tourCity;
	}

	public String getToursCountry() {
		return tourCountry;
	}

	public void setToursCountry(String tourCountry) {
		this.tourCountry = tourCountry;
	}

	public String getToursHotel() {
		return tourHotel;
	}

	public void setToursHotel(String tourHotel) {
		this.tourHotel = tourHotel;
	}

	public int getToursDuration() {
		return tourDuration;
	}

	public void setToursDuration(int tourDuration) {
		this.tourDuration = tourDuration;
	}

	public double getTourPrice() {
		return tourPrice;
	}

	public void setTourPrice(double tourPrice) {
		this.tourPrice = tourPrice;
	}

	@Override
	public String toString() {
		return "TourData [tourID=" + tourID + ", tourType=" + tourType + ", tourLocation=" + tourLocation
				+ ", tourCity=" + tourCity + ", tourCountry=" + tourCountry + ", tourHotel=" + tourHotel
				+ ", tourDuration=" + tourDuration + ", tourPrice=" + tourPrice + "]";
	}
	
	

}