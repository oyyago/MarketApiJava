package com.market.categories.models;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import jakarta.persistence.*;

@Table(name = "CATEGORIES")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesModel extends RepresentationModel<CategoriesModel> implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "category_id")
	private Integer categoryId;
	@Column(name = "category_name")
	private String categoryName;
}
