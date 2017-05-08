package com.jfsaaved.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class DataEntry {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat ( pattern="MM/dd/yyyy HH:mm:ss")
	private Date dateUploaded;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat ( pattern="MM/dd/yyyy HH:mm:ss")
	private Date gmtDateTime;
	
	@NotNull
	@Column(precision=19, scale=6)
	private BigDecimal gpsLatitude;
	
	@NotNull
	@Column(precision=19, scale=6)
	private BigDecimal gpsLongitude;
	
	@NotNull
	@Column(precision=19, scale=3)
	private BigDecimal vocsLcPpm;
	
	@NotNull
	@Column(precision=19, scale=3)
	private BigDecimal ms3LcPpm;
	
	@NotNull
	@Column(precision=19, scale=3)
	private BigDecimal hydrogenSulfideLcPpm;
	
	@NotNull
	@Column(precision=19, scale=3)
	private BigDecimal methaneLcPpm;
	
	@NotNull
	@Column(precision=19, scale=3)
	private BigDecimal ms2LcPpm;
	
	@NotNull
	@Column(precision=19, scale=3)
	private BigDecimal ammoniaLcPpm;
	
	@NotNull
	private Double windSpeed;
	
	@NotNull
	private Integer windDirection;
	
	@NotNull
	private Double dailyRain;
	
	@NotNull
	@Column(precision=19, scale=3)
	private BigDecimal solarSensor;
	
	@NotNull
	@Column(precision=19, scale=3)
	private BigDecimal uvSensor;
	
	@NotNull
	@Column(precision=19, scale=3)
	private BigDecimal barometricPressure;
	
	@NotNull
	private Double internalTemp;
	
	@NotNull
	private Double internalHummidity;
	
	@NotNull
	private Double externalTemp;
	
	@NotNull
	private Double externalHumidity;
	
	@NotNull
	private Integer odourUnit;
	
	public DataEntry() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGmtDate() {
		String dateOnly = new SimpleDateFormat("MM/dd/yyyy").format(gmtDateTime);
		return dateOnly;
	}

	public String getGmtTime() {
		String timeOnly = new SimpleDateFormat("HH:mm:ss").format(gmtDateTime);
		return timeOnly;
	}

	public BigDecimal getGpsLatitude() {
		return gpsLatitude;
	}

	public void setGpsLatitude(BigDecimal gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}

	public BigDecimal getGpsLongitude() {
		return gpsLongitude;
	}

	public void setGpsLongitude(BigDecimal gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}

	public BigDecimal getVocsLcPpm() {
		return vocsLcPpm;
	}

	public void setVocsLcPpm(BigDecimal vocsLcPpm) {
		this.vocsLcPpm = vocsLcPpm;
	}

	public BigDecimal getMs3LcPpm() {
		return ms3LcPpm;
	}

	public void setMs3LcPpm(BigDecimal ms3LcPpm) {
		this.ms3LcPpm = ms3LcPpm;
	}

	public BigDecimal getHydrogenSulfideLcPpm() {
		return hydrogenSulfideLcPpm;
	}

	public void setHydrogenSulfideLcPpm(BigDecimal hydrogenSulfideLcPpm) {
		this.hydrogenSulfideLcPpm = hydrogenSulfideLcPpm;
	}

	public BigDecimal getMethaneLcPpm() {
		return methaneLcPpm;
	}

	public void setMethaneLcPpm(BigDecimal methaneLcPpm) {
		this.methaneLcPpm = methaneLcPpm;
	}

	public BigDecimal getMs2LcPpm() {
		return ms2LcPpm;
	}

	public void setMs2LcPpm(BigDecimal ms2LcPpm) {
		this.ms2LcPpm = ms2LcPpm;
	}

	public BigDecimal getAmmoniaLcPpm() {
		return ammoniaLcPpm;
	}

	public void setAmmoniaLcPpm(BigDecimal ammoniaLcPpm) {
		this.ammoniaLcPpm = ammoniaLcPpm;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Integer getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(Integer windDirection) {
		this.windDirection = windDirection;
	}

	public Double getDailyRain() {
		return dailyRain;
	}

	public void setDailyRain(Double dailyRain) {
		this.dailyRain = dailyRain;
	}

	public BigDecimal getSolarSensor() {
		return solarSensor;
	}

	public void setSolarSensor(BigDecimal solarSensor) {
		this.solarSensor = solarSensor;
	}

	public BigDecimal getUvSensor() {
		return uvSensor;
	}

	public void setUvSensor(BigDecimal uvSensor) {
		this.uvSensor = uvSensor;
	}

	public BigDecimal getBarometricPressure() {
		return barometricPressure;
	}

	public void setBarometricPressure(BigDecimal barometricPressure) {
		this.barometricPressure = barometricPressure;
	}

	public Double getInternalTemp() {
		return internalTemp;
	}

	public void setInternalTemp(Double internalTemp) {
		this.internalTemp = internalTemp;
	}

	public Double getInternalHummidity() {
		return internalHummidity;
	}

	public void setInternalHummidity(Double internalHummidity) {
		this.internalHummidity = internalHummidity;
	}

	public Double getExternalTemp() {
		return externalTemp;
	}

	public void setExternalTemp(Double externalTemp) {
		this.externalTemp = externalTemp;
	}

	public Double getExternalHumidity() {
		return externalHumidity;
	}

	public void setExternalHumidity(Double externalHumidity) {
		this.externalHumidity = externalHumidity;
	}

	public Integer getOdourUnit() {
		return odourUnit;
	}

	public void setOdourUnit(Integer odourUnit) {
		this.odourUnit = odourUnit;
	}

	public Date getDateUploaded() {
		return dateUploaded;
	}

	public void setDateUploaded(Date dateUploaded) {
		this.dateUploaded = dateUploaded;
	}

	public Date getGmtDateTime() {
		return gmtDateTime;
	}

	public void setGmtDateTime(Date gmtDateTime) {
		this.gmtDateTime = gmtDateTime;
	}
	
	@Override
	public String toString() {
		return "DataEntry [id=" + id + ", dateUploaded=" + dateUploaded + ", gmtDateTime=" + gmtDateTime
				+ ", gpsLatitude=" + gpsLatitude + ", gpsLongitude=" + gpsLongitude + ", vocsLcPpm=" + vocsLcPpm
				+ ", ms3LcPpm=" + ms3LcPpm + ", hydrogenSulfideLcPpm=" + hydrogenSulfideLcPpm + ", methaneLcPpm="
				+ methaneLcPpm + ", ms2LcPpm=" + ms2LcPpm + ", ammoniaLcPpm=" + ammoniaLcPpm + ", windSpeed="
				+ windSpeed + ", windDirection=" + windDirection + ", dailyRain=" + dailyRain + ", solarSensor="
				+ solarSensor + ", uvSensor=" + uvSensor + ", barometricPressure=" + barometricPressure
				+ ", internalTemp=" + internalTemp + ", internalHummidity=" + internalHummidity + ", externalTemp="
				+ externalTemp + ", externalHumidity=" + externalHumidity + ", odourUnit=" + odourUnit + "]";
	}
	
}
