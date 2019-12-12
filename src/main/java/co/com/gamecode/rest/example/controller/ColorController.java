package co.com.gamecode.rest.example.controller;


import co.com.gamecode.rest.example.model.Color;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorController {

	public static final Map<String, String> colors = new HashMap<>();

	@GetMapping("/color")
	public Map getAllColors(){

		return colors;
	}

	@GetMapping("/color/{id}")
	public String getColorById(@PathVariable("id") String idColor){

		return colors.get(idColor);
	}

	@PostMapping("/color")
	public Map saveColor(@RequestBody Color color){
		colors.put(color.getIdColor(), color.getColor());
		return colors;
	}

	@PutMapping("/color/{id}")
	public Map updateColor(@PathVariable("id") String idColor, @RequestBody Color color){
		colors.put(idColor, color.getColor());
		return colors;
	}

	@DeleteMapping("/color/{id}")
	public Map deleteColor(@PathVariable("id") String id){

		colors.remove(id);
		return colors;

	}

}
