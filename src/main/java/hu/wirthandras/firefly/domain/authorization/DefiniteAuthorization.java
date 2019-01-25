package hu.wirthandras.firefly.domain.authorization;

import hu.wirthandras.firefly.domain.person.Client;
import hu.wirthandras.firefly.domain.person.Witness;

public class DefiniteAuthorization extends Authorization {

	public DefiniteAuthorization(Client meghatalmazo, Client meghatalmazott, Witness witness1, Witness witness2) {
		super(meghatalmazo, meghatalmazott, witness1, witness2);
		this.title = "Hatarozott ideju szerzodes";
	}

}
