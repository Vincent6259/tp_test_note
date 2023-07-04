package Exo1;
import java.util.UUID;

public class PaymentGateway {

    // Effectue une demande de paiement au fournisseur de services de paiement et renvoie un identifiant de transaction.
    public String makePayment(double montant) {
        // Simule le traitement du paiement...
        // Dans une application réelle, cela pourrait impliquer de communiquer avec un service de paiement tiers via une API.

        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être supérieur à zéro");
        }

        // Génère un identifiant de transaction unique.
        String transactionId = UUID.randomUUID().toString();

        // Simule le succès du paiement et renvoie l'identifiant de transaction.
        // Dans une application réelle, le succès du paiement dépendrait de la réponse du service de paiement tiers.
        return transactionId;
    }
}
