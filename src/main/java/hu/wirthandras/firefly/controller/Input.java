package hu.wirthandras.firefly.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class Input {

	private String valid;
	private String applicable;
	private String condition;
	private String proxyPersonName;
	private String authorizingPersonName;

	private String witness1Name;
	private String witness1Address;

	private String witness2Name;
	private String witness2Address;

	public Input() {

	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getApplicable() {
		return applicable;
	}

	public void setApplicable(String applicable) {
		this.applicable = applicable;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getProxyPersonName() {
		return proxyPersonName;
	}

	public void setProxyPersonName(String proxyPeronName) {
		this.proxyPersonName = proxyPeronName;
	}

	public String getAuthorizingPersonName() {
		return authorizingPersonName;
	}

	public void setAuthorizingPersonName(String authorizingPersonName) {
		this.authorizingPersonName = authorizingPersonName;
	}

	public String getWitness1Name() {
		return witness1Name;
	}

	public void setWitness1Name(String witness1Name) {
		this.witness1Name = witness1Name;
	}

	public String getWitness1Address() {
		return witness1Address;
	}

	public void setWitness1Address(String witness1Address) {
		this.witness1Address = witness1Address;
	}

	public String getWitness2Name() {
		return witness2Name;
	}

	public void setWitness2Name(String witness2Name) {
		this.witness2Name = witness2Name;
	}

	public String getWitness2Address() {
		return witness2Address;
	}

	public void setWitness2Address(String witness2Address) {
		this.witness2Address = witness2Address;
	}

}
