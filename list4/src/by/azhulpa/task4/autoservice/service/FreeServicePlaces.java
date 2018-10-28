package by.azhulpa.task4.autoservice.service;

import java.util.Set;

import by.azhulpa.task4.autoservice.model.ServicePlace;

public interface FreeServicePlaces {

	Set<ServicePlace> getFreeServicePlaces(Set<ServicePlace> places);
}
