package com.restful.webservices.restful.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filter")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean bean = new SomeBean("value1", "value2", "value3");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

		FilterProvider filters = new SimpleFilterProvider().addFilter("SimpleBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(bean);

		mapping.setFilters(filters);

		return mapping;
	}

	@GetMapping("/filters")
	public MappingJacksonValue retrieveSomeBeans() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
				new SomeBean("value4", "value5", "value6"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3", "field2");

		FilterProvider filters = new SimpleFilterProvider().addFilter("SimpleBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(list);

		mapping.setFilters(filters);

		return mapping;
	}

}
