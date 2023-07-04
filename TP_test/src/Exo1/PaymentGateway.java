package Exo1;
import java.util.UUID;

public class PaymentGateway {

    // Effectue une demande de paiement au fournisseur de services de paiement et renvoie un identifiant de transaction.
    public String makePayment(double montant) {
        // Simule le traitement du paiement...
        // Dans une application r�elle, cela pourrait impliquer de communiquer avec un service de paiement tiers via une API.

        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit �tre sup�rieur � z�ro");
        }

        // G�n�re un identifiant de transaction unique.
        String transactionId = UUID.randomUUID().toString();

        // Simule le succ�s du paiement et renvoie l'identifiant de transaction.
        // Dans une application r�elle, le succ�s du paiement d�pendrait de la r�ponse du service de paiement tiers.
        return transactionId;
    }
}
