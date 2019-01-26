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

	public void setTourID(int tourID) {
		this.tourID = tourID;
	}

	public String getTourType() {
		return tourType;
	}

	public void setTourType(String tourType) {
		this.tourType = tourType;
	}

	public String getTourLocation() {
		return tourLocation;
	}

	public void setTourLocation(String tourLocation) {
		this.tourLocation = tourLocation;
	}

	public String getTourCity() {
		return tourCity;
	}

	public void setTourCity(String tourCity) {
		this.tourCity = tourCity;
	}

	public String getTourCountry() {
		return tourCountry;
	}

	public void setTourCountry(String tourCountry) {
		this.tourCountry = tourCountry;
	}

	public String getTourHotel() {
		return tourHotel;
	}

	public void setTourHotel(String tourHotel) {
		this.tourHotel = tourHotel;
	}

	public int getTourDuration() {
		return tourDuration;
	}

	public void setTourDuration(int tourDuration) {
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