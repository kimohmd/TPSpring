package sample.aop.bank;

import org.springframework.stereotype.Component;

@Component
public class Bank implements IBank{
	
	public Boolean authenticated = false;
	
	@Override
	public void transfetMoney(String debiteur, String crediteur, double montant, Boolean auth) {
		System.out.println("montant de "+ montant + "transféré avec succés de "+ debiteur + "vers" + crediteur);
		
	}

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}

}
