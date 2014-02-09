package se.guards.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WeatherController
{

	@RequestMapping(value = "/weather", method = RequestMethod.GET)
	public String showWeather(ModelMap model)
	{
		return "weather";
	}

}
