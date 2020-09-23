package sample.aop.bank;

import org.springframework.stereotype.Component;

@Component
public class Bank implements IBank{

	@Override
	public void transfetMoney(String debiteur, String crediteur, double montant) {
		System.out.println("montant de "+ montant + "transféré avec succés de "+ debiteur + "vers" + crediteur);
		
	}

}
