package hu.wirthandras.firefly.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Node {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@OneToOne(optional = true)
	private Node parent;
	@OneToMany
	private List<Node> children;

	private String name;

	public Node() {

	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParentName() {
		if (parent != null) {
			return  parent.name;
		} else {
			return "No parent";
		}
	}

}
