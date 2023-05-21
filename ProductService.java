import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

	List<Product> products = new ArrayList<>();

	public void addProduct(Product p) {
		products.add(p);
	}

	public List<Product> getAllProducts() {
		return products;
	}

	public Product getProductbyName(String name) {
		for (Product p : products) {
			if (p.getName().equals(name))
				return p;
		}

		return null;
	}

	public List<Product> getProductWithText(String text) {
		String str = text.toLowerCase();
		List<Product> prods = new ArrayList<>();

		for (Product p : products) {
			String name = p.getName().toLowerCase();
			String type = p.getType().toLowerCase();
			String place = p.getPlace().toLowerCase();
			if (name.contains(str) || type.contains(str) || place.contains(str))
				prods.add(p);
		}
		return prods;

	}

	public List<Product> getProductsOutofWarranty() {

		List<Product> filteredList = products.stream()
				.filter(products -> products.getWarranty() < LocalDateTime.now().getYear())
				.collect(Collectors.toList());

		return filteredList;

	}

	public List<Product> getProductsByPlace(String place) {

		List<Product> filteredList = products.stream()
				.filter(product -> product.getPlace().toLowerCase().contains(place.toLowerCase()))
				.collect(Collectors.toList());
		return filteredList;
	}

}
